package shuowong.github.androidmvp.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

import shuowong.github.androidmvp.api.APIResponse;
import shuowong.github.androidmvp.api.APIs;
import shuowong.github.androidmvp.model.RetTestModel;

/**
 * Created by WANGSHUO on 11/23/15.
 */
@Deprecated
public class APIsImpl implements APIs {

    private OkHttpClient client ;
    private String url;
    private Gson gson;


    public APIsImpl() {
        url = "http://192.168.1.132:3000";
        gson = new Gson();

        client = new OkHttpClient();
        client.setConnectTimeout(5, TimeUnit.SECONDS);
    }

    @Override
    public APIResponse<RetTestModel> getUserDesc() {
        try {
            Request req = new Request.Builder().url(url + "/db").build();
            com.squareup.okhttp.Response res = client.newCall(req).execute();

            Type type = new TypeToken<APIResponse<RetTestModel>>(){}.getType();
            return gson.fromJson(res.body().string(), type);
        } catch (Exception e) {
            return null;// new APIResponse("TIME_OUT", "error");
        }

    }
}
