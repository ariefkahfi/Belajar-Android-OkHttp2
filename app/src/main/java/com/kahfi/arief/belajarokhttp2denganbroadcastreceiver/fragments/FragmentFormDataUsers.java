package com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.fragments;

import android.app.Activity;
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
import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.asyncrequest.AsinkronInsert;
import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.model.Users;
import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.prerequestokhttp.abstracts.MyUsersCrud;
import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.services.MyService;

import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by arief on 20/09/17.
 */

public class FragmentFormDataUsers extends Fragment {


    @BindView(R.id.idUsers)EditText idUsers;
    @BindView(R.id.noHpUsers)EditText noHpUsers;
    @BindView(R.id.namaUsers)EditText namaUsers;

    @BindView(R.id.insertData)Button insertData;

    private MyUsersCrud crud;




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        crud = new MyUsersCrud();
        setUpUUID();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_form,container,false);

        ButterKnife.bind(this,v);

        return v;
    }


    private void setUpUUID(){

        UUID uuid = UUID.randomUUID();

        idUsers.setText(uuid.toString());
        idUsers.setEnabled(false);
    }


    private void startServiceForInsert(){
        Intent inten = new Intent(getActivity(), MyService.class);
        getActivity().startService(inten);
    }

    private void refreshFields(){
        setUpUUID();
        namaUsers.setText("");
        noHpUsers.setText("");
        Toast.makeText(getActivity(), "UUID refreshed", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.insertData)
    public void insertData(View v){

        try{

            String idUser = idUsers.getText().toString().trim();
            String noHp = String.valueOf(noHpUsers.getText().toString().trim());
            String namaUser = namaUsers.getText().toString().trim();



            if(idUser.equals("")
                    || noHp.equals("")
                    || namaUser.equals("")){
                Toast.makeText(getActivity(), "Masih ada form yang kosong", Toast.LENGTH_SHORT).show();
            }else{
              Users u = new Users(idUser,noHp,namaUser);

              new AsinkronInsert(u,getActivity()).execute();


              startServiceForInsert();

              refreshFields();

            }
        }catch (Exception ex){
            ex.printStackTrace();
            Log.e("Error",ex.getMessage());
        }
    }

}
