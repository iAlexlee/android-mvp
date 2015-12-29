package shuowong.github.androidmvp.fragments;

import android.os.Bundle;
import android.view.View;

import com.meetme.android.multistateview.MultiStateView;

import shuowong.github.androidmvp.R;
import shuowong.github.androidmvp.view.tab.MessageTabView;


public class MessageTabFragment extends BaseTabFragment<MessageTabView> {

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
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MultiStateView container = (MultiStateView) viewDelegate.get(R.id.fragment_list_container);
        container.setState(MultiStateView.ContentState.ERROR_GENERAL);
    }

    @Override
    protected Class getViewClass() {
        return MessageTabView.class;
    }


}
