package com.bvhloc.general.base;

public interface BaseAction {

    /**
     * Set contentView for Activity/Fragment
     *
     * @return - view
     */
    int getViewId();

    /**
     * Init view
     */
    void initView();

    /**
     * Init value
     */
    void initValue();

    /**
     * Init action
     */
    void initAction();
}
