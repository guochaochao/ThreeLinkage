package com.gcc.three.bean;

import java.util.List;

/**
 * Created by user on 2017/3/31.
 */

public class CateListbean {

    private List<BigcatelistBean> bigcatelist;

    public List<BigcatelistBean> getBigcatelist() {
        return bigcatelist;
    }

    public void setBigcatelist(List<BigcatelistBean> bigcatelist) {
        this.bigcatelist = bigcatelist;
    }

    public static class BigcatelistBean {
        /**
         * categorytitle : 速食速冻
         * categorynum : 0
         * categorylist : [{"gdname":"火腿香肠","gdnum":"0","gdlist":[{"gdid":"5992","gdname":"双汇泡面搭档火腿肠40g/个","gdnum":"0","picture_url":"http://websystem.zhangxinshequ.com/userfile/2015120910293545622412465_V4ZFL80T4J.jpg","min_price":"1.00","praise_rate":"100%","month_saled":"0","orderCount":"0"},{"gdid":"5989","gdname":"双汇王中王香肠70g/个","gdnum":"0","picture_url":"http://websystem.zhangxinshequ.com/userfile/2015120910281001539478858_B6PR00FH86.jpg","min_price":"2.00","praise_rate":"100%","month_saled":"0","orderCount":"0"},{"gdid":"5946","gdname":"双汇润口香甜王玉米风味香肠270g/袋 9只","gdnum":"0","picture_url":"http://websystem.zhangxinshequ.com/userfile/2015120909440354093585346_ZH204P0004.jpg","min_price":"7.00","praise_rate":"100%","month_saled":"0","orderCount":"0"},{"gdid":"5942","gdname":"双汇香脆肠150g/个","gdnum":"0","picture_url":"http://websystem.zhangxinshequ.com/userfile/2015120909371696736040031_Z2TVR42020.jpg","min_price":"4.00","praise_rate":"100%","month_saled":"0","orderCount":"0"},{"gdid":"5929","gdname":"双汇王中王38g/个","gdnum":"0","picture_url":"http://websystem.zhangxinshequ.com/userfile/2015120908481605359345467_VPFJ640N6V.jpg","min_price":"1.00","praise_rate":"100%","month_saled":"0","orderCount":"0"},{"gdid":"5927","gdname":"双汇王中王105g/个","gdnum":"0","picture_url":"http://websystem.zhangxinshequ.com/userfile/2015120908445667310113987_28DZ60NJL4.jpg","min_price":"3.00","praise_rate":"100%","month_saled":"0","orderCount":"0"},{"gdid":"337","gdname":"双汇润口香甜王玉米风味香肠48g","gdnum":"0","picture_url":"http://websystem.zhangxinshequ.com/userfile/2015110710385470916634515_LT866NX24B.jpg","min_price":"1.00","praise_rate":"100%","month_saled":"0","orderCount":"0"}]},{"gdname":"泡面","gdnum":"0","gdlist":[{"gdid":"5992","gdname":"泡面1","gdnum":"0","picture_url":"http://websystem.zhangxinshequ.com/userfile/2015120910293545622412465_V4ZFL80T4J.jpg","min_price":"1.00","praise_rate":"100%","month_saled":"0","orderCount":"0"},{"gdid":"5989","gdname":"泡面2","gdnum":"0","picture_url":"http://websystem.zhangxinshequ.com/userfile/2015120910281001539478858_B6PR00FH86.jpg","min_price":"2.00","praise_rate":"100%","month_saled":"0","orderCount":"0"},{"gdid":"5946","gdname":"泡面3","gdnum":"0","picture_url":"http://websystem.zhangxinshequ.com/userfile/2015120909440354093585346_ZH204P0004.jpg","min_price":"7.00","praise_rate":"100%","month_saled":"0","orderCount":"0"},{"gdid":"5942","gdname":"泡面4","gdnum":"0","picture_url":"http://websystem.zhangxinshequ.com/userfile/2015120909371696736040031_Z2TVR42020.jpg","min_price":"4.00","praise_rate":"100%","month_saled":"0","orderCount":"0"},{"gdid":"5929","gdname":"泡面5","gdnum":"0","picture_url":"http://websystem.zhangxinshequ.com/userfile/2015120908481605359345467_VPFJ640N6V.jpg","min_price":"1.00","praise_rate":"100%","month_saled":"0","orderCount":"0"},{"gdid":"5927","gdname":"泡面6","gdnum":"0","picture_url":"http://websystem.zhangxinshequ.com/userfile/2015120908445667310113987_28DZ60NJL4.jpg","min_price":"3.00","praise_rate":"100%","month_saled":"0","orderCount":"0"},{"gdid":"337","gdname":"泡面7","gdnum":"0","picture_url":"http://websystem.zhangxinshequ.com/userfile/2015110710385470916634515_LT866NX24B.jpg","min_price":"1.00","praise_rate":"100%","month_saled":"0","orderCount":"0"}]}]
         */

        private String categorytitle;
        private String categorynum;
        private List<CategorylistBean> categorylist;

        public String getCategorytitle() {
            return categorytitle;
        }

        public void setCategorytitle(String categorytitle) {
            this.categorytitle = categorytitle;
        }

        public String getCategorynum() {
            return categorynum;
        }

        public void setCategorynum(String categorynum) {
            this.categorynum = categorynum;
        }

        public List<CategorylistBean> getCategorylist() {
            return categorylist;
        }

        public void setCategorylist(List<CategorylistBean> categorylist) {
            this.categorylist = categorylist;
        }

        public static class CategorylistBean {
            /**
             * gdname : 火腿香肠
             * gdnum : 0
             * gdlist : [{"gdid":"5992","gdname":"双汇泡面搭档火腿肠40g/个","gdnum":"0","picture_url":"http://websystem.zhangxinshequ.com/userfile/2015120910293545622412465_V4ZFL80T4J.jpg","min_price":"1.00","praise_rate":"100%","month_saled":"0","orderCount":"0"},{"gdid":"5989","gdname":"双汇王中王香肠70g/个","gdnum":"0","picture_url":"http://websystem.zhangxinshequ.com/userfile/2015120910281001539478858_B6PR00FH86.jpg","min_price":"2.00","praise_rate":"100%","month_saled":"0","orderCount":"0"},{"gdid":"5946","gdname":"双汇润口香甜王玉米风味香肠270g/袋 9只","gdnum":"0","picture_url":"http://websystem.zhangxinshequ.com/userfile/2015120909440354093585346_ZH204P0004.jpg","min_price":"7.00","praise_rate":"100%","month_saled":"0","orderCount":"0"},{"gdid":"5942","gdname":"双汇香脆肠150g/个","gdnum":"0","picture_url":"http://websystem.zhangxinshequ.com/userfile/2015120909371696736040031_Z2TVR42020.jpg","min_price":"4.00","praise_rate":"100%","month_saled":"0","orderCount":"0"},{"gdid":"5929","gdname":"双汇王中王38g/个","gdnum":"0","picture_url":"http://websystem.zhangxinshequ.com/userfile/2015120908481605359345467_VPFJ640N6V.jpg","min_price":"1.00","praise_rate":"100%","month_saled":"0","orderCount":"0"},{"gdid":"5927","gdname":"双汇王中王105g/个","gdnum":"0","picture_url":"http://websystem.zhangxinshequ.com/userfile/2015120908445667310113987_28DZ60NJL4.jpg","min_price":"3.00","praise_rate":"100%","month_saled":"0","orderCount":"0"},{"gdid":"337","gdname":"双汇润口香甜王玉米风味香肠48g","gdnum":"0","picture_url":"http://websystem.zhangxinshequ.com/userfile/2015110710385470916634515_LT866NX24B.jpg","min_price":"1.00","praise_rate":"100%","month_saled":"0","orderCount":"0"}]
             */

            private String gdname;
            private String gdnum;
            private List<GdlistBean> gdlist;

            public String getGdname() {
                return gdname;
            }

            public void setGdname(String gdname) {
                this.gdname = gdname;
            }

            public String getGdnum() {
                return gdnum;
            }

            public void setGdnum(String gdnum) {
                this.gdnum = gdnum;
            }

            public List<GdlistBean> getGdlist() {
                return gdlist;
            }

            public void setGdlist(List<GdlistBean> gdlist) {
                this.gdlist = gdlist;
            }

            public static class GdlistBean {
                /**
                 * gdid : 5992
                 * gdname : 双汇泡面搭档火腿肠40g/个
                 * gdnum : 0
                 * picture_url : http://websystem.zhangxinshequ.com/userfile/2015120910293545622412465_V4ZFL80T4J.jpg
                 * min_price : 1.00
                 * praise_rate : 100%
                 * month_saled : 0
                 * orderCount : 0
                 */

                private String gdid;
                private String gdname;
                private String gdnum;
                private String picture_url;
                private String min_price;
                private String praise_rate;
                private String month_saled;
                private String orderCount;

                public String getGdid() {
                    return gdid;
                }

                public void setGdid(String gdid) {
                    this.gdid = gdid;
                }

                public String getGdname() {
                    return gdname;
                }

                public void setGdname(String gdname) {
                    this.gdname = gdname;
                }

                public String getGdnum() {
                    return gdnum;
                }

                public void setGdnum(String gdnum) {
                    this.gdnum = gdnum;
                }

                public String getPicture_url() {
                    return picture_url;
                }

                public void setPicture_url(String picture_url) {
                    this.picture_url = picture_url;
                }

                public String getMin_price() {
                    return min_price;
                }

                public void setMin_price(String min_price) {
                    this.min_price = min_price;
                }

                public String getPraise_rate() {
                    return praise_rate;
                }

                public void setPraise_rate(String praise_rate) {
                    this.praise_rate = praise_rate;
                }

                public String getMonth_saled() {
                    return month_saled;
                }

                public void setMonth_saled(String month_saled) {
                    this.month_saled = month_saled;
                }

                public String getOrderCount() {
                    return orderCount;
                }

                public void setOrderCount(String orderCount) {
                    this.orderCount = orderCount;
                }
            }
        }
    }
}
