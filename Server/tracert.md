2020 5 12

ACL 확인

WINDOW OS

1. telnet
```console
C:\Users\kakaogames>telnet 10.63.91.13 443
```


2. tracert / traceroute
```console
C:\Users\kakaogames>tracert daum.net

최대 30홉 이상의
daum.net [10.41.244.71](으)로 가는 경로 추적:

  1     3 ms     3 ms     3 ms  10.200.200.200
  2     4 ms     5 ms     3 ms  10.63.95.11
  3     5 ms     4 ms     4 ms  172.25.255.242
  4     5 ms     5 ms     5 ms  172.28.255.49
  5     6 ms     5 ms     5 ms  172.28.255.249
  6     4 ms     4 ms     4 ms  172.26.0.129
  7     5 ms     5 ms     4 ms  10.4.2.13
  8     5 ms     5 ms     4 ms  10.4.38.30
  9     5 ms     5 ms     5 ms  10.41.244.71

추적을 완료했습니다.
```

LINUX OS
```console
[hanadmin@gm-pcb-ncrm1 ~]$ traceroute www.daum.net
traceroute to www.daum.net (203.133.167.16), 30 hops max, 60 byte packets
 1  1.255.12.2 (1.255.12.2)  0.433 ms  0.316 ms  0.419 ms
 2  110.9.3.64 (110.9.3.64)  1.003 ms 110.9.3.60 (110.9.3.60)  0.999 ms  1.025 ms
 3  * * *
 4  58.229.10.50 (58.229.10.50)  2.830 ms 175.124.170.34 (175.124.170.34)  21.157 ms  21.153 ms
 5  211.58.252.105 (211.58.252.105)  2.519 ms  2.474 ms 203.229.222.209 (203.229.222.209)  1.594 ms
 6  * * *
 7  112.174.25.110 (112.174.25.110)  1.663 ms 112.174.34.82 (112.174.34.82)  1.947 ms  2.407 ms
 8  * * *
 9  * * *
10  * * *

```



