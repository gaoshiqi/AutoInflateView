package com.kongge.autoinflateview.bean;

import android.text.TextUtils;
import android.view.View;

/**
 * author:kongge
 * date:2018/5/28
 * layout:
 * description:
 */

public class AutoInflateDataBean {

    private String mValueId;  // 控件id

    private String mActionId;  // 点击事件id

    private String mHide;  // 是否隐藏

    private String mDataId;  // 获取数据id

    private View mContentView;  // 控件

    public AutoInflateDataBean() {
    }

    public String getValueId() {
        return mValueId;
    }

    public void setValueId(String mValueId) {
        this.mValueId = mValueId;
    }

    public String getActionId() {
        return mActionId;
    }

    public void setActionId(String mActionId) {
        this.mActionId = mActionId;
    }

    public View getContentView() {
        return mContentView;
    }

    public void setContentView(View mView) {
        this.mContentView = mView;
    }

    public String getHide() {
        return mHide;
    }

    public void setHide(String mHide) {
        this.mHide = mHide;
    }

    public String getDataId() {
        return mDataId;
    }

    public void setDataId(String dataId) {
        this.mDataId = dataId;
    }
}
