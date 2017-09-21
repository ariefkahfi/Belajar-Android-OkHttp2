package com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.services;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by arief on 21/09/17.
 */

public class MyService extends IntentService {


    public MyService(){
        super("MyService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Intent receiver = new Intent("com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.notifier.NotifierNewData");

        Bundle bundle = new Bundle();
        bundle.putBoolean("updated",true);
        receiver.putExtras(bundle);

        sendBroadcast(receiver);
    }

}
