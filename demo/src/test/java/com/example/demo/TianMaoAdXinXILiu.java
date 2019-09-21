package com.example.demo;


import com.example.demo.proto.AdDongFengRequest;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class TianMaoAdXinXILiu {
    public static final String POST_URL = "http://ope.tanx.com/api";
//    public static final String POST_URL = "http://ope.tanx.com/api?trace=1";
//    public static final String POST_URL = "http://www.baidu.com";

    public static void main(String[] args) {
        postRequest();
    }

    /**
     * 发送 post请求访问本地应用并根据传递参数不同返回不同结果
     */
    public static void postRequest() {
        AdDongFengRequest.Request.App app = AdDongFengRequest.Request.App.newBuilder()
                .setPackageName("com.xxxx.news")
                .setAppName("新闻")
                .addCategory("101701")
                .build();
        AdDongFengRequest.Request.Device device = AdDongFengRequest.Request.Device.newBuilder()
                .setIp("59.172.75.115")
//                .setUserAgent("Mozilla/5.0 (Linux; U; Android 4.2.2; zh-CN; vivo Y13 Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 UCBrowser/10.10.8.822 U3/0.8.0 Mobile Safari/534.30")
                .setUserAgent("")
                .setImei("867348022656925")
                .setDeviceType(0)
                .setBrand("Samsung")
                .setModel("galaxy")
                .setOs("Android")
                .setOsv("4.4.4")
                .setNetwork(1)
                .setOperator(1)
                .setWidth(640)
                .setHeight(1136)
                .setPixelRatio(10000)
                .setTimezoneOffset(480)
                .build();
        AdDongFengRequest.Request.Impression.Deal deal = AdDongFengRequest.Request.Impression.Deal.newBuilder()
                .setDealId("67890")
                .setMinPrice(0)
                .build();
        AdDongFengRequest.Request.Impression impression = AdDongFengRequest.Request.Impression.newBuilder()
                .setId(0)
                .setPid("mm_116532257_14932390_58188168")
                .setWidth(640)
                .setHeight(1136)
                .setCampaignDate("")//信息流广告这个字段为空字符串
                .addDeal(deal)
                .build();

        AdDongFengRequest.Request adRequest = AdDongFengRequest.Request.newBuilder()
                .setVersion(2)
                .setId("0a674362000057b6be176e7600d4c089")
                .setApp(app)
                .setDevice(device)
                .addImp(impression)
                .build();

        System.out.println(adRequest);
        byte[] content = adRequest.toByteArray();
        System.out.println("===========");

        HttpHost proxy = new HttpHost("192.168.3.76", 8888, "http");
        DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
        CloseableHttpClient httpclient = HttpClients.custom()
//                .setRoutePlanner(routePlanner)
                .build();

        // 创建httppost
        HttpPost httppost = new HttpPost(POST_URL);

        try {
            httppost.setHeader("Content-Type", "application/octet-stream");
            httppost.setHeader("Charset","UTF-8");
            httppost.setHeader("Accept","application/*");
            httppost.setHeader("Accept-Encoding","gzip");
            httppost.setEntity(new ByteArrayEntity(content));

            System.out.println("executing request " + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    System.out.println("11--------------------------------------");
                    AdDongFengRequest.Response response1 = AdDongFengRequest.Response.parseFrom(entity.getContent());
                    System.out.println("Response content: \r\n" + response1);
                    System.out.println("--------------------------------------");
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
