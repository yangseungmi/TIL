2019 4 27

https://leetcode.com/problems/second-highest-salary/

```mssql
select
ISNULL
(NULL,
    (select distinct salary 
    from Employee
    order by salary desc
    offset 1 rows
    fetch next 1 rows only
    )
) AS SecondHighestSalary
```


offset next n rows only: n만큼 건너 뛴 후에 출력하는 기능
fetch next n rows only : n행만 출력하는 기능

```
    order by seq desc
    offset 10 rows
    fetch next 20 rows only
```
seq가 큰 순서로 출력 후 맨 위 10개 제외 후
그 아래 20개 행 출력.
