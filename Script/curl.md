2019 3 23

curl

요즘들어 스크립트를 사용할 일이 많아졌다
맨날 아는것만 쓰고 필요할 때 구글링 해서 사용하고 잊어버리고 또 찾고 해서 
제일 자주(?) 쓰는 curl 옵션들을 찾아보았다
옵션 뜻도 알고 앞으로 더 효율적으로 사용할듯.

출처 https://sarc.io/index.php/os/1364-tip-curl-option
의 출처 : https://www.lesstif.com/pages/viewpage.action?pageId=14745703


sort |   long | 설명 | 비고
------------ | ---------------- | ------------- | ------------- 
-k | --insecure | https 사이트를 SSL certificate 검증없이 연결한다. | wget 의 -no-check-certificate와 비슷한 역할 수행
-l | --head     | HTTP header만 보여주고 content는 표시하지 않는다. |
-D | --dump-header <file> | <file> 에 HTTP header를 기록한다. |
-L | --location | 서버에서 HTTP 301이나 HTTP 302 응답이 왔을 경우 redirection URL 로 따라간다. --max-redirs 뒤에 숫자로 redirection을 몇 번 따라갈지 지정할 수 있다.(기본값 50) |  curl -v daum.net 을 실행하면 결과값으로 다음과 같이 HTTP 302가 리턴된다 $curl -L daum.net으로 하면 www.daum.net 으로 재접속하여 결과를 받아온다
-d | --data | HTTP Post Data | FORM을 POST하는 HTTP나 JSON으로 데이타를 주고받는 REST 기반의 웹서비스 디버깅시 유용한 옵션이다
-v | --vervose | 동작하면서 자세한 옵션을 출력한다. |
-J | --remote-header-name | 어떤 웹서비스는 파일 다운로드시 'Content-Disposition Header'를 파싱해야 정확한 파일이름을 알 수 있는 경우가 있다. -J 옵션을 주면 헤더에 있는 파일 이름으로 저장한다. | curl 7.20 이상부터 추가된 옵션
-o | --output FILE | curl은 remote에서 받아온 데이터를 기본적으로는 콘솔에 출력한다. -o 옵션 뒤에 FILE을 적어주면 해당 FILE로 저장한다.|
-O | --remote name | file 저장시 remote의 file 이름으로 저장한다. |
-s | --silent | 정숙 모드. 진행 내역이나 메세지 등을 출력하지 않는다 -o 옵션으로 remote data도 /dev/null로 보내면 결과물도 출력되지 않는다 | HTTP response code만 가져오거나 할 경우 유리


curl -L game.daum.net
정도만 알고있었는데 새삼 많이 깨달았다. 더 많으니 사용하면서 추가로 정리할 생각이다.

