package com.bvhloc.general.utils.encrypt;


import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by COVISOFT on 8/21/2017.
 */

public class Encryptor {

    private static final String DEFAULT_KEY = "BVHLOC12BVHLOC12"; // 128 bit key;
    private static final String INIT_VECTOR = "RandomInitVector"; // 16 bytes IV

    public static String encrypt(String value) {
        return encrypt(value, DEFAULT_KEY);
    }

    public static String decrypt(String encrypted) {
        return decrypt(encrypted, DEFAULT_KEY);
    }

    public static String encrypt(String value, String key) {
        try {
            IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
//            System.out.println("encrypted string: "
//                    + Base64.encodeBase64String(encrypted));

            return Base64.encodeToString(encrypted, Base64.DEFAULT);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static String decrypt(String encrypted, String key) {
        try {
            IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

//            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
            byte[] original = cipher.doFinal(Base64.decode(encrypted, Base64.DEFAULT));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
