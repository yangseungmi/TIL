2021 2 1

##### 어제 스프링 AOP에 DI를 복습하고 정리해보았다.

우선 내가 실제 사용했던 소스들을 예제로 보면서 공부했다.
1. ApplicationConfig.java
```java
@Configuration
public class ApplicationConfig {
    public Map<String, Map<String, Object>> fqdn;
}
```

2. RedbellService.java
```java
@Service
public class RedbellService {

    // 1번 - 필드 주입 방식
    @Autowired
    private ApplicationConfig applicationConfig;

    // 2번 - 생성자 메서드 주입방식 (선호 )
    private ApplicationConfig applicationConfig;
    
    public RedbellService(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }
}
```

코드 RedbellService에서 ApplicationConfig를 생성하지 않고, 
RedbellService의 생성자에 파라미터로 지정 -> DI

3. RedbellController.java
```java
@RequiredArgsConstructor     -> 초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성해 줍니다.
@Controller
public class RedbellController {
    private final RedbellService redbellService;
    
    public Boolean test(){
      boolean isSave = redbellService.saveRedbellIdentification(dto);
      return isSave;
    }
}
```

DI 장점
Service에서 직접 객체를 생성하지 않아 자원을 아낄 수 있고, 객체들 간의 의존성을 줄일 수 있다.

```
도움받은 글
https://medium.com/@yongkyu.jang/spring-ioc-%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9D%98%EC%A1%B4%EC%84%B1-%EC%A3%BC%EC%9E%85%EC%97%90-%EB%8C%80%ED%95%9C-%EC%9E%A1%EC%84%A4-9388de65ce8c
https://medium.com/webeveloper/requiredargsconstructor-%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EC%9D%98%EC%A1%B4%EC%84%B1-%EC%A3%BC%EC%9E%85-dependency-injection-4f1b0ac33561

도움받은 유튜브
https://www.youtube.com/watch?v=NOAajiABq6A
https://youtu.be/IVzYerodIyg
```
