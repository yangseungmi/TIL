2020 6 4

POJO 형태로 post 전송

보내는쪽

```java
   CertificationLog log = new CertificationLog();
            log.setTransaction_id(transactionId);
            log.setMember_id(memberId);
            log.setUserid(daumUser.getUserId());
            log.setService_code(serviceCode);
            log.setService_step(certType);
            log.setService_result(certResult);
            log.setClient_ip(clientIp);

            String url = "http://local-member-api.kakaogames.io:21041/cert/log";

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.valueOf(MediaType.APPLICATION_JSON_UTF8_VALUE));
            HttpEntity<CertificationLog> httpEntity = new HttpEntity<CertificationLog>(log, headers);

            memberRestTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
```

받는쪽 - "HttpServletRequest httpServletRequest" 필수.
```java
 @ResponseBody
    @RequestMapping(value = "/cert/log", produces = "application/json", method = RequestMethod.POST)
    public String post( @RequestBody CertificationLog log,
                        HttpServletRequest httpServletRequest, HttpServletResponse response ) {
        try {
            int insert = memberCertificationRepository.insertMemberCertificationLog(log);
            return result(insert);
        } catch (DataIntegrityViolationException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            return gson.toJson(RestApiDto.error(e.getMessage()));
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return gson.toJson(RestApiDto.error(e.getMessage()));
        }
    }
```

참고 
https://howtodoinjava.com/spring-boot2/resttemplate/resttemplate-post-json-example/
