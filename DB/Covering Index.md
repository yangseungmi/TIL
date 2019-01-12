2019 1 12

## DB

### 커버링 인덱스 Covering Index

쿼리 짤 때 대량 데이터 조회면 인덱스를 타게 해서 효과적으로 추출하지만
이게 이름이 '커버링 인덱스'인줄은 또 몰랐다 ;;

각 컬럼마다 인덱스를 생성 해 줄 순 없고, 인덱스를 못 만드는 컬럼도 있다.

또 요청하는 팀에서 어떤 데이터를 어떻게 요청하는지도 그때그때마다 다르다.(요구사항이 바뀌기도 하고)

구글링해보니 https://d2.naver.com/helloworld/1155 
'성능 향상을 위한 SQL 작성법' 블로그에 기초부터 자세히 나와있다.( +  참고 http://helloino.tistory.com/29) 

1) Order By 쿼리
```
SELECT a, b FROM tbl  
WHERE a > 1 AND a < 5  
AND b < 'K'  
ORDER BY b; 
```
(a, b) index가 존재한다면 a에 조건을 걸고, b를 정렬하는 쿼리는 b 정렬(ORDER BY b)가 없을 때보다 성능을 높일수가 있다.

2) 대용량 데이터 Range 처리
(블로그에 있는 예시를 참고하려 패스)
```
SELECT * FROM TB1 T1
INNER JOIN TB2 T2 ON T1.ID = T2.ID
INNER JOIN TB3 T3 ON T1.ID = T3.ID
INNER JOIN TB4 T4 ON T1.ID = T4.ID
WHERE T1.REGDATE > '2019-01-01 00:00:00' T1.REGDATE < '2019-01-12: 23:59:59'
```

데이터의 양이 많을 때 inner join 테이블을 먼저 join을 한후 
WHERE 조건을 타게 되서 Full-Scan이 발생될수가 있다.

이럴 때 해당 조건의 T1 ID를 먼저 추출 후 JOIN 테이블에서 IN 쿼리로 검색하는게 효과적이라고 한다
> 1- 이 추출시 T1의 REGDATE에 인덱스가 있다고 가정한다 없으면 생성
(ALTER INDEX T1 ADD T1_IDX_REGDATE (REGDATE) )

> 2- 조건의 ID 추출
```
SELECT ID FROM T1
WHERE T1.REGDATE > '2019-01-01 00:00:00' T1.REGDATE < '2019-01-12: 23:59:59'
```
> 3- In Query를 이용하여 다시한번 쿼리 실행한다
```
SELECT * FROM TB1 T1
INNER JOIN TB2 T2 ON T1.ID = T2.ID
INNER JOIN TB3 T3 ON T1.ID = T3.ID
INNER JOIN TB4 T4 ON T1.ID = T4.ID
WHERE T1.ID in ('s1','s2','s3', ... 's100')
```
Select Query를 2번이상 사용했지만, 상황 (데이터의 양 등)에 따라 inner join이 3번이 있는 Query 1번보다 
**2번이상의 Select**가 더욱더 빠른 쿼리 성능을 낼수가 있다
