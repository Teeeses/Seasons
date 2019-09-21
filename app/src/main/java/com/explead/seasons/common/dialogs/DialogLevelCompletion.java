package com.explead.seasons.common.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.explead.seasons.R;
import com.explead.seasons.common.interfaces.OnDialogCompletionListener;

/**
 * Created by develop on 12.09.2017.
 */

public class DialogLevelCompletion extends Dialog {

    private OnDialogCompletionListener mOnDialogCompletionListener;

    private Context context;

    public DialogLevelCompletion(@NonNull Context context, OnDialogCompletionListener mOnDialogCompletionListener) {
        super(context);
        this.context = context;
        this.mOnDialogCompletionListener = mOnDialogCompletionListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_level_completion);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        getWindow().setAttributes(params);

        Button btnMenu = (Button) findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnDialogCompletionListener.onMenu();
                dismiss();
            }
        });

        Button btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnDialogCompletionListener.onNextLevel();
                dismiss();
            }
        });
    }
}