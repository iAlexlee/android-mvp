package shuowong.github.androidmvp;

import shuowong.github.androidmvp.presenter.BasePresenterActivity;
import shuowong.github.androidmvp.view.base.BaseView;

public class BaseActivity extends BasePresenterActivity<BaseView> {

    @Override
    protected void onViewDidLoad() {
        super.onViewDidLoad();
    }

    @Override
    protected Class<BaseView> getViewClass() {
        return BaseView.class;
    }


}
