package com.kongge.autoinflateview.service;

import com.kongge.autoinflateview.bean.AutoInflateDataBean;
import com.kongge.autoinflateview.view.IAutoInflateView;

/**
 * author:kongge
 * date:2018/5/25
 * layout:
 * description:
 */

public interface OnAutoInflateViewClickListener {

    void onAutoInflateViewClick(AutoInflateDataBean autoInflateDataBean, Object allDataObj, Object dataObj);
}
