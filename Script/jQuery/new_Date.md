2019 4 23

C#의 front에서 jQuery를 사용해 입력한 날짜 데이터를 비교하는 스크립트를 짜보았다

구글링해서 알게되어 오늘 커밋하면서 정리해본다

```c#
...

        <select id="progressStartYear" class="opt_pcbang" runat="server">
          <option value="">년</option>
          <option value="2019">2019</option>
          <option value="2020">2020</option>
          <option value="2021">2021</option>
        </select>
        <select id="progressStartMonth" class="opt_pcbang" runat="server">
          <option value="">월</option>
          <option value="01">01</option>
          ...
        </select>
        
          ...
       
       <script>   
         var progressST = new Date($("#progressStartYear").val(), $("#progressStartMonth").val(), $("#progressStartDay").val());
         var progressED = new Date($("#progressEndYear").val(), $("#progressEndMonth").val(), $("#progressEndDay").val());

         var joinST = new Date($("#joinStartYear").val(), $("#joinStartMonth").val() ,$("#joinStartDay").val());
         var joinED = new Date($("#joinEndYear").val(), $("#joinEndMonth").val(), $("#joinEndDay").val());


        ...
        
         //compare
         else if (progressST > progressED) {
             alert("진행 기간을 확인해주세요.");
             return false;
         }
      </script>
...
```


다음엔 datepicker를 써서 해보는것도 좋을 거 같다

