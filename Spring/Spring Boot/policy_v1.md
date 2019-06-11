2019 6 11


#### 1. - 개발완료
약관 페이지에서
약관 이름 service_20180102.html과 내용을 가지고 저장 버튼 클릭

#### 2.
PolicyController.java로 넘어와서
 1)파일 생성
 ```java
 private MultipartFile localFileUpload(HttpServletRequest request, String typeFileName, String content) {

        //1. 텍스트로 로컬파일에 약관 이름으로 파일 생성

        try {
            String tmpFileName =
                    String.format(
                            "%s%s__%s%s",
                            "C:/tmp/",
                            typeFileName,
                            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")),
                            ".txt"
                    );
            OutputStream outputStream = new FileOutputStream(tmpFileName);
            byte[] by = content.getBytes();
            outputStream.write(by);

            MultipartHttpServletRequest multi = (MultipartHttpServletRequest) request;
            MultipartFile file = multi.getFile(tmpFileName);
            return file;

        } catch (Exception e) {
            e.printStackTrace();
        }

        //2. 파일이름과 파일을 kg-pub-api에 전송 -> restTemplate



        return null;
  }
  ```
 
 2)kg-pub-api에 파일 넘기기


#### 3. - 개발완료
디비 수정


