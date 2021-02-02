2021.1.26

## 인터뷰 준비

### 오늘의 주제는 Java Memory 

Java Memory 구조로 구글링을 해보면 많은 블로그에 개발자 면접 Q&A로 올라와 있다

그중 그림으로 잘 표현해 주신 블로그 글을 참고로 정리해보았다.
오랜만이라 다 잊었는데, 텅 빈 머리를 다시 채워나가... 기 힘들다.

이미지 찾아서 내 리파지토리에 올렸는데 ㅋㅋㅋ비슷한 이름의 이미지들이 많았다... 공부를 했었지만 또 잊어버려서 반복하는 중이다 ;(

![Alt text](/Image/java_memory.png  "java_memory")

메모리 구조
1. **Class Area(=Method Area)** 메모리로 읽어온 클래스의 정보를 기억한다.
2. **heap** 클래스의 객체를 생성하여 기억한다.
3. **stack** 메서드 수행 시마다 프레임이 할당되어 메서드 수행에 필요한 변수(로컬변수)나 중간 결과 값을 임시 기억한다. 
메서드가 종료될 경우 할당된 메모리가 자동 제거된다.


참고 https://beforb.tistory.com/6#Java3