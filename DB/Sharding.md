####2019 1 7

##DB

###Sharding

마크다운 작성 시작
참고 https://gist.github.com/ihoneymon/652be052a0727ad59601

Database의 샤딩(Sharding)이란?
서비스의 크기가 점점 커지게 되면서 다양하고 많은 Table들이 존재하게 된다
파티셔닝 (인덱스를 관리하기 쉬운 단위로 분리하는 방법)   이나
샤딩 (같은 테이블 스키마를 가진 데이터를 다수의 데이터베이스에 분산하여 저장하는 방법) 으로 분리한다


Vertical Partitioning
![Alt text](/Image/6.png  "Vertical Partitioning")
- 그림그대로 수직으로 자르는데 도메인에 따라 쉽게 분리할 수 있다

Sharding

![Alt text](/Image/5.png  "Sharding")
- 수평으로 자른다.   같은 테이블 스키마를 가진 데이터를 다수의 데이터베이스에 분산하여 저장한다
Horizontal Partitioning 이라고도 한단다

샤딩 단점
 프로그래밍, 운영적인 복잡도는 더 높아진다
 가능하면 샤딩을 피하거나 지연시킬 수 있는 방법을 찾는 것이 우선되어야 한다
솔직히 나도 안쓰고 싶은데 우리 데이터가 점점 많아지고 그걸 관리하기 매우 벅차다 지연시킬 수 있는 방법이 이젠 없다.
```
1.Scale-in
Hardware Spec이 더 좋은 컴퓨터를 사용한다???
Scale-out 이 접속된 서버의 대수를 늘려 처리 능력을 향상시키는 것이다(수평 스케일)
Scale-up  이 서버 그 자체를 증강하는 것에 의해서 처리 능력을 향상 시키는 것이다(수직 스케일)
2.Read 부하가 크다면
Cache나 DataBase의 Replication을 적용하는 것도 하나의 방법이다
3.Table의 일부 컬럼만 자주 사용한다면
Vertically Partition도 하나의 방법이다
```

옆팀에서는 게임 서버마다 디비를 나누기 위해 샤딩을 썼다고 한다 혹은 region별로
우리팀은 매일 매일 쌓여가는 적재성 데이터(로그와 가까운) 를 분리 보관하기 위해
3개월 마다 데이터를 샤딩해 따로 보관하고 있다


참고 <https://nesoy.github.io/articles/2018-05/Database-Shard>
