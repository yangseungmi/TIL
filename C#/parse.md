2019 3 18

아직도 aspx를 하면서 java 문법을 적고 있다. 문득 빨간 줄이 생겨야 깨달아 오늘 처음으로 aspx 잔디를 심어보기로 했다

잔디심기 시즌 3 첫날인 만큼 간단하게 자료형간 Convert 할 때 내가 주로 사용하는 문법을 정리해 보았다

|   |   |   |
|---|---|---| 
|   |   |  ex |
| int ->     | string  |  pageNo.ToString()  | 
|            |  double |  (double)  | 
|  double -> | string  |  someDouble.ToString()  | 
|            | int     |  Convert.ToInt32(someDouble)  | 
|  string -> |  double |  Convert.ToDouble("52,8725945")  | 
|            |  int    |  Int32.Parse("abc")  | 
|   |   | * or int.TryParse(Request["1300"], out temp)  |


\* parse 시 문제가 생겼을 때 temp로 출력


참고 https://docs.microsoft.com/ko-kr/dotnet/csharp/programming-guide/types/how-to-convert-a-string-to-a-number
