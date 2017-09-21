package com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.asyncrequest;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.model.Users;
import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.prerequestokhttp.abstracts.MyUsersCrud;

import java.io.IOException;

/**
 * Created by arief on 21/09/17.
 */

public class AsinkronInsert extends AsyncTask<String,Integer,String> {


    private MyUsersCrud crud ;
    private Users users;
    private Context context;

    public AsinkronInsert(Users users,Context context){
        crud = new MyUsersCrud();
        this.users=users;
        this.context=context;
    }

    @Override
    protected String doInBackground(String... strings) {
        String response = null;

        try {
           response =  crud.save(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }
}
