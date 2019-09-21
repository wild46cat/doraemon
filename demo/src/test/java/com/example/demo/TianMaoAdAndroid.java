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

public class TianMaoAdAndroid {
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
                .setPackageName("cn.j.hers")
                .setAppName("她社区")
                .addCategory("101201")
                .build();
        AdDongFengRequest.Request.Device device = AdDongFengRequest.Request.Device.newBuilder()
                .setIp("123.59.151.225")
//                .setUserAgent("Mozilla/5.0 (Linux; U; Android 4.2.2; zh-CN; vivo Y13 Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 UCBrowser/10.10.8.822 U3/0.8.0 Mobile Safari/534.30")
                .setUserAgent("Dalvik/2.1.0 (Linux; U; Android 7.0; MI 5s Build/NRD90M)")
                .setImei("863817034132269")
                .setDeviceType(0)
                .setBrand("Xiaomi")
                .setModel("MI 5s")
                .setOs("Android")
                .setOsv("7.0")
                .setNetwork(1)
                .setOperator(1)
                .setWidth(1080)
                .setHeight(1920)
//                .setPixelRatio(10000)
//                .setTimezoneOffset(480)
                .build();
        AdDongFengRequest.Request.Impression.Deal deal = AdDongFengRequest.Request.Impression.Deal.newBuilder()
                .setDealId("01")
                .setMinPrice(0)
                .build();
        AdDongFengRequest.Request.Impression impression = AdDongFengRequest.Request.Impression.newBuilder()
                .setId(0)
                .setPid("mm_26632555_23456001_81242592")
                .setWidth(800)
                .setHeight(1200)
                .setCampaignDate("")//媒体计划在此日期展示开屏广告。如果开屏逻辑是实时请求实时展现，则该字段置为空
                .addDeal(deal)
                .build();

        AdDongFengRequest.Request adRequest = AdDongFengRequest.Request.newBuilder()
                .setVersion(2)
                .setId("1ba8968afde241f783e4202b5fcf385b")
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
