package shuowong.github.androidmvp.view.base;

import android.widget.Button;

import shuowong.github.androidmvp.R;
import shuowong.github.androidmvp.view.AppViewDelegate;

/**
 * Created by WANGSHUO on 11/23/15.
 */
public class BaseView extends AppViewDelegate {
    @Override
    public int getRootLayoutID() {
        return R.layout.activity_base;
    }

    public void setButtonText(int id, String msg) {
        ((Button) get(id)).setText(msg);
    }
}
