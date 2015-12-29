package shuowong.github.androidmvp.activites;

import android.view.View;

import de.greenrobot.event.EventBus;
import shuowong.github.androidmvp.R;
import shuowong.github.androidmvp.events.TestEvent;
import shuowong.github.androidmvp.presenter.BasePresenterActivity;
import shuowong.github.androidmvp.view.IAppViewDataBinder;
import shuowong.github.androidmvp.view.base.TestEventView;

/**
 * Created by WANGSHUO on 11/24/15.
 */
public class TestEventActivity extends BasePresenterActivity<TestEventView> {


    @Override
    protected void onViewDidLoad() {
        super.onViewDidLoad();
    }

    @Override
    protected void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    protected void bindEventListener() {
        super.bindEventListener();

        viewDelegate.get(R.id.button_event).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new TestEvent("TEST EVENT"));
            }
        });


    }

    @Override
    protected IAppViewDataBinder getDataBinder() {
        return null;
    }

    @Override
    protected Class getViewClass() {
        return TestEventView.class;
    }
}
