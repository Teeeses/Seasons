package com.explead.seasons.common.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.explead.seasons.R;
import com.explead.seasons.common.beans.ButtonLevel;
import com.explead.seasons.common.utils.Utils;

import java.util.ArrayList;

/**
 * Created by develop on 30.01.2017.
 */

public class GridAdapter extends BaseAdapter {

    public interface OnLevelListener {
        void onClickLevel(int level);
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

    public GridAdapter(Context context, int size, OnLevelListener onLevelListener){
        this.context = context;
        this.onLevelListener = onLevelListener;
        this.array.addAll(create(size));
        lInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        imageOpen = context.getResources().getDrawable(R.drawable.circle_winter_level);
        imageClose = context.getResources().getDrawable(R.drawable.circle_closed);
        star = context.getResources().getDrawable(R.drawable.star);
        emptyStar = context.getResources().getDrawable(R.drawable.empty_start);
    }

    private ArrayList<ButtonLevel> create(int size) {
        ArrayList<ButtonLevel> array = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            array.add(new ButtonLevel(i + 1));
        }
        refreshStatus();
        return array;
    }

    public void refreshStatus() {
        //TODO: исправить на текущий открытый уровень
        //int current = ((LevelsActivity)context).getPref().getInt(Utils.WINTER_CURRENT_LEVEL, 1);
        int current = 31;
        for(int i = 0; i < array.size(); i++) {
            array.get(i).installStatus(current);
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
            viewHolder.ivStar1 = convertView.findViewById(R.id.ivStar_1);
            viewHolder.ivStar2 = convertView.findViewById(R.id.ivStart_2);
            viewHolder.tvLevel = convertView.findViewById(R.id.tvLevel);

            viewHolder.tvLevel.setTypeface(Utils.getTypeFaceLevel(context.getAssets()));
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final ButtonLevel buttonLevel = (ButtonLevel) getItem(position);
        viewHolder.tvLevel.setText(Integer.toString(buttonLevel.getNumber()));
        if(buttonLevel.getStatus() == ButtonLevel.STATUS_CURRENT) {
            viewHolder.ivLevel.setBackgroundDrawable(imageOpen);
            viewHolder.tvLevel.setVisibility(View.VISIBLE);
            viewHolder.ivStar1.setVisibility(View.INVISIBLE);
            viewHolder.ivStar2.setVisibility(View.INVISIBLE);
            viewHolder.ivStar1.setBackgroundDrawable(emptyStar);
        }
        if(buttonLevel.getStatus() == ButtonLevel.STATUS_OPEN) {
            viewHolder.ivLevel.setBackgroundDrawable(imageOpen);
            viewHolder.tvLevel.setVisibility(View.VISIBLE);
            viewHolder.ivStar1.setVisibility(View.VISIBLE);
            viewHolder.ivStar2.setVisibility(View.VISIBLE);
            viewHolder.ivStar1.setBackgroundDrawable(star);
        }
        if(buttonLevel.getStatus() == ButtonLevel.STATUS_CLOSE) {
            viewHolder.ivLevel.setBackgroundDrawable(imageClose);
            viewHolder.tvLevel.setVisibility(View.GONE);
            viewHolder.ivStar1.setVisibility(View.INVISIBLE);
            viewHolder.ivStar2.setVisibility(View.INVISIBLE);
            viewHolder.ivStar1.setBackgroundDrawable(emptyStar);
        }

        viewHolder.levelLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(buttonLevel.getStatus() == ButtonLevel.STATUS_OPEN || buttonLevel.getStatus() == ButtonLevel.STATUS_CURRENT) {
                    onLevelListener.onClickLevel(buttonLevel.getNumber());
                } else {
                    onLevelListener.onLevelIsClose(buttonLevel.getNumber());
                }
            }
        });

        return convertView;
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