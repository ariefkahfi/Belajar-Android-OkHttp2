package com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.prerequestokhttp.abstracts;

import android.util.Log;

import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.prerequestokhttp.base.BaseRequestAndResponse;
import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.prerequestokhttp.base.HttpMethod;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by arief on 20/09/17.
 */

public abstract class AbstractReqAndRes implements BaseRequestAndResponse {


    private final Logger log = Logger.getLogger(this.getClass().getName());

    private MediaType mediaType;
    private String json;
    private String url;
    private HttpMethod method;
    private Map<String,Object> map;


    private HttpUrl httpUrlInjected;

    public AbstractReqAndRes(){}




    private static OkHttpClient createOkHttpInstance(){
        return new OkHttpClient();
    }

    private static HttpUrl createInstanceForHttpUrlBuilder(String scheme,String host ,String pathSegments, Map<String,String> queryParam){
        HttpUrl.Builder b = new HttpUrl.Builder();

        b.scheme(scheme)
                .host(host)
                .addPathSegments(pathSegments);

        for(Map.Entry sets  : queryParam.entrySet()){
            b.addQueryParameter((String) sets.getKey(),(String) sets.getValue());
        }

        return b.build();
    }

    @Override
    public void setMediaType(MediaType mediaType) {
        this.mediaType=mediaType;
    }

    @Override
    public void setUrl(String url) {
        this.url=url;
    }


    @Override
    public void setJson(String json) {
        this.json=json;
    }

    @Override
    public void setHttpMethod(HttpMethod method) {
        this.method = method;
    }

    @Override
    public void initComponentsForJsonType(MediaType mediaType, String url, String json, HttpMethod method) {
        this.mediaType=mediaType;
        this.url=url;
        this.json=json;
        this.method=method;
    }

    @Override
    public void initComponentsForFormEncodedType(String url, HttpMethod method, Map<String, Object> paramForPOST) {
        this.url=url;
        this.method=method;
        this.map=paramForPOST;
    }

    @Override
    public void initHttpUrlBuilderComponents(String scheme,
                                             String host,
                                             Map<String, String> queryParameter,
                                             String pathSeg) {
        httpUrlInjected = createInstanceForHttpUrlBuilder(scheme,host,pathSeg,queryParameter);

        Log.e("HttpUrl", String.valueOf(HttpUrl.parse(httpUrlInjected.toString())));
    }


    protected Request doRequestWithHttpUrlBuilderInstance() throws IOException {
       Request request = new Request.Builder()
               .url(httpUrlInjected)
               .get()
               .build();
       return request;
    }



    @Override
    public Request makeRequest() {
        Request request = null;


        switch (method){
            case POST:
                request = new Request.Builder()
                        .url(url)
                        .post(makeRequestFormBody())
                        .build();
                break;
            case GET:
                request = new Request.Builder()
                        .url(url)
                        .get()
                        .build();
                break;
        }

        return  request;
    }

    @Override
    public Response makeResponseForHttpUrlBuilderInstance() throws IOException {
        return createOkHttpInstance().
                newCall(doRequestWithHttpUrlBuilderInstance())
                .execute();
    }

    @Override
    public RequestBody makeRequestFormBody() {

        FormBody.Builder form = new FormBody.Builder();

        for(Map.Entry entry : map.entrySet()){
            form.add((String) entry.getKey(),(String) entry.getValue());
        }

        return form.build();
    }





    @Override
    public Response makeResponse() throws IOException {
        return createOkHttpInstance().newCall(makeRequest())
                .execute();
    }




}
