package com.ctl.simple.net.http;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * java项目内的http请求
 * 1. java内置的
 * 2. apache heepClient的请求方法
 * 3. spring Framework的请求方法包括(RestTemplate,WebClient等)
 * 4. OkHttp? Android到java的一个框架,好处是什么
 * <p>
 * 同时需要考虑一些高可用、负载均衡、重试等问题。一些HTTP客户端库提供了这些功能的支持，如Ribbon、Feign等。
 * 1.Ribbon
 * 2.Feign
 * <p>
 * @author cheti
 */
public class TestHttpRequest {

    /**
     * 1.java内置的http请求
     */
    public static void testJavaHttpClient() {
        try {
            URL url = new URL("http://www.example.com");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Java/1.8");
            int responseCode = conn.getResponseCode();
            System.out.println(responseCode);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 2.Apache HttpClient是一个非常流行的第三方HTTP客户端库，
     * 可以用来发送HTTP请求、接收响应、处理Cookie等。使用HttpClient发送HTTP请求的示例代码如下
     */
    public static void testApacheHttpClient() {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("http://www.example.com");
            CloseableHttpResponse response = httpClient.execute(httpGet);
            int responseCode = response.getCode();
            System.out.println(responseCode);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 3.Spring Framework是一个非常流行的Java Web开发框架，
     * 其中包含了一些用于实现HTTP的API，包括RestTemplate、WebClient等
     */
    public static void testSpringHttpClient() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.
                getForEntity("http://www.example.com", String.class);
        int statusCode = response.getStatusCodeValue();
        System.out.println(statusCode);
    }

    public static void main(String[] args) {
        testJavaHttpClient();
        testApacheHttpClient();
        testSpringHttpClient();
    }

}
