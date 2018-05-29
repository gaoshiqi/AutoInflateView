package com.kongge.autoinflateview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.kongge.autoinflateview.R;

/**
 * author:kongge
 * date:2018/5/25
 * layout:
 * description:
 */

public class AutoInflateTextView extends TextView implements IAutoInflateView {

    private String valueId;
    private String actionId;

    public AutoInflateTextView(Context context) {
        super(context);
    }

    public AutoInflateTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AutoInflateTextView);
            valueId = a.getString(R.styleable.AutoInflateTextView_autoViewValueId);
            actionId = a.getString(R.styleable.AutoInflateTextView_autoViewActionId);
            a.recycle();
        }
    }


    @Override
    public void setValueId(String valueId) {
        this.valueId = valueId;
    }

    @Override
    public String getValueId() {
        return valueId;
    }

    @Override
    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    @Override
    public String getActionId() {
        return actionId;
    }

    @Override
    public boolean hasAutoInflateViewChild() {
        return false;
    }
}
