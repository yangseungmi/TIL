2019 10 15

mysql workbench에서 null값을 조건에 넣어 추출하는데
값이 안나와서 데이터를 계속 확인하다

```sql
selet *
from test_table
where 
id = '' or id = null
```
이렇게 했을때 mysql에서 ''값은 select해도 null 값은 select 하지 못한다.


```sql
selet *
from test_table
where 
id = '' or id is null
```

=등호가 아닌 'is'를 사용해야 한다.
