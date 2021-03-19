2021 3 19

SQL 자격검정 실전문제 실기문제 3번


```sql
select 주문번호, 업체번호, 주문일자, 주문금액
count(*) over (partition by 업체번호) as 총주문횟수,
avg(주문금액) over (partition by 업체번호) as 평균주문금액,
max(주문금액) over (partition by 업체번호) as 최대주문금액
from 주문
where 주문일자 like '201509%'
order by 평균주문금액 desc;



select 주문번호, 업체번호, 주문일자, 주문금액
from (
select max(주문번호) over (partition by 업체번호) as 마지막주문번호,
       주문번호, 업체번호, 주문일자, 주문금액
 from 주문
where 주문일자 like '201509%'
)
where 주문번호 = 마지막주문번호

```






