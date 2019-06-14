2019 6 14


```javascript
 <script type="text/javascript" language="javascript">
        $(document).ready(function () {

            var d = new Date();
            var month  = d.getMonth() + 1 > 10 ? (d.getMonth() + 1) : "0" + (d.getMonth() + 1),
                day    = d.getDate(),
                year   = d.getFullYear();
            var today  = Date.parse(year +"-"+ month +"-"+ day);
            var endDay = Date.parse("2019-07-08");

            if (today >= endDay) {
                $("#poe_benefit03").hide();
            }
        });
     </script>
```

7월에 안식휴가를 가서 (ㅎㅎㅎ)
그날 배포를 할 순 없으니까 미리 스크립트로 오늘 날짜를 구해
비교해서 숨김처리를 하는 스크립트를 만들었다
짧게 짠다고 생각했는데 10줄이면... 그래도 짧은 편인거 같다.


