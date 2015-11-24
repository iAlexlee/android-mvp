package shuowong.github.androidmvp.biz.base;

import android.content.Context;
import android.os.AsyncTask;

import com.socks.library.KLog;

import shuowong.github.androidmvp.api.APIs;
import shuowong.github.androidmvp.api.NormalResponse;
import shuowong.github.androidmvp.api.impl.NormalAPIsImpl;

/**
 * Created by WANGSHUO on 11/23/15.
 */
public class AppActionImpl implements AppAction {

    private Context context;
    private APIs api;

    public AppActionImpl(Context context) {
        this.context = context;
        this.api = new NormalAPIsImpl();
    }

    @Override
    public void getUserDesc(final AppCallbackListener<Void> listener) {

        new AsyncTask<Void, Void, NormalResponse<Void>>() {

            @Override
            protected NormalResponse<Void> doInBackground(Void... params) {
                return api.getUserDesc();
            }

            @Override
            protected void onPostExecute(NormalResponse<Void> response) {
                KLog.d(response.getResult());
                KLog.d(response.getMsg());

                if(listener != null && response != null) {
                    listener.onFailure("TIMEOUT", "msg");
                }
            }
        }.execute();
    }
}
