package com.kongge.demo;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * author:kongge
 * date:2018/5/25
 * layout:
 * description:
 */

public class FileUtil {

    // ~常量区块
    // ========================================================

    // ~成员变量区块
    // ========================================================

    // ~构造函数区块
    // ========================================================

    // ~方法区块
    // ========================================================

    // ~静态方法区块
    // ========================================================
    public static String parserStreamToString(InputStream is){
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                    is = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static InputStream parserAssertFile(Context context, String fileName) {
        InputStream is = null;
        try {
            is = context.getAssets().open(fileName);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return is;
    }

    public static String parseAssetsFile(Context context, String fileName) {
        InputStream inputStream = parserAssertFile(context, fileName);
        return parserStreamToString(inputStream);
    }


    // ~内部接口（类）区块
    // ========================================================

}
