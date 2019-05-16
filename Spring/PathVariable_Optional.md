2019 5 16


출처 https://gyumin-kim.github.io/optional-pathvariable/



Java 8의 Optional<T>를 사용하면 된다. 코드는 다음과 같다.

```java
@GetMapping({"/product_detail", "/product_detail/{pageStart}"})
  public String productDetail(ModelMap modelMap, @PathVariable Optional<Integer> pageStart) {
    Pageable pageable = PageRequest.of(pageStart.isPresent() ? pageStart.get() : 0, 10);

  // ... (생략)

}
```

@GetMapping(혹은 @RequestMapping) 내에 pageStart가 넘어오지 않는 경우와 pageStart가 포함된 경우의 2가지 url을 모두 적는다.

@PathVariable에 Optional를 붙여준다.

이제 메소드 내에서 사용하면 된다.
단, 해당 변수(이 경우 pageStart)가 존재하는지 여부를 .isPresent()로 체크한 다음 .get() 메소드로 값을 가져온 뒤 사용해야 한다.





