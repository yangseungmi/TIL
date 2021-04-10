2021 4 9


## vim 문자열 치환

substitute 의 's'
1. 명령어 기본
```
: 시작행,끝행s/원래문자열/변경문자열/옵션 
```


aa -> AA 예시
```vi
aa

:%s/aa/AA/g
:%s/[a-z]/AA/g       -- 사이에 정규식도 가능.
```
<-
```vi
AA
```

:%s/{변경하고자 하는 문자열}/{변경할 문자열}</br>


### Example
#### (1) 1~10행의 모든 Hello를 Bye로 변경
- :1,10s/Hello/Bye/g
#### (2) 문서 전체의 모든 Hello를 Bye로 변경
- :%s/Hello/Bye/g
#### (3) 현재 행에서 마지막 행 까지의 모든 Hello를 Bye로 변경
- :.,$s/Hello/Bye/g

</br>
참고 https://harryp.tistory.com/736</br>
참고 https://soulduse.tistory.com/87
