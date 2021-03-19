2021 3 19


SQL 자격검정 실전문제 
실기문제 2번


```sql
select /*+ leading(c) use_nl(o) index(c 고객_idx) index(o 주문_idx) */
      o.주문일시, o.주문번호, c.고객번호, c.고객명, o.주문금액
from  고객 c, 주문 o
where o.주문일시 between to_date('20150301','yyyymmdd')
  and to_date('20151103','yyyymmdd')
  and o.고객번호 = c.고객번호
  and (c.거주지역코드, c.고객명) in (('02','최지호'), ('05','양승미'))
order by o.주문일시, c.고객명

create index 고객_idx on 고객('거주지역코드', '고객명');
create index 주문_idx on 주문('고객번호', '주문일시');

```
