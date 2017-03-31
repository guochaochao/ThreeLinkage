package com.gcc.three.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gcc.three.R;
import com.gcc.three.bean.CateListbean;

import java.util.List;

/**
 * @author GCC
 * @version V1.0
 * @Description:CVS列表右侧listview
 * @date 2016-4-11 下午4:09:31
 */

public class TestSectionedAdapter extends SectionedBaseAdapter {
    private Context mContext;
    private List<CateListbean.BigcatelistBean.CategorylistBean> beanList;
    public TestSectionedAdapter(List<CateListbean.BigcatelistBean.CategorylistBean> beanList,Context context) {
        mContext = context;
        this.beanList = beanList;

    }

    @Override
    public Object getItem(int section, int position) {
        return beanList.get(section).getGdlist().get(position);
    }

    @Override
    public long getItemId(int section, int position) {
        return position;
    }

    @Override
    public int getSectionCount() {
        return beanList.size();
    }

    @Override
    public int getCountForSection(int section) {
        return beanList.get(section).getGdlist().size();
    }

    @Override
    public View getItemView(final int section, final int position,
                            View convertView, ViewGroup parent) {
        final ItemHolder holder;
        if (convertView == null) {
            holder = new ItemHolder();
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.list_item, null);
            holder.itemName = (TextView) convertView
                    .findViewById(R.id.tv_goods_name);
            holder.itemPic = (ImageView) convertView
                    .findViewById(R.id.iv_goods_pic);
            holder.itemPrice = (TextView) convertView
                    .findViewById(R.id.tv_goods_price);
            holder.itemScale = (TextView) convertView
                    .findViewById(R.id.tv_goods_saless);
            holder.itemPraise = (TextView) convertView
                    .findViewById(R.id.tv_goods_praise);
            convertView.setTag(holder);
        } else {
            holder = (ItemHolder) convertView.getTag();
        }

        holder.itemName.setText(beanList.get(section).getGdlist().get(position).getGdname());
        holder.itemPrice.setText("￥"
                + beanList.get(section).getGdlist().get(position).getMin_price());
        holder.itemScale.setText("月售"
                + beanList.get(section).getGdlist().get(position).getMonth_saled() + "件");
        holder.itemPraise.setText(beanList.get(section).getGdlist().get(position).getPraise_rate());
        Glide.with(mContext).load(beanList.get(section).getGdlist().get(position).getPicture_url()).into(holder.itemPic);
        return convertView;
    }

    @Override
    public View getSectionHeaderView(int section, View convertView,
                                     ViewGroup parent) {
        LinearLayout layout = null;
        if (convertView == null) {
            LayoutInflater inflator = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = (LinearLayout) inflator
                    .inflate(R.layout.header_item, null);
        } else {
            layout = (LinearLayout) convertView;
        }
        layout.setClickable(false);
        ((TextView) layout.findViewById(R.id.textItem)).setText(beanList
                .get(section).getGdname());
        return layout;
    }

    public class ItemHolder {
        private TextView itemName;
        private TextView itemPrice;
        private ImageView itemPic;
        private TextView itemScale;
        private TextView itemPraise;
    }
}
