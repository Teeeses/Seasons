package com.explead.seasons.common.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.explead.seasons.R;
import com.explead.seasons.common.app.App;
import com.explead.seasons.common.beans.AllLevels;
import com.explead.seasons.common.beans.ButtonLevel;
import com.explead.seasons.common.utils.Utils;

import java.util.ArrayList;

/**
 * Created by develop on 30.01.2017.
 */

public class GridAdapter extends BaseAdapter {

    public interface OnLevelListener {
        void onClickLevel(int level, AllLevels.Month month);
        void onLevelIsClose(int level);
    }

    private OnLevelListener onLevelListener;
    private Context context;

    private ArrayList<ButtonLevel> array = new ArrayList<>();
    private LayoutInflater lInflater;
    private ViewHolder viewHolder;

    private Drawable imageOpen;
    private Drawable imageClose;
    private Drawable star;
    private Drawable emptyStar;

    private AllLevels.Month month;

    private int sizeImage;
    private int circuleRadiusOneStar;

    public GridAdapter(Context context, ArrayList<ButtonLevel> array, AllLevels.Month month, OnLevelListener onLevelListener){
        this.context = context;
        this.onLevelListener = onLevelListener;
        this.month = month;
        this.array.clear();
        this.array.addAll(array);
        lInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        sizeImage = (int)((App.getWidthScreen() - context.getResources().getDimension(R.dimen.standard_margin)*8)/2.6f);
        circuleRadiusOneStar = (int)(sizeImage/2.6f);
        imageOpen = context.getResources().getDrawable(R.drawable.circle_winter_level);
        imageClose = context.getResources().getDrawable(R.drawable.circle_closed);
        star = context.getResources().getDrawable(R.drawable.star);
        emptyStar = context.getResources().getDrawable(R.drawable.empty_start);
    }

    public void refreshStatus() {
        ArrayList<Integer> easyArray = App.getSaverSpref().getArray(month, AllLevels.Complication.EASY);
        ArrayList<Integer> hardArray = App.getSaverSpref().getArray(month, AllLevels.Complication.HARD);
        for(int i = 0; i < array.size(); i++) {
            int numberLevel = array.get(i).getNumber();
            boolean isEasy = easyArray.contains(numberLevel);
            boolean isHard = hardArray.contains(numberLevel);
            array.get(i).installStatus(easyArray.size(), isEasy, isHard);
        }
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = lInflater.inflate(R.layout.item_level, parent, false);
            viewHolder = new ViewHolder();

            viewHolder.levelLayout = convertView.findViewById(R.id.levelLayout);
            viewHolder.ivLevel = convertView.findViewById(R.id.ivLevel);
            viewHolder.levelLayout.setLayoutParams(new ConstraintLayout.LayoutParams(sizeImage, sizeImage));
            viewHolder.ivStar1 = convertView.findViewById(R.id.ivStar_1);
            viewHolder.ivStar2 = convertView.findViewById(R.id.ivStart_2);
            viewHolder.tvLevel = convertView.findViewById(R.id.tvLevel);

            ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams)viewHolder.ivStar1.getLayoutParams();
            params.circleRadius = circuleRadiusOneStar;
            viewHolder.ivStar1.setLayoutParams(params);

            ConstraintLayout.LayoutParams params2 = (ConstraintLayout.LayoutParams)viewHolder.ivStar2.getLayoutParams();
            params2.circleRadius = circuleRadiusOneStar;
            viewHolder.ivStar2.setLayoutParams(params2);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final ButtonLevel buttonLevel = (ButtonLevel) getItem(position);
        viewHolder.tvLevel.setText(Integer.toString(buttonLevel.getNumber()));
        if(buttonLevel.getStatus() == ButtonLevel.STATUS_CURRENT) {
            setStateLevel(imageOpen, View.VISIBLE, buttonLevel.isEasyCompleted(), buttonLevel.isHardCompleted());
        }
        if(buttonLevel.getStatus() == ButtonLevel.STATUS_OPEN) {
            setStateLevel(imageOpen, View.VISIBLE, buttonLevel.isEasyCompleted(), buttonLevel.isHardCompleted());
        }
        if(buttonLevel.getStatus() == ButtonLevel.STATUS_CLOSE) {
            setStateLevel(imageClose, View.INVISIBLE, buttonLevel.isEasyCompleted(), buttonLevel.isHardCompleted());
        }

        viewHolder.levelLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(buttonLevel.getStatus() == ButtonLevel.STATUS_OPEN || buttonLevel.getStatus() == ButtonLevel.STATUS_CURRENT) {
                    onLevelListener.onClickLevel(buttonLevel.getNumber(), month);
                } else {
                    onLevelListener.onLevelIsClose(buttonLevel.getNumber());
                }
            }
        });

        return convertView;
    }

    private void setStateLevel(Drawable image, int tvVisible, boolean isEmpty, boolean isHard) {
        viewHolder.ivLevel.setBackgroundDrawable(image);
        viewHolder.tvLevel.setVisibility(tvVisible);
        if(isEmpty) {
            viewHolder.ivStar1.setVisibility(View.VISIBLE);
            viewHolder.ivStar1.setBackgroundDrawable(star);
        } else {
            viewHolder.ivStar1.setVisibility(View.INVISIBLE);
            viewHolder.ivStar1.setBackgroundDrawable(emptyStar);
        }
        if(isHard) {
            viewHolder.ivStar2.setVisibility(View.VISIBLE);
            viewHolder.ivStar2.setBackgroundDrawable(star);
        } else {
            viewHolder.ivStar2.setVisibility(View.INVISIBLE);
            viewHolder.ivStar2.setBackgroundDrawable(emptyStar);
        }
    }

    @Override
    public int getCount() {
        return array.size();
    }

    @Override
    public Object getItem(int position) {
        return array.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView tvLevel;
        ImageView ivLevel;
        ImageView ivStar1;
        ImageView ivStar2;
        ConstraintLayout levelLayout;
    }
}