2019 10 23



### 소수점 숫자를 Long형으로 변환

#### 소수점이나 123E7 같은 스트링형을 long형으로 변환하는 방법

 
```java
Long a= new Long(0);
BigDecimal b = new BigDecimal( "12322.22"); // 변환하고자 하는 스트링
a = new Long( b.longValue());
```
 

#### 이런 방법으로 중간에 BigDecimal 을 둬서 변환한다.
#### 이렇게 하지 않으면 스트링형에 . 이나 E가 붙어있을 경우 ParseLong 같은 함수는 제대로 작동하지 않고 오류를 낸다.

참고 https://m.blog.naver.com/PostView.nhn?blogId=alucard99&logNo=90330113&proxyReferer=https%3A%2F%2Fwww.google.com%2F
