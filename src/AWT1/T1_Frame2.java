package AWT1;

import java.awt.Frame;

@SuppressWarnings("serial")
public class T1_Frame2 extends Frame {
	
	public T1_Frame2() {
		super("프레임 테스트");
		setSize(400, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
//		Frame frame = new Frame();
//		
//		frame.setTitle("AWT 연습");
//		frame.setSize(400, 300); // (폭, 높이) : 픽셀단위
//		
//		frame.setVisible(true);
		
		new T1_Frame2();
	}
}
