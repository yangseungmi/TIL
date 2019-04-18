2019 4 18

leetcode query 문제

조인 문제 라서 이번기회에 조인 정리... 하려고 했는데 이건 내일 ㅎㅎ

https://leetcode.com/problems/combine-two-tables/

```mssql
select p.FirstName, p.LastName, a.City, a.State from Person p
left outer join Address a on p.PersonId = a.PersonId
```

