2019 11 25



현재 우리 서버에서는
1. logstash
2. elastic search
3. kibana
이렇게 사용해서 보여주고 있다.
보통 ELK라고 부른다

하지만 각 서버마다 로그를 파싱해서 적재해주는 logstash는
용량을 많이 차지할 뿐더러
옵션 변경이나 업데이트시 각 서버마다 해줘야 할 일이 많다.


그래서 이번에 우리는 Filebeat를 사용하여

![A1](/Image/filebeat.png)

![A2](/Image/img1.daumcdn.png)

이런식으로 바꿔 파일비트에서 가져온 로그를
로그스태시에서 수집하여 파싱한 뒤 시각화하는 방법으로 바꿔본다.

1. Filebeat
2. logstash
3. elastic search
4. kibana

#### 그럼 Filebeat의 작동 방식은 어떻게 될까?

Filebeat를 시작하면 설정에서 지정한 로그데이터를 바라보는
하나이상의 inputs를 가진다.
지정한 로그 파일에서 이벤트(데이터발생)가 발생할 때마다
Filebeat는 데이터 수확기(harvester)를 시작한다.
하나의 로그 파일을 바라보는 각 havester는 새 로그 데이터를 읽고
libbeat에 보낸다. 그리고 libbeat는 이벤트를 집계하고
집계된 데이터를 Filebeat 설정에 구성된 출력으로 데이터를 보낸다.

출처 https://coding-start.tistory.com/135
