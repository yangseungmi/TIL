2021 2 10

참고 https://futurecreator.github.io/2018/08/26/java-8-streams/

jdk 1.8부터 지원하는 Stream을 전 회사에서 1.6이라 이제서야 알아 사용해보게 되었다.
알면 알수록 너무 편하고, 능력이 많은 Stream은 처음에 Arrays.stream으로 알게 되었다.
오늘 하루 정리로 부족할 내용이지만 그래도 알게된만큼 정리를 해보려고 한다.

스트림은 크게 3가지로 나눌 수 있다.
1. 생성 : 스트림 인스턴스 생성.

2. 가공 : 필터링(filtering) 및 맵핑(mapping) 등 원하는 결과를 만들어가는 중간 작업

3. 결과 만들기 : 최종적으로 결과를 출력하는 작업

```java
String[] arr = new String[]{"a", "b", "c"};
Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3); // 1~2 요소 b,c
        
Stream<String> builderStream = 
    Stream.<String>builder()
    .add("thomas")
    .add("aria")
    .build(); // ["thomas", "aria"]
    
Stream<String> generatedStream = Stream.generate(()->"gen").limit(5); // ["gen","gen","gen","gen","gen"]

Stream<Integer> iteratedStream = Stream.iterate(30, n->n+2).limit(3); // [30,32,34]

IntStream intStream = IntStream.range(1, 5); // 1,2,3,4
LongStream longStream = LongStrea.rangeClosed(1,5); //1,2,3,4,5
DoubleStream doubles = new Random().doubles(3); // 난수 3개 생성 

IntStream charsStream = "Streamm".chars(); // [83, 116, 114, 101, 97, 109]

Stream<String> stringStream = 
  Pattern.compile(", ").splitAsStream("Eric, Elena, Java");
  // [Eric, Elena, Java]

/* map은 스트림 내 요소들을 하나씩 특정 값으로 변환해준다. 이때 값을 변환하기 위해 람다를 인자로 받는다 */

Stream<String> stream = names.stream().map(String::toUpperCase); // [ERIC, ELENA, JAVA]

/* Iterating 스트림 내 요소들 각각을 대상으로 특정 연산을 수행하는 메소드로는 'peek'이 있다.
뜻은 '확인해본다'로 결과를 반환하지 않고 Consumer를 인자로 받는다. */
int sum = IntStream.of(1,3,5).peek(System.out::println).sum(); // 9

List<String> names = Arrays.asList("Eric", "Elena", "Java");  // 여기 Arrays.asList도 궁금해서 찾아보았다(https://shinsunyoung.tistory.com/57)
names.stream().forEach(System.out::println);






```
