package shuowong.github.androidmvp.api.retrofit;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import shuowong.github.androidmvp.api.APIResponse;
import shuowong.github.androidmvp.model.CommentModel;
import shuowong.github.androidmvp.model.PostsModel;
import shuowong.github.androidmvp.model.RetTestModel;

/**
 * Created by WANGSHUO on 12/3/15.
 */
public interface RetrofitAPIs {


    @GET("/posts")
    Call<List<PostsModel>> posts();

    @GET("/db")
    Call<APIResponse<RetTestModel>> getRes();

    @GET("/posts/{postId}")
    Call<PostsModel> getPosts(@Path("postId") Integer postId);

    @POST("/comments")
    Call<CommentModel> createComment(@Body CommentModel comm);

}
