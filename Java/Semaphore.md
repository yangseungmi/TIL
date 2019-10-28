2019 10 28

오랜만에 leetcode 문제를 풀다
Semaphore란 걸 알게 되었다
```java
import java.util.concurrent.Semaphore;
```

처음들어 보고 이번 문제에 사용하면서 좀 더 공부를 해 보았다.

https://leetcode.com/problems/print-in-order/discuss/355969/Java-Solution-Semaphore-vs.-CountDownLatch

문제 https://leetcode.com/problems/print-in-order/

참고 https://m.blog.naver.com/PostView.nhn?blogId=seban21&logNo=70155297540&proxyReferer=https%3A%2F%2Fwww.google.com%2F

#### Semaphore의 메소드
##### 1) acquire()
##### Semaphore 리소스 확보
##### https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Semaphore.html#acquire()

##### 2) release()
##### Semaphore 리소스 해제 (반납)
##### https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Semaphore.html#release()

##### 3) availablePermits()
##### Semaphore에서 이용가능한 리소스 갯수
##### https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Semaphore.html#availablePermits()


