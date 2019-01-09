2019 1 9

## DB

### JDBC 와 DBCP

JDBC

 : Java Data Base Connectivity. 한글로 번역하면, 자바 데이터 베이스 연결.

  정의는 DataBase와 연결하기 위한 Java Interface이다.

DBCP

 : DataBase Connection Pool. 역시 간단하게 정리하면 DataBase와 Connection을 맺고 있는 객체를 관리하기 위한

  Connection Pool


일반적인 JDBC의 프로세스는 다음과 같이 추릴 수 있다.
```
1.DriverManager를 통한 DB Connection 객체 생성(DataBase와 Connection 생성)
2.Connection 객체에서 statement 객체 생성 및 쿼리 실행
3.ResultSet 가지고 놀기
4.Connection Close
```
여기서 JAVA와 DataBase에 커넥션을 생성(1번)하는 것이 오랜 시간을 필요로 하게 된다.

예를들어 사람 1명이 가게에서 용무를 보는데 걸리는 시간이 아래와 같을 때
```
1.가게 문(Connection)을 연다.(Open) - 1초
2.가게에서 용무를 보는데 (Statement 객체 생성 및 쿼리 실행 & ResultSet 조작) - 2초
3.용무를 마치고 나가서 가게문을 닫음 (Connection close) - 1초
```
10명이 용무를 본 시간은 40초 일것이다
하지만 문을 열고 닫는 프로세스가 매번 반복되어야 할까
마지막 10번째 사람이 나갈 때까지 문을 계속 연 상태로 유지한다면 시간은 18초로 절약할 수 있다.

이 때 가게를 Connection Poll과 유사하게 생각하면 되겠다
Connection을 열고 닫는 절차의 생력으로 기존보다 시스템에도 부하가 덜 감은 물론이고,
사용자에게 응답할 수 있는 시간도 더 빨라질 것이다.
(쿼리가 빨라진다는 것이 아니라 Connection Open/Close 절차가 
줄어듬으로써 속도라 빨라진다는 것이다)

오픈한 커넥션을 Close하지 않고 Pool이라 칭해지는 Connection을 관리하는 곳에서 오픈된 상태의 
커넥션을 가지고 있다가 Connection이 필요한 곳에 이미 오픈된 Connection을 사용할 수 있도록 할당해주고, 
작업이 끝나면 다시 Pool에서 관리하는 것을 Connection Pool이라 한다.
```
 - DBCP(DataBase Connection Pool)은 JDBC(Java DataBase Connectivity)를 
 관리하기 위한 기법이라고 생각하면 된다
 - Java에서 Database와 연결하기 위해선 JDBC를 필요로 하며, JDBC를 이용해 생성한 Connection을 
 효율적으로 활용하기 위해 Connection 객체를 관리하는 것을 DBCP의 개념으로 보면 된다.
```

출처: http://leminity.tistory.com/20 [Reminiscence]


***
### JDBC 드라이버
(JDBC는 'VM의 시스템과 DB 시스템을 연결하고 통신하기 위한 JAVA의 표준 스펙'이기도 하다)
![Alt text](/Image/helloworld-1321-1.png  "JDBC Type4 드라이버의 DBMS 통신 구조")


***
### DBCP
Commons DBCP 2.x의 BasicDataSource 클래스 설정 사례
```
<bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource"  
    destroy-method="close"
    p:driverClassName="${db.driverClassName }"
    p:url="${db.url}"
    p:username="${db.username}"
    p:password="${db.password}"
    p:maxTotal="${db.maxTotal}"
    p:maxIdle="${db.maxIdle}"
    p:maxWaitMillis="${db.maxWaitMills}""
/>
```

