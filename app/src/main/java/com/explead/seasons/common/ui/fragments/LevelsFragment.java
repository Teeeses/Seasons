package com.explead.seasons.common.ui.fragments;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.explead.seasons.R;
import com.explead.seasons.common.adapters.GridAdapter;
import com.explead.seasons.common.beans.AllLevels;
import com.explead.seasons.common.beans.ButtonLevel;
import com.explead.seasons.common.ui.CustomGridView;
import com.explead.seasons.common.ui.LevelsActivity;
import com.explead.seasons.common.utils.Utils;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import static com.explead.seasons.common.beans.AllLevels.Month.DECEMBER;
import static com.explead.seasons.common.beans.AllLevels.Month.JANUARY;

/**
 * Created by develop on 15.12.2016.
 */
public class LevelsFragment extends Fragment implements GridAdapter.OnLevelListener {

    protected View view;

    protected LevelsActivity activity;
    protected CustomGridView gvDecember;
    protected CustomGridView gvJanuary;
    protected GridAdapter decemberAdapter;
    protected GridAdapter januaryAdapter;

    private Snackbar sbLevelClosed;

    public void createButtons() {
        decemberAdapter = createGrid(DECEMBER);
        gvDecember.setAdapter(decemberAdapter);
        gvDecember.setNumColumns(3);

        januaryAdapter = createGrid(JANUARY);
        gvJanuary.setAdapter(januaryAdapter);
        gvJanuary.setNumColumns(3);

        createSB();
    }

    private void createSB() {
        view.post(() -> {
            sbLevelClosed = Snackbar.make(view, activity.getResources().getString(R.string.level_is_close), Snackbar.LENGTH_SHORT);
            View view = sbLevelClosed.getView();
            TextView tv = view.findViewById(R.id.snackbar_text);
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tv.setGravity(Gravity.CENTER_HORIZONTAL);
            tv.setTypeface(Utils.getTypeFaceLevel(getContext().getAssets()));
        });
    }

    private GridAdapter createGrid(final AllLevels.Month month) {
        return new GridAdapter(activity, create(month), month, this);
    }

    @Override
    public void onClickLevel(int level, AllLevels.Month month) {
        activity.openGameActivity(level, month);
    }

    @Override
    public void onLevelIsClose(int number) {
        if(!sbLevelClosed.isShown()) {
            sbLevelClosed.show();
        }
    }

    private ArrayList<ButtonLevel> create(AllLevels.Month month) {
        ArrayList<ButtonLevel> array = new ArrayList<>();
        for(int i = 0; i < month.getDeis(); i++) {
            array.add(new ButtonLevel(i + 1));
        }
        return array;
    }

    @Override
    public void onResume() {
        if(decemberAdapter != null)
            decemberAdapter.refreshStatus();
        if(januaryAdapter != null)
            januaryAdapter.refreshStatus();
        super.onResume();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (LevelsActivity)context;
    }
}
