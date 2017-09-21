package com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.prerequestokhttp.abstracts;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.constants.ApiUrl;
import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.model.Users;
import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.prerequestokhttp.base.BaseCrud;
import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.prerequestokhttp.base.HttpMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Response;

/**
 * Created by arief on 20/09/17.
 */

public class MyUsersCrud extends AbstractReqAndRes implements BaseCrud<Users,String> {




    @Override
    public String save(Users users) throws IOException {

        Map<String,Object> param = Users.postForMap(users);

        initComponentsForFormEncodedType(ApiUrl.BASE_URL_API+"insert.php",HttpMethod.POST,param);

        makeRequestFormBody();
        makeRequest();
        String responseBody = makeResponse().body().string();

        return responseBody;

    }

    @Override
    public List<Users> getAll() throws IOException {

        List<Users> data = new ArrayList<>();

        setHttpMethod(HttpMethod.GET);
        setUrl(ApiUrl.BASE_URL_API+"select.php");
        makeRequest();
        Response response = makeResponse();


        String json = response.body().string();

        JsonElement element = new JsonParser().parse(json);
        JsonArray jsonArray = element.getAsJsonArray();

        for(JsonElement el : jsonArray){
            String id = el.getAsJsonObject().get("id").getAsString();
            String noHp = el.getAsJsonObject().get("no_hp").getAsString();
            String nama = el.getAsJsonObject().get("nama").getAsString();

            data.add(new Users(id,noHp,nama));
        }

        return data;
    }

    @Override
    public String delete(String s) throws IOException {
       Map<String,String> map = new HashMap<>();

       map.put("no_hp",s);

       initHttpUrlBuilderComponents("http","192.168.1.100",map,"/android-ok2/delete.php");

       String responseBody = makeResponseForHttpUrlBuilderInstance().body().string();


       return responseBody;
    }
}
