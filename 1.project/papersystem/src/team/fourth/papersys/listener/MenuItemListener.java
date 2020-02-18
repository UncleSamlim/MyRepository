package team.fourth.papersys.listener;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import team.fourth.papersys.admin.ui.AddAndModifyPaperFrame;
import team.fourth.papersys.admin.ui.AddAndModifyUserFrame;
import team.fourth.papersys.operation.AbstractInfoOperation;
import team.fourth.papersys.operation.PaperInfoOperation;
import team.fourth.papersys.operation.UserInfoOperation;
import team.fourth.papersys.pojo.Newspaper;
import team.fourth.papersys.pojo.User;
import team.fourth.papersys.service.PaperService;
import team.fourth.papersys.service.UserService;
import team.fourth.papersys.util.UserGlobalObject;
import team.fourth.papersys.util.JFrameUtil;
import team.fourth.papersys.util.PaperGlobalObject;

public class MenuItemListener implements ActionListener{
	
	private String[] ids;
	private Object service;
	
	public MenuItemListener(String[] ids, Object service) {
		super();
		this.ids = ids;
		this.service = service;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem menuItem = (JMenuItem) e.getSource();
		if(service instanceof UserService) {
			// 得到滚动面板
			JScrollPane userPane = UserGlobalObject.getjScrollPane();
			// 由滚动面板得到总面板
			Container container = userPane.getParent();
			// 获取南部的面板
			JPanel southPane = (JPanel) container.getComponent(2);
			UserService userService = (UserService)service;
			AbstractInfoOperation operation = new UserInfoOperation();
			if("删除".equals(menuItem.getText())){
				int yesOrNo = JOptionPane.showConfirmDialog(menuItem, "是否确认删除?");
				// 点击确认删除
				if(yesOrNo == JOptionPane.OK_OPTION) {
					int result = userService.removeUserById(ids);
					if(result==ids.length) {
						JOptionPane.showMessageDialog(menuItem, "删除成功！", "操作成功", JOptionPane.OK_OPTION, new ImageIcon("img/correct-icon.png"));
						// 重载数据
						operation.reloadInfo(UserGlobalObject.getPageSize(), UserGlobalObject.getCurrentPage(), UserGlobalObject.getUsername(), UserGlobalObject.getPhone());
						// 重载动态标签内容
						operation.reloadLabelData(southPane);
					}else {
						JOptionPane.showMessageDialog(menuItem, "删除失败！", "操作失败", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
					}
				}
			}else {		// 修改
				JTable table = UserGlobalObject.getjTable();
				String userId = (String) table.getValueAt(table.getSelectedRow(),0);
				String firstName = "修改";
				String secondName = "取消";
				AddAndModifyUserFrame frame = new AddAndModifyUserFrame(firstName, secondName);
				User user = userService.findUserById(userId);
				if (user!=null) {
					// 回显信息
					frame.getIdLabel().setText(user.getUserId());;
					frame.getNameText().setText(user.getUsername());
					frame.getPswdText().setText(user.getPassword());
					frame.getPhoneText().setText(user.getPhone());
					if (user.getAge()!=null) {
						frame.getAgeText().setText(String.valueOf(user.getAge()));
					}else {
						frame.getAgeText().setText("");
					}
					frame.getJobText().setText(user.getJob());
					frame.getEmailText().setText(user.getEmail());
					if ("男".equals(user.getGender())) {
						frame.getMale().setSelected(true);
					}
					if ("女".equals(user.getGender())){
						frame.getFemale().setSelected(true);
					}
				}
				JFrameUtil.init(frame, 600, 600, JFrame.DISPOSE_ON_CLOSE);
			}
		}
		
		if(service instanceof PaperService) {
			// 得到滚动面板
			JScrollPane paperPane = PaperGlobalObject.getjScrollPane();
			// 由滚动面板得到总面板
			Container container = paperPane.getParent();
			// 获取南部的面板
			JPanel southPane = (JPanel) container.getComponent(2);
			PaperService paperService = (PaperService)service;
			AbstractInfoOperation infoOperation = new PaperInfoOperation();
			if("删除".equals(menuItem.getText())){
				int yesOrNo = JOptionPane.showConfirmDialog(menuItem, "是否确认删除?");
				// 点击确认删除
				if(yesOrNo == JOptionPane.OK_OPTION) {
					int result = paperService.removePaperById(ids);
					if(result==ids.length) {
						JOptionPane.showMessageDialog(menuItem, "删除成功！", "操作成功", JOptionPane.OK_OPTION, new ImageIcon("img/correct-icon.png"));
						// 重载数据
						infoOperation.reloadInfo(PaperGlobalObject.getPageSize(), PaperGlobalObject.getCurrentPage(), PaperGlobalObject.getPaperName(), PaperGlobalObject.getPublisher());
						// 重载动态标签内容
						infoOperation.reloadLabelData(southPane);
					}else {
						JOptionPane.showMessageDialog(menuItem, "删除失败！", "操作失败", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
					}
				}
			}else if ("修改".equals(menuItem.getText())){
				JTable table = PaperGlobalObject.getjTable();
				String paperId = (String) table.getValueAt(table.getSelectedRow(),0);
				String firstName = "修改";
				String secondName = "取消";
				AddAndModifyPaperFrame frame = new AddAndModifyPaperFrame(firstName, secondName);
				Newspaper paper = paperService.findPaperById(paperId);
				if (paper!=null) {
					// 回显信息
					frame.getIdLabel().setText(paper.getPaperId());;
					frame.getpNameText().setText(paper.getPaperName());
					frame.getCategorys().setSelectedItem(paper.getCategory());
					frame.getPublisherText().setText(paper.getPublisher());
					if (paper.getPrice()!=null) {
						frame.getPriceText().setText(String.valueOf(paper.getPrice()));
					}
					frame.getPublishNumberText().setText(paper.getPublishNumber());
					frame.getDateText().setText(paper.getPublishDate());
					if (paper.getStorageNum()!=null) {
						frame.getStorageText().setText(String.valueOf(paper.getStorageNum()));
					}
					frame.getFileText().setText(paper.getPaperImg());
				}
				JFrameUtil.init(frame, 600, 600, JFrame.DISPOSE_ON_CLOSE);
			}
		}
	}
	
}
