2109 10 29

오늘은 https://deview.kr/2019/schedule
네이버 DEVIEW 날!


이지만 아침에 일이 생겨 쿼리 수정 후 배포한 뒤 코엑스로 출발한다..

```mssql

      SELECT 
            [SEQ]
            ,[USERID]
            ,[PCBANGNAME]
            ,[TOWN]
            ,CONCAT([ADDR], ' ', [ADDR_DETAIL]) AS ADDR
            ,[LATITUDE]
            ,[LONGITUDE]
            ...
           
```
MSSQL의 CONCAT을 사용하는데
위처럼 ADDR과 ADDR_DETAIL을 붙이는데 
처음에 ADDR + ADDR_DETAIL로 했다가 NULL이라서 문제가 생겼었다.

CONCAT을 사용해서 여러 컬럼을 붙여 출력할 수 있다.

