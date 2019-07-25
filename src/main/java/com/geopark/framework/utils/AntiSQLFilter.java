package com.geopark.framework.utils;

import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * AntiSQLFilter
 *
 * @author lichee
 */
public class AntiSQLFilter {

    private static final String[] keyWords = {";", "\"", "\'", "/*", "*/", "--", "exec",
            "select", "update", "delete", "insert",
            "alter", "drop", "create", "shutdown"};

    public static Map<String, String[]> getSafeParameterMap(Map<String, String[]> parameterMap) {
        Maps.MapBuilder<String, String[]> builder = Maps.builder(HashMap<String, String[]>::new);
        Iterator<String> iter = parameterMap.keySet().iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            String[] oldValues = parameterMap.get(key);
            builder.put(key, getSafeValues(oldValues));
        }
        return builder.unmodifiable().build();
    }


    public static String[] getSafeValues(String[] oldValues) {
        if (ArrayUtils.isNotEmpty(oldValues)) {
            String[] newValues = new String[oldValues.length];
            for (int i = 0; i < oldValues.length; i++) {
                newValues[i] = getSafeValue(oldValues[i]);
            }
            return newValues;
        }
        return null;
    }

    public static String getSafeValue(String oldValue) {
        StringBuilder sb = new StringBuilder(oldValue);
        String lowerCase = oldValue.toLowerCase();
        for (String keyWord : keyWords) {
            int x;
            while ((x = lowerCase.indexOf(keyWord)) >= 0) {
                if (keyWord.length() == 1) {
                    sb.replace(x, x + 1, " ");
                    lowerCase = sb.toString().toLowerCase();
                    continue;
                }
                sb.deleteCharAt(x + 1);
                lowerCase = sb.toString().toLowerCase();
            }
        }
        return sb.toString();
    }

}
