2019 10 4



파이썬에서 날짜 구하기

```python
import datetime

##오늘날짜
now = datetime.datetime.now()
##어제날짜
yesterday = datetime.now() - timedelta(days=1)
##날짜 format
yesterday.strftime('%Y%m%d')
##-> 20191003
```

