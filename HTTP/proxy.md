2019 1 21

### HTTP

##### proxy

프록시(ProxyP란 '대리'라는 의미로 네트워크 기술에서는 프로토콜에 있어서 대리 응답 등에서 친숙한 개념이다
보안 분야에서는 주로 보안상의 이유로 직접 통신할 수 없는 두 점 사이에서 통신을 할 경우 그 상이에 있어서
중간역할로서 대리로 통신을 수행하는 기능을 가리켜 '프록시', 그 중계 시근을 하는 것을 프록시 서버라고 부릅니다


특징
프록시 서버는 단순히 봉나상의 이유만으로 설치하는 것은 아니다.
물론 보안상의 목적으로 설치하는 경우가 많겠비만, 그외의 경우도 있다
프록시 서버는 프록시 서버에 요청된 내용들을 캐시를 이용하여 저장해 둔다
이렇게 캐시를 해 두고 난 후에, 캐시 안에 있는 정보를 요구하는 요청에 대해서는
원격 서버에 접속하여 데이터를 가져올 필요가 없게 됨으로써 전송 시간을 절약할 수 있게 됨과
동시에 불필요하게 외부와의 연결을 하지 않아도 된다는 장점을 갖게 된다
또한 외부와의 트래픽을 줄이게 됨으로써 네트워크 병목 현상을 방지하는 효과도 얻을 수 있다


종류
##### 1. Forward 프록시
![Alt text](/Image/forward_proxy.PNG  "forward_proxy")
  프록시 서버를 '클라이언트 호스트들과 접근하고자 하는 원격 리소스의 사이'에 위치시키는 것이다.
  이 프록시 서버는 원격 서버로부터 요청된 리소스를 가져와서 요청한 사용자에게 돌려주는 역할을 수행하며
  만일 캐시에 데이터가 남아있다면 다음 요청시 캐시된 데이터로부터 제공해 주게 된다.
  이 서버는 전형적으로 로컬 디스크에 데이터를 저장하며, 클라이언트 호스트들은 사용중인 웹 브라우저를
  이용하여 **프록시 서버 사용 설정**을 해야 하므로 프록시 서버를 사용하고 있다는걸 알 수 있다.
  이 방식은 대역폭 사용을 감소시킬 수 있다는 것과 접근 정책 구현에 있어 다루기 쉬우면서도 비용이 저렴하다는 장점을 갖는다
  또한 사용자의 정해진 사이트만 연결할 수 있는 등 웹 사용 환경을 제한할 수 있으므로 기업 환경등에서 많이 사용한다

##### 2. Reverse 프록시
![Alt text](/Image/reverse_proxy.PNG  "reverse_proxy")
  '인터넷 리소스 또는 인트라넷 리소스 앞'에 프록시 서버를 위치시키는 방식이다
  클라이언트들이 프록시 서버에 연결되었다는 것을 알지 못하며, 마치 최종 사용자가 요청 리소스에 직접 접근하는 것과
  같이 느끼게 된다 내부 서버가 직접 서비스를 제공해도 되지만 이렇게 구서하는 이유는 보안 때문이다
  보통 기업의 네트워크 환경은 내부 네트워크와 외부 네트워크 사이에 위치하는 구간이 존재하며 
  이 구간에는 메일서버, 웹서버, FTP서버 등 외부 서비스를 제공하는 서버가 위치하게 된다.
  예를 들어 사내에서 사용하는 사내 어드민 툴에서 메일 발송이 필요한데 메일 서버에 접근하기 위해서 중간에 프록시 서버를 두고
  ACL(접근 제어 목록, Access control list)에 IP를 추가해 통신하고 있다 또는 특정 포트만 통신할 수 있도록 설정하기도 한다
  
  



