2021 2 9


String
StringBuffer
StringBuilder

이 3개를 비교 정리해보았다.

#### String, StringBuffer, StringBuilder 특징 및 차이점

우선 JAVA에서 세 가지 클래스의 특장과 차이가 무엇인지 요약하면, 세 가지 클래스는 모두 문자열을 처리하기 위한 클래스이다.
문자열을 더하는 연산을 할 때 성능의 차이가 발생하는데 String 클래스가 StringBuffer, StringBuilder보다
느리고 메모리 관리 측면에서도 큰 차이를 보입니다.
따라서 문자열의 더하기 연산을 이용할 때는 StringBuffer 또는 StingBuilder의 사용을  고려해봐야 한다.


StringBuffer와 StringBuilder는 기능이 동일하지만 한 가지 차이점이 존대한다. 바로 동기화 처리 문제이다.
StringBuffer는 동기화를 지원하여 멀티스레드 환경에서 안전하게 동작하지만 StringBuilder는 동기화를 지원하지
않는다. 따라서 단일 스레드 환경에서는 StringBuilder를 사용하고, 멀티 스레드 환경에서는 StringBuilder를
사용하는 것이 권장된다. 

#### 문자열을 추가하는 연산에서 String이 느린 이유
String 클래스가 StringBuffer 혹은 StringBuilder 클래스보다 성능이 떨어지는 이유는
String 클래스의 immutable 특성 때문이다. immutable이란 변경할 수 없는, 불변의 라는 뜻으로
String의 value값은 한번 생성되면 변경될 수 없다.

```java
String a = "aa";
String b = new String("bb");

System.out.printf("a | value: %-4s, address: %s\n", a, a.hashCode());
System.out.printf("b | value: %-4s, address: %s\n", b, b.hashCode());

a = a + b;

System.out.printf("a | value: %-4s, address: %s\n", a, a.hashCode());


/*
a | value: aa  , address: 3104
b | value: bb  , address: 3136
a | value: aabb, address: 2986080     새로운 메모리 공간이 할당됨.
*/
```

StringBuffer, StringBuilder와 비교한 String 클래스의 장점

StringBuffer와 StringBuilder가 String보다 성능이 그렇게 좋다면 StringBuffer와 StringBuilder만
사용하지 왜 String을 사용하지 의문이 든다. 
String 클래스는 immutable 속성을 가짐으로써 안전하다고 했는데 값이 변경되지 않기 때문에 여러 스레드가 데이터를
공유핟더라도 동기화를 신경쓸 필요가 없어 안정성이 유지되는 장점이 있다. 그리고 StringBuffer, StringBuilder
클래스에서도 String 클래스를 이용한다. toString()을 호출하면 String 객체가 생성되어 반환된다.
따라서 연산이 적게 사용되고, 문자열 값의 수정없이 읽기가 많은 경우에는 String클래스의 사용이 더 적절하다.











