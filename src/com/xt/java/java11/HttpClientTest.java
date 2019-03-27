package com.xt.java.java11;

import org.junit.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

/**
 * @author xt
 * @create 2019/3/25 9:38
 * @Desc
 */
public class HttpClientTest {

    // 异步
    @Test
    public void test2() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://www.baidu.com")).build();
        HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();
        CompletableFuture<HttpResponse<String>> sendAsync = client.sendAsync(request, responseBodyHandler);
        HttpResponse<String> response = sendAsync.get();
        String body = response.body();
        System.out.println(body);
    }

    // 同步
    @Test
    public void test() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://www.baidu.com")).build();
        HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();
        HttpResponse<String> response = client.send(request, responseBodyHandler);
        String body = response.body();
        System.out.println(body);
    }
}
