package obj;

public class Bookinfo {
	private String paper_id;

	private String category;// 报刊类别

	private String book_name;

	private String publisher;// 出版社

	private double price;

	private String publishnumber;

	private String publishdate;

	private String img;

	private int storagenum;// 库存

	public String getPaper_id() {
		return paper_id;
	}

	public void setPaper_id(String paper_id) {
		this.paper_id = paper_id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBookName() {
		return book_name;
	}

	public void setBookName(String book_name) {
		this.book_name = book_name;
	}

	public String getPublishing() {
		return publisher;
	}

	public void setPublishing(String publisher) {
		this.publisher = publisher;
	}

	public double getPrice() {
		return price;
	}

	public double setPrice(double price) {
		return this.price = price;
	}

	public String getPublishnumber() {
		return publishnumber;
	}

	public void setPublishnumber(String publishnumber) {
		this.publishnumber = publishnumber;
	}

	public String getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getStoragenum() {
		return storagenum;
	}

	public int setStoragenum(int storagenum) {
		return this.storagenum = storagenum;
	}
}