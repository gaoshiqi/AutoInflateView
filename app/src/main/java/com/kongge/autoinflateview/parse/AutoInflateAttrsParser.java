package com.kongge.autoinflateview.parse;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

import com.kongge.autoinflateview.bean.AutoInflateDataBean;
import com.kongge.autoinflateview.parse.IAutoInflateViewParser;
import com.kongge.autoinflateview.view.IAutoInflateView;

import java.util.HashMap;
import java.util.Map;

/**
 * author:kongge
 * date:2018/5/28
 * layout:
 * description:
 */

public class AutoInflateAttrsParser implements IAutoInflateViewParser {

    @Override
    public Map<String, AutoInflateDataBean> parseViewWithConfig(View rootView, Object config) {
        if (rootView == null) {
            return null;
        }
        Map<String, AutoInflateDataBean> beanMap = new HashMap<>();
        traverseView(rootView, beanMap);
        return beanMap;
    }

    /**
     * 遍历view
     * @param view
     */
    private void traverseView(View view, Map<String, AutoInflateDataBean> beanMap) {
        if (view instanceof IAutoInflateView) {
            IAutoInflateView autoInflateView = (IAutoInflateView) view;
            addViewToMap(autoInflateView, beanMap);
            if (!autoInflateView.hasAutoInflateViewChild()) {
                return;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                traverseView(viewGroup.getChildAt(i), beanMap);
            }
        }
    }

    private void addViewToMap(IAutoInflateView autoInflateView, Map<String, AutoInflateDataBean> beanMap) {
        String valueId = autoInflateView.getValueId();
        if (beanMap != null && !TextUtils.isEmpty(valueId)) {
            AutoInflateDataBean bean = new AutoInflateDataBean();
            bean.setValueId(valueId);
            bean.setActionId(autoInflateView.getActionId());
            bean.setContentView((View) autoInflateView);
            beanMap.put(valueId, bean);
        }
    }
}
