2019 10 31



참고 https://blog.hkwon.me/ab-apache-http-server-benchmarking-tool/

AB(Apache HTTP server benchmarking tool)는 커맨드 라인을 활용한 매우 가볍고 유용한 웹서버 벤치마킹 도구 이다.

간단한 REST API나 정적 컨텐츠에 대한 성능 테스트 시에 빠르고 간편하게 벤치마킹 정보를 얻어올 수 있다.

옵션

옵션	설명
-n	성능을 검사하기위해 보내는 요청수. 기본값으로 요청을 한번만 보내기때문에 일반적인 성능검사 결과를 얻을 수 없다.
-c	동시에 요청하는 요청수. 기본적으로 한번에 한 요청만을 보낸다.
-g	측정한 모든 값을 'gnuplot' 혹은 TSV (Tab separate values, 탭으로 구분한 값) 파일에 기록한다. 라벨은 output 파일의 첫번째 라인을 참고한다.
-t	성능을 검사하는 최대 초단위 시간. 내부적으로 -n 50000을 가정한다. 정해진 시간동안 서버 성능을 검사할때 사용한다. 기본적으로 시간제한 없이 검사한다.
-v	출력 수준을 지정한다.
4 이상이면 헤더에 대한 정보를,
3 이상이면 (404, 202, 등) 응답코드를,
2 이상이면 경고(warning)와 정보(info)를 출력한다.
-A	프록시를 통해 BASIC Authentication 정보를 제공한다.
:로 구분한 사용자명과 암호를 base64 인코딩하여 전송한다.
-X	proxy[:port] 프록시 서버를 사용하여 요청한다.


예를들어
```cmd
$ ab -n 100 -c 10 -g result.plot http://www.google.com/index.html
```

 http://www.google.com/index.html파일에 대해서 10개의 동시요청으로 총 100개의 요청을 한다.
 
