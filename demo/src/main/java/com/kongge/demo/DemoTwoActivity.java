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
import com.kongge.autoinflateview.parse.AutoInflateConfigParser;
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

public class DemoTwoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_demotwo_layout);

        View llLineContainer = findViewById(R.id.ll_lineContainer);

        String jsonDataStr = FileUtil.parseAssetsFile(this, "data/auto_demo2.json");
        Gson gson = new Gson();
        Map<String, Object> dataMap = (Map<String, Object>) gson.fromJson(jsonDataStr, Object.class);

        String jsonConfigStr = FileUtil.parseAssetsFile(this, "config/auto_demo2_config.json");
        Map<String, Object> configMap = (Map<String, Object>) gson.fromJson(jsonConfigStr, Object.class);

        AutoInflateCtrl autoInflateCtrl = new AutoInflateCtrl.Builder()
                .setRootView(llLineContainer)
                .setConfig(configMap)
                .setAutoInflateDataAdapter(new AutoInflateDataMapAdapter())
                .setAutoInflateViewParser(new AutoInflateConfigParser())
                .setOnRootViewClickListener(new OnRootViewClickListener() {
                    @Override
                    public void onRootViewClick(View rootView, Object allDataObj) {
                        if (allDataObj != null) {
                            Toast.makeText(DemoTwoActivity.this, "rootView click---->" + allDataObj.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setOnAutoInflateViewClickListener(new OnAutoInflateViewClickListener() {
                    @Override
                    public void onAutoInflateViewClick(AutoInflateDataBean autoInflateDataBean, Object allDataObj, Object dataObj) {
                        if (dataObj != null) {
                            Toast.makeText(DemoTwoActivity.this, "click---->" + autoInflateDataBean.getValueId() + dataObj.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .build();

        autoInflateCtrl.setData(dataMap);

    }
}
