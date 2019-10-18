package cn.com.lt992.love.utility;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.util.Date;
import java.util.Random;

public class password_Utilmp {
    public final static String[] word={
            "a","b","c","d","e","f", "g",
            "h","j","k","m","n",
            "p","q",
            "r","s","t",
            "u", "v","w","x","y","z",
            "A","B","C","D","E","F","G",
            "H","J","K","M","N",
            "P","Q",
            "R","S","T",
            "U","V","W","X","Y","Z",
    };
    public static String[] num={
            "2","3","4","5","6","7","8","9"
    };
    /**
     * 随机生成密码
     * @return
     */
    public static String randomPassword(){
        StringBuffer stringBuffer=new StringBuffer();
        //以当前时间生成random
        Random random=new  Random(new Date().getTime());
        boolean flag=false;
        //设置默认密码的长度为1+6位
        int length=random.nextInt(1)+6;
        for (int i = 0; i < length; i++) {
            if(flag){
                stringBuffer.append(num[random.nextInt(num.length)]);
            }else{
                stringBuffer.append(word[random.nextInt(word.length)]);
            }
            flag=!flag;
        }
        return stringBuffer.toString();
    }

    /**
     * 对密码进行Md5加密
     * @param password
     * @return
     */
    public static String passwordMd5(String password){
        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        String salt = sb.toString();
        password = md5Hex(password + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return new String(cs);
    }

    /**
     * 获取十六进制字符串形式的MD5摘要
     */
    public static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 校验密码是否正确
     */
    public static boolean verify(String password, String md5) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5.charAt(i);
            cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
            cs2[i / 3] = md5.charAt(i + 1);
        }
        String salt = new String(cs2);
        return md5Hex(password + salt).equals(new String(cs1));
    }
   /* *//**
     * 生成随机盐
     * @return
     *//*
    public static int randomSalt(){
        return (int) ((Math.random()*9+1)*100000);
    }*/

    public static void main(String[] args) {
        String password = randomPassword();
        String passwordMd5 = passwordMd5(password);
        //输出密码
        System.out.println(password);
        //验证密码生成是否正确
        System.out.println(verify(password, passwordMd5));
    }
}
