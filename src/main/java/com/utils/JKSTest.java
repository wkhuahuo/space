package com.utils;

/**
 * @author wangkai43
 * @create 2018-05-17-11:45
 * @email wangkai43@meituan.com
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

/**
 * JKS读取密匙
 */
public class JKSTest {

    public static PublicKey getPublicKey(String keyStoreFile,
                                         String storeFilePass, String keyAlias) {
        // 读取密钥是所要用到的工具类
        KeyStore ks;

        // 公钥类所对应的类
        PublicKey pubkey = null;
        try {
            // 得到实例对象
            ks = KeyStore.getInstance("JKS");
            FileInputStream fin;
            try {
                // 读取JKS文件
                fin = new FileInputStream(keyStoreFile);
                try {
                    // 读取公钥
                    ks.load(fin, storeFilePass.toCharArray());
                    Certificate cert = ks
                            .getCertificate(keyAlias);
                    pubkey = cert.getPublicKey();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (CertificateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return pubkey;
    }

    /**
     * 得到私钥
     *
     * @param keyStoreFile
     *            私钥文件
     * @param storeFilePass
     *            私钥文件的密码
     * @param keyAlias
     *            别名
     * @param keyAliasPass
     *            密码
     * @return
     */

    public static PrivateKey getPrivateKey(String keyStoreFile,
                                           String storeFilePass, String keyAlias, String keyAliasPass) {
        KeyStore ks;
        PrivateKey prikey = null;
        try {
            ks = KeyStore.getInstance("JKS");
            FileInputStream fin;
            try {
                fin = new FileInputStream(keyStoreFile);
                try {
                    try {
                        ks.load(fin, storeFilePass.toCharArray());
                        // 先打开文件
                        prikey = (PrivateKey) ks.getKey(keyAlias, keyAliasPass
                                .toCharArray());
                        // 通过别名和密码得到私钥
                    } catch (UnrecoverableKeyException e) {
                        e.printStackTrace();
                    } catch (CertificateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return prikey;
    }

    /**
     * jks读取密钥
     */
    public static void main(String[] args) {
        PublicKey publicKey;
        PrivateKey privateKey;

        publicKey=getPublicKey("/Users/wangkai43/certificate/test8/afe_client.jks","123456", "client");
        //privateKey=getPrivateKey("C:\\aaa.jks","AAAAAAAA", "ibmwebspheremq","AAAAAAAA");

        System.out.println(publicKey.toString());
        //System.out.println(privateKey.toString());
    }

}
