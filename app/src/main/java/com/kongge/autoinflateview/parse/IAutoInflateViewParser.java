package com.kongge.autoinflateview.parse;

import android.view.View;

import com.kongge.autoinflateview.bean.AutoInflateDataBean;

import java.util.Map;

/**
 * author:kongge
 * date:2018/5/28
 * layout:
 * description:
 */

public interface IAutoInflateViewParser<C> {

    Map<String, AutoInflateDataBean> parseViewWithConfig(View rootView, C config);

}
