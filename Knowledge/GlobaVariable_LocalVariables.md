2021 4 8


전역변수, 지역변수

```java

public class CrmsSendQuestion {
    private static final int MAX_UPLOAD_FILE_SIZE = 10; // 전역변수
    private static final String MY_GITHUB= "https://yangseungmi.github.io";
    ...
    
    public static String getNameCheck(String certType, String ssnHead) {
        String apiUrl = MY_GITHUB + "/resume/src/index.html"; // 지역변수
        ...
        return apiUrl;
    }
}
```

참고 : </br>
https://m.blog.naver.com/okarduino/220737147601</br>
https://java119.tistory.com/20
