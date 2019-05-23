2019 5 14

DB 설계 중 자료형을 'Text'로 잡았다가

' Data truncation: Data too long for column 'content' at row ' 라는 에러가 나왔다

데이터 크기가 타입보다 커서 검색하다가 BLOB으로 바꿀까 했었는데 

TEXT와 다른점도 많고 MEDIUMTEXT라는 자료형이 있어 바꿔서 해결했다

|TYPE|SIZE|
|----|----|
|TEXT|65,535|
|MEDIUMTEXT|16,777,215|
|BLOB|65,535|

-> TEXT와 BLOB은 크기가 같았다.


        TEXT는 문자셋(Character set),
        BLOB은 이진데이터를 저장한다 (BLOB - Binary Large Object)


## 차이점

1. MySQL의 BLOB은 "binary large object"의 약자로 
binary 형태의 데이터(byte strings)를 저장하기에 적당하고, 
TEXT는 문자셋(Character set)에 대한 내용을 포함하기 때문에 
문자형태의 데이터(character strings)를 저장하기에 적당하다.


2. BLOB은 정렬 시에 저장된 숫자값 기반으로 정렬을 수행하고, 
TEXT는 문자집합을 고려하여 정렬한다.


3. TEXT 필드에 인덱스(index)가 지정되어 있으면, 
내용 비교 시에 마지막에 붙은 공백(trailing-space)은 무시된다. 
unique와 같이 인데스 비교를 하는 테이블에 "a"가 들어있다고 하자. 
이 때, "a "를 넣으려고 하면 중복 오류(duplicate-key)가 발생하는 것이다. 
하지만, BLOB은 그렇지 않다

