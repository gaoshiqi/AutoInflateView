package com.kongge.autoinflateview.parse;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import com.kongge.autoinflateview.bean.AutoInflateProtocolBean;
import com.kongge.autoinflateview.bean.AutoInflateDataBean;

import java.util.HashMap;
import java.util.Map;

/**
 * author:kongge
 * date:2018/5/28
 * layout:
 * description:配置管理类
 */

public class AutoInflateConfigParser implements IAutoInflateViewParser {
    @Override
    public Map<String, AutoInflateDataBean> parseViewWithConfig(View rootView, Object config, AutoInflateProtocolBean autoInflateProtocolBean) {
        if (rootView == null || config == null || !(config instanceof Map)) {
            return null;
        }
        Map<String, AutoInflateDataBean> beanMap = new HashMap<>();
        Map<String, Object> configMap = (Map) config;
        traverseView(rootView,configMap, beanMap, autoInflateProtocolBean);
        return beanMap;
    }

    private void traverseView(View rootView, Map<String, Object> configMap, Map<String, AutoInflateDataBean> beanMap, AutoInflateProtocolBean autoInflateProtocolBean) {
        try {
            Context context = rootView.getContext();
            for (String key : configMap.keySet()) {
                if (autoInflateProtocolBean.isProtocolKey(key)) {
                    continue;
                }
                String action = null;
                String hide = null;
                String dataId = null;
                Object objConfigItem = configMap.get(key);
                if (objConfigItem instanceof String) {
                    action = "";
                    hide = "";
                } else if (objConfigItem instanceof Map) {
                    Map<String, String> configItemMap = (Map<String, String>) configMap.get(key);
                    action = configItemMap.get(autoInflateProtocolBean.getStr_action());
                    hide = configItemMap.get(autoInflateProtocolBean.getStr_hide());
                    dataId = configItemMap.get(autoInflateProtocolBean.getStr_dataId());
                }
                if (TextUtils.isEmpty(dataId)) {
                    dataId = key;
                }

                int id = context.getResources().getIdentifier(key, "id", context.getPackageName());
                View view = rootView.findViewById(id);
                if (view == null) {
                    continue;
                }
                AutoInflateDataBean bean = new AutoInflateDataBean();
                bean.setValueId(key);
                bean.setActionId(action);
                bean.setContentView(view);
                bean.setHide(hide);
                bean.setDataId(dataId);
                beanMap.put(key, bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
