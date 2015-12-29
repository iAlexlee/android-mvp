package shuowong.github.androidmvp.view;

import shuowong.github.androidmvp.model.IModel;

/**
 * Created by WANGSHUO on 11/12/15.
 */
public interface IAppViewDataBinder<V extends IAppViewDelegate, D extends IModel> {

    void bindData(V viewDelegate, D data);

}
