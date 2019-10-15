2019 10 14

```aspx

      <tr>
          <th>PC방 주소</th>
          <td>
              <asp:TextBox ID="TextBox8" runat="server" Width="30%" CssClass="fm_trim_require" readonly/>
              <input type="button" value="우편번호 검색" id="btn_ZIP" style="margin-bottom:5px">
              <div id="Div1" style="display: inline;" runat="server"></div>
              <br />
              <asp:TextBox ID="TextBox2" runat="server" Width="65%" MaxLength="100" CssClass="fm_trim_require" readonly/>
              <asp:TextBox ID="TextBox10" runat="server" Width="30%" MaxLength="100" CssClass="fm_trim_require"/>
          </td>
      </tr>     
```            


#### asp:TextBox 태그에 수정을 막기위해 readonly 옵션을 넣었는데
#### aspx.cs 소스에서 this.TextBox2.Text 이렇게 텍스트를 가져올 때 ""로 가져와 데이터를 추출할 수 없다.

때문에

```aspx
     <asp:HiddenField ID="hfADDRESSSTREET" runat="server" /> 
        
```

#### 이런식으로 HiddenField 태그에 데이터를 따로 담아 
####  hfADDRESSSTREET.Value 이런식으로 가져와야 한다.



