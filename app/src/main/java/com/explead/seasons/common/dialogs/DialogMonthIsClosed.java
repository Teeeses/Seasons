package com.explead.seasons.common.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.explead.seasons.R;
import com.explead.seasons.common.interfaces.OnClosedCallback;

public class DialogMonthIsClosed extends Dialog {

    private Context context;

    private OnClosedCallback onClosedCallback;

    public DialogMonthIsClosed(@NonNull Context context, OnClosedCallback onClosedCallback) {
        super(context);
        this.context = context;
        this.onClosedCallback = onClosedCallback;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_month_is_closed);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        getWindow().setAttributes(params);

        setCancelable(false);

        Drawable drawable = new ColorDrawable(Color.BLACK);
        drawable.setAlpha(100);
        getWindow().setBackgroundDrawable(drawable);

        TextView close = findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                onClosedCallback.onClosed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        dismiss();
        onClosedCallback.onClosed();
    }
}