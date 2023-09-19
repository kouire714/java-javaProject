package AWT1;

import java.awt.Frame;

public class T1_Frame {
	
	public static void main(String[] args) {
		Frame frame = new Frame();
		
		frame.setTitle("AWT 연습");
		frame.setSize(400, 300); // (폭, 높이) : 픽셀단위
		
		frame.setVisible(true);
	}
}
