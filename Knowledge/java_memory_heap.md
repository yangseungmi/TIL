2019 5 20

출처 https://yaboong.github.io/java/2018/05/26/java-memory-management/


어제 stack에 이어 heap을 정리해 본다.
대학교 때 후로 거의 근처도 가지 않았었는데..

오랜만에 읽어보니 또 새롭다 ㅎㅎ
오늘 하루에 heap을 정리하려니 양이 많아 오늘도 간단한 예제만 가져와봤다

 - Heap 영역에는 주로 긴 생명주기를 가지는 데이터들이 저장된다. 
(대부분의 오브젝트는 크기가 크고, 서로 다른 코드블럭에서 공유되는 경우가 많다)

 - 애플리케이션의 모든 메모리 중 stack 에 있는 데이터를 제외한 부분이라고 보면 된다.
 
 - 모든 Object 타입(Integer, String, ArrayList, ...)은 heap 영역에 생성된다.
 
 - 몇개의 스레드가 존재하든 상관없이 단 하나의 heap 영역만 존재한다.
 
 - Heap 영역에 있는 오브젝트들을 가리키는 레퍼런스 변수가 stack 에 올라가게 된다.

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> listArgument = new ArrayList<>();
        listArgument.add("yaboong");
        listArgument.add("github");

        print(listArgument);
    }

    private static void print(List<String> listParam) {
        String value = listParam.get(0);
        listParam.add("io");
        System.out.println(value);
    }
}

```

![Alt text](/Image/java-memory-management_heap-3.png)
![Alt text](/Image/java-memory-management_heap-4.png)
![Alt text](/Image/java-memory-management_heap-5.png)
![Alt text](/Image/java-memory-management_heap-6.png)
![Alt text](/Image/java-memory-management_heap-7.png)










