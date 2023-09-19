package AWT1;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class T4_Button extends Frame implements WindowListener, ActionListener {

	public T4_Button() {
		super("프레임 테스트");
		// setSize(400, 300);
		setBounds(300, 300, 400, 300);
		
		// 이름표(Label) : 레이블 컴포넌트
		Label lbl = new Label("회 원 가 입 품");
		this.add(lbl);
		
		// 버튼 컴포넌트
		Button btnExit = new Button("종 료");
		add(btnExit);
		
		setVisible(true);
		
		/* ----------------------------------------- */
	
		btnExit.addActionListener(this);
		
		addWindowListener(this);
	}
	
	public static void main(String[] args) {
		new T4_Button();
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
