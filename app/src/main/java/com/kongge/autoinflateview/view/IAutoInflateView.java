package com.kongge.autoinflateview.view;

/**
 * author:kongge
 * date:2018/5/25
 * layout:
 * description: 自动填充布局的接口
 */

public interface IAutoInflateView {

    /**
     * 设置valueid
     * @param valueId
     */
    void setValueId(String valueId);

    /**
     * 获取valueid
     * @return
     */
    String getValueId();

    /**
     * 设置动作id
     * @param actionId
     */
    void setActionId(String actionId);

    /**
     * 获取动作id
     * @return
     */
    String getActionId();

    /**
     * 子控件是否有AutoInflateView
     * @return
     */
    boolean hasAutoInflateViewChild();

}
