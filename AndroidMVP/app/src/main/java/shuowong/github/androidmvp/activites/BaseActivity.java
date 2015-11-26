package shuowong.github.androidmvp.activites;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.view.View;
import android.widget.Toast;

import com.socks.library.KLog;

import de.greenrobot.event.EventBus;
import shuowong.github.androidmvp.R;
import shuowong.github.androidmvp.activites.proxy.ProxyActivity;
import shuowong.github.androidmvp.biz.base.AppCallbackListener;
import shuowong.github.androidmvp.broadcast.ConnectionChangeReceiver;
import shuowong.github.androidmvp.events.ConnectionChangedEvent;
import shuowong.github.androidmvp.events.TestEvent;
import shuowong.github.androidmvp.presenter.BasePresenterActivity;
import shuowong.github.androidmvp.view.base.BaseView;


public class BaseActivity extends BasePresenterActivity<BaseView> {

    ConnectionChangeReceiver mNetworkStateReceiver;

    @Override
    protected void onViewDidLoad() {
        super.onViewDidLoad();

        EventBus.getDefault().register(this, 1);

        if (mNetworkStateReceiver == null) {
            mNetworkStateReceiver = new ConnectionChangeReceiver();
        }

        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(mNetworkStateReceiver, filter);

        appAction.getUserDesc(new AppCallbackListener<Void>() {
            @Override
            public void onSuccess(Void data) {

            }

            @Override
            public void onFailure(String result, String msg) {
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onDestroyView() {
        super.onDestroyView();
        unregisterReceiver(mNetworkStateReceiver);
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(TestEvent event) {

        KLog.d(event.geteMSg());
        viewDelegate.setButtonText(R.id.button, event.geteMSg());
    }

    public void onEventMainThread(ConnectionChangedEvent event) {

        Toast.makeText(getApplicationContext(), event.getTypeName(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected Class<BaseView> getViewClass() {
        return BaseView.class;
    }

    @Override
    protected void bindEventListener() {
        super.bindEventListener();

        viewDelegate.get(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(BaseActivity.this, TestEventActivity.class);
                startActivity(intent);
            }
        });

        viewDelegate.get(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaseActivity.this, ProxyActivity.class);
                intent.putExtra(ProxyActivity.EXTRA_DEX_PATH, "/mnt/sdcard/plugin-release.apk");
                intent.putExtra(ProxyActivity.EXTRA_CLASS, "shuowong.github.androidmvp.plugin.MainActivity");
                startActivity(intent);
            }
        });
    }
}
