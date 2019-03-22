2019 3 22

### git rebase

회사에서 함께 커밋해가는 프로젝트를 하면 rebase는 필수인것 같다

자주 사용하지만 여러 옵션들이 있는 rebase의 옵션들에 대해서 찾아보았다

우선 이론을 정리하기 전에 나는 현업에서

$git rebase master
를 자주 사용한다 우선 그 전에 ($git pull)이 우선이다

내가 origin master에 merge 하기 전 현재 최신버전의 master와 비교 후

내 커밋을 merge 하는게 confict을 막을 수 있기 때문이다

하지만 항상 문제 없이 rebase 되지 않는다

충돌이 생길 때가 종종 있고 가끔 말도 안되는 옛날버전이 올라 올 때도 있었다

이러한 경우 사용했던 rebase 옵션들과 앞으로 git을 사용하면서 도움이 될 만한 옵션들을 정리해 보았다

출처 https://git-scm.com/docs/git-rebase
***
우선 메뉴얼은 아래와 같다
```
git rebase [-i | --interactive] [<options>] [--exec <cmd>] [--onto <newbase>]
	[<upstream> [<branch>]]
  
git rebase [-i | --interactive] [<options>] [--exec <cmd>] [--onto <newbase>]
	--root [<branch>]
  
git rebase --continue | --skip | --abort | --quit | --edit-todo | --show-current-patch
```
(생각보다 엄청많넹...)

일단 오늘 사용했던 rebase의 대표적인 3가지 옵션들에 대해 찾아보았다

#### 1. git rebase --continue
##### -> rebase 후 conflict 발생시 rebase(1/3) 이런 식으로 브랜치 이름이 바뀐다(?)
#####   뜻은 내가 커밋한 3가지 중 첫번째 conflict가 stage에 있다는 것이고 이 때 conflict를 수정하고
#####   stage에 올린 뒤 $git rebase --contine를 하면 다음 conflict 커밋으로 넘어가 rebase(2/3)이 된다

#### 2. git rebase --skip
##### -> 위 상황에서 $git rebase --skip을 하면 내가 두번째 한 커밋은 rebase 되지 않고 스킵(삭제)된다

#### 3. git rebase --abort
##### -> 하지만 도중에 rebase 작업을 중지하고자 하는 경우에는 rebase에 --abort 옵션을 지정하여 실행하면 된다
#####    (rebase 포기ㅜ)

