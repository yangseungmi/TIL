2021 3 15


Index_Scan
인덱스 스캔

1. Index Range Scan
B-tree 인덱스의 가장 일반적이고 정상적인 형태의 엑세스 방식
* 조건 : 인덱스를 구성하는 **선두컬럼**이 조건절에 사용되어야 한다.

2. Index Full Scan
수직적 탐색없이 인덱스 리프 블록을 처음부터 끝까지 수평적으로 탐색하는 방식.

3. Index Unique Scan
Unique 인덱스를 '=' 조건으로 탐색하는 경우에 작동한다.

4. Index Skip Scan
루트 또는 브랜치 블록에서 읽은 컬럼 값 정보를 이용해 조건에 부합하는 레코드를
포함할 '가능성이 있는' 하위 블록만 골라서 엑세스 하는 방식
인덱스 선행컬럼이 누락됐거나 부등호, like 같은 범위검색 조건일 때

5. Index Fast Full Scan
인덱스 트리 구조를 무시하고, 인덱스 세그먼트 전체를 
MultiBlock Read 방식으로 스캔.
인덱스에 포함된 컬럼만으로 조회될 때 사용 가능.

6. Index Range Scan Descending
인덱스를 뒤에서 앞으로 스캔하는 내림차순 결과 집합.

참고 - https://riverandeye.tistory.com/entry/4-인덱스-확장기능-사용법
