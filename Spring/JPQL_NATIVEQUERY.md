2019 1 17

## SPRING

### JPQL_NATIVEQUERY

참고 https://www.baeldung.com/spring-data-jpa-query



1. JPQL
> 정의 JPQL(Java Persistence Query Language)
```java
@Query("SELECT u FROM User u WHERE u.status = 1")
Collection<User> findAllActiveUsers();
```


2. Native
```java
@Query(
  value = "SELECT * FROM USERS u WHERE u.status = 1", 
  nativeQuery = true)
  Collection<User> findAllActiveUsersNative();
```

처음에 둘의 차이를 바로 찾지 못했다.. 머가 다른거지?
유저 중에서 상태가 1인거 찾는건대 똑같아 보여

하지만 먼가 조금씩 다르다 같은 Query 어노테이션 안에 있지만
JPQL은 User 테이블에서 가져오고, Native는 USERS 에서 가져온다

우선 
JPQL은 테이블을 대상으로 쿼리하지 않고 **객체**를 고려해 쿼리한다 실제로 User라는 테이블은 없다.
이 때문에 JPQL은 데이터베이스 테이블에 직접적인 의존 관계를 맺고 있지 않고 Users 테이블 내용을 담은 
User라는 객체를 불러와 쿼리 실행을 하는 구조이다.

```java
TypedQuery<Parent> query = em.createQuery("SELECT p FROM Parent p WHERE p.name = :name", Parent.class);
query.setParameter("name", name);
```
또한
파라미터 바인딩이라는 방법이 있다. 파라미터 바인딩은 JPQL문 안에 파라미터로 설정한 기준 파라미터 앞에 :를 설정합니다.
:name처럼  그리고 setParameter 메서드를 이용해 외부에서 파라미터를 설정할 수 있습니다.




출처: http://happygrammer.tistory.com/149 [해피그래머의 개발 노트]


