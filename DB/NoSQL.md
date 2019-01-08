2019 1 8
---------

## DB

### NoSQL

참고 https://aws.amazon.com/ko/nosql/
참고 http://lazybrain.ikspres.com/nosql1/

#### NoSQL 데이터베이스란?
***

NoSQL 데이터베이스는 특정 데이터 모델에 대해 특정 목적에 맞추어 구축되는 
데이터베이스로서 현대적인 애플리케이션 구축을 위한 유연한 스키마를 갖추고 있습니다. 
NoSQL 데이터베이스는 개발의 용이성, 기능성 및 확장성을 널리 인정받고 있습니다. 
문서, 그래프, 키 값, 인 메모리, 검색을 포함해 다양한 데이터 모델을 사용합니다. 


#### NoSQL(비관계형) 데이터베이스를 사용해야 하는 이유
***

NoSQL 데이터베이스는 탁월한 사용자 경험을 제공하기 위하여 유연성과 확장성을 비롯해 고성능의 매우 기능적인
데이터베이스를 필요로 하는 모바일, 웹이나 게이밍과 같은 다양한 현대적인 애플리케이션에 적합합니다.

1) 유연성 : NoSQL 데이터베이스는 일반적으로 유연한 스키마를 제공하여 보다 빠르고 반복적인 개발을 
가능하게 해줍니다. 이같은 유연한 데이터 모델은 NoSQL 데이터베이스를 반정형 및 비정형 데이터에
이상적으로 만들어 줍니다.
2) 확장성 : NoSQL 데이터베이스는 일반적으로 고가의 강력한 서버를 추가하는 대신 분사형
헤드웨어 클러스터를 이용해 확장하도록 설계되었습니다.
3) 고성능 : NoSQL 데이터베이스는 특정 데이터 모델(문서, 키 값, 그래프 등) 및 액세스 패턴에 
대해 최적화되어 관계형 데이터베이스를 통해 유사한 기능을 충족하려 할 때보다 뛰어난 성능을 얻게 해줍니다
4) 고기능성 : NoSQL 데이터베이스는 각 데이터 모델에 맞추어 특별히 구축된 뛰어난 기능의 API와
데이터 유형을 제공합니다


#### SQL 과 NoSQL 용어 비교
***
NoSQL은 경험이 없고 주로 SQL만 사용하다 공부해보고 비교해보니 이해가 쏙쏙되는거 같다
사이트엔 NoSQL의 종류로 MongoDB와 DynamoDB, Cassandra, Couchbase가 있는데 MongoDB만 적어보았다
SQL                MongoDB   

테이블               컬렉션
열                  문서 document
컬럼                 필드(키/필드)
기본 키              ObjectId(신기),Primary Key(_id)
인덱스               인덱스
보기                 보기?
중첩된 테이블 또는 객체  포함 문서
배열                 배열

위에 document형태는 key-value쌍으로 이루어져 있다

```
{ 
   "_id": ObjectId("5099803df3f4948bd2f98391"), 
   "username": "ljh", 
   "language": { java: 10, go: 3 } 
}
```
궁금해서 체험하기 클릭해서 들어가보니 
현재 Nike Digital 은 Cassandra 사용하고
SAMSUNG은 DynamoDB,
Snap 은 Snapchat Stories를 DynamoDB로 마이그레이션 했고
우리주변에 많이 사용하고 있는 NETFLX도 DynamoDB를 사용중이라고 한다




몽고디비에 대해 좀더 찾아보았다
참고 http://sjh836.tistory.com/98 (여기선 또 여길 참고 https://docs.mongodb.com/)

__특징__
***

- Document-oriendted storage 문서 지향이다
  MongoDB는 database > collectioins > documents 구조로 document는 key-value형태의
  BSON(Binary JSON)으로 되어있다
  
- Full Index Support
  Single Field Indexes : 기본적인 인덱스 타입
  Compound Indexes : RDBMS의 복합인덱스 같은 거
  Multikey Indexes : Array에 미챙되는 값이 하나라도 있으면 인덱스에 추가하는 멀티키 인덱스
  Geospatial Indexes and Queries : 위치기반 인덱스와 쿼리
  Text Indexes : String에도 인덱싱이 가능
  Hashed Index : Btree 인덱스가 아닌 Hash 타입의 인덱스도 사용 가능

- Replication& High Availability
  간단한 설정만으로도 데이터 복제를 지원. 가용성 향상.

- Auto-Sharding
  MongoDB는 처음부터 자동으로 데이터를 분산하여 저장하며, 
  하나의 컬렉션처럼 사용할 수 있게 해준다. 수평적 확장 가능

- Querying(documented-based query)
  다양한 종류의 쿼리문 지원. (필터링, 수집, 정렬, 정규표현식 등)

- Fast In-Pace Updates
  고성능의 atomic operation을 지원

- Map/Reduce
  맵리듀스를 지원.
  map과 reduce 함수의 조합을 통해 분산/병렬 시스템 운용 지원, 
  but 하둡처럼 MR전용시스템에 비해서는 성능이 떨어진다

- GridFS
  분산파일 저장을 MongoDB가 자동으로 해준다. 
  실제 파일이 어디에 저장되어 있는지 신경 쓸 필요가 없고 복구도 자동이다.

이 아래가 핵심이다 장점과 단점!
***
__장점__

쌓아놓고 삭제가 없는 경우 제일 적합니다(그래서 우리 개발팀에선 사용 안하고 있음)
ex. 로그데이터, 세션 등

Flexibility : Schema-less라서 어떤 형태의 데이터라도 저장할 수 있다.
Performance : Read & Write 성능이 뛰어나다. 캐싱이나 많은 트래픽을 감당할 때 써도 좋다.
Scalability : 애초부터 스케일아웃 구조를 채택해서 쉽게 운용가능하다. Auto sharding 지원
Deep Query ability : 문서지향적 Query Language 를 사용하여 SQL 만큼 강력한 Query 성능을 제공한다.
Conversion / Mapping : JSON형태로 저장이 가능해서 직관적이고 개발이 편리하다.

__단점__

정합성이 떨어지므로 트랜잭션이 필요한 경우에는 부적합하다
ex. 금융, 결제, 회원정보 등 +우리팀

JOIN이 없다. join이 필요없도록 데이터 구조화 필요
memory mapped file으로 파일 엔진 DB이다. 메모리 관리를 OS에게 위임한다. 
메모리에 의존적, 메모리 크기가 성능을 좌우한다. 
SQL을 완전히 이전할 수는 없다.
B트리 인덱스를 사용하여 인덱스를 생성하는데, B트리는 크기가 커질수록 새로운 데이터를 입력하거나 
삭제할 때 성능이 저하된다. 
이런 B트리의 특성 때문에 데이터를 넣어두면 변하지않고 정보를 조회하는 데에 적합하다.



