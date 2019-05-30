2019 05 30


MSSQL 에서 데이터 추출 시

select 쿼리 1과 
select 쿼리 2를 

inner join 해야 할 일이 생겼다

그냥 사이에 join 넣으면 되지 라고 생각했지만

select
...

select
---
이 두 쿼리를

```mssql
select * from (
...
)
```

이 안에 넣을 생각하니 일단 막연했다
그래서 구글링 해보다가 
두 쿼리 사이에 'INTERSECT'를 넣는 방법도 있었지만
사수께서 알려주신 방법이 훨씬 나아서 정리해 보았다


```mssql
select a.USERID
from (
  select USERID
  from DAUMPC_PAY with(nolock)
     ...
  group by USERID
) a
inner join
(
 select pay.USERID
 from (
  select USERID, max(seq) as SEQ
  from DAUMPC_PAY with(nolock)
   ...
  group by USERID
 ) a 
 inner join DAUMPC_PAY pay with(nolock) on a.SEQ = pay.SEQ 
) b on a.USERID = b.USERID
;
```
