2019 10 16


CSS에서 사용하는  ~ Tilde 물결표시
이름이 틸드라고 불리는지 오늘 알았다.

예를 들어

```css
h3 ~ span {color:red;}
```
라고 했을 때 
h3 뒤에 오는 span 요소(하지만 다른 요소가 사이에 있어서는 안된다.) 빨간색 글씨가 된다
바로 뒤가 아니어도 된다.


예를 들어
```html
<h3>title1</h3>
<p>content1</p>    <- 이 content1만 빨강색

<h3>title2</h3>
<div>
  <p>content2</p>
</div>
```

참고 https://aboooks.tistory.com/270
