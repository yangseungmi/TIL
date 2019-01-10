2019 1 10

## DB

### Explain

```
EXPLAIN tbl_name
또는
EXPLAIN [EXTENDED] SELECT select_options
```
EXPLAIN 명령문은 DESCRIBE에 대한 동의어로 사용할 수 있거나 
또는 MySQL이 SELECT 명령문을 실행하는 방법에 대한 정보를 얻기 위한 수단으로 사용할 수가 있다:

EXPLAIN tbl_name은 DESCRIBE tbl_name 또는 SHOW COLUMNS FROM tbl_name과 동일한 의미이다.
SELECT 명령문을 EXPLAIN 앞에 두면, MySQL은 쿼리 실행 플랜 (query execution plan) 정보를 
옵티마이저 (optimizer)에서 가져 와서 출력 한다. 

즉, MySQL은 테이블들이 어떤 순서로 조인 (join) 하는지에 대한 정보를 포함해서, 
SELECT를 처리하는 방법에 대해서 알려 준다. 

EXPLAIN를 사용함으로써, 테이블의 어느 곳에 인덱스를 추가해야만 열을 찾기 위한 
SELECT가 보다 빠르게 되는지를 알 수 있게 된다. 
또한, EXPLAIN를 사용하면 옵티마이저가 최적의 (optimal) 순서로 테이블을 조인 (join)할 수 있는지 
여부도 검사할 수가 있다. 
SELECT 명령문에 명명되어 있는 테이블의 순서와 상응하게 
조인 (join) 순서를 사용하도록 옵티마이저를 만들기 위해서는, 
명령문에 SELECT만을 사용하는 대신에 SELECT STRAIGHT_JOIN을 사용해서 시작을 하도록 한다.

만일 생각에는 사용 되어야만 했을 인덱스가 사용되지 않은 상태로 문제를 일으키게 되면, 
키의 기수 (cardinality)와 같은 테이블 상태를 업데이트 하기 위해 ANALYZE TABLE을 구동 시켜야 하는데, 
이것은 옵티마이저의 선택에 영향을 미치게 된다. 

EXPLAIN은 SELECT 명령문에서 사용된 각 테이블 정보 열을 리턴한다. 
MySQL이 쿼리를 처리하는 동안 읽을 수 있도록 테이블들은 결과물 안에 목록으로 정리가 된다. 
MySQL 은 single-sweep multi-join 방법을 사용해서 모든 조인 (join)을 풀어 버린다 (reslove). 
이것은 MySQL이 첫 번째 테이블에서 열을 읽고, 그 다음에 두 번째 테이블에서 매치 (match)가 되는 것을 찾으며, 
세 번째, 네 번째 등으로 이동을 한다는 것을 의미하는 것이다. 
모든 테이블을 처리한 후에, MySQL은 선택된 컬럼을 내 보내고 테이블에서 매치되는 다른 열이 있을 때까지 
테이블을 역으로 검사한다. 그 테이블에서 그 다음 열을 읽고 다음 테이블로 이동을 해서 동일한 과정을 반복 진행한다.

EXTENDED 키워드가 사용되면, EXPLAIN은 EXPLAIN 명령문 다음에 SHOW WARNINGS 명령문을 입력해서 
볼 수 있는 기타 정보를 리턴한다. 
이 정보는 옵티마이저가 SELECT 명령문에 있는 컬럼 이름과 테이블을 얼마나 많이 검증을 하였는지를 보여주며, 
SELECT는 최적화 과정에 관한 어플리케이션 재 작성과 최적화 규칙, 그리고 다른 가능한 노트 (notes)를 보여준다.

### EXPLAIN 출력 컬럼
id 쿼리 내의 SELECT 구분 번호

select_type	
SELECT 타입
- SIMPLE : 단순 SELECT(UNION 또는 서브쿼리 아님)
- PRIMARY
- UNION
- DEPENDENT UNION
- UNION RESULT
- SUBQUERY
- DEPENDENT SUBQUERY
- DERIVED
- MATERIALIZED
- UNCACHEABLE SUBQUERY
- UNCACHEBLE UNION

table	참조하는 테이블

partitions	매칭되는 파티션

type	
조인 타입(뒤로 갈수록 안좋음)
- system
- const
- eq_ref
- ref
- fulltext
- ref_or_null
- index_merge
- unique_subquery
- index_subquery
- range
- index
- ALL : 행을 찾기 위해 전체 테이블을 스캔

possible_keys	행을 찾기 위해 검색에 사용할 수 있는 인덱스 목록

key	행을 찾기 위해 실제 사용한 인덱스

key_len	행을 찾기 위해 사용한 인덱스의 길이

ref	행을 찾기 위해 사용된 컬럼이나 상수값

rows	행을 찾기 위해 예상되는 행의 갯수

filtered	테이블 조건에 의해 필터되는 비율

Extra	 추가 정보



