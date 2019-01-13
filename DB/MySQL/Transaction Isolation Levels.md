2019 1 13

## DB

### Transaction Isolation Levels 트랜잭션 격리 수준 in MySQL

- READ UNCOMMITTED
- READ COMMITTED
- REPEATABLE READ
- SERIALIZABLE

1. READ UNCOMMITTED   (dirty read)
 READ UNCOMMITTED 는 이름 그대로 아직 다른 트랜젝션에서 **COMMIT**되지 않은 데이터들을 
 읽어올 수 있는 level이다. 이 때 읽어온 데이터들이 결국 COMMIT 된다면 더 빨리 읽어오는게
 무슨 문제가 있겠냐 생각할 수도 있다. 하지만 만약 해당 크랜잭션이 COMMIT되지 않고 ROLLBACK된다면
 격국 세상에 존재해서는 안될 데이터를 읽어온 게 되어버린다.(?)
 >이렇게 신뢰할 수 없는 데이터를 읽어오는 것을 dirty read라고 부른다.
 >한 트랜잭션에서 동일한 SELECT 쿼리의 결과가 다름(non-repeatable read)
 >이전의 SELECT 쿼리의 결과에 없던 row가 생김(phantom read)


2. READ COMMITTED
말그대로 '읽는다 커밋된' 다른 트랜젝션에서 **COMMIT** 된 내용만 읽어올 수 있는 level이다
>신뢰할 수 없는 데이터는 읽어올 수 없음
>한 트랜잭션에서 동일한 SELECT 쿼리의 결과가 다름(non-repeatable read) 
>이전의 SELECT 쿼리의 결과에 없던 row가 생김(phantom read)

3. REPEATABLE READ
MySQL InnoDB의 기본 isolation level이다. MySQL에서 지정한 기본 level인만큼 동시성과 
안정성의 균형을 가장 잘 갖춘 level이 아닐까 생각한다.
> 신뢰할 수 없는 데이터는 읽어올 수 없음
>한 트랜잭션에서 동일한 SELECT 쿼리의 결과가 동일 (이게 가장 큰 특징 같다)
한 트랜잭션에서 처음 데이터를 읽어올 때 구축한 **snapshot에서 모두 데이터를 읽어온다.
따라서 매번 **SELECT** 쿼리의 결과들이 항상 처음과 동일했던 것이고, 
이로 인해 phantom read도 발생하지 않았던 것이다.
```
This is the default isolation level for InnoDB. 
Consistent reads within the same transaction read 
the snapshot established by the first read.
```
또 한가지 흥미로운 점은, 비록 한 트랜잭션에서 SELECT 쿼리는 항상 동일하더라도
다른 트랜잭션에서 건드린 row에 대한 **UPDATE, DELETE**의 결과는 출력될 수 있다!!
(이건 또 스냅샷에 추가되는가 봄..)

4. SERIALIZABLE serializable
앞서 REPEATABLE READ 가 동시성과 안정성의 균형을 가장 잘 갖춘 isolation level였다면, 
SERIALIZABLE 는 동시성을 상당 부분 포기하고 안정성에 큰 비중을 둔 isolation level이다. 

SERIALIZABLE 은 한 트랜잭션 안에서 단순 SELECT 쿼리를 사용하더라도,
모두 SELECT ... FOR SHARE 으로 변환한다. 
SELECT ... FOR SHARE 은 읽어온 row들에 shared lock(또는 read lock)을 거는 쿼리이다.

UPDATE 나 INSERT 쿼리로는 해당 row의 lock이 풀리기 전까지 수정이나 추가할 수 없다. 
따라서 위에서처럼 UPDATE 쿼리를 실행하면 결과가 출력되지 않고 **계속 대기 상태**에 있게 된다 . 

물론 한없이 기다리진 않고, 설정된 timeout이 지나면 아래와 같이 에러를 출력할 것이다.
```
ERROR 1205 (HY000): Lock wait timeout exceeded; try restarting transaction  
```
만약 timeout 되기 전에 TRANSACTION이  COMMIT 한다면, 
걸려있던 lock이 풀려나 UPDATE 쿼리가 정상적으로 실행될 것이다.

이렇듯 SERIALIZABLE 에서는, 한 트랜잭션에서 SELECT 쿼리를 실행하면 
그 트랜잭션이 COMMIT 되기 전까지 다른 트랜잭션에서는 수정, 추가, 삭제 등의 작업조차 할 수 없다.

출처 https://jupiny.com/2018/11/30/mysql-transaction-isolation-levels/
참고 https://dev.mysql.com/doc/refman/8.0/en/innodb-transaction-isolation-levels.html
