2019 12 10

12월이라니ㅠㅠ


리눅스 서버에서
winscp에서 받아온 스크립트 파일을 실행시키니

```
/bin/bash^M: bad interpreter
```

에러 문구가 나왔다.

나는 ^M을 붙인 적이 없는데
구글링 해보니


윈도우에서 스크립트 파일을 만든 뒤, linux 에서 실행했기 때문에 나타나는 오류이다.
정확히는 줄 끝 (줄바꿈)을 의미하는 개행문자가 달라서 발생하는 문제인데 이것의 해결을 위해서는 다음의 방법 중 한 가지로 처리한다.


라고 한다.

$vi -b test.sh
로 확인해보니 줄 끝마다 ^M가 붙어있다.


### 해결방법

$vi test.sh

:set fileformat=unix 
실행하고 저장

./test.sh

문제 없이 실행 된다.

출처 https://itgameworld.tistory.com/23


