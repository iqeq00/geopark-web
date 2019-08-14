package com.geopark.test;

//import liquibase.util.MD5Util;
import org.apache.commons.codec.digest.DigestUtils;

public class MD5Test {

    public static void main(String[] args) {

        String str = "Str实打实123";
        String md5Str = DigestUtils.md5Hex(str);
        System.out.println("MD5-->" + md5Str);

        System.out.println("============================");

//        String md5Str2 = MD5Util.computeMD5(str);
//        System.out.println("MD5-->" + md5Str2);

    }
}
