package com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.R;
import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.asyncrequest.AsinkronDeleteData;
import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.services.MyService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by arief on 20/09/17.
 */

public class FragmentDeleteDataUsers extends Fragment {


    @BindView(R.id.deleteData)Button deleteData;
    @BindView(R.id.deleteNoHp)EditText deleteNoHp;



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_delete,container,false);

        ButterKnife.bind(this,v);

        return v;
    }

    private void startServiceForDeleteData(){
        Intent inten = new Intent(getActivity(), MyService.class);
        getActivity().startService(inten);
    }

    @OnClick(R.id.deleteData)
    public void deleteButton(View v){
        try{
           if(deleteNoHp.getText().toString().trim().equals("")){
               Toast.makeText(getActivity(), "Masih ada field yang kosong", Toast.LENGTH_SHORT).show();
           }else{
               new AsinkronDeleteData(getActivity()).execute(deleteNoHp.getText().toString().trim());
               startServiceForDeleteData();
           }
        }catch (Exception ex){
            Log.e("Error",ex.getMessage());
        }
    }
}
