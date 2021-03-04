2021 3 4



### 옵티마이저

인덱스의 유무, 데이터 분산 또는 편향 정도 등의 통계정보를 참고하여
여러 실행계획을 작성하고, 이들의 비용을 연산하고, 가장 낮은 비용을
가진 실행계획을 선택하는 DBMS 핵심 엔진.
그리고 이러한 최적의 실행 방법을 실행계획(Execution Plan)이라고 한다.


1) 규칙 기반 옵티마이저(Heuristic Optimizer, Rule-Based Optimizer, RBO)

- 미리 정해놓은 규칙에 맞춰 엑세스 경로를 평가, 실행계획을 선택
- 엑세스 경로 별 인덱스 구조, 연산자, 조건절 형태를 중요시 한다.

2) 비용 기반 옵티마이저(Cost-Based Optimizer)

- 통계 정보를 기초로 오퍼레이션 단계 별 예상 비용 산정, 최소 비용을 선택
- 레코드 개수, 블록 개수, 평균 행 길이, 칼럼 값 수와 분포 등을 고려한다.

3) 스스로 학습하는 옵티마이저(Self-Learning Optimizer)

- sql별 저장된 런타임 수행 통계 등, 앞으로의 예상값과 비교하여 실행계획을 조정


[출처] DB - Optimizer(옵티마이저)|작성자 repid2





도움 - https://www.youtube.com/watch?v=dP0MIgyrqlo
https://blog.naver.com/joonbread/222231968294
