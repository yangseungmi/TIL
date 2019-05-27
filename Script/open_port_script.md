2019 05 27


리눅스 로컬서버 열린 포트 확인을 위해 구글링해서 찾은 페이지 첨부

https://zetawiki.com/wiki/%EB%A6%AC%EB%88%85%EC%8A%A4_%EB%A1%9C%EC%BB%AC%EC%84%9C%EB%B2%84_%EC%97%B4%EB%A6%B0_%ED%8F%AC%ED%8A%B8_%ED%99%95%EC%9D%B8


### 방법 1 netstat
```
root@zetawiki:~# netstat -tnlp
Active Internet connections (only servers)
Proto Recv-Q Send-Q Local Address           Foreign Address         State       PID/Program name
tcp        0      0 127.0.0.1:8005          0.0.0.0:*               LISTEN      1212/java       
tcp        0      0 0.0.0.0:3306            0.0.0.0:*               LISTEN      1118/mysqld     
tcp        0      0 0.0.0.0:3690            0.0.0.0:*               LISTEN      919/svnserve    
tcp        0      0 0.0.0.0:8080            0.0.0.0:*               LISTEN      1212/java       
tcp        0      0 0.0.0.0:80              0.0.0.0:*               LISTEN      1157/apache2    
tcp        0      0 0.0.0.0:22              0.0.0.0:*               LISTEN      968/sshd
```


### 방법 2 lsof
```
root@zetawiki:~# lsof -i -nP | grep LISTEN | awk '{print $(NF-1)" "$1}' | sort -u
127.0.0.1:8005 java
*:22 sshd
*:3306 mysqld
*:3690 svnserve
*:8080 java
*:80 apache2
```

### 방법 3 nmap
```
root@zetawiki:~# nmap localhost

Starting Nmap 5.21 ( http://nmap.org ) at 2016-06-07 16:54 KST
Nmap scan report for localhost (127.0.0.1)
Host is up (0.0000050s latency).
Not shown: 995 closed ports
PORT     STATE SERVICE
22/tcp   open  ssh
80/tcp   open  http
3306/tcp open  mysql
3690/tcp open  svn
8080/tcp open  http-proxy

Nmap done: 1 IP address (1 host up) scanned in 0.05 seconds
```
