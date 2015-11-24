package shuowong.github.androidmvp.activites;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.socks.library.KLog;

import de.greenrobot.event.EventBus;
import shuowong.github.androidmvp.R;
import shuowong.github.androidmvp.biz.base.AppCallbackListener;
import shuowong.github.androidmvp.events.TestEvent;
import shuowong.github.androidmvp.presenter.BasePresenterActivity;
import shuowong.github.androidmvp.view.base.BaseView;


public class BaseActivity extends BasePresenterActivity<BaseView> {


    @Override
    protected void onViewDidLoad() {
        super.onViewDidLoad();

        EventBus.getDefault().register(this);

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
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(TestEvent event) {

        KLog.d(event.geteMSg());
        viewDelegate.setButtonText(R.id.button, event.geteMSg());
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
    }
}
