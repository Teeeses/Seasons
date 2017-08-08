package com.explead.twoseasons.ui.game_ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.explead.twoseasons.R;
import com.explead.twoseasons.app.App;
import com.explead.twoseasons.logic.controllers.Modes;
import com.explead.twoseasons.logic.controllers.WinterController;
import com.explead.twoseasons.logic.elements.Cell;
import com.explead.twoseasons.utils.Utils;
import com.explead.twoseasons.views.WinterFieldView;

/**
 * Created by Александр on 09.07.2017.
 */

public class WinterFragment extends GameFragment implements Modes.OnGameListener, WinterController.OnControllerListener{

    private WinterController controller;
    private int start_x, start_y, end_x, end_y;

    private WinterFieldView winterFieldView;
    private int level;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_winter, container, false);

        tvNumberLevel = (TextView) view.findViewById(R.id.tvNumberLevel);
        tvLevel = (TextView) view.findViewById(R.id.tvLevel);
        tvNumberLevel.setTypeface(Utils.getTypeFaceLevel(getContext().getAssets()));
        tvLevel.setTypeface(Utils.getTypeFaceLevel(getContext().getAssets()));

        btnRestart = (ImageView) view.findViewById(R.id.btnRestart);
        btnRestart.setOnClickListener(btnRestartClick);


        btnMenu = (ImageView) view.findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(btnMenuClick);

        winterFieldView = (WinterFieldView) view.findViewById(R.id.fieldView);

        level = getArguments().getInt("level");
        onRestart();

        tvNumberLevel.setText(String.format("%s", level));

        setTouchView(view);
        return view;
    }


    public void setTouchView(View view) {
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        start_x = (int) event.getX();
                        start_y = (int) event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        end_x = (int) event.getX();
                        end_y = (int) event.getY();
                        controller.logicMove(start_x, start_y, end_x, end_y);
                        break;
                    default:
                        break;
                }

                return true;
            }
        });
    }

    @Override
    public void onChangeCell(final Cell startCell, final Cell newCell, final String direction) {
        getActivity().runOnUiThread(new Runnable() {
            public void run() {
                winterFieldView.onChange(startCell, newCell, direction);
            }
        });
    }

    View.OnClickListener btnMenuClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getActivity().onBackPressed();
        }
    };

    View.OnClickListener btnRestartClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onRestart();
        }
    };


    @Override
    public void onWin() {
        Toast.makeText(getContext(), "WIN", Toast.LENGTH_SHORT).show();
    }

    public void onRestart() {
        controller = new WinterController(level);
        winterFieldView.clearField();
        winterFieldView.createField(App.getWidthScreen()*0.96f, controller.getField());
        controller.setOnControllerListener(this);
        controller.setOnGameListener(this);
    }
}
