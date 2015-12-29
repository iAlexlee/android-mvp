package shuowong.github.androidmvp.fragments;

import shuowong.github.androidmvp.view.base.BaseView;


public class WorkTabFragment extends BaseTabFragment<BaseView> {

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


    @Override
    protected Class getViewClass() {
        return BaseView.class;
    }


}
