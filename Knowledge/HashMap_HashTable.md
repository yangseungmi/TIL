2021 2 8

저번에 HashSet을 사용해보고
오늘 HashMap과 HashTable을 비교하면서 각각 공부를 해보았다.




자바에서 제공하는 HashMap과 HashTable은 Map 인터페이스를 상속받아 구현되어 데이터를
키와 값으로 관리하는 자료구조이다.


#### 차이점
1) 동기화
HashMap은 동기화를 지원하지 않는다.
반면 다중 스레드 환경에서 HashTable은 동기화를 지원하기 때문에 실행 환경에 따라 구분하여 사용하면 된다.
  * 해쉬테이블의 동기화는 속도를 굉장히 느리게 해주기 때문에, 동기화가 보장되는 HashMap이 등장 -> ConcurrentHashMap

2) 반환값
HashMap은 저장된 요소들의 순회를 위해 Fail-Fast Iterator를 반환한다
HashTabledms Enumeration을 반환한다.

3) Null 허용
HashTable 은 null 키를 허용하지 않는다
HashMap은 하나의 null 키와 임의의 수의 null 값을 허용한다.




