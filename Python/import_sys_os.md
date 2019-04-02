2019 4 2

python에서 외장함수를 import 할 수 있도록 위에 선언해서 사용하는데
이번에 encoding을 쓰면서 정리 해 보았다


```python
import sys
import os
import getopt
import requests
import json
import logging
import datetime
import md5
import enum
...

```

이 중 sys와 os 에 대해 알아보았다

### sys
***
sys 모듈은 파이썬 인터프리터가 제공하는 변수들과 함수들을 직접 제어할 수 있게 해주는 모듈이다.


```python
sys.path.append(os.path.abspath('../lib/'))
```
위와 같이 파이썬 프로그램 파일에서 sys.path.append를 이용해 경로명을 추가할 수 있다. 
이렇게 하고 난 후에는 '../lib/' 디렉터리에 있는 파이썬 모듈을 불러와서 사용할 수가 있다.

```python
sys.setdefaultencoding('utf8')
sys.setdefaultencoding('euc-kr')
```
한글처리할 때 sys의 setdefaultencoding을 사용한다

#### os
***
OS 모듈은 환경 변수나 디렉터리, 파일 등의 OS 자원을 제어할 수 있게 해주는 모듈이다.

```python
environ({'ACLOCAL_PATH': 'C:\\Program Files\\Git\\mingw64\\share\\aclocal;C:\\Pr...
```
시스템은 제각기 다른 환경 변수값을 가지고 있는데, os.environ은 현재 시스템의 환경 변수 값들을 보여 준다. 

 * 디렉터리 위치 리턴받기 - os.getcwd
 * 시스템 명령어 호출하기 - os.system
 * 디렉터리 생성         - os.mkdir(디렉터리)



