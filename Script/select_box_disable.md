2019 10 11


select box에서 항목말고 '선택' 구분자는 선택하지 못하게 하는 옵션

```html
<td>
    <div class="group_period">
       <select id="Select1" class="opt_pcbang opt_admin" runat="server">
          <option value="" selected disabled hidden> --- 선택 --- </option>
          <option value="피카플레이">피카플레이</option>
          <option value="게토">게토</option>
          <option value="플레이도넛">플레이도넛</option>
        </select>
    </div>
</td>
```

![Alt Text](https://github.com/yangseungmi/TIL/blob/master/Image/select_box.JPG)


#### 이렇게 하면
#### '--- 선택 ---'은 선택할 수 없다 disable
#### '--- 선택 ---'은 항목에 보이지 않는다 hidden
