package com.techyourchance.template.screens.home;

import com.techyourchance.template.screens.common.mvcviews.ObservableViewMvc;

public interface HomeViewMvc extends ObservableViewMvc<HomeViewMvc.Listener> {

    interface Listener {
        void onRequestPermissionsClicked();
    }

    void enableRequestPermissionsButton();
    void disableRequestPermissionsButton();

}
