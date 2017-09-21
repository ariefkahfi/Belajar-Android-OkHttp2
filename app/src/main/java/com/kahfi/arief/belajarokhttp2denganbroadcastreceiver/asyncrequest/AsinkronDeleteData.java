package com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.asyncrequest;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.prerequestokhttp.abstracts.MyUsersCrud;

import java.io.IOException;

/**
 * Created by arief on 21/09/17.
 */

public class AsinkronDeleteData extends AsyncTask<String,Integer,String> {

    private Context context;
    private MyUsersCrud crud;

    public AsinkronDeleteData(Context context){
        crud = new MyUsersCrud();
        this.context=context;
    }

    @Override
    protected String doInBackground(String... strings) {
       String response = null;

        try {
            response = crud.delete(strings[0]);
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
