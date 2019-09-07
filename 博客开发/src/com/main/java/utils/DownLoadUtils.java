package com.main.java.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.Base64.Encoder;

public class DownLoadUtils {

    public static String getFileName(String agent,String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")) {
            //IE浏览器
            filename = URLEncoder.encode(filename,"utf-8");
            filename = filename.replace("+"," ");
        } else if(agent.contains("Fircfox")) {
            //火狐浏览器
            Encoder encoder = Base64.getEncoder();
            filename="=?utf-8"+encoder.encode(filename.getBytes("utf-8"));
        } else {
            //其他浏览器
            filename = URLEncoder.encode(filename,"utf8");
        }
        return filename;
    }
}
