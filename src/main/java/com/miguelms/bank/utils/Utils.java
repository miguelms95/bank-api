package com.miguelms.bank.utils;

import org.springframework.util.DigestUtils;

public class Utils {

    public static String encryptMd5(String text){
        return DigestUtils.md5DigestAsHex(text.getBytes()).toUpperCase();
    }

}
