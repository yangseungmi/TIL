2019 11 18

문자열 자르기 SubString

SubString을 사용할 때마다 구글링을 하는건.. 
손이 기억을 못했기 때문일 거라고 생각한다

그래서 머리를 통해 손이 기억하도록
SubString.md를 만들어보았다.


```java
//사용법
String.substring(start) //문자열  start위치부터 끝까지 문자열 자르기
String.substring(start,end) //문자열  start위치 부터 end전까지 문자열 발췌
		

//예제
String str = "ABCDEFG"; //대상 문자열
/*A=0 B=1 C=2 D=3 E=4 F=5 G=6의 index를 가진다.*/
		
str.substring(3); 
/*substring(시작위치) 결과값 = DEFG*/

str.substring(3, 6); 
/*substring(시작위치,끝위치) 결과값 = DEF*/

```


여기서 **end전까지 문자열 발췌**
왜 end까지가 아닌 end전까지 에서 발췌를 할까...

https://www.javatpoint.com/java-string-substring

그리고 만약 여기서 end값을 잘못입력하면
"StringIndexOutOfBoundsException"
Exception이 발생한다.

