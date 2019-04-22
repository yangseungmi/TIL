2019 4 22

https://leetcode.com/problems/employees-earning-more-than-their-managers/

```mysql
# Write your MySQL query statement below
select e1.name as Employee
from employee e1, employee e2
where e1.managerid = e2.id
and e1.salary > e2.salary
```
