package com.explead.seasons.winter.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.explead.seasons.R;
import com.explead.seasons.common.utils.Utils;

public class WinterGameBar extends RelativeLayout {

    public interface OnMenuClickListener {
        void onMenu();
        void onRestart();
        void onHelp();
    }

    private Context context;
    private OnMenuClickListener onMenuClickListener;

    private TextView tvNumberLevel;

    public WinterGameBar(Context context) {
        super(context);
        init(context);
    }

    public WinterGameBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public WinterGameBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void setOnMenuClickListener(OnMenuClickListener onMenuClickListener) {
        this.onMenuClickListener = onMenuClickListener;
    }

    private void init(Context context) {
        this.context = context;
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.winter_game_bar, null);

        inflate(getContext(), R.layout.winter_game_bar, this);
        tvNumberLevel = view.findViewById(R.id.tvNumberLevel);
        TextView tvLevel = view.findViewById(R.id.tvLevel);
        tvNumberLevel.setTypeface(Utils.getTypeFaceLevel(context.getAssets()));
        tvLevel.setTypeface(Utils.getTypeFaceLevel(context.getAssets()));

        ImageView btnRestart = view.findViewById(R.id.btnRestart);
        btnRestart.setOnClickListener(btnRestartClick);

        ImageView btnHelp = view.findViewById(R.id.btnHelp);
        btnHelp.setOnClickListener(btnHelpClick);

        ImageView btnMenu = view.findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(btnMenuClick);

        this.addView(view);
    }

    private View.OnClickListener btnMenuClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onMenuClickListener.onMenu();
        }
    };

    private View.OnClickListener btnRestartClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onMenuClickListener.onRestart();
        }
    };

    private View.OnClickListener btnHelpClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openHelpDialog();
        }
    };

    private void openHelpDialog() {
        onMenuClickListener.onHelp();
    }

    public void setNumberLevel(int level) {
        tvNumberLevel.setText(String.format("%s", level));
    }
}
