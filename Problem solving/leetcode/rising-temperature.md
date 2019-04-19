2019 4 19

rising-temperature 문제

https://leetcode.com/problems/rising-temperature/

```mssql
select w1.id from weather w1
join weather w2 on  DATEDIFF(dd,w1.RecordDate,w2.RecordDate) = -1
where w1.temperature >w2.temperature
```
