package com.ebs.common.jdbcspy;

import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import org.apache.commons.lang.ArrayUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Spy工具类
 *
 * @工程： 核心4.0
 * @模块： 核心-常用-jdbcspy
 * 
 * @作者： 刘明磊
 * @创建日期： 2015年11月7日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public class OraCryptUtil {
    private Cipher en;
    private Cipher de;
    private static OraCryptUtil instance = new OraCryptUtil();

    public String encode(byte[] bstr) {
        return new BASE64Encoder().encode(bstr);
    }

    public byte[] decode(String str) {
        byte[] bt = (byte[]) null;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            bt = decoder.decodeBuffer(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bt;
    }

    public byte[] encrypt(String s) {
        try {
            byte[] data = s.getBytes();
            if (data.length % 8 != 0) {
                int length = 8 - data.length % 8;
                byte[] spaces = new byte[length];
                for (int i = 0; i < spaces.length; ++i) {
                    spaces[i] = 32;
                }
                data = ArrayUtils.addAll(data, spaces);
            }
            return this.en.doFinal(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String decrypt(byte[] b) {
        try {
            byte[] data = this.de.doFinal(b);
            return new String(data).trim();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private OraCryptUtil() {
        try {
            DESKeySpec deskey = new DESKeySpec("xinyuan123".getBytes());
            SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
            SecretKey key = skf.generateSecret(deskey);
            IvParameterSpec iv = new IvParameterSpec(new byte[8]);
            this.en = Cipher.getInstance("DES/CBC/NoPadding");
            this.en.init(1, key, iv);
            this.de = Cipher.getInstance("DES/CBC/NoPadding");
            this.de.init(2, key, iv);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static OraCryptUtil getInstance() {
        return instance;
    }

    public String encryptByChar(String str, String hz) {
        if ((str == null) || (str.length() == 0)) {
            return str;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); ++i) {
            sb.append(encode(encrypt(str.substring(i, i + 1))));
        }
        sb.append(hz);
        return sb.toString();
    }

    public String decryptByChar(String str, String hz) {
        if ((str == null) || (str.length() == 0)) {
            return str;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length() - hz.length(); i += 12) {
            sb.append(decrypt(decode(str.substring(i, i + 12))));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = getInstance().encryptByChar("你哦好", "<!des,64>");
        System.out.println(s);
        System.out.println(getInstance().decryptByChar("qkxlTnZnJ7E=<!des,64>", "<!des,64>"));
    }
}
