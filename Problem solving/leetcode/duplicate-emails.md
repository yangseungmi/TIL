2019 4 28

요즘 거의 모든 커밋을 leetcode 문제 풀기로 하고있는데
알고리즘보다 SQL 문제 푸는 횟수가 더 많아졌다
그래서 그런지 더 자신감이 붙고 커밋이 예전보다 빨리 끝나 정말 뿌듯하다

이제 슬슬 시간을 더 투자해 알고리즘 문제를 풀어 볼 생각이다
벌써 시즌3 커밋한지 40일이 지났는데

100일이 다 되면 지금보다 더 많이 성장해 있는 내가 기대된다.

https://leetcode.com/problems/duplicate-emails/

```mysql
/* Write your T-SQL query statement below */
select distinct email from person
group by email
having count(email) > 1
```

group by 해서 distinct는 없어도 될듯..
