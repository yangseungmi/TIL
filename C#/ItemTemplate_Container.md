2019 04 17


C#에 데이터를 리스트 형태로 뿌릴 때

```C#
    <asp:Repeater ID="rpList" runat="server">
        <ItemTemplate>
          ...

        </ItemTemplate>
    </asp:Repeater>                                
```
형태로 안에 뿌려지는데

이 때 데이터아이템 인덱스를 ROW COUNT 로 같이 데이터에 넣어서 출력할 수 있지만
ItemTemplate에서 제공하는 "Container.ItemIndex"를 사용하면 따로 데이터를 넣지 않아도 된다


```C#

    <asp:Repeater ID="rpList" runat="server">
        <ItemTemplate>
            <tr>
              <th scope="row"><%# Container.ItemIndex + 1 %></th>
              ...
```


