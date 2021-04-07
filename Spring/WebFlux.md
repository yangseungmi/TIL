2021 4 7


# Spring WebFlux

우선 제일 많이 알고 있는 Spring MVC 와 비교를 해보자면  
MVC : request - Dispatcher Servlet - Handler Mapper - Controller - B/L - Controller - ViewResolver ...</br>
WebFlux : request - HttpHandler - WebHandler - Handler Mapper / Handler Adapter - Controller - B/L - 이하 같음

동작흐름은 이렇다.

출처: https://kimyhcj.tistory.com/343 [기억과 기록]


소스코드로 예를 들자면
```java

// 1) FirstHandler.java
@Component
public class FirstHandler {
	
    private HashMap<Object, Object> result = new HashMap<>();
    private Mono<HashMap<Object, Object>> mapper = Mono.just(result);

    public Mono<ServerResponse> hello(ServerRequest request) {
        result.put("number", 1234);
        result.put("text", "webFlux");			
        mapper.subscribe( (arg)->{//구독..?
            System.out.println(arg);  
        });
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromProducer(mapper, HashMap.class));
    }
}
```

```java
2) RoutsConfig.java
@Configuration
public class RoutsConfig {	

    @Bean
    public RouterFunction<ServerResponse> route(FirstHandler handler) {
        return RouterFunctions.route(
            RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), handler::hello);
    }
	
}    


```
많음 도움 및 출처 :https://lts0606.tistory.com/301?category=761939

참고 https://projectreactor.io/
