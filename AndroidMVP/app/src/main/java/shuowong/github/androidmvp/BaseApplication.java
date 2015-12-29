package shuowong.github.androidmvp;

import android.app.Application;

/**
 * Created by WANGSHUO on 11/24/15.
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        KLog.init(BuildConfig.LOG_DEBUG);
    }

}
