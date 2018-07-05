package com.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


/**
 * @author wangkai43
 * @create 2018-05-18-13:40
 * @email wangkai43@meituan.com
 */
public class Base64Util {
    public static void main(String[] args) throws Exception {
    //    String filePathOri = "/Users/wangkai43/certificate/test8/afe_client.jks";
        String filePathRes = "/Users/wangkai43/certificate/test8/afe_client_2.jks";
     //   String result = base64Encode(filePathOri);

        String compare = "/u3+7QAAAAIAAAABAAAAAgAGc2hiYW5rAAABWkaVlBEABVguNTA5AAACFjCCAhIwggF7AgRVnhfwMA0GCSqGSIb3DQEBBQUAMFAxCzAJBgNVBAYTAmNuMQswCQYDVQQIEwJTSDELMAkGA1UEBxMCU0gxDDAKBgNVBAoTA2JlYTEMMAoGA1UECxMDQUZFMQswCQYDVQQDEwJDTjAeFw0xNTA3MDkwNjQyNTZaFw0yNTA3MDYwNjQyNTZaMFAxCzAJBgNVBAYTAmNuMQswCQYDVQQIEwJTSDELMAkGA1UEBxMCU0gxDDAKBgNVBAoTA2JlYTEMMAoGA1UECxMDQUZFMQswCQYDVQQDEwJDTjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEAgrdM34KA5LdfGOKf8UsRs5lOQzxVt1h1ELP31VQIAwIOt7RjbjEyB8QjY6L5GUhMPaPgUMUnbTkRxfdT16GlJH38NMsQswMSeVEUXcao1k+n4uvIdeGGMdhECtRr9AIeyWkeFOyZcbaTQbNxA5Tvd4slWrm5V612Y48xInYUBI8CAwEAATANBgkqhkiG9w0BAQUFAAOBgQBil/fED3kblctlTxZicQZHIdP8YKbzubtqkG2PYhXylegRF7is6hEvSPo73xga6w2e8AIxv9njh6ajgiOsQR+b8ox8gpZergfS92G6llotDHBsJJ77jgaJ3BrPWogUQ4CjpBdPmsT07R6V60lVC1UElA5XgJJwu79QF0AjCSxGMA8FWHzCki/bcsHjtXUHupAKDU6K";
        base64Decode(filePathRes, compare);

    }

    public static String base64Encode(String path) throws Exception {
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        int length = fileInputStream.available();
        byte[] bytess = new byte[length];
        fileInputStream.read(bytess);
        String str = Base64.encodeBase64String(bytess);
        System.out.println(str);
        return str;
    }

    public static void base64Decode(String path,String contents) throws Exception {
        byte[] bytes = Base64.decodeBase64(contents);
        File file = new File(path);
        if(!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(bytes);
        fileOutputStream.flush();
        fileOutputStream.close();
        System.out.println(file.getAbsolutePath());
    }


}
