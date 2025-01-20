package com.saki.company.util;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.digest.MD5;

public class BigDataApiToken {

    public static void main(String[] args) {
        String apiPrefix = "";
        String clientSecret = "";
        String apiTokenClient = new MD5().digestHex(apiPrefix+ DateUtil.format(DateUtil.date(), DatePattern.NORM_DATE_FORMAT) +  clientSecret);
        System.out.println(apiTokenClient);
    }
}
