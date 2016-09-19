package java基础.GUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestAWT {
	public static void main(String[] args) {
		CreateDialog();
	}
	//创建基本窗口
	private static void CreateWindow() {
		Frame f = new Frame();// frame is a window
		f.setBounds(30,30,250,250);
		f.setVisible(true);
	}
	//创建复杂点的窗口
	private static void CreateWindowWithPanel() {
		Frame f = new Frame();// frame is a window, use BorderLayout default.
		
		Panel p = new Panel();// panel is a ViewGroup, use FlowLayout default.
		p.add(new Button("btn"));
		p.add(new TextField(20));
		f.add(p,BorderLayout.NORTH);
		
		f.add(new TextArea("hello"), BorderLayout.CENTER);
		f.setBounds(30,30,250,250);
		f.setVisible(true);
	}
	//创建带对话框的窗口。
	private static void CreateDialog() {
		Frame f = new Frame();
		Button b1 = new Button("b1");
		Button b2 = new Button("b2");
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//模式对话框, 当前对话框不消息，所属窗口不能得焦点
				new Dialog(f, "模式对话框", true).setVisible(true);
			}
		});
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//非模式对话框, 当前对话框不消息，所属窗口能得焦点
				new Dialog(f, "非模式对话框", false).setVisible(true);
			}
		});
		f.add(b1, BorderLayout.NORTH);
		f.add(b2, BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
}
