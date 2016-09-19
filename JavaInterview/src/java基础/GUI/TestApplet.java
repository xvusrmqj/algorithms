package java基础.GUI;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JApplet;

public class TestApplet extends JApplet {

	@Override
	public void init() {
		setLayout(new FlowLayout());
		add(new Button("xxx"));
		add(new Button("yyy"));
	}

	@Override
	public void start() {

	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(3, 3, 200, 300);
	}

	@Override
	public void stop() {

	}

	@Override
	public void destroy() {

	}
}
