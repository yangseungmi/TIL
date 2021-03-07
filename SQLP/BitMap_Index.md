2021 3 7


BitMap Index
비트맵 인덱스


비트맵인덱스는 컴퓨터에서 사용하는 최소단위의 비트를 이용하여 컬럼값을 저장하고, ROWID를 자동으로
생성하는 인덱스의 한 방법이다.

비트를 직접 관리하므로 저장공간이 크게 감소하고 비트연산을 수행할 수 있다는 이점이 있다.

BitMap Index는
= Index key Value 
  + Start RowId
  + End RowId
  + BitMap 엔트리
로 구성되어 있다.

Start RowId와 End RowId의 Range 사이에 있는 모든 row 수만큼 BitMap이 표현되어야 하지만
오라클에서는 내부적인 압축 알고리즘을 사용하여 BitMap을 생성하기 때무에 모두 표현되지 않는 경우도 있다.

비트맵도 B-트리처럼 조직되어 있지만, leaf 노드는 ROWID 값들 대신 각 키 값에 대한 비트맵을 저장한다.

출처 http://www.gurubee.net/lecture/1109
