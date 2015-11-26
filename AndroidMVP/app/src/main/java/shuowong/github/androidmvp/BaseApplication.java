package shuowong.github.androidmvp;

import android.app.Application;

import com.socks.library.KLog;

import shuowong.github.androidmvp.biz.base.AppAction;
import shuowong.github.androidmvp.biz.base.AppActionImpl;

/**
 * Created by WANGSHUO on 11/24/15.
 */
public class BaseApplication extends Application {

    private AppAction appAction;

    @Override
    public void onCreate() {
        super.onCreate();

        appAction = new AppActionImpl(this);

        KLog.init(BuildConfig.LOG_DEBUG);
    }

    public AppAction getAppAction() {
        return appAction;
    }
}
