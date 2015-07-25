package com.daivp.xlistview.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.daivp.xlistview.R;
import com.daivp.xlistview.viewHolder.TagViewHolder;

import java.util.ArrayList;

public class TagManagementAdapter extends ArrayAdapter<String> {
    Activity mContext;
    ArrayList<String> mTagList;
    int layoutId;

    public TagManagementAdapter(Activity context, int resource, ArrayList<String> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.layoutId = resource;
        this.mTagList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TagViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(layoutId, null);
            viewHolder = new TagViewHolder();
            viewHolder.tvTagName = (TextView) convertView.findViewById(R.id.activity_tag_tv_tagName);
            convertView.setTag(viewHolder);

        }else {
            viewHolder = (TagViewHolder) convertView.getTag();
        }
        viewHolder.tvTagName.setText(mTagList.get(position));

        return convertView;
    }
}