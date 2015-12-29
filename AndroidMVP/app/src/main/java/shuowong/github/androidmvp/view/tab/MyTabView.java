package shuowong.github.androidmvp.view.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import shuowong.github.androidmvp.R;
import shuowong.github.androidmvp.view.AppViewDelegate;

/**
 * Created by WANGSHUO on 11/23/15.
 */
public class MyTabView extends AppViewDelegate {


    @Override
    public void init(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.init(inflater, container, savedInstanceState);
    }

    @Override
    public int getRootLayoutID() {
        return R.layout.fragment_tab_my;
    }

    public void setButtonText(int id, String msg) {
        ((Button) get(id)).setText(msg);
    }

    public void setOnListItemClickListener(AdapterView.OnItemClickListener listener, int... ids) {
        if (ids == null) {
            return;
        }
        for (int id : ids) {
            ((ListView) get(id)).setOnItemClickListener(listener);
        }
    }

}
