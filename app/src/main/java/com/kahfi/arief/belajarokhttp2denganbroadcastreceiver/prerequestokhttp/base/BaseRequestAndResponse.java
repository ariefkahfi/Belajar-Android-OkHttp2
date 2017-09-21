package com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.prerequestokhttp.base;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by arief on 20/09/17.
 */

public interface BaseRequestAndResponse {
    void setMediaType(MediaType mediaType);
    void setUrl(String url);
    void setJson(String json);
    void setHttpMethod(HttpMethod method);
    void initComponentsForJsonType(MediaType mediaType, String url , String json, HttpMethod method );
    void initComponentsForFormEncodedType(String url , HttpMethod method,Map<String,Object> paramForPOST);
    void initHttpUrlBuilderComponents(String scheme, String host, Map<String, String> queryParameter, String pathSeg);
    Request makeRequest();
    Response makeResponseForHttpUrlBuilderInstance() throws IOException;
    RequestBody makeRequestFormBody();
    Response makeResponse() throws IOException;

}
