package com.codestates.PracticeMySelf.kakao;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;

public class KakaoMessage {

    private static final String API_URL = "https://kapi.kakao.com/v2/api/talk/memo/default/send";
    private static final String ACCESS_TOKEN = "pEfyEo4DAxJ-24fnKK1lPJ-tgEYAqFXIlzfLB839Cj10mAAAAYbUz530";

    public static void main(String[] args) {

        MediaType JSON
                = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody requestBody = RequestBody.create("ㅇㅇ", JSON);

        Request request = new Request.Builder()
                .url(API_URL)
                .post(requestBody)
                .addHeader("Authorization", "Bearer " + ACCESS_TOKEN)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

