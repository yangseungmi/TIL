2019 11 4




java의 substring과 같이 string에서 원하는 문자를 추출할 수 있다.


SUBSTRING(문자열,시작자리번호,자를문자수)

```sql
SELECT * FROM MEMBER
WHERE NUMBER = SUBSTRING(num,0,6)
```
