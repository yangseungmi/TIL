2019 4 9


오늘도 간단한 쿼리문제 하나 풀어봤습니다

https://leetcode.com/problems/swap-salary/

```mssql
UPDATE 
SALARY 
SET sex= 
  CASE sex
  WHEN 'm' THEN  'f'
  WHEN 'f' THEN 'm' END
```

