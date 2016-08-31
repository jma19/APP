//package com.im.server;
//
//import com.google.gson.Gson;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.HttpStatus;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.params.HttpConnectionParams;
//import org.apache.http.util.EntityUtils;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = ServerApplication.class)
//@WebAppConfiguration
//public class ServerApplicationTests {
//
//    @Test
//    public void contextLoads() {
//
//    }
//
//    @Test
//    public void testName() throws Exception {
//        ResponseOojec xiaoya = new ResponseOojec();
//        xiaoya.setName("xiaoya");
//        xiaoya.setValue(415);
//
//        String s = post("http://localhost:8080/test",new Gson().toJson(xiaoya));
//        System.out.println("\"result=====\"+" + s);
//    }
//
//    public static String doPost(String uri, String jsonStr, int connectTimeOut, int socketTimeOut) {
//        HttpClient httpClient = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost(uri);
//        String result = null;
//        BufferedReader br = null;
//        try {
//            StringEntity stringEntity = new StringEntity(jsonStr, "UTF-8");
//            stringEntity.setContentType("application/json");
//            stringEntity.setContentEncoding("UTF-8");
//            httpPost.setEntity(stringEntity);
//            HttpConnectionParams.setConnectionTimeout(httpClient.getParams(), connectTimeOut);
//            httpClient.getParams().setIntParameter("http.socket.timeout", socketTimeOut);
//            HttpResponse response = httpClient.execute(httpPost);
//            if (response != null && HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
//                br = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "utf-8"));
//                String temp;
//                StringBuilder resultStr = new StringBuilder();
//                while ((temp = br.readLine()) != null) {
//                    resultStr.append(temp);
//                }
//                result = resultStr.toString();
//            } else {
//                System.out.println("获取数据失败");
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        } finally {
//            try {
//                if (br != null) {
//                    br.close();
//                }
//            } catch (IOException e) {
//
//            }
//
//            httpClient.getConnectionManager().shutdown();
//        }
//        return result;
//    }
//
//
//    public String post(String url, String jsonStr) {
//
//        HttpClient httpClient = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost(url);
//        StringEntity entity = new StringEntity(jsonStr, "UTF-8");
//        entity.setContentType("application/json");
//        httpPost.setEntity(entity);
//        try {
//            HttpResponse response = httpClient.execute(httpPost);
//            HttpEntity respEntity = response.getEntity();
//            if (respEntity != null) {
//                String content = EntityUtils.toString(respEntity);
//                System.out.println(content);
//                return content;
//            }
//        } catch (ClientProtocolException e) {
//            // writing exception to log
//            e.printStackTrace();
//        } catch (IOException e) {
//            // writing exception to log
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
