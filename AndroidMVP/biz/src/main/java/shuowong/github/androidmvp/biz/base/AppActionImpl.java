package shuowong.github.androidmvp.biz.base;

import android.content.Context;
import android.os.AsyncTask;

import com.socks.library.KLog;

import de.greenrobot.event.EventBus;
import shuowong.github.androidmvp.api.APIs;
import shuowong.github.androidmvp.api.Response;
import shuowong.github.androidmvp.api.impl.APIsImpl;

/**
 * Created by WANGSHUO on 11/23/15.
 */
public class AppActionImpl implements AppAction {

    private Context context;
    private APIs api;

    public AppActionImpl(Context context) {
        this.context = context;
        this.api = new APIsImpl();
    }

    @Override
    public void getUserDesc(final AppCallbackListener<Void> listener) {

        new AsyncTask<Void, Void, Response<Void>>() {

            @Override
            protected Response<Void> doInBackground(Void... params) {
                return api.getUserDesc();
            }

            @Override
            protected void onPostExecute(Response<Void> response) {
                KLog.d(response.getResult());
                KLog.d(response.getMsg());

                if(listener != null && response != null) {
                    listener.onFailure("TIMEOUT", "msg");
                }
            }
        }.execute();
    }
}
