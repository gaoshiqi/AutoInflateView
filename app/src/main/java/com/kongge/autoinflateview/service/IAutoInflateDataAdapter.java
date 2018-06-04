package com.kongge.autoinflateview.service;

import android.view.View;

import com.kongge.autoinflateview.bean.AutoInflateProtocolBean;
import com.kongge.autoinflateview.bean.AutoInflateDataBean;

/**
 * author:kongge
 * date:2018/5/25
 * layout:
 * description:
 */

public interface IAutoInflateDataAdapter {

    void setRootViewData(View rootView, Object objData, Object objConfig, OnRootViewClickListener clickListener, AutoInflateProtocolBean autoInflateProtocolBean);

    void setAutoInfalteViewData(AutoInflateDataBean autoInflateDataBean, Object objData, OnAutoInflateViewClickListener clickListener, AutoInflateProtocolBean autoInflateProtocolBean);

}
