package com.kongge.autoinflateview.service;

import android.view.View;

import com.kongge.autoinflateview.bean.AutoInflateDataBean;
import com.kongge.autoinflateview.view.IAutoInflateView;

/**
 * author:kongge
 * date:2018/5/25
 * layout:
 * description:
 */

public interface IAutoInflateDataAdapter {

    void setRootViewData(View rootView, Object objData, OnRootViewClickListener clickListener);

    void setAutoInfalteViewData(AutoInflateDataBean autoInflateDataBean, Object objData, OnAutoInflateViewClickListener clickListener);

}
