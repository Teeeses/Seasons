package com.explead.seasons.common.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.explead.seasons.R;
import com.explead.seasons.common.app.App;
import com.explead.seasons.common.beans.ButtonLevel;
import com.explead.seasons.common.beans.Level;
import com.explead.seasons.common.utils.Utils;

import java.util.ArrayList;

/**
 * Created by develop on 30.01.2017.
 */

public class GridAdapter extends BaseAdapter {

    public interface OnLevelListener {
        void onClickLevel(int mode, int level);
        void onLevelIsClose(int level);
    }

    private OnLevelListener onLevelListener;
    private Context context;

    ArrayList<ButtonLevel> array =  new ArrayList<>();
    private LayoutInflater lInflater;
    private ViewHolder viewHolder;

    private int widthCell;

    private Drawable imageOpen;
    private Drawable imageClose;
    private Drawable star;
    private Drawable emptyStar;


    public GridAdapter(Context context, ArrayList<ButtonLevel> array, int mode, OnLevelListener onLevelListener){
        this.context = context;
        this.onLevelListener = onLevelListener;
        this.array.clear();
        this.array.addAll(array);
        lInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        widthCell = (int)(App.getWidthScreen() - context.getResources().getDimension(R.dimen.standard_margin)*8)/3;

        if(mode == Level.SUMMER) {
            imageOpen = context.getResources().getDrawable(R.drawable.circle_summer_level);
        }
        if(mode == Level.WINTER) {
            imageOpen = context.getResources().getDrawable(R.drawable.circle_winter_level);
        }
        imageClose = context.getResources().getDrawable(R.drawable.circle_closed);
        star = context.getResources().getDrawable(R.drawable.start);
        emptyStar = context.getResources().getDrawable(R.drawable.empty_start);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = lInflater.inflate(R.layout.item_level, parent, false);
            viewHolder = new ViewHolder();

            viewHolder.levelLayout = (RelativeLayout) convertView.findViewById(R.id.levelLayout);
            viewHolder.starsLayout = (LinearLayout) convertView.findViewById(R.id.starsLayout);
            viewHolder.levelLayout.setLayoutParams(new RelativeLayout.LayoutParams(widthCell, widthCell));
            viewHolder.ivLevel = (ImageView) convertView.findViewById(R.id.ivLevel);
            viewHolder.ivStar1 = (ImageView) convertView.findViewById(R.id.ivStar_1);
            viewHolder.ivStar2 = (ImageView) convertView.findViewById(R.id.ivStart_2);
            viewHolder.tvLevel = (TextView) convertView.findViewById(R.id.tvLevel);

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
            viewHolder.starsLayout.setVisibility(View.VISIBLE);
            viewHolder.ivStar1.setBackgroundDrawable(emptyStar);
        }
        if(buttonLevel.getStatus() == ButtonLevel.STATUS_OPEN) {
            viewHolder.ivLevel.setBackgroundDrawable(imageOpen);
            viewHolder.tvLevel.setVisibility(View.VISIBLE);
            viewHolder.starsLayout.setVisibility(View.VISIBLE);
            viewHolder.ivStar1.setBackgroundDrawable(star);
        }
        if(buttonLevel.getStatus() == ButtonLevel.STATUS_CLOSE) {
            viewHolder.ivLevel.setBackgroundDrawable(imageClose);
            viewHolder.tvLevel.setVisibility(View.GONE);
            viewHolder.starsLayout.setVisibility(View.INVISIBLE);
            viewHolder.ivStar1.setBackgroundDrawable(emptyStar);
        }


        viewHolder.levelLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(buttonLevel.getStatus() == ButtonLevel.STATUS_OPEN || buttonLevel.getStatus() == ButtonLevel.STATUS_CURRENT) {
                    onLevelListener.onClickLevel(buttonLevel.getMode(), buttonLevel.getNumber());
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
        RelativeLayout levelLayout;
        LinearLayout starsLayout;
    }
}