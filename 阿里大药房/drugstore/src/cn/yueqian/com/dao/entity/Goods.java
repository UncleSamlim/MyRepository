package cn.yueqian.com.dao.entity;

public class Goods {
	private int id;
	private String name;
	private double price;
	private double previousPrice;
	private String pic;
	private String shortDescription;
	private String longDesctiption;
	private int catscore;
	private int goodsKindId;
	private int saleamount;
	private int amount;
	
	public Goods() {
		super();
	}

	public Goods(int id, String name, double price, double previousPrice, String pic, String shortDescription,
			String longDesctiption, int catscore, int goodsKindId, int saleamount, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.previousPrice = previousPrice;
		this.pic = pic;
		this.shortDescription = shortDescription;
		this.longDesctiption = longDesctiption;
		this.catscore = catscore;
		this.goodsKindId = goodsKindId;
		this.saleamount = saleamount;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPreviousPrice() {
		return previousPrice;
	}

	public void setPreviousPrice(double previousPrice) {
		this.previousPrice = previousPrice;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDesctiption() {
		return longDesctiption;
	}

	public void setLongDesctiption(String longDesctiption) {
		this.longDesctiption = longDesctiption;
	}

	public int getCatscore() {
		return catscore;
	}

	public void setCatscore(int catscore) {
		this.catscore = catscore;
	}

	public int getGoodsKindId() {
		return goodsKindId;
	}

	public void setGoodsKindId(int goodsKindId) {
		this.goodsKindId = goodsKindId;
	}

	public int getSaleamount() {
		return saleamount;
	}

	public void setSaleamount(int saleamount) {
		this.saleamount = saleamount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", previousPrice=" + previousPrice + ", pic="
				+ pic + ", shortDescription=" + shortDescription + ", longDesctiption=" + longDesctiption
				+ ", catscore=" + catscore + ", goodsKindId=" + goodsKindId + ", saleamount=" + saleamount + ", amount="
				+ amount + "]";
	}
	

}
