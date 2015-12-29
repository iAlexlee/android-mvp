package shuowong.github.androidmvp.api.retrofit.impl;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by WANGSHUO on 12/4/15.
 */
public class AuthRequestInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder requestBuilder = original.newBuilder()
                .header("Authorization", "")
                .header("Accept", "applicaton/json")
                .method(original.method(), original.body());

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
