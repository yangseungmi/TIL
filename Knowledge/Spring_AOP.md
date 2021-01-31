2021 1 31

1월 마지막날...

##### 스프링 AOP를 대학교때부터 배우고 회사다닐때도 어노테이션으로 종종보고 이번에 면접준비하면서도 찾아보는데
##### 오늘에서야 정확히 설명할 수 있을만큼 공부했다.

```java
@Component
@Aspect
public class LogAspect {
    
    Logger logger = LoggerFactory.getLogger(LogAspect.class);
    
    @Around("@annotation(LogExecutionTime)")
    //LogExecutionTime 이게 PointCut 
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        
        // @LogExecutionTime 애노테이션이 붙어있는 타겟 메소드를 실행
        Object proceed = joinPoint.proceed();
        
        stopWatch.stop();
        logger.info(stopWatch.prettyPrint());
        
        return proceed; // 결과 리턴
    }
}

public class Test {

    @LogExecutionTime
    public String print() {
        System.out.println(" print method ");
        return "print end";
    }
}

```
출력
```
 print method
print end
--------------------------
ns        %     Task name
--------------------------
13292398  100%
```

### 1. Target
##### 핵심 기능을 담고 있는 모듈로 타겟은 부가기능을 부여할 대상
##### print()

### 2. Advice
##### 타겟에 제공할 부가기능을 담고 있는 모듈
##### @Before
##### @After
##### @Around

### 3. JoinPoint
##### @LogExecutionTime를 붙인 타겟 메소드의 내용
##### 타켓 메소드의 실제 메소드 소스.

### 4. PointCut
##### ex) "@annotation(LogExecutionTime)", execution(* com.xyz.service.*.*(..))
##### @LogExecutionTime가 붙은 곳, service 패키지의 모든 메소드
##### 어느 시점에 적용할 것인지를 정의할 수 있다.

```
출처: https://jeong-pro.tistory.com/171 [기본기를 쌓는 정아마추어 코딩블로그]
도움받은 유튜브 https://www.youtube.com/watch?v=3750wh1wNuY
도움받은 블로그 https://atoz-develop.tistory.com/entry/Spring-%EC%8A%A4%ED%94%84%EB%A7%81-AOP-%EA%B0%9C%EB%85%90-%EC%9D%B4%ED%95%B4-%EB%B0%8F-%EC%A0%81%EC%9A%A9-%EB%B0%A9%EB%B2%95
```
