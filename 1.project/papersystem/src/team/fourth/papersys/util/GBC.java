package team.fourth.papersys.util;

import java.awt.GridBagConstraints;
import java.awt.Insets;

//GBC类继承GridBagConstraints，简化对GridBagConstraints对象的操作
public class GBC extends GridBagConstraints {

	private static final long serialVersionUID = 1L;

	public GBC() {}
	
	// 初始化左上角位置和所占的行数和列数,gridx=0、gridy=0时放在0行0列。
	public GBC(int gridx, int gridy, int gridwidth, int gridheight) {
		this.gridx = gridx;
		this.gridy = gridy;
		this.gridwidth = gridwidth;
		this.gridheight = gridheight;
	}
	
	// gridwidth、gridheight用来设置组件所占的单位长度与高度，默认值皆为1。
	public GBC setGridWH(int gridwidth, int gridheight) {
		this.gridwidth = gridwidth;
		this.gridheight = gridheight;
		return this;
	}
	
	// 设置组件在单元格中的对齐方式
	public GBC setAnchor(int anchor) {
		this.anchor = anchor;
		return this;
	}

	// 是否拉伸及拉伸方向，当某个组件未能填满单元格时，可由此属性设置横向、纵向或双向填满
	public GBC setFill(int fill) {
		this.fill = fill;
		return this;
	}

	// x和y方向上的增量
	public GBC setWeight(double weightx, double weighty) {
		this.weightx = weightx;
		this.weighty = weighty;
		return this;
	}
	
	// 设置左上角的位置
	public GBC setGridXY(int gridx, int gridy) {
		this.gridx = gridx;
		this.gridy = gridy;
		return this;
	}

	
	// 外部填充
	public GBC setInsets(int distance) {
		this.insets = new Insets(distance, distance, distance, distance);
		return this;
	}

	// 外填充
	public GBC setInsets(int top, int left, int bottom, int right) {
		this.insets = new Insets(top, left, bottom, right);
		return this;
	}

	// 内填充
	public GBC setIpad(int ipadx, int ipady) {
		this.ipadx = ipadx;
		this.ipady = ipady;
		return this;
	}
	
}
