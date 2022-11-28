package com.lyk.demo.utils;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


/**
 * //https://blog.csdn.net/yyt593891927/article/details/110202102?spm=1001.2101.3001.6650.13&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-13-110202102-blog-124841874.pc_relevant_sortByAnswer&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-13-110202102-blog-124841874.pc_relevant_sortByAnswer&utm_relevant_index=20
 *AES加解密处理
 */
public class AesUtil {

    public static void main(String[] args) {
        String enStr = encrypt("hello world");
        System.out.println("enStr: " + enStr);
        System.out.println("deStr: " + decrypt(enStr));
    }

    public static void OutPut(byte[] content) {
        for (int i = 0; i < content.length; i++) {
            System.out.print(content[i] + ", ");
        }
        System.out.print("\n");
    }

    //加密
    public static String encrypt(String content) {
        try {
            if (content.isEmpty())
                return "";

            String password = "t7CLWhtUTAgAFbw0";
            // 使用密钥生成器
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(password.getBytes());
            kgen.init(128, secureRandom);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            OutPut(enCodeFormat);
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(byteContent);
            String str = Base64.encodeBase64String(result);

            return str; // 加密
        } catch (NoSuchAlgorithmException e) {
            // e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            // e.printStackTrace();
        } catch (InvalidKeyException e) {
            // e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            // e.printStackTrace();
        } catch (BadPaddingException e) {
            // e.printStackTrace();
        }
        return null;
    }

    //解密
    public static String decrypt(String str) {
        try {
            String password = "t7CLWhtUTAgAFbw0";
            byte[] content = Base64.decodeBase64(str);
            // 使用密钥生成器
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(password.getBytes());
            kgen.init(128, secureRandom);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(content);

            return new String(result);
        } catch (NoSuchAlgorithmException e) {
            // e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            // e.printStackTrace();
        } catch (InvalidKeyException e) {
            // e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            // e.printStackTrace();
        } catch (BadPaddingException e) {
            // e.printStackTrace();
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return "";
    }


}
