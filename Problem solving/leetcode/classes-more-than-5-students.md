2019 4 10

https://leetcode.com/problems/classes-more-than-5-students/

sql 문제 풀어보았습니다

```mysql
select class
from courses
group by class
having count(distinct student) >= 5
```
