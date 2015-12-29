package shuowong.github.androidmvp.fragments;

import shuowong.github.androidmvp.presenter.BasePresenterFragment;
import shuowong.github.androidmvp.view.IAppViewDelegate;

public abstract class BaseTabFragment<V extends IAppViewDelegate> extends BasePresenterFragment<V> {

    private String title;
    private int iconId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }


}
