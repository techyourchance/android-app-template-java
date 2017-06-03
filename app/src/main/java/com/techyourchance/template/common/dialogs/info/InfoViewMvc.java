package com.techyourchance.template.common.dialogs.info;

import com.techyourchance.template.screens.common.mvcviews.ObservableViewMvc;

public interface InfoViewMvc extends ObservableViewMvc<InfoViewMvc.InfoViewMvcListener> {

    public interface InfoViewMvcListener {
        void onDismissClicked();
    }

    void setTitle(String title);
    void setMessage(String message);
    void setDismissCaption(String dismissCaption);

}
