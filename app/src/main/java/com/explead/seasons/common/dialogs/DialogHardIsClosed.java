package com.explead.seasons.common.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;
import android.view.WindowManager;

import com.explead.seasons.R;

public class DialogHardIsClosed extends Dialog {

    private Context context;

    public DialogHardIsClosed(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_hard_is_closed);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        getWindow().setAttributes(params);


        Drawable drawable = new ColorDrawable(Color.BLACK);
        drawable.setAlpha(100);
        getWindow().setBackgroundDrawable(drawable);
    }
}
