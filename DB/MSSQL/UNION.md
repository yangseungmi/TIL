2019 6 24

select no table

select 'a' union
select 'b'

결과는 
a
b
마치 한 테이블에 있는 데이터를 조회한 것처럼 보인다
(따로 temp 테이블을 만들 필요 없음)

여기서 이 데이터를 join해야 한다
컬럼?에 이름도 달아주고 ( as ip1 )

```sql
select * from 
(
  SELECT 'a' as ip1 UNION
  SELECT 'b' as ip1 UNION
  SELECT '61.99.170.11' as ip1 UNION
  SELECT '61.99.172.11' as ip1 UNION
  SELECT '61.99.193.130' as ip1 UNION
  ...
  SELECT '61.99.93.131' as ip1 
) as a
left join test t with(nolock)
on a.ip1 = t.ip1

````

