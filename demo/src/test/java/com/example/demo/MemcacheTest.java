package com.example.demo;

import com.schooner.MemCached.SockOutputStream;
import com.schooner.MemCached.TransCoder;
import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wuxueyou on 2018/6/30.
 */
public class MemcacheTest {
    public static MemCachedClient memcachedClient;

    static {
        try {
            String[] servers = {"wuxueyou.cn:11212"};
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

    public static void main(String[] args) {
//        memcachedClient.set("xy00","bbb",3);
        Object o = memcachedClient.get("xy00");
        System.out.println(o);

    }

}
