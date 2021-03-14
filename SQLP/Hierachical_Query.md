2021 3 14


Hierachical_Query
계층형 질의

|가상컬럼|설명|
|------|-------|
|Level|루트 데이터면 1, 하위 데이터면 2, 리프테이터까지 1씩 증가|

```sql
SELECT LEVEL, EMPNO, MGR, CONNECT_BY_ISLEAF
FROM   EMP
START WITH MGR IS NULL
CONNECT BY PRIOR EMPNO = MGR;
```


- START WITH절은 계층 구조 전개의 시작 위치를 지정하는 구문이다. 즉, 루트 데이터를 지정한다.
- CONNECT BY절은 다음에 전개될 자식 데이터를 지정하는 구문이다. 자식 데이터는 CONNECT BY절에 주어진 조건을 만족해야한다.
- PRIOR : CONNECT BY절에 사용되면, 현재 읽은 컬럼을 지정한다.
          PRIOR 자식 = 부모 형태를 사용하면 계층 구조에서 부모데이터 -> 자식데이터 방향으로 전개하는 순방향 전개를 한다.
          PRIOR 부모 = 자식 형태를 사용하면 반대로 자식데이터 -> 부모데이터 방향으로 전개하는 역방향 전개를 한다.
- NOCYCLE : 데이터를 전개하면서 이미 나타났던 동일한 데이터가 전개 중에 다시 나타난다면 이것을 가리켜 사이클이 형성되었다한다.
            사이클이 발생한 데이터는 런타임 오류가 발생해 NOCYCLE을 추가하면서 사이클이 발생한 이유의 데이터는 전개하지 않는다.
- ORDER SIBILINGS BY : 형제 노드(동일 LEVEL) 사이에서 정렬을 수행한다.
- WHERE : 모든 전개를 수행한 후에 지정된 조건을 만족하는 데이터만 추출한다. 필터링.


