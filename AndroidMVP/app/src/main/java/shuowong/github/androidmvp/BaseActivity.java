package shuowong.github.androidmvp;

import android.widget.Toast;
import com.socks.library.KLog;
import shuowong.github.androidmvp.biz.base.AppCallbackListener;
import shuowong.github.androidmvp.presenter.BasePresenterActivity;
import shuowong.github.androidmvp.view.base.BaseView;


public class BaseActivity extends BasePresenterActivity<BaseView> {


    @Override
    protected void onViewDidLoad() {
        super.onViewDidLoad();

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
    protected Class<BaseView> getViewClass() {
        return BaseView.class;
    }

    @Override
    protected void bindEventListener() {
        super.bindEventListener();
    }
}
