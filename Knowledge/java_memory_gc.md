2019 5 21

이어서 오늘을 Garbage Collection 정리를 해보았다

마찬가지로
https://yaboong.github.io/java/2018/05/26/java-memory-management/ 블로그 출처

```java
public class Main {
    public static void main(String[] args) {
        String url = "https://";
        url += "yaboong.github.io";
        System.out.println(url);
    }
}
```

![Alt text](/Image/java-memory-management_heap-12.png)


##### Stack 에는 새로운 변수가 할당되지 않는다. 
문자열 더하기 연산의 결과인 "https://yaboong.github.io" 가 새롭게 heap 영역에 생성되고, 
기존에 "https://" 를 레퍼런스 하고 있던 url 변수는 새롭게 생성된 문자열을 레퍼런스 하게 된다.

### 기존의 "https://" 라는 문자열을 레퍼런스 하고 있는 변수는 아무것도 없으므로 "Unreachable 오브젝트"가 된다.


JVM 의 Garbage Collector 는 Unreachable Object 를 우선적으로 메모리에서 제거하여 메모리 공간을 확보한다. 
Unreachable Object 란 Stack 에서 도달할 수 없는 Heap 영역의 객체를 말하는데, 
지금의 예제에서 "https://" 문자열과 같은 경우가 되겠다. 아주 간단하게 이야기해서 이런 경우에 
Garbage Collection 이 일어나면 Unreachable 오브젝트들은 메모리에서 제거된다.


### Garbage Collection 과정은 **Mark and Sweep** 이라고도 한다. 
JVM의 Garbage Collector 가 스택의 모든 변수를 스캔하면서 각각 어떤 오브젝트를 레퍼런스 하고 있는지 찾는과정이 Mark 다.
Reachable 오브젝트가 레퍼런스하고 있는 오브젝트 또한 marking 한다. 
첫번째 단계인 marking 작업을 위해 모든 스레드는 중단되는데 이를 stop the world 라고 부르기도 한다. 
(System.gc() 를 생각없이 호출하면 안되는 이유이기도 하다)

그리고 나서 mark 되어있지 않은 모든 오브젝트들을 힙에서 제거하는 과정이 Sweep 이다.

Garbage Collection 이라고 하면 garbage 들을 수집할 것 같지만 실제로는 garbage 를 수집하여 제거하는 것이 아니라,
garbage 가 아닌 것을 따로 mark 하고 그 외의 것은 모두 지우는 것이다. 
만약 힙에 garbage 만 가득하다면 제거 과정은 즉각적으로 이루어진다.

Garbage Collection 이 일어난 후의 메모리 상태는 아래와 같을 것이다.


![Alt text](/Image/java-memory-management_heap-13.png)

