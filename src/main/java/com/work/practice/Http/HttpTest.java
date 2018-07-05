package com.work.practice.Http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author wangkai43
 * @create 2018-04-03-16:01
 * @email wangkai43@meituan.com
 */
public class HttpTest {
    public static Logger logger = LoggerFactory.getLogger(HttpTest.class);
    public static void main(String[] args) {
        String url  ="https://218.94.59.9:9999/eis/merchant/merchantServices.htm";
        String reqContent = "";
        try {
            String response = HttpTest.sendByHttp(url,reqContent,"utf-8", 1000, 6000, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String sendByHttp(String urlStr, String reqContent, String encoding, int connectionTimeout, int readTimeout,String contentType) throws Exception {
        logger.info("Http请求地址: {}", urlStr);
//        logger.info("Http请求报文: {}", reqContent);
        logger.info("Http请求报文: {}", reqContent);
        StringBuilder reStr = new StringBuilder();
        HttpURLConnection connection = null;
        OutputStream out = null;
        BufferedReader in = null;
        try {
            URL url = new URL(urlStr);
            connection = (HttpURLConnection) url.openConnection();
            byte[] reqContentBytes = reqContent.getBytes(encoding);
            connection.setConnectTimeout(connectionTimeout);
            connection.setReadTimeout(readTimeout);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("Content-Type", contentType==null?"application/xml; charset=utf-8":contentType);
            connection.setRequestProperty("Content-Length", String.valueOf(reqContentBytes.length));
            connection.setRequestMethod("POST");
            connection.connect();
            out = connection.getOutputStream();
            out.write(reqContentBytes);
            String respCode = Integer.toString(connection.getResponseCode());
            if (!"200".equals(respCode)) {
                throw new Exception("HTTP通信失败:" + respCode);
            }
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), encoding));
            String line;
            while ((line = in.readLine()) != null) {
                reStr.append(line);
            }
        } catch (Exception e) {
            logger.error("HttpUtils.sendByHttp()连接异常", e);
            throw e;
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
                logger.error("关闭输出流出现异常！", e);
                out = null;
            }
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                logger.error("关闭输入流出现异常！", e);
                in = null;
            }
            try {
                if (connection != null) {
                    connection.disconnect();
                }
            } catch (Exception e) {
                logger.error("关闭http连接出现异常！", e);
                connection = null;
            }
        }
        return reStr.toString();
    }




}
