2019 5 31


https://leetcode.com/problems/unique-email-addresses/

```java
class Solution {
   public int numUniqueEmails(String[] emails) {
        Set<String> normalized = new HashSet<>(); // used to save simplified email address, cost O(n) sapce.
        for (String email : emails) {
            String[] parts = email.split("@"); // split into local and domain parts.
            String[] local = parts[0].split("\\+"); // split local by '+'.
            normalized.add(local[0].replace(".", "") + "@" + parts[1]); // remove all '.', and concatenate '@' and domain.        
        }
        return normalized.size();
    }
}

```

문제 풀다가 내가 짠 코드를 튜닝하다 보니 다른분 소스 보고 감탄해서 퍼왔습니다 ㅎㅎ
