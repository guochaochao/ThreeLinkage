package com.gcc.three.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.gcc.three.R;
import com.gcc.three.view.AnimatedExpandableListView;

import java.util.List;

/**
 * @author GCC
 * @date 2016-4-7 下午4:34:38
 * @version V1.0
 */

public class ExampleAdapter extends AnimatedExpandableListView.AnimatedExpandableListAdapter {

	private Context context;
	public static List<String> mycat1;
	public static List<List> mycat2;

	public ExampleAdapter(List<String> mycat1, List<List> mycat2,
						  Context context) {
		ExampleAdapter.mycat1 = mycat1;
		ExampleAdapter.mycat2 = mycat2;
		this.context = context;
	}

	@Override
	public Object getGroup(int groupPosition) {

		return mycat1.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return mycat1.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return mycat2.get(groupPosition).get(childPosition);

	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public int getRealChildrenCount(int groupPosition) {
		return mycat2.size() != 0 ? mycat2.get(groupPosition).size() : 0;
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
		holder.groupName.setText(mycat1.get(groupPosition));
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
		holder.itemName.setText((CharSequence) mycat2.get(groupPosition).get(
				childPosition));
		return convertView;
	}

	public class GroupHolder {
		private TextView groupName;
	}

	public class ItemHolder {
		private TextView itemName;
	}
}
