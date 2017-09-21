package com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.notifier;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.ListView;

import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.R;
import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.asyncrequest.AsinkronLoadData;

/**
 * Created by arief on 20/09/17.
 */

public class NotifierNewData extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean inserted = intent.getExtras().getBoolean("updated");
        Log.e("OnReceive",String.valueOf(inserted));

        ListView list =(ListView)((Activity)context).findViewById(R.id.listView);
        setUpForRefreshDataIntoListView(list,context);
    }


    private void setUpForRefreshDataIntoListView(ListView list,Context context){
       new AsinkronLoadData(context,list).execute();
    }

}
