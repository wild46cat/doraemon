package com.example.demo.controller;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

@RestController
@RequestMapping("memcache")
public class WhalinMemcacheController {
    public static MemCachedClient memcachedClient;

    static {
        try {
            String[] servers = {"wuxueyou.cn:11211", "wuxueyou.cn:11212", "wuxueyou.cn:11213"};
            SockIOPool pool = SockIOPool.getInstance();
            pool.setServers(servers);
            pool.setHashingAlg(SockIOPool.CONSISTENT_HASH);
            pool.setFailover(true);
            pool.setInitConn(10);
            pool.setMinConn(5);
            pool.setMaxConn(250);
            pool.setMaintSleep(30);
            pool.setNagle(false);
            pool.setSocketTO(3000);
            pool.setAliveCheck(true);
            pool.initialize();
            memcachedClient = new MemCachedClient();
            System.out.println("Connection to server sucessful.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    @RequestMapping("/set")
    public boolean set(String key, String value) {
        System.out.println("key:" + key);
        System.out.println("value:" + value);
        return memcachedClient.set(key, value, new Date(500000));
    }

    @RequestMapping("/get")
    public Object get(String key) {
        System.out.println("key:" + key);
        Object res = memcachedClient.get(key);
        return res;
    }

    @RequestMapping("/encoder")
    public String selefUrlEncodeing(String key) {
        String s1 = null;
        try {
            s1 = URLEncoder.encode(key, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
        }
        System.out.println(s1);
        return s1;
    }
}
