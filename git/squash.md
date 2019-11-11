2019 11 11


출처 https://meetup.toast.com/posts/39

$ git squash 
여러개의 커밋로그를 하나로 묶기

예를 들어 rebase를 할 때 내 브랜치에 커밋이 10개 있으면
rebase를 한 브랜치에 10개의 커밋이 그래도 올라간다.

하지만 이 커밋을 하나로 묶어버리고 싶은 경우

$ git rebase -i HEAD~3 (최근 3개의 커밋을 묶어 rebase 한다)
또는
$ git rebase --squash feature
몇개든 하나로 묶어 커밋한다.

