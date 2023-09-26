package y_JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class T3_fileUpload extends JFrame {
  private JLabel imageLabel;
  private JFileChooser chooser;
  private JMenuBar menubar;
  private JMenu fileMenu, helpMenu;
  private JMenuItem openItem, exitItem;
  private JMenuItem aboutItem, helpItem;
  
  public T3_fileUpload() {
    setTitle("Menu와 JFileChooser 활용  예제");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    
    imageLabel = new JLabel();
    
    createMenu();
    setSize(300,200);
    setVisible(true);
  }
  
  /* 메뉴 만드는 순서
    1. JMenuBar 객체로 메뉴바를 만든다.
    2. JMenu객체로 주메뉴를 만든다.
    3. JMenuItem객체로 부메뉴를 만든다.
    4. 부메뉴를 주메뉴에 얻는다.
    5. 주메뉴를 메뉴바에 얻는다.
    6. 메뉴바를 컨텐트팬에 부착시킨다.
  */
  public void createMenu() {
    menubar = new JMenuBar();					// 1.메뉴바만들기
    fileMenu = new JMenu("File");			// 2.주메뉴만들기
    openItem = new JMenuItem("Open");	// 3.부메뉴만들기
    exitItem = new JMenuItem("Exit");	// 3.부메뉴만들기
    
    fileMenu.add(openItem);						// 4.부메뉴를 주메뉴에 얻는다.
    fileMenu.add(exitItem);						// 4.부메뉴를 주메뉴에 얻는다.
    menubar.add(fileMenu);						// 5.주메뉴를 메뉴바에 얻는다.
    setJMenuBar(menubar);							// 6.메뉴바를 컨텐트팬에 부착시킨다.
    
    helpMenu = new JMenu("Help");			// 2.주메뉴만들기
    menubar.add(helpMenu);						// 5.주메뉴를 메뉴바에 얻는다.
    
    aboutItem = new JMenuItem("About...");	// 3.부메뉴만들기
    helpMenu.add(aboutItem);								// 4.부메뉴를 주메뉴에 얻는다.
    
    helpItem = new JMenuItem("Help...");		// 3.부메뉴만들기
    helpMenu.add(helpItem);									// 4.부메뉴를 주메뉴에 얻는다.
    
    /* ===================================================================== */
    
    // Open 메뉴아이템에 Action 리스너를 등록한다.(Open메뉴아이템 클릭시 수행)
    openItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chooser= new JFileChooser(); // 파일 다이얼로그 생성
				
				// 파일 필터 설정하기
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "JPG & GIF Images", // 파일 이름 창에 출력될 문자열
            "jpg", "gif"); // 파일 필터로 사용되는 확장자. *.jpg. *.gif만 나열됨
				
				chooser.setFileFilter(filter); // 파일 다이얼로그에 파일 필터 적용하기
				
				// 파일 다이얼로그 출력
				int dialog = chooser.showOpenDialog(null);
				if(dialog != JFileChooser.APPROVE_OPTION) { // 사용자가  창을 강제로 닫았거나 취소 버튼을 누른 경우
				    JOptionPane.showMessageDialog(null,"파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
				}
				else {
				  // 사용자가 파일을 선택하고 "열기" 버튼을 누른 경우
				  String filePath = chooser.getSelectedFile().getPath(); // 파일 경로명을 알아온다.
				  imageLabel.setIcon(new ImageIcon(filePath)); // 파일을 로딩하여 이미지 레이블에 출력한다.
				  System.out.println("filePath : " + filePath);
				  //pack(); // 이미지의 크기에 맞추어 프레임의 크기 조절
				}
			}
    });
    
    // exit 메뉴 클릭시 수행
    exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
    
    // About 메뉴아이템 클릭시 수행
    aboutItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "버전 1.0.1");
			}
		});
    
    // Help 메뉴아이템 클릭시 수행
    helpItem.addActionListener(new ActionListener() {
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		JOptionPane.showMessageDialog(null, "무엇을 도와 드릴까요???");
    	}
    });

  }
  
  public static void main(String[] args) {
		new T3_fileUpload();
	}
}
