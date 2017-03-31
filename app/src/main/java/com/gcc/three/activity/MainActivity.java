package com.gcc.three.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ExpandableListView;

import com.gcc.three.R;
import com.gcc.three.adapter.ExampleAdapter;
import com.gcc.three.adapter.TestSectionedAdapter;
import com.gcc.three.bean.CateListbean;
import com.gcc.three.bean.Constans;
import com.gcc.three.view.PinnedHeaderListView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity {
    @BindView(R.id.left_listview)
    ExpandableListView leftListview;
    @BindView(R.id.pinnedListView)
    PinnedHeaderListView rightListView;
    private String mJson = Constans.mJson;
    public List<String> mString = new ArrayList<String>();// position+child
    private int mPosition; // 左侧控制右侧条目
    int count = 0; // 记录打开分组的变量
    private boolean isScroll = false; // 右侧是否滑动状态
    private ExampleAdapter adapterLeft; // 左侧适配器
    public static TestSectionedAdapter adapterRight;

    private List<CateListbean.BigcatelistBean> cateList = new ArrayList<>();
    private List<CateListbean.BigcatelistBean.CategorylistBean> goodList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }


    private void init() {
        Gson gson = new Gson();
        CateListbean goodsListBean = gson.fromJson(mJson,
                CateListbean.class);
        cateList = goodsListBean.getBigcatelist();
        for (CateListbean.BigcatelistBean bigcatelistBean : cateList) {
            goodList.addAll(bigcatelistBean.getCategorylist());
        }
        mString.clear();
        adapterLeft = new ExampleAdapter(cateList, this);
        leftListview.setAdapter(adapterLeft);
        adapterRight = new TestSectionedAdapter(goodList, this);
        rightListView.setAdapter(adapterRight);
        setData();
    }

    /**
     * child选中效果控制方法
     *
     * @param groupPosition
     * @param childPosition
     */
    protected void setItemCheckePosition(int groupPosition, int childPosition) {
        if (leftListview == null) {
            return;
        }

        int numberOfGroupThatIsOpened = 0;
        for (int i = 0; i < groupPosition; i++) {
            if (leftListview.isGroupExpanded(i)) {
                numberOfGroupThatIsOpened += adapterLeft.getChildrenCount(i);
            }
        }
        int position = numberOfGroupThatIsOpened + groupPosition
                + childPosition + 1;
        if (!leftListview.isItemChecked(position)) {
            leftListview.setItemChecked(position, true);
        }

    }

    /**
     * 通过右侧的headView的position,获取左侧对应Group和child的数据
     *
     * @param position
     * @return int[]
     */
    public int[] getGrAndCh(int position) {
        String sbu = mString.get(position);
        String[] sbus = sbu.split("\\.");
        int[] mIN = {Integer.parseInt(sbus[0]), Integer.parseInt(sbus[1])};
        return mIN;
    }


    public void setData() {

        /********************* 通过拼接String字符串来控制position对应 *********************/
        for (int i = 0; i < cateList.size(); i++) {
            for (int j = 0; j < cateList.get(i).getCategorylist().size(); j++) {
                String d = i + "." + j;
                mString.add(d);
            }
        }
        /***************************************************************************/
        adapterLeft.notifyDataSetChanged();
        adapterRight.notifyDataSetChanged();
        // 左侧默认打开
        if (cateList.size() != 0) {
            leftListview.expandGroup(0);
            leftListview.setItemChecked(1, true);
        }

        leftListview.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @SuppressLint("NewApi")
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                if (count == groupPosition) {
                    leftListview.expandGroup(groupPosition, true);
                } else {
                    if (leftListview.isGroupExpanded(groupPosition)) {
                        leftListview.collapseGroup(groupPosition);
                    } else {
                        leftListview.expandGroup(groupPosition);
                    }
                    for (int i = 0; i < adapterLeft.getGroupCount(); i++) {
                        if (groupPosition != i) {
                            leftListview.collapseGroup(i);
                        }
                    }
                }
                return true;
            }
        });

        /**
         * 左侧group合拢时调用
         */
        leftListview.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {

            }
        });

        /**
         * 左侧group展开时调用
         */

        leftListview.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                count = groupPosition;
            }
        });
        /**
         * 左侧子条目点击监听
         */
        leftListview.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                setItemCheckePosition(groupPosition, childPosition);
                isScroll = false;
                mPosition = mString
                        .indexOf(groupPosition + "." + childPosition);
                adapterLeft.notifyDataSetChanged();
                int rightSection = 0;
                for (int i = 0; i < mPosition; i++) {
                    rightSection += adapterRight.getCountForSection(i) + 1;
                }
                System.out.println("count" + leftListview.getChildCount());
                System.out.println("数据是:" + rightSection);
                rightListView.setSelection(rightSection);
                return true;
            }
        });

        /**
         * 右侧滑动时调用
         */
        rightListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            // 滑动状态改变监听
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:// 空闲状态
                        isScroll = false;
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_FLING:// 滚动状态
                        isScroll = true;
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:// 触摸后滚动
                        isScroll = true;
                        break;

                }
            }

            // 滑动监听
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                if (isScroll) {
                    int position = PinnedHeaderListView.mCurrentSection;
                    int[] mInts = getGrAndCh(position);
                    int G = mInts[0];
                    int C = mInts[1];
                    if (G == count) {
                        if (!leftListview.isGroupExpanded(G)) {
                            leftListview.expandGroup(G);
                        }
                        leftListview.setItemChecked(G + C + 1, true);
                    } else {
                        leftListview.collapseGroup(count);
                        leftListview.expandGroup(G);
                    }
                }
            }
        });

    }

}
