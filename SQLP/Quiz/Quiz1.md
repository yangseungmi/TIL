2021 3 19

드디어 내일 시험...
D-1!


SQL 자격검정 실전문제
실기문제 1번


```sql
select 지점, 판매월, 매출
       sum(매출) over (partition by 지점 order by 판매월) AS 누적매출
  from 월별지점매출;
 

 
select A.지점, A.판매월, A.매출,
       SUM(B.매출) AS 누적매출
  from 월별지점매출 A, 월별지점매출 B
 where A.지점 = B.지점 
      AND A.매출 >= B.매출
 group by 지점, 판매월, 매출
 order by 지점, 판매월
```



