2021 2 25

SQLP 자격증 시험 접수를 했다.
찾아보니 내가 알고 있는 부분도 많고
배우고 싶은 부분도 많아 공부에 도움이 될 자격증 같아서
3/20 토요일로 날짜를 잡았다.

공부하는 모든 내용을 정리하면서 커밋하진 않고
처음 알게 되는 지식이나 정말 중요하다고 생각되는 파트 등을
메모장 처럼 커밋할 생각이다.


|집합연산자 종류|내용|
|------|---|
|UNION|두 집합을 더해서 결과를 출력한다. 중복 값 제거하고 정렬을 수행한다.|
|UNION ALL|두 집합을 더해서 결과를 출력한다. 중복 제거와 정렬을 하지 않는다.|
|INTERSECT|두 집합의 교집합 결과를 정렬하여 출력한다.|
|MINUS|두 집합의 차집합 격롸를 정렬하고 출력한다. SQL의 순서가 중요하다.|

```sql
select * from kmong.exam_result 
union
select * from kmong.exam_result;

select * from kmong.exam_result
union all
select * from kmong.exam_result;

-- 출처: https://stricky.tistory.com/205 [The DataBase that i am good at]

```
![select_union](/Image/select_union.png)
![select_union](/Image/select_union2.png)
