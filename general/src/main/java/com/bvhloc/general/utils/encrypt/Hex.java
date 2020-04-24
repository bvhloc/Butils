package com.bvhloc.general.utils.encrypt;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class Hex {

    public static String encode(String str) {

        if (str == null)
            return "20";
        if (str.equals("") || str.isEmpty())
            return "20";

        byte[] bytes = new byte[0];
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        @SuppressWarnings("")
        String hexString = builder.toString();

        return hexString;
    }

    public static String decode(String hex) {

        if (hex == null)
            return "";
        if (hex.equals(""))
            return "";

        String str = "";
        try {
            byte[] bytes = new BigInteger(hex, 16).toByteArray();
            str = new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return str;
    }
}
