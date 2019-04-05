2019 4 5


leetcode 에 쿼리 문제도 있어서
쉬운 문제로 하나 시작해 보았습니다

https://leetcode.com/problems/not-boring-movies/
Please write a SQL query to output movies with an odd numbered ID and a description that is not 'boring'. Order the result by rating.

```sql
select id, movie, description, rating
from cinema
where description not in ('boring')
and id % 2 = 1
order by rating desc

```



