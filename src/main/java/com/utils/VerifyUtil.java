package com.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;

/**
 * @author wangkai43
 * @create 2018-05-16-17:01
 * @email wangkai43@meituan.com
 */
public class VerifyUtil {

    public static void main(String[] args) {

        String priKeStr = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKG7sw68H9UZHAZ5Q2DiEzQSQ9kw" +
                "JpfME9qH6wRuoMOx3szGF4aUmWoq5nLI3QnNPPOwndybkSdTh9c5hkV6lGfxNvvhSOzH+QY8PI6p" +
                "99D8qUMEUqQZYBT1pm2r9tCUPaX2//pgLoTXD10UVlmi8g3W6bnDTCd8STXr0tQRzmkpAgMBAAEC" +
                "gYEAgxK0bdem0LQ100VJhuYRfBzlYco1LMaWvH90xzXFEnQ/xaMxA7/AiZtVAmepQ71SjYhwl454" +
                "V+/JYnLbT8mlJUIbBmXlUZeu7So6kU5S/bgG7G7gi0LLC/Bp0C3/EY3+eEJwy1sXm8rbEfqZRzHm" +
                "FqczEHKyLYhf2iF/Zs/6AKUCQQDQvg21nwOuWOq0Vscj+QKcAcEO8cxMylNzm93Ur54OaIpXK4da" +
                "ziZeaBwYHWtgc/pTlAveiHUB8vYj8HUlcy1DAkEAxlkqKhWKqd5RojS43xSRXzDYETQpZg3ob6oE" +
                "JDoQtLrmnE0reE6zJTFA6ONzV2tPRNdQALx3WW8wk71pA6vTIwJBAIIHYZLZUvmv+cQMqlAGNVHo" +
                "5dHhXVoYTpOdbDmoi9R92m8idlZiRBRa1eVPriuPE0gs2JfueLSWHC2XA+IoNPECQCTtKq1lD0iq" +
                "rBX/rL9TS/El3cPuKxrl0fUf+N9ps/yBozdMIqCmPjHZZpU06x9GSh6t2yYX8DxFOAz5QVi+n3MC" +
                "QBxYc6U+uHCgEeXQmOKCTJKOIwxxhEP2NJvkGwnOr1UZRv59JVHWloIdRbileX8N9e54lcEXgyot" +
                "Q3q9SXEhdY8=";
        String pubKeyStr = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQChu7MOvB/VGRwGeUNg4hM0EkPZMCaXzBPah+sE" +
                "bqDDsd7MxheGlJlqKuZyyN0JzTzzsJ3cm5EnU4fXOYZFepRn8Tb74Ujsx/kGPDyOqffQ/KlDBFKk" +
                "GWAU9aZtq/bQlD2l9v/6YC6E1w9dFFZZovIN1um5w0wnfEk169LUEc5pKQIDAQAB";

        try {
            verifyStr(priKeStr,pubKeyStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void verifyStr(String priKeyStr, String pubKeyStr) throws Exception {
        String privateKeyStr = priKeyStr;
        String publicKeyStr = pubKeyStr;

        String unSignStr =  "wkwangkai";

        String sign = null;
        //加签
        try {
            System.out.println("unSignStr:"+unSignStr);
            RSAPrivateKey rsaPrivateKey = loadPrivateKey(privateKeyStr);
            sign = signData(unSignStr.getBytes("utf-8"),rsaPrivateKey);
            System.out.println("sign:"+sign);
        } catch (Exception e) {
            throw new Exception("加签异常");
        }

        //验签
        RSAPublicKey publicKey = loadPublicKey(publicKeyStr);
        Signature exp = Signature.getInstance("SHA1withRSA");
        exp.initVerify(publicKey);
        exp.update(unSignStr.getBytes(), 0, unSignStr.getBytes("utf-8").length);
        byte[] signedData = new BASE64Decoder().decodeBuffer(sign);
        int check = exp.verify(signedData) ? 0 : 1;

        if (check == 0 ) {
            System.out.println("验签成功");
        }else {
            System.out.println("验签失败");
        }


    }

    public static RSAPrivateKey loadPrivateKey(String privateKeyStr) throws Exception {
        try {
            BASE64Decoder base64Decoder = new BASE64Decoder();
            byte[] buffer = base64Decoder.decodeBuffer(privateKeyStr);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法", e);
        } catch (InvalidKeySpecException e) {
            throw new Exception("私钥非法", e);
        } catch (IOException e) {
            throw new Exception("私钥数据内容读取错误", e);
        } catch (NullPointerException e) {
            throw new Exception("私钥数据为空", e);
        }
    }

    /**
     * 从字符串中加载公钥
     *
     * @param publicKeyStr 公钥数据字符串
     * @throws Exception 加载公钥时产生的异常
     */
    public static RSAPublicKey loadPublicKey(String publicKeyStr) throws Exception {
        try {
            BASE64Decoder base64Decoder = new BASE64Decoder();
            byte[] buffer = base64Decoder.decodeBuffer(publicKeyStr);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
            return (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法", e);
        } catch (InvalidKeySpecException e) {
            throw new Exception("公钥非法", e);
        } catch (IOException e) {
            throw new Exception("公钥数据内容读取错误", e);
        } catch (NullPointerException e) {
            throw new Exception("公钥数据为空", e);
        }
    }

    /**
     * 加签
     * @param originData
     * @param key
     * @return
     * @throws Exception
     */
    public static String signData(byte[] originData, PrivateKey key) throws Exception {
        Signature sign = Signature.getInstance("SHA1withRSA");
        sign.initSign(key);
        sign.update(originData, 0, originData.length);
        return new BASE64Encoder().encode(sign.sign()).replaceAll("[\\s*\t\n\r]", "");
    }


}
