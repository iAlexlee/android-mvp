package shuowong.github.androidmvp.biz.base;

/**
 * Created by WANGSHUO on 11/23/15.
 */
public interface AppCallbackListener<T> {
    void onSuccess(T data);
    void onFailure(String result, String msg);
}
