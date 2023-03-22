package com.codestates.CordJg.cafe.kakao;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

public class KakaoMessage {

    private static final String API_URL = "https://kapi.kakao.com/v2/api/talk/memo/default/send";
    private static final String ACCESS_TOKEN = "aBUqdMuxzFTp1QL4FsOqZBlaD46OXWAiMWzqMymwCj11GgAAAYbXslsK";

    public static void main(String[] args) throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "b0e42d0f7a61375eb692d70322f70c32");
        headers.setBearerAuth(ACCESS_TOKEN);
        headers.setContentType(MediaType.APPLICATION_JSON);

        String message = "Hello, World!"; // 보낼 메시지

//        Map<String, Object> body = new HashMap<>();
//        body.put("template_object", "{\"text\": \"" + message + "\"}");

        Map<String, Object> templateObject = new HashMap<>();
        templateObject.put("text", message);

        Map<String, Object> body = new HashMap<>();
        body.put("template_object", templateObject);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(body);

        HttpEntity<String> request = new HttpEntity<>(json, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(API_URL, request, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("카카오톡 메시지 전송 성공!");
        } else {
            System.out.println("카카오톡 메시지 전송 실패...");
        }

//
//
//        OkHttpClient client = new OkHttpClient();
//
//        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
//        RequestBody requestBody = RequestBody.create("ㅇㅇ", JSON);
//
//        Request request = new Request.Builder()
//                .url(API_URL)
//                .post(requestBody)
//                .addHeader("Authorization", "Bearer " + ACCESS_TOKEN)
//                .addHeader("Content-Type", "application/x-www-form-urlencoded")
//                .build();
//
//        try {
//            Response response = client.newCall(request).execute();
//            System.out.println(response.body().string());
//            response.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}

