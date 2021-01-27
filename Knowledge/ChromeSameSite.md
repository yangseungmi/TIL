2021.1.27

#### SameSite 설정하기

SameSite 속성을 변경하는 방법은 쿠키를 생성하는 시점부터 설정해주거나 필터 등을 이용하여 기존 쿠키에 none 속성을 추가하는 방법이 있습니다.

 

 

#### 1. JavaScript

document.cookie = "safeCookie1foo; SameSite=Lax";

document.cookie = "safeCookie1foo";

document.cookie = "crossCookie=bar; SameSite=None; Secure";

SameSite 속성을 Lax로 명시한 safeCookie1와 명시하지 않은 safeCookie2는 크롬 80이상부터 Default Lax 값으로 적용되는것을 확인할 수 있습니다.

주의하셔야 할 점은 SameSite속성을 None으로 설정할 경우 Secure속성을 함께 추가해 주셔야 합니다. Secure 속성을 추가된 쿠키는 HTTPS프로토콜에서만 전송이 가능하며 SameSite가 None이어도 Secure 속성이 없으면 None속성이 적용이 되지 않아 쿠키값을 여전히 사용하지 못합니다.

 

 

#### 2. Java Application

response.setHeader("Set-Cookie", "Test1=TestCookieValue1; Secure; SameSite=None");

response.setHeader("Set-Cookie", "Test1=TestCookieValue2; Secure; SameSite=None");

response.setHeader("Set-Cookie", "Test1=TestCookieValue3; Secure; SameSite=None");

 

 

#### 3. Filter or Interceptor

소스상에서 처리가 힘든 경우에 필터나 인터셉터 등을 통해 response를 가로채서 SameSite 속성을 추가할 수 있습니다.

```java
private void addSameSite(HttpServletResponse response, String sameSite) {
    Collection<String> headers = response.getHeaders(HttpHeaders.SET_COOKIE);
    boolean firstHeader = true;
    for(String header : headers) {
        if(firstHeader) {
            response.setHeader(HttpHeaders.SET_COOKIE, String.format("%s; Secure; %s", header, "SameSite=" + sameSite));
            firstHeader = false;
            continue;
        }
        response.addHeader(HttpHeaders.SET_COOKIE, String.format("%s; Secure; %s", header, "SameSite=" + sameSite));
    }

}
```

출처: https://mandlife.tistory.com/entry/크롬에서-Cookie-의-값을-잃어버린다-SameSite-설정하기
