package shuowong.github.androidmvp.presenter;

import android.app.Activity;
import android.os.Bundle;

import shuowong.github.androidmvp.BaseApplication;
import shuowong.github.androidmvp.biz.base.AppService;
import shuowong.github.androidmvp.biz.base.AppServiceImpl;
import shuowong.github.androidmvp.model.IModel;
import shuowong.github.androidmvp.view.IAppViewDataBinder;
import shuowong.github.androidmvp.view.IAppViewDelegate;

/**
 * Created by WANGSHUO on 11/11/15.
 */
public abstract class BasePresenterActivity<V extends IAppViewDelegate> extends Activity {

    protected V viewDelegate;
    protected IAppViewDataBinder viewDataBinder;
    protected BaseApplication application;
    protected AppService appAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewDataBinder = getDataBinder();
        application = (BaseApplication) getApplication();
        appAction = new AppServiceImpl(this);

        try {
            viewDelegate = getViewClass().newInstance();
            viewDelegate.init(getLayoutInflater(), null, savedInstanceState);
            setContentView(viewDelegate.getRootView());
//            ButterKnife.bind(this);

            onViewDidLoad();
            bindEventListener();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onDestroy() {
        onDestroyView();
        viewDelegate = null;
        super.onDestroy();
    }

    protected <D extends IModel> void notifyDataChanged(D data) {
        if (viewDataBinder != null) {
            viewDataBinder.bindData(viewDelegate, data);
        }
    }

    protected abstract IAppViewDataBinder getDataBinder();

    protected abstract Class<V> getViewClass();

    protected void onViewDidLoad() {
    }

    protected void onDestroyView() {
    }

    protected void bindEventListener() {
    }

}
