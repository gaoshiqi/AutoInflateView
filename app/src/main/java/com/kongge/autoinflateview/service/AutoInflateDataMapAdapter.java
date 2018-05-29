package com.kongge.autoinflateview.service;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kongge.autoinflateview.bean.AutoInflateDataBean;
import com.kongge.autoinflateview.view.IAutoInflateView;

import java.util.Map;

/**
 * author:kongge
 * date:2018/5/25
 * layout:
 * description:
 */

public class AutoInflateDataMapAdapter implements IAutoInflateDataAdapter {

    /**
     * 数据约定key值
     */
    public static final String KEY_HIDE = "hide";  // 隐藏
    public static final String KEY_COLOR = "color";  // 颜色
    public static final String KEY_VALUE = "value";  // 值
    public static final String KEY_ACTION = "action";  // 事件id值

    public static final String VALUE_HIDE_OPEN = "1";  // hide值为1，代表隐藏。默认是显示

    @Override
    public void setRootViewData(final View rootView, final Object objData, final OnRootViewClickListener clickListener) {
        if (rootView == null || !(objData instanceof Map)) {
            return;
        }
        String hide = null;
        String action = null;
        if (objData instanceof Map) {
            Map<String, Object> valueMap = (Map) objData;
            hide = (String) valueMap.get(KEY_HIDE);
            action = (String) valueMap.get(KEY_ACTION);
        }

        int visibility = View.VISIBLE;
        if (hide != null && hide.equals(VALUE_HIDE_OPEN)) {
            visibility = View.GONE;
        }
        rootView.setVisibility(visibility);

        if (clickListener != null && !TextUtils.isEmpty(action)) {
            rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onRootViewClick(rootView, objData);
                }
            });
            rootView.setClickable(true);
        } else {
            rootView.setClickable(false);
        }
    }

    @Override
    public void setAutoInfalteViewData(final AutoInflateDataBean autoInflateDataBean, final Object objData, final OnAutoInflateViewClickListener clickListener) {
        if (autoInflateDataBean == null || objData == null || !(objData instanceof Map)) {
            return;
        }
        String valueId = autoInflateDataBean.getValueId();
        if (TextUtils.isEmpty(valueId)) {
            return;
        }
        Map<String, Object> dataMap = (Map) objData;
        final Object valueObj = dataMap.get(valueId);
        if (valueObj == null) {
            return;
        }

        String value = null;
        String textColor = null;
        String hide = null;
        String action = null;

        if (valueObj instanceof String) {
            value = valueObj.toString();
        } else if (valueObj instanceof Map) {
            Map<String, Object> valueMap = (Map) valueObj;
            value = (String) valueMap.get(KEY_VALUE);
            textColor = (String) valueMap.get(KEY_COLOR);
            hide = (String) valueMap.get(KEY_HIDE);
            action = (String) valueMap.get(KEY_ACTION);
        }

        View view = autoInflateDataBean.getContentView();
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            textView.setText(value);
            if (!TextUtils.isEmpty(textColor)) {
                try {
                    textView.setTextColor(Color.parseColor(textColor));
                } catch (Exception e) {
                }
            }
        } else if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            Glide.with(imageView.getContext()).load(value).into(imageView);
        }

        int visibility = View.VISIBLE;
        if (hide != null && hide.equals(VALUE_HIDE_OPEN)) {
            visibility = View.GONE;
        }
        view.setVisibility(visibility);

        // 如果返回的数据里面actionid为空，则以获取本地配置的actionid
        if (TextUtils.isEmpty(action)) {
            action = autoInflateDataBean.getActionId();
        }
        if (clickListener != null && !TextUtils.isEmpty(action)) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onAutoInflateViewClick(autoInflateDataBean, objData, valueObj);
                }
            });
            view.setClickable(true);
        } else {
            view.setClickable(false);
        }


    }

}
