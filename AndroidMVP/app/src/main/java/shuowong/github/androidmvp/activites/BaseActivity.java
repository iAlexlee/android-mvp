package shuowong.github.androidmvp.activites;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.meetme.android.multistateview.MultiStateView;
import com.orhanobut.logger.Logger;

import de.greenrobot.event.EventBus;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import shuowong.github.androidmvp.R;
import shuowong.github.androidmvp.activites.proxy.ProxyActivity;
import shuowong.github.androidmvp.broadcast.ConnectionChangeReceiver;
import shuowong.github.androidmvp.events.ConnectionChangedEvent;
import shuowong.github.androidmvp.events.TestEvent;
import shuowong.github.androidmvp.model.PostsModel;
import shuowong.github.androidmvp.model.TestModel;
import shuowong.github.androidmvp.presenter.BasePresenterActivity;
import shuowong.github.androidmvp.view.IAppViewDataBinder;
import shuowong.github.androidmvp.view.base.BaseView;


/**
 *
 */
public class BaseActivity extends BasePresenterActivity<BaseView> {

    ConnectionChangeReceiver mNetworkStateReceiver;

//    @Bind(R.id.button2) Button btn;

    @Override
    protected void onViewDidLoad() {
        super.onViewDidLoad();

        EventBus.getDefault().register(this, 1);

        if (mNetworkStateReceiver == null) {
            mNetworkStateReceiver = new ConnectionChangeReceiver();
        }

        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(mNetworkStateReceiver, filter);

//        btn.setText("test");

        MultiStateView container = (MultiStateView) viewDelegate.get(R.id.list_container);
        ListView list = (ListView) container.getContentView();
        container.setState(MultiStateView.ContentState.ERROR_GENERAL);

        appAction.getPost(1, new Callback<PostsModel>() {
            @Override
            public void onResponse(Response<PostsModel> response, Retrofit retrofit) {
                Logger.d("onResponse");
            }

            @Override
            public void onFailure(Throwable t) {
                Logger.d("onFailure");
                Logger.d(t.getMessage());
            }
        });

//        CommentModel comm  = new CommentModel(2, "test", 2);
//        Call<CommentModel> call = apis.createComment(comm);
//        call.enqueue(new Callback<CommentModel>() {
//            @Override
//            public void onResponse(Response<CommentModel> response, Retrofit retrofit) {
//                KLog.d("onResponse");
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                KLog.d("onFailure");
//            }
//        });

//        Call<PostsModel> call = apis.getPosts(1);
//        call.enqueue(new Callback<PostsModel>() {
//            @Override
//            public void onResponse(Response<PostsModel> response, Retrofit retrofit) {
//                KLog.d("onResponse");
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                KLog.d("onFailure");
//                KLog.d(t.getMessage());
//            }
//        });

//        Call<APIResponse<RetTestModel>> call = apis.getRes();
//        call.enqueue(new Callback<APIResponse<RetTestModel>>() {
//            @Override
//            public void onResponse(Response<APIResponse<RetTestModel>> response, Retrofit retrofit) {
//                KLog.d("onResponse");
//                APIResponse<RetTestModel> res = response.body();
//                KLog.d(res.getData().getObjs().size());
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                KLog.d("onFailure");
//            }
//        });


//        Call<List<PostsModel>> call =  apis.posts();
//        call.enqueue(new Callback<List<PostsModel>>() {
//            @Override
//            public void onResponse(APIResponse<List<PostsModel>> response, Retrofit retrofit) {
//                KLog.d("onResponse");
//                List<PostsModel> posts = response.body();
//                KLog.d(posts.size());
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                KLog.d("onFailure");
//                KLog.d("onFailure" + t.getMessage());
//
//            }
//        });

    }

    @Override
    protected void onDestroyView() {
        super.onDestroyView();

        unregisterReceiver(mNetworkStateReceiver);
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(TestEvent event) {

        Logger.d(event.geteMSg());
        viewDelegate.setButtonText(R.id.button, event.geteMSg());
    }

    public void onEventMainThread(ConnectionChangedEvent event) {

        Toast.makeText(getApplicationContext(), event.getTypeName(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected IAppViewDataBinder getDataBinder() {
        return new BaseDataBinder();
    }

    @Override
    protected Class<BaseView> getViewClass() {
        return BaseView.class;
    }

    @Override
    protected void bindEventListener() {
        super.bindEventListener();

//        viewDelegate.setOnListItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                KLog.d(position);
//            }
//        }, R.id.listView);

        viewDelegate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                switch (v.getId()) {
                    case R.id.button:
                        intent.setClass(BaseActivity.this, TestEventActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.button2:
                        intent.setClass(BaseActivity.this, ProxyActivity.class);
                        intent.putExtra(ProxyActivity.EXTRA_DEX_PATH, "/mnt/sdcard/plugin-release.apk");
                        intent.putExtra(ProxyActivity.EXTRA_CLASS, "shuowong.github.androidmvp.plugin.MainActivity");
                        startActivity(intent);
                        break;
                }

            }
        }, R.id.button, R.id.button2);

    }
}

class BaseDataBinder implements IAppViewDataBinder<BaseView, TestModel> {

    @Override
    public void bindData(BaseView viewDelegate, TestModel data) {
//        CustomSimpleAdapter a = (CustomSimpleAdapter) ((ListView) viewDelegate.get(R.id.listView)).getAdapter();
//        a.notifyDataSetChanged();
    }


}