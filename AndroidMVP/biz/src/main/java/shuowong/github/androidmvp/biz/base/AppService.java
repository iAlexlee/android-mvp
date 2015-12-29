package shuowong.github.androidmvp.biz.base;

import retrofit.Callback;
import shuowong.github.androidmvp.model.PostsModel;
import shuowong.github.androidmvp.model.RetTestModel;

/**
 * Created by WANGSHUO on 11/23/15.
 */
public interface AppService {

    void getPost(int id, Callback<PostsModel> listener);
}
