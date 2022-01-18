package com.ruoyi.common.EncryptionDecrypt;

import org.springframework.util.ClassUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SHA256Util {
    private static final String SIGN = "sign";
    private static final String SIGNATURE_ALGORITHM = "SHA-256";

    public static String generateSign(Map object, String secretKey){
        if(object == null || secretKey == null){
            return null;
        }
        //将所有参数进行排序
        Set<String> param = new TreeSet<>(object.keySet());
        //将参数进行拼接
        StringBuffer sign = new StringBuffer();
        for(String key : param){
            if(SIGN.equals(key)){
                continue;
            }
            //如果为基础类型或者字符串类型则进行拼接
            Object value = object.get(key);
            if(value == null){
                continue;
            }
            if (ClassUtils.isPrimitiveOrWrapper(value.getClass()) || value instanceof String) {
                sign.append(key).append("=").append(value.toString()).append("&");
            }
        }
        if(sign.length() > 0){
            sign.setLength(sign.length()-1);
        }else{
            return null;
        }
        sign.append(secretKey);
        return getSHA256StrJava(sign.toString()).toUpperCase();
    }




    public static String getSHA256StrJava(String str) {

        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance(SIGNATURE_ALGORITHM);
            messageDigest.update(str.getBytes("UTF-8"));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
//1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

    public static boolean checkSign(String sign, Map object, String secret){
        boolean flag = false;
        if(sign != null && sign.equals(generateSign(object, secret))){
            flag = true;
        }
        return flag;
    }


    public static void main(String[] args) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("appId", "41");
        map.put("channelId", "37010200001320000017");
        map.put("timestamp", "20211220 150405");
        System.out.println(generateSign(map, "S5xFnUK4KXZkn04dLXaWK8dnvZWsr0pH"));
    }

}
