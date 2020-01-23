2020 1 23




MySQL 중복 키 관리 방법 (INSERT 시 중복 키 관리 방법)
- INSERT INGNORE
- REPLACE INTO
- ON DUPLICATE UPDATE


1) INSERT IGNORE
중복 키 에러가 발생했을 때 신규로 입력되는 레코드를 무시하는 단순한 방법이다.
INSERT 구문 자체는 오류가 발생하지 않고 결과가 0이다.

```sql
mysql> INSERT IGNORE INTO person VALUES (NULL, 15, 'James', 'Barkely');
Query OK, 1 row affected (0.00 sec)

mysql> INSERT IGNORE INTO person VALUES (NULL, 15, 'James', 'Barkely');
Query OK, 0 rows affected (0.00 sec)

mysql> SELECT * FROM person;
+----+------------+------------+-----------+
| id | academy_id | first_name | last_name |
+----+------------+------------+-----------+
|  1 |         15 | James      | Barkely   |
|  2 |         15 | Cynthia    | Smith     |
+----+------------+------------+-----------+
2 rows in set (0.00 sec)
```


2) REPLACE INRTO
“REPLACE INTO”는 “INSERT INTO” 구문에서 INSERT를 REPLACE로 바꾼 구문이다. 사용 방법은 “INSERT INTO”와 완벽히 동일하다.

```sql
mysql> REPLACE INTO person VALUES (NULL, 15, 'Cynthia', 'Smith');
Query OK, 1 row affected (0.00 sec)
 
mysql> REPLACE INTO person VALUES (NULL, 15, 'Cynthia', 'Smith');
Query OK, 2 rows affected (0.00 sec)

mysql> SELECT * FROM person;
+----+------------+------------+-----------+
| id | academy_id | first_name | last_name |
+----+------------+------------+-----------+
|  4 |         15 | Cynthia    | Smith     |
|  5 |         15 | James      | Barkely   |
+----+------------+------------+-----------+
2 rows in set (0.00 sec)
```
id가 4,5가 되었다. REPLACE INTO는 중복 키 오류 발생 시 기존 레코드를 삭제하고 새로운 레코드를 입력한 것이다.
그래서 ‘2 rows affected’가 출력되었다. 
1건은 DELETE, 1건은 INSERT로 보면 되고, 새로운 레코드가 입력되면서 AUTO_INCREMENT 컬럼의 값이 매번 새롭게 발급되었다.



3) ON DUPLICATE UPDATE
중복 키 오류 발생 시, 사용자가 UPDATE될 값을 지정할 수 있음

```sql
mysql> INSERT INTO person VALUES (NULL, 15, 'James', 'Barkely', 1)
    ->     ON DUPLICATE KEY UPDATE insert_cnt = insert_cnt + 1;
Query OK, 1 row affected (0.00 sec)
 
mysql>
mysql> INSERT INTO person VALUES (NULL, 15, 'James', 'Barkely', 1)
    ->     ON DUPLICATE KEY UPDATE insert_cnt = insert_cnt + 1;
Query OK, 2 rows affected (0.00 sec)
 
 mysql> SELECT * FROM person;
+----+------------+------------+-----------+------------+
| id | academy_id | first_name | last_name | insert_cnt |
+----+------------+------------+-----------+------------+
|  1 |         15 | James      | Barkely   |          2 |
+----+------------+------------+-----------+------------+
2 rows in set (0.00 sec)
```
id는 그래도 1이고 insert_cnt 값만 증가하였다.

