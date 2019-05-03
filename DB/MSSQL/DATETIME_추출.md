2019 5 3

DATETIME 형식 데이터를 만질 때가 자주있다


2019-01-02 13:00:01.003
이라는 데이터에서
201901을 추출하고 싶었다

처음에 
'SUBSTRING(USE_DT,1,6)'

자료형이 DATETIME인 줄 모르고 SUBSTRING을 사용해서 7자리를 자르려고 했는데 
데이터가 워낙 많다보니  시간이 오래 걸리고 VARCHAR가 아닌 DATETIME이었다...


다음 
FORMAT(REGDATE,'yyyyMM')

FORMAT을 사용하여 년(yyyy)과 월(MM)을 추출하고 했지만 이 쿼리도
GROUP BY 때문인지 모르겠지만 시간이 오래걸렸다

다음 
LEFT(CONVERT(VARCHAR,REGDATE,112),6)

우선 CONVERT(VARCHAR,REGDATE,112)으로 데이터를 20190102 로 바꾼 뒤
그중 LEFT(20190102,6)로 왼쪽에서 6글자 201901까지 잘라서 사용했다

여기서 하나더 SUM(MONEY)를 같이 SELECT 하다가
"expression을(를) 데이터 형식 int(으)로 변환하는 중 산술 오버플로 오류가 발생했습니다."라는 에러 메세지가 떴다

그래서 여기서 한번더 
SUM(convert(bigint,MONEY)) 

MONEY를 bigint로 바꾼 뒤 SUM을 하니 해결되었다.


