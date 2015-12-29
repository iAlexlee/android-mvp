package shuowong.github.androidmvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.List;

import shuowong.github.androidmvp.R;
import shuowong.github.androidmvp.model.RetTestModel;

/**
 * Created by WANGSHUO on 12/1/15.
 */
public class CustomSimpleAdapter extends SimpleAdapter {

    private Context context;
    private List data;
    private int layoutResource;

    public CustomSimpleAdapter(Context context, List data, int resource) {
        super(context, data, resource, null, null);
        this.context = context;
        this.data = data;
        this.layoutResource = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutView = layoutInflater.inflate(layoutResource, null);
        ViewHolder viewHolder = new ViewHolder();

        viewHolder.title = (TextView) layoutView.findViewById(R.id.title);
        viewHolder.desc = (TextView) layoutView.findViewById(R.id.desc);


        viewHolder.title.setText(((RetTestModel) data.get(position)).getTitle());
        viewHolder.desc.setText(((RetTestModel) data.get(position)).getDesc());

        return layoutView;
    }

    class ViewHolder {
        TextView title;
        TextView desc;
    }
}
