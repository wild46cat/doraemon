package com.example.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerDemo {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("aabbcc");
        String appId = "1";
        String mediaUrl = "2";
        String fileType = "3";
        String fileSuffix = "4";
        String url = "5";
        logger.info(String.format("success generateMediaId app[%s] mediaUrl[%s] fileType[%s] fileSuffix[%s]",
                appId, mediaUrl, fileType, fileSuffix));
        logger.info(String.format("success downloadToByte url[%s]", url));
        logger.info(String.format("getAccessTokenFromWeChatServerWithProxies ip:%s,port:%s backip:%s,backport:%s,res:%s",
                1, 2, 3, 4, 5));
    }
}
