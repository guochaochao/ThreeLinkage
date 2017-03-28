package com.gcc.three.bean;

import java.util.List;

/**
 * @Description:商品列表信息
 * @author GCC
 * @date 2016-4-8 下午6:38:55
 * @version V1.0
 */

public class GoodsListBean {
	private String orderdelivery_price;
	private List<Categorylist> categorylist;// 类目信息
	private List<Storegoodslist> Storegoodslist;// 具体商品信息
	private String result;
	private String status;
	private String msg;

	public void setOrderdeliveryPrice(String orderdeliveryPrice) {
		this.orderdelivery_price = orderdeliveryPrice;
	}

	public String getOrderdeliveryPrice() {
		return orderdelivery_price;
	}

	public void setCategorylist(List<Categorylist> categorylist) {
		this.categorylist = categorylist;
	}

	public List<Categorylist> getCategorylist() {
		return categorylist;
	}

	public void setStoregoodslist(List<Storegoodslist> storegoodslist) {
		this.Storegoodslist = storegoodslist;
	}

	public List<Storegoodslist> getStoregoodslist() {
		return Storegoodslist;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	/***************************************************/
	public class Categorylist {

		private String categorytitle;// 大类目
		private String categorynum;
		private List<Categoryname> categoryname;

		public void setCategorytitle(String categorytitle) {
			this.categorytitle = categorytitle;
		}

		public String getCategorytitle() {
			return categorytitle;
		}

		public void setCategorynum(String categorynum) {
			this.categorynum = categorynum;
		}

		public String getCategorynum() {
			return categorynum;
		}

		public void setCategoryname(List<Categoryname> categoryname) {
			this.categoryname = categoryname;
		}

		public List<Categoryname> getCategoryname() {
			return categoryname;
		}

		// 大类目中的小类目
		public class Categoryname {

			private String ctname;

			public void setCtname(String ctname) {
				this.ctname = ctname;
			}

			public String getCtname() {
				return ctname;
			}

		}
	}

	/***********************************/
	public class Storegoodslist {

		private String gdname;
		private String gdnum;
		private List<Gdlist> gdlist;

		public void setGdname(String gdname) {
			this.gdname = gdname;
		}

		public String getGdname() {
			return gdname;
		}

		public void setGdnum(String gdnum) {
			this.gdnum = gdnum;
		}

		public String getGdnum() {
			return gdnum;
		}

		public void setGdlist(List<Gdlist> gdlist) {
			this.gdlist = gdlist;
		}

		public List<Gdlist> getGdlist() {
			return gdlist;
		}

		// 单个商品列表
		public class Gdlist {

			private String gdid;
			private String gdname;
			private String gdnum;
			private String picture_url;
			private String min_price;
			private String praise_rate;
			private String month_saled;
			private String orderCount;

			public void setGdid(String gdid) {
				this.gdid = gdid;
			}

			public String getGdid() {
				return gdid;
			}

			public void setGdname(String gdname) {
				this.gdname = gdname;
			}

			public String getGdname() {
				return gdname;
			}

			public void setGdnum(String gdnum) {
				this.gdnum = gdnum;
			}

			public String getGdnum() {
				return gdnum;
			}

			public void setPictureUrl(String pictureUrl) {
				this.picture_url = pictureUrl;
			}

			public String getPictureUrl() {
				return picture_url;
			}

			public void setMinPrice(String minPrice) {
				this.min_price = minPrice;
			}

			public String getMinPrice() {
				return min_price;
			}

			public void setPraiseRate(String praiseRate) {
				this.praise_rate = praiseRate;
			}

			public String getPraiseRate() {
				return praise_rate;
			}

			public void setMonthSaled(String monthSaled) {
				this.month_saled = monthSaled;
			}

			public String getMonthSaled() {
				return month_saled;
			}

			public void setOrdercount(String ordercount) {
				this.orderCount = ordercount;
			}

			public String getOrdercount() {
				return orderCount;
			}

		}
	}
}
