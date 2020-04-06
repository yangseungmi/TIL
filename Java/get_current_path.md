2020 4 6

```java

아래와 같은 주소가 있을 경우
http://localhost:8080/test/index.jsp
 
request.getRequestURI();   //프로젝트경로부터 파일까지의 경로값을 얻어옴 (/test/index.jsp)
request.getContextPath();  //프로젝트의 경로값만 가져옴(/test)
request.getRequestURL();   //전체 경로를 가져옴 (http://localhost:8080/test/index.jsp)
request.getServletPath();  //파일명 (/index.jsp)

```

