package com.kongge.autoinflateview.service;


import android.view.View;

import com.kongge.autoinflateview.bean.AutoInflateProtocolBean;
import com.kongge.autoinflateview.parse.AutoInflateAttrsParser;
import com.kongge.autoinflateview.parse.IAutoInflateViewParser;

/**
 * author:kongge
 * date:2018/5/28
 * layout:
 * description:
 */

public class AutoInflateCtrl {

    private AutoInflateViewManager autoInflateViewManager;

    private AutoInflateCtrl(Builder builder) {
        autoInflateViewManager = new AutoInflateViewManager();
        autoInflateViewManager.setOnRootViewClickListener(builder.mRootViewClickListener);
        autoInflateViewManager.setOnAutoInflateViewClickListener(builder.mAutoInflateViewClickListener);
        autoInflateViewManager.setAutoInflateProtocolBean(builder.mAutoInflateProtocolBean);
        autoInflateViewManager.setAutoInflateViewParser(builder.mAutoInflateViewParser);
        autoInflateViewManager.setAutoInflateDataAdapter(builder.mAutoInflateDataAdapter);
        autoInflateViewManager.setRootView(builder.mRootView);
        autoInflateViewManager.setConfigObj(builder.mConfigObj);
        autoInflateViewManager.init();
    }

    public void setData(Object data) {
        if (autoInflateViewManager != null) {
            autoInflateViewManager.setData(data);
        }
    }

    public static class Builder {

        private View mRootView;

        private Object mConfigObj;

        private IAutoInflateDataAdapter mAutoInflateDataAdapter;

        private OnRootViewClickListener mRootViewClickListener;

        private OnAutoInflateViewClickListener mAutoInflateViewClickListener;

        private IAutoInflateViewParser mAutoInflateViewParser;

        private AutoInflateProtocolBean mAutoInflateProtocolBean;

        public Builder() {

        }

        public Builder setRootView(View rootView) {
            this.mRootView = rootView;
            return this;
        }

        public Builder setConfig(Object config) {
            this.mConfigObj = config;
            return this;
        }

        public Builder setAutoInflateDataAdapter(IAutoInflateDataAdapter adapter) {
            this.mAutoInflateDataAdapter = adapter;
            return this;
        }

        public Builder setOnRootViewClickListener(OnRootViewClickListener listener) {
            this.mRootViewClickListener = listener;
            return this;
        }

        public Builder setOnAutoInflateViewClickListener(OnAutoInflateViewClickListener listener) {
            this.mAutoInflateViewClickListener = listener;
            return this;
        }

        public Builder setAutoInflateViewParser(IAutoInflateViewParser parser) {
            this.mAutoInflateViewParser = parser;
            return this;
        }

        public Builder setAutoInflateProtocolBean(AutoInflateProtocolBean bean) {
            this.mAutoInflateProtocolBean = bean;
            return this;
        }

        public AutoInflateCtrl build() {
            if (mAutoInflateProtocolBean == null) {
                mAutoInflateProtocolBean = new AutoInflateProtocolBean();
            }
            if (mAutoInflateViewParser == null) {
                mAutoInflateViewParser = new AutoInflateAttrsParser();
            }
            if (mAutoInflateDataAdapter == null) {
                mAutoInflateDataAdapter = new AutoInflateDataMapAdapter();
            }
            if (mAutoInflateDataAdapter == null) {
                mAutoInflateDataAdapter = new AutoInflateDataMapAdapter();
            }
            return new AutoInflateCtrl(this);
        }

    }

}
