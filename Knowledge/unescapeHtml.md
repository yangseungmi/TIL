2019 5 8

오늘 오랜만에 자바 개발해 보았다
CKeditor에서 html 파일을 추가/편집 하는 기능을 만들면서 
ajax로 text를 서버에 넘기는 소스를 구현하였다


에디터에서 텍스트를 넘기는건 어렵지 않았는데
서버에서 html 텍스트를 받았을 때 태그(<,>,..)들이
＆nbsp; ＆amp; ＆lt; ＆gt; ＆quot; 등으로 치환되어

구글링을 해 해결책을 찾았다
'java html tag 변환'라고 검색을 했고 
이 https://aljjabaegi.tistory.com/368 블로그의 
unescapeHtml라는 method를 사용하였다

```java
import org.apache.commons.lang3.StringEscapeUtils;
```
https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/StringEscapeUtils.html


이 API 중 'unescapeHtml3'이라는 메소드를 사용하여
예를 들어
```java
String unescapeText = StringEscapeUtils.unescapeHtml3(htmlText);
```

replace를 사용해서 태그 하나하나 치환 처리 해줘야하나 했었는데
역시 구글링 최고!

