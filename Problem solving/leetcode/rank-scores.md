2019 4 25

https://leetcode.com/problems/rank-scores/

```mysql
SELECT
  Score,
  (SELECT count(distinct Score) FROM Scores WHERE Score >= s.Score) Rank
FROM Scores s
ORDER BY Score desc
```


