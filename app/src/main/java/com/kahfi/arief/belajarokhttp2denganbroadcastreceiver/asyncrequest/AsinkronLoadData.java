package com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.asyncrequest;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.R;
import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.adapters.UserAdapter;
import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.model.Users;
import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.prerequestokhttp.abstracts.MyUsersCrud;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arief on 21/09/17.
 */

public class AsinkronLoadData extends AsyncTask<String,Integer,List<Users>> {


    private ListView listView;
    private MyUsersCrud crud;
    private Context context;

    public AsinkronLoadData(Context context , ListView listView){
        crud = new MyUsersCrud();
        this.listView=listView;
        this.context=context;
    }

    @Override
    protected List<Users> doInBackground(String... strings) {
        List<Users> data  = new ArrayList<>();

        try {
            data = crud.getAll();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    @Override
    protected void onPostExecute(List<Users> userses) {
        listView.setAdapter(new UserAdapter(context, R.layout.list_ui,userses));

        Log.e("asnycLoadData","finishedSetAdapterForListView");
    }
}
