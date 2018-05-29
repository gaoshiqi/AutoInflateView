package com.kongge.autoinflateview.service;

import android.view.View;

import com.kongge.autoinflateview.bean.AutoInflateDataBean;
import com.kongge.autoinflateview.parse.IAutoInflateViewParser;

import java.util.Map;

/**
 * author:kongge
 * date:2018/5/25
 * layout:
 * description:
 */

public class AutoInflateViewManager {

    private View rootView;

    private Map<String, AutoInflateDataBean> mAutoInflateDataBeanMap = null;

    private IAutoInflateDataAdapter mAutoInflateDataAdapter;

    private OnRootViewClickListener mRootViewClickListener;

    private OnAutoInflateViewClickListener mAutoInflateViewClickListener;

    private IAutoInflateViewParser mAutoInflateViewParser;

    public AutoInflateViewManager() {

    }

    public void init(View view, Object config) {
        if (view == null) {
            return;
        }
        rootView = view;
        if (mAutoInflateViewParser != null) {
            mAutoInflateDataBeanMap = mAutoInflateViewParser.parseViewWithConfig(view, config);
        }
    }

    public void setData(Object objData) {
        if (mAutoInflateDataBeanMap == null || mAutoInflateDataBeanMap.size() == 0) {
            return;
        }
        if (mAutoInflateDataAdapter != null) {
            mAutoInflateDataAdapter.setRootViewData(rootView, objData, mRootViewClickListener);
            for (String valueId : mAutoInflateDataBeanMap.keySet()) {
                mAutoInflateDataAdapter.setAutoInfalteViewData(mAutoInflateDataBeanMap.get(valueId), objData, mAutoInflateViewClickListener);
            }
        }

    }

    public void setAutoInflateDataAdapter(IAutoInflateDataAdapter autoInflateDataAdapter) {
        this.mAutoInflateDataAdapter = autoInflateDataAdapter;
    }

    public void setOnRootViewClickListener(OnRootViewClickListener mRootViewClickListener) {
        this.mRootViewClickListener = mRootViewClickListener;
    }

    public void setOnAutoInflateViewClickListener(OnAutoInflateViewClickListener listener) {
        this.mAutoInflateViewClickListener = listener;
    }

    public void setAutoInflateViewParser(IAutoInflateViewParser mAutoInflateViewParser) {
        this.mAutoInflateViewParser = mAutoInflateViewParser;
    }
}
