package com.techyourchance.template.dialogs.prompt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.techyourchance.template.R;
import com.techyourchance.template.screens.common.mvcviews.BaseViewMvc;

public class PromptViewMvcImpl extends BaseViewMvc<PromptViewMvc.PromptViewMvcListener>
        implements PromptViewMvc {

    private final TextView mTxtTitle;
    private final TextView mTxtMessage;
    private final Button mBtnPositive;
    private final Button mBtnNegative;

    public PromptViewMvcImpl(LayoutInflater inflater, ViewGroup container) {
        setRootView(inflater.inflate(R.layout.layout_info_prompt, container, false));

        mTxtTitle = findViewById(R.id.txt_title);
        mTxtMessage = findViewById(R.id.txt_message);
        mBtnPositive = findViewById(R.id.btn_positive);
        mBtnNegative = findViewById(R.id.btn_negative);

        mBtnPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (PromptViewMvcListener listener : getListeners()) {
                    listener.onPositiveButtonClicked();
                }
            }
        });

        mBtnNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (PromptViewMvcListener listener : getListeners()) {
                    listener.onNegativeButtonClicked();
                }
            }
        });
    }

    @Override
    public void setTitle(String title) {
        mTxtTitle.setText(title);
    }

    @Override
    public void setMessage(String message) {
        mTxtMessage.setText(message);
    }

    @Override
    public void setPositiveButtonCaption(String positiveButtonCaption) {
        mBtnPositive.setText(positiveButtonCaption);
    }

    @Override
    public void setNegativeButtonCaption(String negativeButtonCaption) {
        mBtnNegative.setText(negativeButtonCaption);
    }
}
