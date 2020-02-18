package team.fourth.papersys.pojo;

public class OrderItem {
	private Newspaper paper;
	private Order order;
	private Integer num;

	public Newspaper getPaper() {
		return paper;
	}

	public void setPaper(Newspaper paper) {
		this.paper = paper;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}