2019 10 7


date compare

java나 다른 script 와 같이 C#에도 date compare 할 수 있는 CompareTo(DateTime d) method를 사용해 정리해 보았다.

```c#
    public static bool CheckDateDiff(string d, string startDate, System.Web.UI.Page page)
    {
        DateTime day = Convert.ToDateTime(d);
        DateTime sDate = Convert.ToDateTime(startDate);
        int dateDiffDay = day.CompareTo(sDate);

        if (dateDiffDay > 0)
        {
            return false;
        }

        return true;
    }
    
    
    //오늘 날짜가 2019년 10월 1일보다 전일이면 return false.    
    Boolean check = CheckDateDiff('20191001', Date.Now(), Page)
    
```




