2020 1 13

2020년 첫 커밋..

##### 테이블 정보를 알고 싶을 때 툴에서 테이블을 직접 찾아 디자인을 클릭해 상세정보를 알아봤지만 이것 또한 쿼리가 따로있었다. 

```sql

select * from information_schema.columns
where table_name = 'TABLE1'
order by 5

```
