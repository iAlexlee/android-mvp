package shuowong.github.androidmvp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by WANGSHUO on 11/23/15.
 */
public interface IAppViewDelegate {

    void init(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
    View getRootView();
}
