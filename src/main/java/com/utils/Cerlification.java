package com.utils;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

/**
 * @author wangkai43
 * @create 2018-05-16-16:51
 * @email wangkai43@meituan.com
 */
public class Cerlification {

    public static void main(String[] args) throws Exception {
//        String cerFilePath =  "/Users/wangkai43/certificate/test8/bankofshanghai.cer";
//        readCer(cerFilePath);
//        String pfxFilePath = "/Users/wangkai43/certificate/test8/BOS-生产-私钥.pfx";
//        String pfxPassWord = "123123";
//        readPfx(pfxFilePath, pfxPassWord);

        String jksPath = "/Users/wangkai43/certificate/test8/afe_client.jks";
        String jksPassWord = "123456";
        readJks(jksPath, jksPassWord);

    }
    public static void readCer(String filePath) throws Exception{
        FileInputStream fin = new FileInputStream(filePath);
        BufferedInputStream bin = new BufferedInputStream(fin);
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        X509Certificate cer = (X509Certificate)cf.generateCertificate(bin);
        byte[] bb = cer.getPublicKey().getEncoded();
        String pubKey = Base64.encode(bb);
        System.out.println("========\n" + pubKey);
    }
    public static void readJks(String jksPath, String password) throws Exception {
        readPfxAndJks("JKS", jksPath, password);
    }


    public static void readPfx(String certPath, String password)throws Exception {
        readPfxAndJks("PKCS12", certPath, password);
    }

    public static void readPfxAndJks(String type, String filepath, String password) throws Exception{
        KeyStore ks = KeyStore.getInstance(type);
        FileInputStream fis = new FileInputStream(filepath);
        ks.load(fis, password.toCharArray());
        System.out.println("证书类型___:"+ ks.getType());
        Enumeration enumas = ks.aliases();
        String aliases = null;
        if (enumas.hasMoreElements()){
            aliases = (String) enumas.nextElement();
            System.out.println("证书别名Alias___:"+aliases);
        }
        Certificate cert = ks.getCertificate(aliases);
        PublicKey pubkey = cert.getPublicKey();
        System.out.println("公钥___:"+pubkey);
        byte[] encoded = pubkey.getEncoded();
        String alg = pubkey.getAlgorithm();
        String format = pubkey.getFormat();
        System.out.println(Base64.encode(encoded));
        System.out.println("is key entry=" + ks.isKeyEntry(aliases));
        PrivateKey prikey = (PrivateKey) ks.getKey(aliases,password.toCharArray());
        System.out.println("私钥___:"+prikey);
        byte[] priEncode = prikey.getEncoded();
        System.out.println(Base64.encode(priEncode));
    }
}
