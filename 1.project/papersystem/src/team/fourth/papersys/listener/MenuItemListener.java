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
			// �õ��������
			JScrollPane userPane = UserGlobalObject.getjScrollPane();
			// �ɹ������õ������
			Container container = userPane.getParent();
			// ��ȡ�ϲ������
			JPanel southPane = (JPanel) container.getComponent(2);
			UserService userService = (UserService)service;
			AbstractInfoOperation operation = new UserInfoOperation();
			if("ɾ��".equals(menuItem.getText())){
				int yesOrNo = JOptionPane.showConfirmDialog(menuItem, "�Ƿ�ȷ��ɾ��?");
				// ���ȷ��ɾ��
				if(yesOrNo == JOptionPane.OK_OPTION) {
					int result = userService.removeUserById(ids);
					if(result==ids.length) {
						JOptionPane.showMessageDialog(menuItem, "ɾ���ɹ���", "�����ɹ�", JOptionPane.OK_OPTION, new ImageIcon("img/correct-icon.png"));
						// ��������
						operation.reloadInfo(UserGlobalObject.getPageSize(), UserGlobalObject.getCurrentPage(), UserGlobalObject.getUsername(), UserGlobalObject.getPhone());
						// ���ض�̬��ǩ����
						operation.reloadLabelData(southPane);
					}else {
						JOptionPane.showMessageDialog(menuItem, "ɾ��ʧ�ܣ�", "����ʧ��", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
					}
				}
			}else {		// �޸�
				JTable table = UserGlobalObject.getjTable();
				String userId = (String) table.getValueAt(table.getSelectedRow(),0);
				String firstName = "�޸�";
				String secondName = "ȡ��";
				AddAndModifyUserFrame frame = new AddAndModifyUserFrame(firstName, secondName);
				User user = userService.findUserById(userId);
				if (user!=null) {
					// ������Ϣ
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
					if ("��".equals(user.getGender())) {
						frame.getMale().setSelected(true);
					}
					if ("Ů".equals(user.getGender())){
						frame.getFemale().setSelected(true);
					}
				}
				JFrameUtil.init(frame, 600, 600, JFrame.DISPOSE_ON_CLOSE);
			}
		}
		
		if(service instanceof PaperService) {
			// �õ��������
			JScrollPane paperPane = PaperGlobalObject.getjScrollPane();
			// �ɹ������õ������
			Container container = paperPane.getParent();
			// ��ȡ�ϲ������
			JPanel southPane = (JPanel) container.getComponent(2);
			PaperService paperService = (PaperService)service;
			AbstractInfoOperation infoOperation = new PaperInfoOperation();
			if("ɾ��".equals(menuItem.getText())){
				int yesOrNo = JOptionPane.showConfirmDialog(menuItem, "�Ƿ�ȷ��ɾ��?");
				// ���ȷ��ɾ��
				if(yesOrNo == JOptionPane.OK_OPTION) {
					int result = paperService.removePaperById(ids);
					if(result==ids.length) {
						JOptionPane.showMessageDialog(menuItem, "ɾ���ɹ���", "�����ɹ�", JOptionPane.OK_OPTION, new ImageIcon("img/correct-icon.png"));
						// ��������
						infoOperation.reloadInfo(PaperGlobalObject.getPageSize(), PaperGlobalObject.getCurrentPage(), PaperGlobalObject.getPaperName(), PaperGlobalObject.getPublisher());
						// ���ض�̬��ǩ����
						infoOperation.reloadLabelData(southPane);
					}else {
						JOptionPane.showMessageDialog(menuItem, "ɾ��ʧ�ܣ�", "����ʧ��", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
					}
				}
			}else if ("�޸�".equals(menuItem.getText())){
				JTable table = PaperGlobalObject.getjTable();
				String paperId = (String) table.getValueAt(table.getSelectedRow(),0);
				String firstName = "�޸�";
				String secondName = "ȡ��";
				AddAndModifyPaperFrame frame = new AddAndModifyPaperFrame(firstName, secondName);
				Newspaper paper = paperService.findPaperById(paperId);
				if (paper!=null) {
					// ������Ϣ
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
