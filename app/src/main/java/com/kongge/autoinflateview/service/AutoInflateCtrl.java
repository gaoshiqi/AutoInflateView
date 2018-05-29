package com.kongge.autoinflateview.service;


import android.view.View;

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
        IAutoInflateViewParser parser = builder.mAutoInflateViewParser;
        if (parser == null) {
            parser = new AutoInflateAttrsParser();
        }
        autoInflateViewManager.setAutoInflateViewParser(parser);

        IAutoInflateDataAdapter adapter = builder.mAutoInflateDataAdapter;
        if (adapter == null) {
            adapter = new AutoInflateDataMapAdapter();
        }
        autoInflateViewManager.setAutoInflateDataAdapter(adapter);
        autoInflateViewManager.init(builder.mRootView, builder.mConfigObj);
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

        public AutoInflateCtrl build() {
            return new AutoInflateCtrl(this);
        }

    }

}
