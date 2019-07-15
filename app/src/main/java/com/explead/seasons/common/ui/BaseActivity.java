package com.explead.seasons.common.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.explead.seasons.common.beans.AllLevels;
import com.explead.seasons.common.firebase.Events;
import com.google.firebase.analytics.FirebaseAnalytics;


/**
 * Created by develop on 16.08.2017.
 */

public class BaseActivity extends AppCompatActivity {


    public void sendEvent(String event, Bundle params) {
        FirebaseAnalytics.getInstance(this).logEvent(event, params);
    }

    public void sendEventWinGame(int level, AllLevels.Month month, AllLevels.Complication complication) {
        Bundle bundle = new Bundle();
        bundle.putInt("level", level);
        StringBuilder event = new StringBuilder();
        event.append(Events.WIN.name());
        event.append("_");
        event.append(month.name());
        event.append("_");
        event.append(complication.name());
        FirebaseAnalytics.getInstance(this).logEvent(event.toString(), bundle);
    }

    public void sendEventStartGame(int level, AllLevels.Month month, AllLevels.Complication complication) {
        Bundle bundle = new Bundle();
        bundle.putInt("level", level);
        StringBuilder event = new StringBuilder();
        event.append(Events.START.name());
        event.append("_");
        event.append(month.name());
        event.append("_");
        event.append(complication.name());
        FirebaseAnalytics.getInstance(this).logEvent(event.toString(), bundle);
    }
}
