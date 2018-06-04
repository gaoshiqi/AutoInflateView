package com.kongge.demo;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.kongge.autoinflateview.bean.AutoInflateDataBean;
import com.kongge.autoinflateview.bean.AutoInflateProtocolBean;
import com.kongge.autoinflateview.parse.AutoInflateAttrsParser;
import com.kongge.autoinflateview.service.AutoInflateCtrl;
import com.kongge.autoinflateview.service.AutoInflateDataMapAdapter;
import com.kongge.autoinflateview.service.IAutoInflateDataAdapter;
import com.kongge.autoinflateview.service.OnAutoInflateViewClickListener;
import com.kongge.autoinflateview.service.OnRootViewClickListener;

import java.util.Map;

/**
 * author:kongge
 * date:2018/5/25
 * layout:
 * description:
 */

public class DemoOneActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_demoone_layout);

        View llLineContainer = findViewById(R.id.ll_lineContainer);

        String jsonStr = FileUtil.parseAssetsFile(this, "data/auto_demo1.json");
        Gson gson = new Gson();
        Map<String, Object> dataMap = (Map<String, Object>) gson.fromJson(jsonStr, Object.class);

        // 测试自定义解析
        IAutoInflateDataAdapter autoInflateDataAdapter = new IAutoInflateDataAdapter() {
            @Override
            public void setRootViewData(View rootView, Object objData, Object objConfig, OnRootViewClickListener clickListener, AutoInflateProtocolBean autoInflateProtocolBean) {

            }

            @Override
            public void setAutoInfalteViewData(AutoInflateDataBean bean, Object objData, OnAutoInflateViewClickListener clickListener, AutoInflateProtocolBean autoInflateProtocolBean) {
                if (bean == null || objData == null || !(objData instanceof Map)) {
                    return;
                }
                String valueId = bean.getValueId();
                if (TextUtils.isEmpty(valueId)) {
                    return;
                }
                Map<String, Object> dataMap = (Map) objData;
                final Object valueObj = dataMap.get(valueId);
                if (valueObj == null) {
                    return;
                }

                String value = null;

                if (valueObj instanceof String) {
                    value = valueObj.toString();
                } else if (valueObj instanceof Map) {
                    Map<String, Object> valueMap = (Map) valueObj;
                    value = (String) valueMap.get("value");
                }
                View view = bean.getContentView();
                if (value != null) {
                    if (view instanceof TextView) {
                        TextView textView = (TextView) view;
                        textView.setText(value);
                    } else if (view instanceof ImageView) {
                        ImageView imageView = (ImageView) view;
                        Glide.with(imageView.getContext()).load(value).into(imageView);
                    }
                }
            }
        };


        AutoInflateCtrl autoInflateCtrl = new AutoInflateCtrl.Builder()
                .setRootView(llLineContainer)
                .setConfig(null)
                .setAutoInflateDataAdapter(new AutoInflateDataMapAdapter()/*autoInflateDataAdapter*/)
                .setAutoInflateViewParser(new AutoInflateAttrsParser())
                .setOnRootViewClickListener(new OnRootViewClickListener() {
                    @Override
                    public void onRootViewClick(View rootView, Object allDataObj) {
                        if (allDataObj != null) {
                            Toast.makeText(DemoOneActivity.this, "rootView click---->" + allDataObj.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setOnAutoInflateViewClickListener(new OnAutoInflateViewClickListener() {
                    @Override
                    public void onAutoInflateViewClick(AutoInflateDataBean autoInflateDataBean, Object allDataObj, Object dataObj) {
                        if (dataObj != null) {
                            Toast.makeText(DemoOneActivity.this, "click---->" + autoInflateDataBean.getValueId() + dataObj.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .build();

        autoInflateCtrl.setData(dataMap);

    }
}
