package com.techyourchance.template.screens.example.mvcviews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.techyourchance.template.R;
import com.techyourchance.template.screens.common.mvcviews.BaseObservableViewMvc;

public class ExampleViewMvcImpl extends BaseObservableViewMvc<ExampleViewMvc.Listener>
        implements ExampleViewMvc {

    private final Button mBtnShowDialog;

    public ExampleViewMvcImpl(LayoutInflater inflater, ViewGroup container) {
        setRootView(inflater.inflate(R.layout.layout_example, container, false));

        mBtnShowDialog = findViewById(R.id.btn_show_dialog);

        mBtnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Listener listener : getListeners()) {
                    listener.onShowDialogClicked();
                }
            }
        });

    }

}
