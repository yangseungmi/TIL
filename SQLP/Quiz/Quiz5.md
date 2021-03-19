2021 3 19


SQL 자격검정 실전문제 
실기문제 5번


```sql
select a.고객번호, a.고객명, a.등록일시, a.연락처, a.주소
       ,(select max(접속일시)
           from 고객접속이력
          where 고객번호 = a.고객번호
            and 접속일시 > trunc(add_months(sysdate, -1))
       ) as 최근접속일시
from  (
     select rownum,
            고객번호, 고객명, 등록일시, 연락처, 주소
       from 고객
      where 고객상태코드 ='AC'
      order by 등록일시, 고객번호
     ) as a
     where rownum  <= :page * 20
)
where rownum >=  (:page - 1) *  20 + 1;


select a.고객번호, a.고객명, a.등록일시, a.연락처, a.주소, b.최근접속일시
from   고객 a,
       (
          select 고객번호 , max(접속일시)
           from 고객접속이력
            where 접속일시 > trunc(add_months(sysdate, -1))
           group by 고객번호
       ) b
where a.고객상태코드 = 'AC'
and   a.고객번호 = b.고객번호
order by a.등록일시, a.고객번호


```
