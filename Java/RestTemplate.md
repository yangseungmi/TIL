2019 11 13

출처 https://sjh836.tistory.com/141

RestTemplate 동작원리

org.springframework.http.client 패키지에 있다. HttpClient는 HTTP를 사용하여 통신하는 범용 라이브러리고,
RestTemplate는 HttpAClient를 추상화(HttpEntity의 json, xml 등)해서 제공해준다.
따라서 내부 통신(HTTP 커넥션)에 있어서는 Apache HttpComponents를 사용한다.
만약 RestTemplate가 없었다면, 직접 json, xml 라이브러리를 사용해서 변환해야 했을 것이다.

![Alt text](../Image/resttemplate.png) 

1. 어플리케이션이 RestTemplate를 생성하고,
  URI, HTTP 메소드 등의 헤더를 담아 요청한다.
  
2. RestTemplate는 HttpMessageConverter(in org.springframework.http.converter)를 사용하여
  requstEntity를 요청메세지로 변환한다.
  
3. RestTemplate는 ClientHttpRequestFactory로 부터 
  ClientHttpRequest를 가져와서 요청을 **보낸다.**
  
   -> createRequest라는 메소드를 사용하는듯.
   
4. ClientHttpRequest는 요청메세지를 만들어 HTTP 프로토콜을 통해 서버와 통신한다.

5. RestTemplate는 ResponseErrorHandler로 오류를 확인하고 있다면 처리로직을 태운다.
   -> ResponseErrorHandler는 hasError()와 handleError()가 있다.
   
6. ResponseErrorHandler는 오류가 있다면 ClientHttpResponse에서 응답데이터를 가져와서 처리한다.

7. RestTemplate는 HttpMessageConverter를 이용해서 응답(결과)메세지를 java object(Class responseType)으로
   변환한다.
   
8. 어플리케이션에 반환된다.
  


