package com.techyourchance.template.screens.main.mvcviews;

import com.techyourchance.template.screens.common.mvcviews.ObservableViewMvc;

public interface MainViewMvc extends ObservableViewMvc<MainViewMvc.Listener> {

    interface Listener {
        void onShowDialogClicked();
    }

}
