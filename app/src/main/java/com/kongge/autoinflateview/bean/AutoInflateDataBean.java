package com.kongge.autoinflateview.bean;

import android.view.View;

/**
 * author:kongge
 * date:2018/5/28
 * layout:
 * description:
 */

public class AutoInflateDataBean {

    private String mValueId;

    private String mActionId;

    private View mContentView;

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
}
