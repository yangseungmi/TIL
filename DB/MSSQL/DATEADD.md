2019 6 18


참고 https://docs.microsoft.com/ko-kr/sql/t-sql/functions/dateadd-transact-sql?view=sql-server-2017

시간 계산할 때 초를 더한 값을 구하는 방법
ISNULL(DATEADD(second, DURATION_SEC, REGDATE) AS SEC

* ISNULL는 값이 NULL일 때 뒤에 있는 REGDATE(현재날짜)로 출력
