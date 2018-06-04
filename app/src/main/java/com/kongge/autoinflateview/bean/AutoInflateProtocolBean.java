package com.kongge.autoinflateview.bean;

import android.text.TextUtils;

/**
 * author:kongge
 * date:2018/6/4
 * layout:
 * description: 字符串协议bean
 */

public class AutoInflateProtocolBean {

    /**
     * 数据约定key值
     */
    public static final String KEY_HIDE = "hide";  // 隐藏
    public static final String KEY_COLOR = "color";  // 颜色
    public static final String KEY_VALUE = "value";  // 值
    public static final String KEY_ACTION = "action";  // 事件id值
    public static final String KEY_DATA_ID = "dataid";  // 事件id值

    private String mStr_hide = KEY_HIDE;
    private String mStr_color = KEY_COLOR;
    private String mStr_value = KEY_VALUE;
    private String mStr_action = KEY_ACTION;
    private String mStr_dataId = KEY_DATA_ID;

    public AutoInflateProtocolBean() {
    }

    public String getStr_hide() {
        return mStr_hide;
    }

    public void setStr_hide(String mStr_hide) {
        this.mStr_hide = mStr_hide;
    }

    public String getStr_color() {
        return mStr_color;
    }

    public void setStr_color(String mStr_color) {
        this.mStr_color = mStr_color;
    }

    public String getStr_value() {
        return mStr_value;
    }

    public void setStr_value(String mStr_value) {
        this.mStr_value = mStr_value;
    }

    public String getStr_action() {
        return mStr_action;
    }

    public void setStr_action(String mStr_action) {
        this.mStr_action = mStr_action;
    }

    public String getStr_dataId() {
        return mStr_dataId;
    }

    public void setmStr_dataId(String mStr_dataId) {
        this.mStr_dataId = mStr_dataId;
    }

    public boolean isProtocolKey(String value) {
        return TextUtils.equals(value, mStr_hide) ||
                TextUtils.equals(value, mStr_color) ||
                TextUtils.equals(value, mStr_value) ||
                TextUtils.equals(value, mStr_action) ||
                TextUtils.equals(value, mStr_dataId);
    }
}
