package shuowong.github.androidmvp.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import de.greenrobot.event.EventBus;
import shuowong.github.androidmvp.events.ConnectionChangedEvent;
import shuowong.github.androidmvp.utils.Network;

/**
 * Created by WANGSHUO on 11/24/15.
 */
public class ConnectionChangeReceiver extends BroadcastReceiver {

    public int lastType = -1;

    @Override
    public void onReceive(Context context, Intent intent) {

        int currentType = Network.getConnectedType(context);
        if(currentType != lastType) {
            String currentTypeName = "UNKNOW";

            switch (currentType) {
                case ConnectivityManager.TYPE_WIFI:
                    currentTypeName = "WIFI";
                    break;
                case ConnectivityManager.TYPE_MOBILE:
                    currentTypeName = "3G/4G";
                    break;
                case -1:
                    currentTypeName = "NONE";
                    break;
                default:
                    break;
            }

            EventBus.getDefault().post(new ConnectionChangedEvent(currentType, currentTypeName));
        }
        lastType = currentType;
    }
}
