package java基础.GUI;

import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TestSwing {
	public static void main(String[] args) {
		createDialogUseJOptionPane();
	}
	private static void createWindow(){
		JFrame f = new JFrame("jframe...");
		String currentPath = TestSwing.class.getResource("").getPath();
		Icon icon = new ImageIcon(currentPath+"true.png" );//FIXME 不知道为什么这里设置icon不起作用
		JButton b = new JButton("btn", icon);
		f.add(b,BorderLayout.NORTH);
		f.add(new JButton("btn"),BorderLayout.CENTER);
		f.add(new JTextField("textfield"),BorderLayout.SOUTH);
		f.setBounds(30,30,250,250);
		f.setVisible(true);
	}
	private static void createDialogUseJOptionPane(){
		String msg = JOptionPane.showInputDialog("pleaseInput");
		JOptionPane.showMessageDialog(null, msg);
		JOptionPane.showConfirmDialog(null, "1+1=2? please confirm");
	}
}
