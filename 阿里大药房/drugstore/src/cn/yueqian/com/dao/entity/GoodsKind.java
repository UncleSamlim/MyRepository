package cn.yueqian.com.dao.entity;

public class GoodsKind {
	private int id;
	private String kindName;
	private int superKind;
	
	public GoodsKind() {
		super();
	}
	
	public GoodsKind(int id, String kindName, int superKind) {
		super();
		this.id = id;
		this.kindName = kindName;
		this.superKind = superKind;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKindName() {
		return kindName;
	}
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	public int getSuperKind() {
		return superKind;
	}
	public void setSuperKind(int superKind) {
		this.superKind = superKind;
	}

	@Override
	public String toString() {
		return "goodskind [id=" + id + ", kindName=" + kindName + ", superKind=" + superKind + "]";
	}

	@Override
	public boolean equals(Object arg0) {
		GoodsKind obj = (GoodsKind)arg0;
		boolean isYes =false;
		if(this.kindName.equals(obj.kindName)){
			isYes=true;
		}
		return isYes;
	}

	@Override
	public int hashCode() {
		
		return 12316132;
	}
	
	
}
