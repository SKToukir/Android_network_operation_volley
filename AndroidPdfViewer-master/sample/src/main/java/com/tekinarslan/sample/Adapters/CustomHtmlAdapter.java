package com.tekinarslan.sample.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tekinarslan.sample.Activities.HtmlViwerActivity;
import com.tekinarslan.sample.R;

/**
 * Created by toukir on 4/4/16.
 */
public class CustomHtmlAdapter extends BaseAdapter {
    String[] result;
    Context context;
    int imageId;
    private static LayoutInflater inflater=null;

    public CustomHtmlAdapter(HtmlViwerActivity activity, String[] prgmNameList, int prgmImages) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=activity;
        imageId=prgmImages;
        inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.htmlitems, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView1l);

        holder.tv.setText(result[position]);

        return rowView;
    }

}

