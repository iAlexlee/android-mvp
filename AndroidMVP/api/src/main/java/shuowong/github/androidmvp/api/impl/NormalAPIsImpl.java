package shuowong.github.androidmvp.api.impl;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import shuowong.github.androidmvp.api.APIs;
import shuowong.github.androidmvp.api.NormalResponse;

/**
 * Created by WANGSHUO on 11/23/15.
 */
public class NormalAPIsImpl implements APIs {

    private OkHttpClient client ;

    public NormalAPIsImpl() {
        client = new OkHttpClient();
    }

    @Override
    public NormalResponse<Void> getUserDesc() {
        try {
            Request req = new Request.Builder().url("http://192.168.1.55:3000/db").build();
            Response res = client.newCall(req).execute();

            return new NormalResponse(String.valueOf(res.code()), res.body().string());
        } catch (Exception e) {
            return new NormalResponse("TIME_OUT", "error");
        }

    }
}
