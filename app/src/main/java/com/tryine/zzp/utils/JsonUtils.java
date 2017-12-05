package com.tryine.zzp.utils;

import java.util.List;
import java.util.Map;

/**
 * Created by Yugr on 2017/9/3 13:35.
 * Introduce:
 * Update by
 */

public class JsonUtils {

    public static String toJson(List<Map<String, String>> datas) {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("[");
        for (int i = 0; i < datas.size(); i++) {
            strBuilder.append("{");
            for (Map.Entry<String, String> entry : datas.get(i).entrySet()) {
                strBuilder.append("\"" + entry.getKey() + "\":");
                strBuilder.append("\"" + entry.getValue() + "\",");
            }
            strBuilder.deleteCharAt(strBuilder.length() - 1);
            strBuilder.append("},");
        }
        strBuilder.deleteCharAt(strBuilder.length() - 1);
        strBuilder.append("]");
        return strBuilder.toString();
    }

    public String toJson(Map<String, String> data) {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("{");
        for (Map.Entry<String, String> entry : data.entrySet()) {
            strBuilder.append("\"" + entry.getKey() + "\":");
            strBuilder.append("\"" + entry.getValue() + "\",");
        }
        strBuilder.deleteCharAt(strBuilder.length() - 1);
        strBuilder.append("}");
        return strBuilder.toString();
    }
}
