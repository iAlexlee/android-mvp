package shuowong.github.androidmvp.biz.base;

import java.util.List;

/**
 * Created by WANGSHUO on 11/23/15.
 */
public interface AppCallbackListener<T> {
    void onSuccess(T data);
    void onSuccess(List<T> data);
    void onFailure(String result, String msg);
}
