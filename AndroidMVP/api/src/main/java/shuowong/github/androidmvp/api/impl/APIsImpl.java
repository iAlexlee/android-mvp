package shuowong.github.androidmvp.api.impl;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import shuowong.github.androidmvp.api.APIs;
import shuowong.github.androidmvp.api.Response;

/**
 * Created by WANGSHUO on 11/23/15.
 */
public class APIsImpl implements APIs {

    private OkHttpClient client ;

    public APIsImpl() {
        client = new OkHttpClient();
    }

    @Override
    public Response<Void> getUserDesc() {
        try {
            Request req = new Request.Builder().url("http://192.168.1.55:3000/db").build();
            com.squareup.okhttp.Response res = client.newCall(req).execute();

            return new Response(String.valueOf(res.code()), res.body().string());
        } catch (Exception e) {
            return new Response("TIME_OUT", "error");
        }

    }
}
