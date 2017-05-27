package com.techyourchance.template.screens.example.mvcviews;

import com.techyourchance.template.screens.common.mvcviews.ObservableViewMvc;

public interface ExampleViewMvc extends ObservableViewMvc<ExampleViewMvc.ExampleViewMvcListener> {

    interface ExampleViewMvcListener {
        void onShowDialogClicked();
    }

}
