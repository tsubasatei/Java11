package com.xt.java;

import org.junit.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * jdk 9 中使用 HttpClient 替换原有的 HttpURLConnection
 */
public class HttpClientTest {

    @Test
    public void test () {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://www.atguigu.com")).build();
        HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();
        try {
            HttpResponse<String> response = client.send(request, responseBodyHandler);
            System.out.println(response.statusCode());
            System.out.println(response.version().name());
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
