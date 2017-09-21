package com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by arief on 20/09/17.
 */

public class Users {

    private String id;
    private String noHp;
    private String nama;


    public Users(){}


    public Users(String nama){
        this.nama=nama;
    }

    public Users(String id , String noHp , String nama){
        this.id=id;
        this.noHp=noHp;
        this.nama=nama;
    }

    public void setId(String id){
        this.id=id;
    }

    public void setNoHp(String noHp){
        this.noHp=noHp;
    }

    public void setNama(String nama){
        this.nama=nama;
    }


    public String getId(){
        return id;
    }
    public String getNoHp(){
        return noHp;
    }
    public String getNama(){
        return nama;
    }


    public static Map<String,Object> postForMap(Users u){
        Map<String,Object> map = new HashMap<>();

        map.put("id",u.getId());
        map.put("no_hp",u.getNoHp());
        map.put("nama",u.getNama());

        return map;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id='" + id + '\'' +
                ", noHp='" + noHp + '\'' +
                ", nama='" + nama + '\'' +
                '}';
    }
}
