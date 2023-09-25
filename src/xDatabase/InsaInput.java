package xDatabase;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class InsaInput extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdMale, rdFemale;
	private JButton btnInput, btnReset, btnClose;

	InsaDAO dao = new InsaDAO();
	InsaVO vo = null;
	
	int res = 0;

	public InsaInput() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		
		setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 760, 64);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회 원 가 입 폼");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 736, 44);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 84, 760, 390);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblName = new JLabel("성    명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("굴림", Font.PLAIN, 22));
		lblName.setBounds(138, 42, 158, 45);
		pn2.add(lblName);
		
		JLabel lblName_1 = new JLabel("나    이");
		lblName_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1.setFont(new Font("굴림", Font.PLAIN, 22));
		lblName_1.setBounds(138, 127, 158, 45);
		pn2.add(lblName_1);
		
		JLabel lblName_2 = new JLabel("성    별");
		lblName_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_2.setFont(new Font("굴림", Font.PLAIN, 22));
		lblName_2.setBounds(138, 216, 158, 45);
		pn2.add(lblName_2);
		
		JLabel lblName_3 = new JLabel("입 사 일");
		lblName_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_3.setFont(new Font("굴림", Font.PLAIN, 22));
		lblName_3.setBounds(138, 307, 158, 45);
		pn2.add(lblName_3);
		
		txtName = new JTextField();
		txtName.setFont(new Font("굴림", Font.PLAIN, 22));
		txtName.setBounds(327, 42, 290, 45);
		pn2.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("굴림", Font.PLAIN, 22));
		txtAge.setColumns(10);
		txtAge.setBounds(327, 127, 290, 45);
		pn2.add(txtAge);
		
		rdMale = new JRadioButton("남  자");
		rdMale.setSelected(true);
		rdMale.setFont(new Font("굴림", Font.PLAIN, 22));
		rdMale.setBounds(327, 216, 99, 45);
		buttonGroup.add(rdMale);
		pn2.add(rdMale);
		
		rdFemale = new JRadioButton("여  자");
		rdFemale.setFont(new Font("굴림", Font.PLAIN, 22));
		rdFemale.setBounds(490, 216, 99, 45);
		buttonGroup.add(rdFemale);
		pn2.add(rdFemale);
		
		String[] yy = new String[24];
		String[] mm = new String[12];
		String[] dd = new String[31];
		
		int imsi;
		for(int i=0; i<yy.length; i++) {
			imsi = i + 2000;
			yy[i] = imsi + "";
		}
		for(int i=0; i<mm.length; i++) {
			mm[i] = (i+1) + "";
		}
		for(int i=0; i<dd.length; i++) {
			dd[i] = (i+1) + "";
		}
		
		
		JComboBox cbYY = new JComboBox(yy);
		cbYY.setFont(new Font("굴림", Font.PLAIN, 20));
		cbYY.setBounds(308, 307, 86, 30);
		pn2.add(cbYY);
		
		JComboBox cbMM = new JComboBox(mm);
		cbMM.setFont(new Font("굴림", Font.PLAIN, 20));
		cbMM.setBounds(454, 307, 62, 30);
		pn2.add(cbMM);
		
		JComboBox cbDD = new JComboBox(dd);
		cbDD.setFont(new Font("굴림", Font.PLAIN, 20));
		cbDD.setBounds(584, 307, 53, 30);
		pn2.add(cbDD);
		
		JLabel lblYY = new JLabel("년");
		lblYY.setFont(new Font("굴림", Font.PLAIN, 22));
		lblYY.setBounds(400, 307, 42, 30);
		pn2.add(lblYY);
		
		JLabel lblMM = new JLabel("월");
		lblMM.setFont(new Font("굴림", Font.PLAIN, 22));
		lblMM.setBounds(528, 307, 42, 30);
		pn2.add(lblMM);
		
		JLabel lblDD = new JLabel("일");
		lblDD.setFont(new Font("굴림", Font.PLAIN, 22));
		lblDD.setBounds(649, 307, 42, 30);
		pn2.add(lblDD);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 487, 760, 64);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		btnInput = new JButton("가입하기");
		btnInput.setFont(new Font("굴림", Font.PLAIN, 22));
		btnInput.setBounds(59, 10, 174, 44);
		pn3.add(btnInput);
		
		btnReset = new JButton("다시입력");
		btnReset.setFont(new Font("굴림", Font.PLAIN, 22));
		btnReset.setBounds(292, 10, 174, 44);
		pn3.add(btnReset);
		
		btnClose = new JButton("창 닫 기");
		btnClose.setFont(new Font("굴림", Font.PLAIN, 22));
		btnClose.setBounds(525, 10, 174, 44);
		pn3.add(btnClose);
		
		/* ================================================ */
		
		// 회원가입 버튼
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String age = txtAge.getText();
				String gender;
				String ipsail = cbYY.getSelectedItem()+"-"+cbMM.getSelectedItem()+"-"+cbDD.getSelectedItem();
				
				if(name.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "성명을 입력하세요?");
					txtName.requestFocus();
				}
				else if(age.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "나이를 입력하세요?");
					txtAge.requestFocus();
				}
				else {
					if(!Pattern.matches("^[0-9]*$", age)) {
						JOptionPane.showMessageDialog(null, "나이는 숫자로 입력하세요?");
						txtAge.requestFocus();
					}
					else {
						if(rdMale.isSelected()) gender = "남자";
						else gender = "여자";
						
						// 모든 체크가 끝나면 DB에 새로운 회원을 가입처리한다.
						// 회원명 중복처리
						vo = dao.getNameSearch(name);
						if(vo.getName() != null) {
							JOptionPane.showMessageDialog(null, "이미 가입된 회원입니다. 다시 입력하세요");
							txtName.requestFocus();
						}
						else {
							// 정상적으로 자료가 입력되었다면 vo에 담아있는 값을 DB에 저장한다.
							vo.setName(name);
							vo.setAge(Integer.parseInt(age));
							vo.setGender(gender);
							vo.setIpsail(ipsail);
							
							// vo에 담긴 자료를 DB에 저장시켜준다.
							res = dao.setInsaInput(vo);
							
							if(res == 0) {
								JOptionPane.showMessageDialog(null, "회원가입실패~~. 다시 가입하세요");
								txtName.requestFocus();
							}
							else {
								JOptionPane.showMessageDialog(null, "회원에 가입되셨습니다.");
								
								// 다음 입력자료 처리를 위한 준비....
//								txtName.setText("");
//								txtAge.setText("");
//								rdMale.setSelected(true);
//								txtName.requestFocus();
								btnReset.doClick();
							}
						}
					}
				}
			}
		});
		
		// 다시입력 버튼
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtAge.setText("");
				rdMale.setSelected(true);
				
				// 오늘 날짜로 입사일을 채우기...
				InsaService service = new InsaService();
				vo = service.getDefaultDate();
				
				// vo에 가져온 날짜데이터를 날짜 콤보상자에 넣어준다.
				cbYY.setSelectedItem(vo.getStrYY());
				cbMM.setSelectedItem(vo.getStrMM());
				cbDD.setSelectedItem(vo.getStrDD());
				
				txtName.requestFocus();
			}
		});
		
		// 창닫기 버튼
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
				dispose();
			}
		});
	}
	
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InsaInput frame = new InsaInput();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		
		new InsaInput();
//		frame.setVisible(true);
	}
}
