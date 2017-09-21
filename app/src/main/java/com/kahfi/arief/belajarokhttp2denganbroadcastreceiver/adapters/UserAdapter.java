package com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.R;
import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.model.Users;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by arief on 20/09/17.
 */

public class UserAdapter extends ArrayAdapter<Users> {


    private List<Users> data;


    public UserAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Users> objects) {
        super(context, resource, objects);
        this.data = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_ui,parent,false);


        Users u = data.get(position);

        ViewHolder holder = new ViewHolder(convertView);

        holder.viewNoHp.setText(u.getNoHp());
        holder.viewNama.setText(u.getNama());


        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.viewNoHp)TextView viewNoHp;
        @BindView(R.id.viewNama)TextView viewNama;

        ViewHolder(View v){
            ButterKnife.bind(this,v);
        }
    }
}
