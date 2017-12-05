package com.yugrdev.devlibrary.utils;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * 项目名称：DevPKG
 * 类：StreamUtils
 * 描述：
 * 创建人：Yugr
 * 创建日期：2016/11/24
 * 时间：11:19
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public class StreamUtils {
    public static byte[] bytesString(InputStream is) throws Exception {
        BufferedInputStream in = new BufferedInputStream(is);
        ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
        byte[] temp = new byte[1024];
        int size = 0;
        while ((size = in.read(temp)) != -1) {
            out.write(temp, 0, size);
        }
        in.close();
        byte[] content = out.toByteArray();
        return content;
    }

    public static String bytes2HexString(byte[] b) {
        StringBuffer result = new StringBuffer();
        String hex;
        for (int i = 0; i < b.length; i++) {
            hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            result.append(hex.toUpperCase());
        }
        return result.toString();
    }

    /**
     * 获取输入流转换为字符串
     *
     * @param is 输入流
     * @return 文本字符串
     * @throws Exception IOException
     */
    public static String readStream(InputStream is) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            baos.write(buffer, 0, len);
        }
        is.close();
        String temp = baos.toString();
        return temp;

    }


}

