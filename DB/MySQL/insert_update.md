2019 03 28

#### 값이 없으면 Insert 하고, 값이 있으면 update 하기

##### mssql 에서 select를 하고 값을 mysql 에 insert 하는 python 스크립트를 짜는 중

##### 조건에 따라 다르게 insert or update 하는 쿼리를 알게 되었다

***

데이터베이스에서 대량의 데이터를 등록할때 기존에 값이 저장되어 있는 경우 기존에 저장된 값이 존재하거나
Unique 키 값은 같은데 데이터가 다를 경우들이 있다.

이런 경우 insert 문만 계속 요청하면 오류가 발생하기도 하고, 이미 값이 저장되어 있으면 새로운 값으로 
변경되어 저장해야 하는 경우들이 있다.

이럴 때 Unique 키 값이 존재할 때 새로운 값이 들어오면  UPDATE를 실행해주도록 하는 
```sql
INSERT INTO ON DUPLICATGE KEY UPDATE
```
쿼리를 사용하여 원활한 작업을 수행할 수 있다.


***


```python
 pubg_insert_query = """
        INSERT INTO GM_PUBG_PCBATTLE.OOO (
            userid
            , name
            , owner
            , address_sido
            , address_jibun
            , address_street
            , address_detail
            , is_delete
            , status
            , area_code
            , ward_code
        )
        VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)
        ON DUPLICATE KEY UPDATE
            name = %s
            , owner = %s
            , address_sido = %s
            , address_jibun = %s
            , address_street = %s
            , address_detail = %s
            , is_delete = %s
            , status = %s
            , area_code = %s
            , ward_code = %s
    """
 ```












출처: https://tez.kr/161






