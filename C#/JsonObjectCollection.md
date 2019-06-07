2019 06 07



데이터 통신 후 받은 데이터 형식을 아래처럼 만들기 위해
C#의 JsonObjectCollection과 JsonArrayCollection을 사용했다

출처 https://miniweb4u.tistory.com/49

```Json
{
    "result": "fail",
    "ipList": [
        {
            "key": "0",
            "clientIp": "23.3.2.2",
            "retCode": "01",
            "retMsg": "성공"
        },
        {
            "key": "1",
            "clientIp": "211.63.161.193",
            "retCode": "02",
            "retMsg": "해당ID로 PC방이 존재하지 않습니다."
        },
        {
            "key": "2",
            "clientIp": "127.0.0.1",
            "retCode": "03",
            "retMsg": "PC방 코인이 없습니다."
        },
        {
            "key": "3",
            "clientIp": "127.0.0.4",
            "retCode": "04",
            "retMsg": "해당ID로 PC방이 존재하지 않습니다."
        }
    ]
}
```

제일 큰 Object 를 
```c#
  JsonObjectCollection jsonObj = new JsonObjectCollection(); 
```           
으로 선언하고

"ipList" 데이터로 대괄호 안에 담기 위해
```c#
  JsonArrayCollection arrayObj = new JsonArrayCollection("ipList");
```
이렇게 arrayObj로 만들어서 담는다


```c#

  jsonObj.Add(new JsonStringValue("result", result));
  foreach (var item in JObject.Parse(postData))
  {
      JsonObjectCollection items = new JsonObjectCollection();
      items.Add(new JsonStringValue("key", item.Key.ToString()));
      ...
      arrayObj.Add(items);
      jsonObj.Add(arrayObj);
  }
  
  context.Response.ContentType = "application/json";
  context.Response.Write(jsonObj.ToString());
```                
















