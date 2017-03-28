package com.gcc.three.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gcc.three.R;
import com.gcc.three.bean.GoodsListBean;

import java.util.List;

/**
 * @author GCC
 * @version V1.0
 * @Description:CVS列表右侧listview
 * @date 2016-4-11 下午4:09:31
 */

public class TestSectionedAdapter extends SectionedBaseAdapter {
    private Context mContext;
    public static List<String> mycat22;
    public static List<List<GoodsListBean.Storegoodslist.Gdlist>> mycat3;
    public static ExampleAdapter adapter;
    public static List<List> mycat2;
    public TestSectionedAdapter(Context context, List<List> mycat2,
                                List<String> mycat22, List<List<GoodsListBean.Storegoodslist.Gdlist>> mycat3,
                                ExampleAdapter adapter) {
        this.mContext = context;
        this.mycat22 = mycat22;
        this.mycat3 = mycat3;
        this.adapter = adapter;
        this.mycat2 = mycat2;

    }

    @Override
    public Object getItem(int section, int position) {
        return mycat3.get(section).get(position);
    }

    @Override
    public long getItemId(int section, int position) {
        return position;
    }

    @Override
    public int getSectionCount() {
        return mycat22.size();
    }

    @Override
    public int getCountForSection(int section) {
        return mycat3.get(section).size();
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

        holder.itemName.setText(mycat3.get(section).get(position).getGdname());
        holder.itemPrice.setText("￥"
                + mycat3.get(section).get(position).getMinPrice());
        holder.itemScale.setText("月售"
                + mycat3.get(section).get(position).getMonthSaled() + "件");
        holder.itemPraise.setText(mycat3.get(section).get(position)
                .getPraiseRate());
        Glide.with(mContext).load(mycat3.get(section).get(position).getPictureUrl()).into(holder.itemPic);
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
        ((TextView) layout.findViewById(R.id.textItem)).setText(mycat22
                .get(section));
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
