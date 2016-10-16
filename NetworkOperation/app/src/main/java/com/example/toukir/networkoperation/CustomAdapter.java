package com.example.toukir.networkoperation;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toukir on 3/23/16.
 */
public class CustomAdapter extends ArrayAdapter{

    List items = new ArrayList();
    public CustomAdapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(NoticeItems noticeItems) {
        super.add(noticeItems);
        items.add(noticeItems);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        ViewHolder holder;

        if (row == null){

            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            row = inflater.inflate(R.layout.row,parent,false);

            holder = new ViewHolder();

            holder.txtTitle = (TextView) row.findViewById(R.id.txt_title);
            holder.txtDate = (TextView) row.findViewById(R.id.txt_date);

            row.setTag(holder);
        }else {
            holder = (ViewHolder) row.getTag();
        }

        NoticeItems items = (NoticeItems) this.getItem(position);

        holder.txtTitle.setText(items.getTitle());
        holder.txtDate.setText(items.getDate());

        return row;
    }

    public class ViewHolder{

        private TextView txtTitle;
        private TextView txtDate;

    }
}
