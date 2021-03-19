2021 3 19


SQL 자격검정 실전문제 실기문제 4번


```sql
select  고객번호,  주문일시, 주문금액, 우편번호, 배송지
from 주문
where 고객번호 = NVL(:고객번호,고객번호)
and   주문일자 >= to_date(:ord_dt1,'yyyymmdd')
and   주문일자 <  to_date(:ord_dt2,'yyyymmdd') +  1
order by 주문일자 desc;


create index 주문_idx on 주문('고객번호', '주문일자');
```




