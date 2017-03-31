package com.gcc.three.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.gcc.three.R;
import com.gcc.three.bean.CateListbean;
import com.gcc.three.view.AnimatedExpandableListView;

import java.util.List;

/**
 * @author GCC
 * @version V1.0
 * @date 2016-4-7 下午4:34:38
 */

public class ExampleAdapter extends AnimatedExpandableListView.AnimatedExpandableListAdapter {

    private Context context;
    private List<CateListbean.BigcatelistBean> beanList;

    public ExampleAdapter(List<CateListbean.BigcatelistBean> beanList,
                          Context context) {
        this.beanList = beanList;
        this.context = context;
    }

    @Override
    public Object getGroup(int groupPosition) {

        return beanList.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return beanList.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return beanList.get(groupPosition).getCategorylist().get(childPosition);

    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public int getRealChildrenCount(int groupPosition) {
        Log.e("gcc","size:"+beanList.size());
        return beanList.size() != 0 ? beanList.get(groupPosition).getCategorylist().size() : 0;

    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        final GroupHolder holder;
        if (convertView == null) {
            holder = new GroupHolder();
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.item_group, parent, false);
            holder.groupName = (TextView) convertView
                    .findViewById(R.id.groupName);
            convertView.setTag(holder);
        } else {
            holder = (GroupHolder) convertView.getTag();
        }
        holder.groupName.setText(beanList.get(groupPosition).getCategorytitle());
        return convertView;
    }

    @Override
    public View getRealChildView(int groupPosition, int childPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {
        final ItemHolder holder;
        if (convertView == null) {
            holder = new ItemHolder();
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.item_left_child, parent, false);

            holder.itemName = (TextView) convertView
                    .findViewById(R.id.textTitle);
            convertView.setTag(holder);
        } else {
            holder = (ItemHolder) convertView.getTag();
        }
        holder.itemName.setText(beanList.get(groupPosition).getCategorylist().get(childPosition).getGdname());
        return convertView;
    }

    public class GroupHolder {
        private TextView groupName;
    }

    public class ItemHolder {
        private TextView itemName;
    }
}
