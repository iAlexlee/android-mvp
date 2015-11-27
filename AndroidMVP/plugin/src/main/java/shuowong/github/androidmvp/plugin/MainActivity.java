package shuowong.github.androidmvp.plugin;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends BasePluginActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView(savedInstanceState);

    }

    private void initView(Bundle savedInstanceState) {
//        mProxyActivity.setContentView(generateContentView(mProxyActivity));
        mProxyActivity.setContentView(R.layout.activity_main);

    }

    private View generateContentView(final Context context) {
        LinearLayout layout = new LinearLayout(context);
        layout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        layout.setBackgroundColor(Color.parseColor("#F79AB5"));

        Button button = new Button(context);
        button.setText("button");
        layout.addView(button, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "you clicked button",
                        Toast.LENGTH_SHORT).show();
//                startActivityByProxy("shuowong.github.androidmvp.plugin.TestActivity");
            }
        });
        return layout;
    }
}
