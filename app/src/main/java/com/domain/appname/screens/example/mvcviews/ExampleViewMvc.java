package com.domain.appname.screens.example.mvcviews;

import com.domain.appname.screens.common.mvcviews.ObservableViewMvc;

public interface ExampleViewMvc extends ObservableViewMvc<ExampleViewMvc.ExampleViewMvcListener> {

    interface ExampleViewMvcListener {
        void onShowDialogClicked();
    }

}
