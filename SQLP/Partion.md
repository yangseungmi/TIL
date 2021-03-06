2021 3 5


DB Partition
디비 파티션


개념
- 논리적인 데이터 elemet들을 다수의 entity로 쪼개는 행위를 뜻하는 일반적인 용어
- 즉 큰 table이나 index를, 관리하기 쉬운 partition이라는 작은 단위로 물리적으로 분할하는 것.


목적
1. 성능
- 특정 DML과 QUERY의 성능을  향상
- 주로 대용량 Data WRITE 환경에서 효율적이다.
- 특히, Full Scan에서 데이터 Access의 범위를 줄여 성능 향상을 가져온다.
- 많은 INSERT가 있는 OLTP 시스템에서 INSERT 작업을 작은 단위인 partition들로
분산시켜 경합을 줄인다.

2. 가용성
-  물리적인 파티셔닝으로 인해 전체 데이터의 훼손 가능성이 줄어들고 데이터 가용성이 향상.
-  각 분할 영역을 독립적으로 백업하고 복구 가능.
-  table의 partition 단위로 Disk I/O을 분산하여 경합을 줄이기 때문에 UPDATE 성능을 향상

3. 관리용이성
- 큰 테이블들을 제거하여 관리를 쉽게 해준다.


  종류
  1. 수평 파티셔닝


  2. 수직 파티셔닝



분할기준
1. 범위 분할
2. 목록 분할
3. 해시 분할
4. 합성 분할



https://gmlwjd9405.github.io/2018/09/24/db-partitioning.html
