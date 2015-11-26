package shuowong.github.androidmvp.presenter;

import android.app.Activity;
import android.os.Bundle;

import shuowong.github.androidmvp.BaseApplication;
import shuowong.github.androidmvp.biz.base.AppAction;
import shuowong.github.androidmvp.view.IAppViewDelegate;

/**
 * Created by WANGSHUO on 11/11/15.
 */
public abstract class BasePresenterActivity<V extends IAppViewDelegate> extends Activity {

    protected V viewDelegate;
    protected AppAction appAction;
    protected BaseApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (BaseApplication) getApplication();
        appAction = application.getAppAction();

        try {
            viewDelegate = getViewClass().newInstance();
            viewDelegate.init(getLayoutInflater(), null, savedInstanceState);
            setContentView(viewDelegate.getRootView());

            onViewDidLoad();
            bindEventListener();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onDestroy() {
        onDestroyView();
        viewDelegate = null;
        super.onDestroy();
    }

    protected abstract Class<V> getViewClass();

    protected void onViewDidLoad() {
    }

    protected void onDestroyView() {
    }

    protected void bindEventListener() {
    }

}
