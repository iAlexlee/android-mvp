package shuowong.github.androidmvp.api.retrofit.impl;

import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by WANGSHUO on 12/3/15.
 */
public class RetrofitAPIsImpl {

    private static final String BASE_URL = "http://192.168.2.226:3000";
    private static OkHttpClient httpClient = new OkHttpClient();
    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        httpClient.interceptors().clear();
        httpClient.interceptors().add(new RecordRequestInterceptor());

        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }


    public static <S> S createService(Class<S> serviceClass, String username, String password) {
        if (username != null && password != null) {
//            String credentials = username + ":" + password;
            final String basic =
                    "Basic " ;//+ Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);

            httpClient.interceptors().clear();
            httpClient.interceptors().add(new AuthRequestInterceptor());
            httpClient.interceptors().add(new RecordRequestInterceptor());
        }

        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }

}
