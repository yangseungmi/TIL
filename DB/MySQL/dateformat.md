2019 12 9


MYSQL 날짜 데이터 포맷 형식


```mysql
SELECT
DATE_FORMAT(a.regdate, '%Y-%m-%d %H:%i:%s') as regDate
FROM a

...

```

#### DATE_FORMAT(테이블명 or 컬럼명 or 테이블명.컬럼명, '%Y-%m-%d %H:%i:%s') as a
