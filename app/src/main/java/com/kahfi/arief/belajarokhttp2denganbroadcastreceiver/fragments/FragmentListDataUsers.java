package com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.R;
import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.asyncrequest.AsinkronLoadData;
import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.notifier.NotifierNewData;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by arief on 20/09/17.
 */

public class FragmentListDataUsers extends Fragment {


    @BindView(R.id.listView)ListView list;

    NotifierNewData newData ;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        newData = new NotifierNewData();

        new AsinkronLoadData(getActivity(),list).execute();
        setUpForReceiver();
    }


    private void setUpForReceiver(){
        IntentFilter iFilter = new IntentFilter("com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.notifier.NotifierNewData");
        getActivity().registerReceiver(newData,iFilter);
        Log.e("broadCastReceiver","registered");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(newData);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list,container,false);

        ButterKnife.bind(this,v);

        return v;
    }



}
