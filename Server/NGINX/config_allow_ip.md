2109 12 13


nginx 서버 config 파일에서 IP 제어

대역 차단시
```
 location / {
 
    # IP LIST
    allow 123.4.0.0/8;
    deny  all;

```
맨 뒤는 2진수이다.

예를들어 deny 70.0.0.0/8이면
70.0.0.0부터 70.255.255.255 까지 전부 차단한다.


출처 https://corse.tistory.com/61
https://www.mediawiki.org/wiki/Help:Range_blocks/ko

