package shuowong.github.androidmvp.biz.base;

import android.content.Context;

import retrofit.Call;
import retrofit.Callback;
import shuowong.github.androidmvp.api.retrofit.impl.RetrofitAPIsImpl;
import shuowong.github.androidmvp.api.retrofit.RetrofitAPIs;
import shuowong.github.androidmvp.model.PostsModel;

/**
 * Created by WANGSHUO on 11/23/15.
 */
public class AppServiceImpl implements AppService {

    private Context context;
    private RetrofitAPIs api;

    public AppServiceImpl(Context context) {
        this.context = context;
        this.api = RetrofitAPIsImpl.createService(RetrofitAPIs.class);
    }

    @Override
    public void getPost(int id, Callback<PostsModel> listener) {
        Call<PostsModel> call = api.getPosts(1);
        call.enqueue(listener);
    }
}
