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
import com.gcc.three.bean.GoodsListBean;
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
    //注释到底是发生
    //离开了都卡了
    private String mJson = "{\"orderdelivery_price\":\"0\",\"categorylist\":[{\"categorytitle\":\"速食速冻\",\"categorynum\":\"0\",\"categoryname\":[{\"ctname\":\"火腿香肠\"}]},{\"categorytitle\":\"饮料酒水\",\"categorynum\":\"0\",\"categoryname\":[{\"ctname\":\"茶饮\"},{\"ctname\":\"功能饮料\"}]},{\"categorytitle\":\"休闲食品\",\"categorynum\":\"0\",\"categoryname\":[{\"ctname\":\"薯片\"}]}],\"Storegoodslist\":[{\"gdname\":\"火腿香肠\",\"gdnum\":\"0\",\"gdlist\":[{\"gdid\":\"5992\",\"gdname\":\"双汇泡面搭档火腿肠40g/个\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015120910293545622412465_V4ZFL80T4J.jpg\",\"min_price\":\"1.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"5989\",\"gdname\":\"双汇王中王香肠70g/个\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015120910281001539478858_B6PR00FH86.jpg\",\"min_price\":\"2.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"5946\",\"gdname\":\"双汇润口香甜王玉米风味香肠270g/袋 9只\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015120909440354093585346_ZH204P0004.jpg\",\"min_price\":\"7.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"5942\",\"gdname\":\"双汇香脆肠150g/个\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015120909371696736040031_Z2TVR42020.jpg\",\"min_price\":\"4.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"5929\",\"gdname\":\"双汇王中王38g/个\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015120908481605359345467_VPFJ640N6V.jpg\",\"min_price\":\"1.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"5927\",\"gdname\":\"双汇王中王105g/个\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015120908445667310113987_28DZ60NJL4.jpg\",\"min_price\":\"3.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"337\",\"gdname\":\"双汇润口香甜王玉米风味香肠48g\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015110710385470916634515_LT866NX24B.jpg\",\"min_price\":\"1.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"}]},{\"gdname\":\"茶饮\",\"gdnum\":\"0\",\"gdlist\":[{\"gdid\":\"8096\",\"gdname\":\"（直营店特供）康师傅茉莉蜜茶550ML*15瓶/箱\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2016090311212756388529692_48T8FB8FBX.jpg\",\"min_price\":\"33.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"8083\",\"gdname\":\"（直营店特供）康师傅茉莉蜜茶1LX8/瓶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2016090221593227111796786_BTF0ZZ4XR8.jpg\",\"min_price\":\"28.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"8078\",\"gdname\":\"（直营店特供）康师傅冰红茶2L*6瓶 \",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2016090221335192974095697_04DR68FV8P.jpg\",\"min_price\":\"33.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"8066\",\"gdname\":\"（直营店特供）康师傅冰红茶柠檬味 1L*8瓶/箱\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2016090219434257395818995_P6B6BLVDV2.jpg\",\"min_price\":\"28.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"7446\",\"gdname\":\"茶π果味茶饮料西柚茉莉花茶500ml*15瓶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2016061417390185372912660_8LZD4F0428.jpg\",\"min_price\":\"5.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"7445\",\"gdname\":\"茶π果味茶饮料蜜桃乌龙茶500ml*15瓶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2016061417374129891652281_F866H46008.jpg\",\"min_price\":\"5.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"7444\",\"gdname\":\"茶π果味茶饮料柠檬红茶500ml*15瓶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2016061417360730193494241_NLVNVL2TXR.jpg\",\"min_price\":\"5.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"7443\",\"gdname\":\"茶π果味茶饮料柚子绿茶500ml*15瓶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2016061417330171335448148_JVZ0TFR28J.jpg\",\"min_price\":\"5.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"3445\",\"gdname\":\"统一 小茗同学 青柠红茶480ML/瓶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015101318085590574195373_600DDX644V.jpg\",\"min_price\":\"5.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"3429\",\"gdname\":\"统一 奶茶（阿萨姆奶茶）500ml/瓶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015110517025523474695559_J0FB8RXP4R.jpg\",\"min_price\":\"4.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"3395\",\"gdname\":\"达利园和其正凉茶 600ml*15瓶/箱\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015101317390824064631332_L66DVP0PJF.jpg\",\"min_price\":\"4.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"3394\",\"gdname\":\"统一 小茗同学 冷泡茶 冰橘绿茶 调味茶饮料 480毫升/瓶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015101317390282411526515_DL82FJVR22.jpg\",\"min_price\":\"5.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"3332\",\"gdname\":\"康师傅 蜂蜜柚子茶500ml/瓶X 6\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015110609251327999745359_2ZR2L2TJV4.jpg\",\"min_price\":\"18.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"3326\",\"gdname\":\"康师傅 茉莉清茶 550ml4/瓶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015110516411917585494111_462TZZ6626.jpg\",\"min_price\":\"12.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"3324\",\"gdname\":\"康师傅 茉莉蜜茶 2L/瓶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015101316352698788765262_X822BDZVVB.jpg\",\"min_price\":\"6.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"3275\",\"gdname\":\"康师傅 茉莉清1L/瓶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015110516464374592041685_P8002R4FBX.jpg\",\"min_price\":\"4.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"3270\",\"gdname\":\"康师傅冰红茶柠檬味 1L*8/瓶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015101315593056749086570_40PFB604J2.jpg\",\"min_price\":\"28.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"3264\",\"gdname\":\"康师傅 冰红茶 青苹果口味 550ml/瓶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015110516033101495477807_4D8RNT8NJZ.jpg\",\"min_price\":\"3.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"3259\",\"gdname\":\"康师傅茉莉蜜茶550ML*15/瓶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015110609042439834321028_0646L08N26.jpg\",\"min_price\":\"33.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"3187\",\"gdname\":\"康师傅茉莉清茶 2L/瓶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015110516564645132376838_J4JR8JD804.jpg\",\"min_price\":\"6.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"3184\",\"gdname\":\"康师傅茉莉清茶 2L*6/瓶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015110517065973375656827_0N024VZPT8.jpg\",\"min_price\":\"33.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"3176\",\"gdname\":\"康师傅酸梅汤2L/瓶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015101315284090396269354_8NN4L64642.jpg\",\"min_price\":\"7.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"3172\",\"gdname\":\"康师傅酸梅汤2L/瓶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015101315275693096610070_602N6D646X.jpg\",\"min_price\":\"34.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"2746\",\"gdname\":\"统一小茗同学冷泡青柠红茶480ml/瓶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015101311233014679105653_46J6V04BXR.jpg\",\"min_price\":\"5.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"2532\",\"gdname\":\"加多宝500ml*15瓶/箱\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015101310241485865402192_02062D2X2N.jpg\",\"min_price\":\"4.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"1641\",\"gdname\":\"康师傅绿茶 蜂蜜茉莉味550ML/瓶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015110516424467352701426_BLZ0BFZ482.jpg\",\"min_price\":\"3.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"1634\",\"gdname\":\"康师傅绿茶 蜂蜜茉莉味550MLX15/瓶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015110516432201087391622_0F8RL0L84T.jpg\",\"min_price\":\"33.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"1624\",\"gdname\":\"康师傅茉莉清茶550ML/瓶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015110516401374480569724_T0JX2B00J8.jpg\",\"min_price\":\"3.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"1619\",\"gdname\":\"康师傅茉莉清茶550MLX15/瓶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015110516392820339797956_P086624N40.jpg\",\"min_price\":\"33.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"1497\",\"gdname\":\"康师傅冰红茶青苹果味茶饮品 550ML/瓶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015110515095138344949639_0088J8484P.jpg\",\"min_price\":\"3.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"}]},{\"gdname\":\"功能饮料\",\"gdnum\":\"0\",\"gdlist\":[{\"gdid\":\"2657\",\"gdname\":\"脉动维生素饮料水蜜桃口味1L*12瓶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015101310532905527228857_N20R88ZP88.jpg\",\"min_price\":\"4.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"}]},{\"gdname\":\"薯片\",\"gdnum\":\"0\",\"gdlist\":[{\"gdid\":\"7319\",\"gdname\":\"好丽友薯愿红酒牛排味薯片 48克\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2016040711292089325389047_4VT624668V.jpg\",\"min_price\":\"4.50\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"7296\",\"gdname\":\"好丽友薯愿香烤原味薯片 48克\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2016040709555395831225981_T80L66T8LN.jpg\",\"min_price\":\"4.50\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"6021\",\"gdname\":\"好丽友薯愿红酒牛排味薯片48g/桶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015120910550220898771907_DJZPJDTLV8.jpg\",\"min_price\":\"4.50\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"6018\",\"gdname\":\"好丽友薯愿烤鸡沙拉味薯片104g/桶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015120910523726388280818_H0FB68N6F6.jpg\",\"min_price\":\"7.50\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"6013\",\"gdname\":\"好丽友薯愿蜂蜜牛奶味薯片104g/桶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015120910500807835381226_24X64N608D.jpg\",\"min_price\":\"7.50\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"6011\",\"gdname\":\"好丽友呀！香焗原味薯条70g/袋\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015120910474771826860542_0T42FD0P4B.jpg\",\"min_price\":\"5.50\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"6008\",\"gdname\":\"好丽友呀！土豆蜂蜜黄油味40g/袋\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015120910452188795375960_T42H64N8FB.jpg\",\"min_price\":\"3.50\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"6005\",\"gdname\":\"好丽友好友趣凹凸薯片韩国泡菜75g/袋\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015120910420944251940887_FZ44NB8DLP.jpg\",\"min_price\":\"5.50\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"6002\",\"gdname\":\"好丽友好友趣凹凸薯片加勒比烤翅味75g/袋\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015120910391266963688796_PT42NDDTFR.jpg\",\"min_price\":\"5.50\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"5999\",\"gdname\":\"好丽友好友趣大凹凸蜂蜜黄油味75g/袋\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015120910353033583916022_P0L6DTTVVB.jpg\",\"min_price\":\"5.50\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"5890\",\"gdname\":\"可比克香辣味薯片105g/桶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015120818023522480570107_ZB2L4F0LTV.jpg\",\"min_price\":\"8.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"5697\",\"gdname\":\"浪味仙海苔口味创意花式薯卷70g/袋\",\"gdnum\":\"0\",\"picture_url\":\"\",\"min_price\":\"5.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"5464\",\"gdname\":\"好丽友好友趣薯片(纯香原味)45g/包\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015112123225393768192564_204846V2L4.jpg\",\"min_price\":\"4.50\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"5463\",\"gdname\":\"好丽友 好友趣薯片多汁牛排味 45g袋\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015112123200135225471620_F2DVNTF484.jpg\",\"min_price\":\"4.50\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"5462\",\"gdname\":\"好友趣韩国泡菜味75g\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015112123175997681945746_0HNJ8TL6NB.jpg\",\"min_price\":\"5.50\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"5461\",\"gdname\":\"好丽友 好友趣 多汁牛排味 75g\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015112123142544843688698_JNZ04J84B4.jpg\",\"min_price\":\"5.50\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"5439\",\"gdname\":\"好有趣大凹凸蜂蜜黄油味薯片45克/袋\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015112120480552187842151_R6Z88HB202.jpg\",\"min_price\":\"3.50\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"441\",\"gdname\":\"可比克 薯片番茄味105g/罐\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015101213532618151935950_64J2J48HJ6.jpg\",\"min_price\":\"8.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"439\",\"gdname\":\"可比克烧烤味薯片105g/桶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015110516261857380074901_8H4P26NJJT.jpg\",\"min_price\":\"8.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"434\",\"gdname\":\"可比克脆香鸡翅味薯片105g/桶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015101213512208165711442_0FTRLHRFFN.jpg\",\"min_price\":\"8.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"429\",\"gdname\":\"可比克薯片香浓红烩105g/桶\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015101213500971717821143_N6L0XRXX22.jpg\",\"min_price\":\"8.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"409\",\"gdname\":\"可比克薯片(原味)105g\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015101213450244859528075_P42RJ0X440.jpg\",\"min_price\":\"8.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"351\",\"gdname\":\"乐吧薯片(泡菜味) 50g条\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015101213264094116005935_6J4Z862N20.jpg\",\"min_price\":\"2.00\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"172\",\"gdname\":\"好丽友 薯愿马铃薯膨化食品(红酒牛排味) 104g/罐\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015101211011257511349734_FT242NJ4T6.jpg\",\"min_price\":\"7.50\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"165\",\"gdname\":\"好丽友 薯愿马铃薯膨化食品(香焗番茄味) 104g/罐\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015101210595389779361123_8DP266N882.jpg\",\"min_price\":\"7.50\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"158\",\"gdname\":\"好丽友 薯愿马铃薯膨化食品(烤鸡沙拉味) 104g/罐\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015101210581107283842454_6F44RJ0642.jpg\",\"min_price\":\"7.50\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"152\",\"gdname\":\"好丽友 好友趣 纯香原味 75g/袋\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015101210563606747406137_622R48T6TR.jpg\",\"min_price\":\"5.50\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"143\",\"gdname\":\"好丽友 好友趣韩国泡菜味 45g/袋\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015101210545398935596175_0L48H8680L.jpg\",\"min_price\":\"3.50\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"139\",\"gdname\":\"好丽友 薯愿马铃薯膨化食品(香烤原味) 104g/罐\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015101210532162764432787_688DHXNPX6.jpg\",\"min_price\":\"7.50\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"103\",\"gdname\":\"好丽友好友趣薯片(多汁牛排)45g/包\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015101210393792437561170_0H4R680X24.jpg\",\"min_price\":\"3.50\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"70\",\"gdname\":\"好丽友好友趣薯片45//包\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015101204251041128079727_B024TNXZFF.jpg\",\"min_price\":\"3.50\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"},{\"gdid\":\"52\",\"gdname\":\"好丽友好友趣韩国泡菜味 45/包\",\"gdnum\":\"0\",\"picture_url\":\"http://websystem.zhangxinshequ.com/userfile/2015101016541306718126802_4L846800ZZ.jpg\",\"min_price\":\"3.50\",\"praise_rate\":\"100%\",\"month_saled\":\"0\",\"orderCount\":\"0\"}]}],\"result\":\"\",\"status\":\"1\",\"msg\":\"\"}";
    public List<String> mString = new ArrayList<String>();// position+child
    private int mPosition; // 左侧控制右侧条目
    int count = 0; // 记录打开分组的变量
    private boolean isScroll = false; // 右侧是否滑动状态
    private ExampleAdapter adapterLeft; // 左侧适配器
    public static TestSectionedAdapter adapterRight;
    private List<String> mycat1 = new ArrayList<String>();// 总类目
    private List<List> mycat2 = new ArrayList<List>(); // 小类目分开显示
    public static List<List<GoodsListBean.Storegoodslist.Gdlist>> mycat3 = new ArrayList<List<GoodsListBean.Storegoodslist.Gdlist>>();// 商品列表
    private List<String> mycat22 = new ArrayList<String>();// 所有小类目

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mycat1.clear();
        mycat2.clear();
        mycat22.clear();
        mycat3.clear();
        mString.clear();
        adapterLeft = new ExampleAdapter(mycat1, mycat2, this);
        leftListview.setAdapter(adapterLeft);
        adapterRight = new TestSectionedAdapter(this, mycat2, mycat22, mycat3, adapterLeft);
        rightListView.setAdapter(adapterRight);
        getData();
    }

    private void getData() {
        Gson gson = new Gson();
        GoodsListBean goodsListBean = gson.fromJson(mJson,
                GoodsListBean.class);
        if (goodsListBean.getCategorylist() != null) {
            List<GoodsListBean.Categorylist> categorylist = goodsListBean
                    .getCategorylist();// 类目信息

            for (GoodsListBean.Categorylist categorylist2 : categorylist) {
                String categroyTitle = categorylist2
                        .getCategorytitle();// 获取大类目
                mycat1.add(categroyTitle);
                List<String> list = new ArrayList<String>();
                for (GoodsListBean.Categorylist.Categoryname name : categorylist2
                        .getCategoryname()) {
                    list.add(name.getCtname());// 小类目
                }
                mycat2.add(list);// 小类目完成
            }
        }
        if (goodsListBean.getStoregoodslist() != null) {
            List<GoodsListBean.Storegoodslist> storegoodslist = goodsListBean
                    .getStoregoodslist();
            for (GoodsListBean.Storegoodslist storegoodslist2 : storegoodslist) {
                List<GoodsListBean.Storegoodslist.Gdlist> gdlist = storegoodslist2
                        .getGdlist();
                mycat3.add(gdlist);// 商品添加完成
            }
        }
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
        for (List list : mycat2) {
            for (Object object : list) {
                mycat22.add(object.toString());
            }
        }
        /********************* 计算总的分类数目,遍历my2,并存入list,核心算法 *********************/
        for (int i = 0; i < mycat2.size(); i++) {
            for (int j = 0; j < mycat2.get(i).size(); j++) {
                String d = i + "." + j;
                mString.add(d);
            }
        }
        /***************************************************************************/
        adapterLeft.notifyDataSetChanged();
        adapterRight.notifyDataSetChanged();
        // 左侧默认打开
        if (mycat2.size() != 0) {
            leftListview.expandGroup(0);
            leftListview.setItemChecked(1, true);
        }

        leftListview.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @SuppressLint("NewApi")
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                System.out.println("listview:" + leftListview.getEmptyView());
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
                    System.out.println("truetruetruetruetruetrue");

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
