package xDatabase;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class InsaSearch extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdMale, rdFemale;
	private JButton btnUpdate, btnDelete, btnClose;

	InsaDAO dao = new InsaDAO();
	InsaVO vo = null;
	
	int res = 0;

	public InsaSearch(InsaVO vo) {
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
		
		JLabel lblNewLabel = new JLabel("회원 개별조회(검색할 성명을 입력하세요)");
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
		txtName.setEditable(false);
		txtName.setFont(new Font("굴림", Font.PLAIN, 22));
		txtName.setBounds(327, 42, 290, 45);
		txtName.setText(vo.getName());
		pn2.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("굴림", Font.PLAIN, 22));
		txtAge.setColumns(10);
		txtAge.setBounds(327, 127, 290, 45);
		txtAge.setText(vo.getAge() + "");
		pn2.add(txtAge);
		
		rdMale = new JRadioButton("남  자");
		rdMale.setSelected(true);
		rdMale.setFont(new Font("굴림", Font.PLAIN, 22));
		rdMale.setBounds(327, 216, 99, 45);
		buttonGroup.add(rdMale);
		
		if(vo.getGender().equals("남자")) rdMale.setSelected(true);
		
		pn2.add(rdMale);
		
		rdFemale = new JRadioButton("여  자");
		rdFemale.setFont(new Font("굴림", Font.PLAIN, 22));
		rdFemale.setBounds(490, 216, 99, 45);
		buttonGroup.add(rdFemale);
		
		if(vo.getGender().equals("여자")) rdFemale.setSelected(true);
		
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
		
//		String[] ymds = vo.getIpsail().substring(0, 10).split("-");	// 2023-09-21
//		if(ymds[1].substring(0,1).equals("0")) ymds[1] = ymds[1].substring(1);
//		if(ymds[2].substring(0,1).equals("0")) ymds[2] = ymds[2].substring(1);
		
		// LocalDate currentDate = LocalDate.now();
		// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-M-d");
		// String strDate = currentDate.format(dtf);
		// System.out.println("strDate : " + strDate);
		
		//System.out.println("vo.getIpsail() : " + vo.getIpsail());					// 기존에 저장된 날짜형식의 문자열 자료.
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-M-d");	// 2023-09-02 을 2023-9-2로 변환하기하기위한 준비
		LocalDate date = LocalDate.parse(vo.getIpsail().substring(0, 10),dtf);	// vo.getIpsail()안의 날짜시간자료를 날짜만 뽑아서 앞에서 정의한 포멧으로 변경하면서 날짜형으로 저장시켰다.
		//System.out.println("date타입 : " + date);
		String strDate = date.format(dtf);			// 날짜형식의 자료를 문자로 변경시켜주고 있다.
		//System.out.println("strDate : " + strDate);
		
		String[] ymds = strDate.split("-");	// 2023-9-2
		//System.out.println(ymds[0] + "-" + ymds[1] + "-" + ymds[2]);
		
		JComboBox cbYY = new JComboBox(yy);
		cbYY.setFont(new Font("굴림", Font.PLAIN, 20));
		cbYY.setBounds(308, 307, 86, 30);
		cbYY.setSelectedItem(ymds[0]);
		pn2.add(cbYY);
		
		JComboBox cbMM = new JComboBox(mm);
		cbMM.setFont(new Font("굴림", Font.PLAIN, 20));
		cbMM.setBounds(454, 307, 62, 30);
		cbMM.setSelectedItem(ymds[1]);
		pn2.add(cbMM);
		
		JComboBox cbDD = new JComboBox(dd);
		cbDD.setFont(new Font("굴림", Font.PLAIN, 20));
		cbDD.setBounds(584, 307, 53, 30);
		cbDD.setSelectedItem(ymds[2]);
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
		
		btnUpdate = new JButton("수정하기");
		btnUpdate.setFont(new Font("굴림", Font.PLAIN, 22));
		btnUpdate.setBounds(59, 10, 174, 44);
		pn3.add(btnUpdate);
		
		btnDelete = new JButton("삭제하기");
		btnDelete.setFont(new Font("굴림", Font.PLAIN, 22));
		btnDelete.setBounds(292, 10, 174, 44);
		pn3.add(btnDelete);
		
		btnClose = new JButton("창 닫 기");
		btnClose.setFont(new Font("굴림", Font.PLAIN, 22));
		btnClose.setBounds(525, 10, 174, 44);
		pn3.add(btnClose);
		
		/* ================================================ */
		
		// 회원정보수정 버튼
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String age = txtAge.getText();
				String gender;
				String ipsail = cbYY.getSelectedItem()+"-"+cbMM.getSelectedItem()+"-"+cbDD.getSelectedItem();
				
				if(age.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "나이를 입력하세요.");
					txtAge.requestFocus();
				}
				else {
					if(rdMale.isSelected()) gender = "남자";
					else gender = "여자";
					
					// 정상적으로 수정할 자료가 입력되어 넘어온다면 모든값을 vo에 담아서 DB에 저장(수정)처리한다.
					vo.setName(txtName.getText());
					vo.setAge(Integer.parseInt(age));
					vo.setGender(gender);
					vo.setIpsail(ipsail);
					
					res = dao.setInsaUpdate(vo);
					if(res == 0) {
						JOptionPane.showMessageDialog(null, "회원정보 수정실패~~. 다시 수정하세요");
					}
					else {
						JOptionPane.showMessageDialog(null, "회원정보가 수정되었습니다.");
					}
				}
			}
		});
		
		// 삭제 버튼
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				
				int ans = JOptionPane.showConfirmDialog(null, name + "회원을 삭제하시겠습니까?","회원삭제",JOptionPane.YES_NO_OPTION);
				if(ans == 0) {
					res = dao.setInsaDelete(name);
					if(res == 0) JOptionPane.showMessageDialog(null, "회원 삭제 실패~~. 확인 하세요");
					else {
						JOptionPane.showMessageDialog(null, "회원정보가 삭제되었습니다.");
						dispose();
					}
				}
				else JOptionPane.showMessageDialog(null, "회원삭제 취소!!");
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
	
}
