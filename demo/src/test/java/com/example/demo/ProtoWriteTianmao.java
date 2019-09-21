package com.example.demo;

import com.example.demo.proto.AdDongFengRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;

public class ProtoWriteTianmao {
    public static Logger logger = LoggerFactory.getLogger("ProtoWrite");

    public static void main(String[] args) {

        AdDongFengRequest.Request.App app = AdDongFengRequest.Request.App.newBuilder()
                .setPackageName("com.xxxx.news")
                .setAppName("新闻")
//                .setCategory(0, "101701")
                .build();
        AdDongFengRequest.Request.Device device = AdDongFengRequest.Request.Device.newBuilder()
                .setIp("59.172.75.115")
                .setUserAgent("Mozilla/5.0 (Linux; U; Android 4.2.2; zh-CN; vivo Y13 Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 UCBrowser/10.10.8.822 U3/0.8.0 Mobile Safari/534.30")
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
                .setDealId("12345")
                .setMinPrice(0)
                .build();
        AdDongFengRequest.Request.Impression impression = AdDongFengRequest.Request.Impression.newBuilder()
                .setId(0)
                .setPid("mm_116532257_14926483_58192126")
                .setWidth(640)
                .setHeight(1136)
                .setCampaignDate("")//媒体计划在此日期展示开屏广告。如果开屏逻辑是实时请求实时展现，则该字段置为空
//                .setDeal(0, deal)
                .build();

        AdDongFengRequest.Request adRequest = AdDongFengRequest.Request.newBuilder()
                .setVersion(2)
                .setId("0a674362000057b6be176e7600d4c089")
                .setApp(app)
                .setDevice(device)
//                .setImp(0, impression)
                .build();


        System.out.println(adRequest);
        System.out.println("-=============-");
        try {
            System.out.println(adRequest.toByteArray());
            System.out.println("-=============-");
            adRequest.writeTo(System.out);
            System.out.println("-=============-");
            adRequest.writeTo(new FileOutputStream("C:\\Users\\admin\\Desktop\\22.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
