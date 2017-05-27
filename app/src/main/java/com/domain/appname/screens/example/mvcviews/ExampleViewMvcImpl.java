package com.domain.appname.screens.example.mvcviews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.domain.appname.R;
import com.domain.appname.screens.common.mvcviews.BaseViewMvc;

public class ExampleViewMvcImpl extends BaseViewMvc<ExampleViewMvc.ExampleViewMvcListener>
        implements ExampleViewMvc {

    private final Button mBtnShowDialog;

    public ExampleViewMvcImpl(LayoutInflater inflater, ViewGroup container) {
        setRootView(inflater.inflate(R.layout.layout_example, container, false));

        mBtnShowDialog = findViewById(R.id.btn_show_dialog);

        mBtnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (ExampleViewMvcListener listener : getListeners()) {
                    listener.onShowDialogClicked();
                }
            }
        });

    }

}
