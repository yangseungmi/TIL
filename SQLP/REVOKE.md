2021 3 3

DCL
Data Controll Language

GRANT와 REVOKE 중
오늘 REVOKE를 정리해보았다.


권한을 주는 GRANT는 사용해봤지만 REVOKE는 사용해본적도 없고 생소해서 짚고 넘어가야할것같다.

```sql
REVOKE {privilege [, privilege...] | ALL}
ON object
FROM {user[, user...] | role | PUBLIC}
[CASCADE CONSTRAINTS] 
```
형식은 이러하다


```sql
-- 문제집에서 한 문제 발췌
Lee : GRANT SELECT, INSERT, DELETE ON R TO Kim WITH GRANT OPTION;
-- Lee가 Kimm에게 SELECT, INSERT, DELETE와 권한을 줄 수 있는 GRANT 자격까지 부여.

Kim : GRANT SELECT, INSERT, DELETE ON R TO Park;
-- (Lee에게 받은 권한으로) Kim이 Park에게 SELECT, INSERT, DELETE 권한을 부여.

Lee : REVOKE DELETE ON R FROM Kim;
-- Lee가 Kim에게서 DELETE 권한을 회수.

Lee : REVOKE INSERT ON R FROM Kim CASCADE;
-- Lee가 Kim에게 INSERT 권한도 회수.

-- 여기서 CASCADE
-- CASCADE는 연쇄적인 권한을 해제할때 입력한다. (WITH GRANT OPTION으로 부여된 사용자들의 권한까지 취소= 권한을 받은 다른 유저의 권한도 연쇄적으로 삭제)
-- RESTRICT는 KIM에게 권한을 받은 유저가 있다면 REVOKE 취소.
```

1) Park : SELECT * FROM R WHERE A = 400;
2) Park : INSERT INTO R VALUES(400, 600);
3) Park : DELETE FROM R WHERE B = 800;
4) Kim : INSET INTO R VALUES(500, 600);

실행가능한 것은?
--> 정답은 1, 3

참고 :https://docs.microsoft.com/ko-kr/sql/t-sql/statements/revoke-database-permissions-transact-sql?view=sql-server-ver15

