package y_JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class T6_fileUpload3 extends JFrame {
	
  private JLabel lblImage;
  private JMenuBar mb;
  private JMenu fileMenu, helpMenu;
  private JMenuItem openItem, exitItem, aboutItem, helpItem;
  private JFileChooser chooser;
  
  public T6_fileUpload3() {
    setTitle("Menu와 JFileChooser 활용  예제");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    
    createMenu();
    setSize(300,200);
    getContentPane().setLayout(null);
    
    JPanel panel = new JPanel();
    panel.setBounds(12, 10, 260, 118);
    getContentPane().add(panel);
    panel.setLayout(null);
    
    lblImage = new JLabel("");
    lblImage.setBounds(0, 0, 260, 118);
    panel.add(lblImage);
    setVisible(true);
  }
  
  public void createMenu() {
    mb = new JMenuBar();							// 1.메뉴바생성
    fileMenu = new JMenu("File");			// 2.주메뉴만들기
    openItem = new JMenuItem("Open");	// 3.부메뉴만들기
    
    fileMenu.add(openItem);						// 4.부메뉴를 주메뉴에 올리기
    mb.add(fileMenu);									// 5.주메뉴를 메뉴바에 올리기
    
    exitItem = new JMenuItem("Exit");	// 3.부메뉴만들기
    fileMenu.add(exitItem);											// 4.부메뉴를 주메뉴에 올리기
    
    setJMenuBar(mb);									// 6.메뉴바를 컨텐트팬에 부착하기
    
    helpMenu = new JMenu("Help");
    mb.add(helpMenu);
    
    aboutItem = new JMenuItem("About...");
    helpMenu.add(aboutItem);
    
    helpItem = new JMenuItem("Help...");
    helpMenu.add(helpItem);
    
    // Open 메뉴아이템에 Action 리스너를 등록한다.(Open 메뉴아이템을 클릭시 수행)
    openItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chooser= new JFileChooser(); // 파일 다이얼로그 생성
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "JPG & GIF Images", // 파일 이름 창에 출력될 문자열
            "jpg", "gif"); // 파일 필터로 사용되는 확장자. *.jpg. *.gif만 나열됨
				chooser.setFileFilter(filter); // 파일 다이얼로그에 파일 필터 설정
				
				// 파일 다이얼로그 출력
				int ret = chooser.showOpenDialog(null);
				if(ret != JFileChooser.APPROVE_OPTION) { // 사용자가  창을 강제로 닫았거나 취소 버튼을 누른 경우
			    JOptionPane.showMessageDialog(null,"파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
				}
				else {
				  // 사용자가 파일을 선택하고 "열기" 버튼을 누른 경우
				  String filePath = chooser.getSelectedFile().getPath(); // 파일 경로명을 알아온다.
				  lblImage.setIcon(new ImageIcon(filePath)); // 파일을 로딩하여 이미지 레이블에 출력한다.
				  //System.out.println("filePath : " + filePath);
				  //pack(); // 이미지의 크기에 맞추어 프레임의 크기 조절
				  
				  // 파일 업로드하기
				  try {
						//URL imgURL = new URL(imageURL);		// URL을 통한 파일 가져오기
				  	File imageFile = new File(filePath);	// 파일시스템에서 가져온 정보로 파일객체 생성하기
						String fileName = filePath.substring(filePath.lastIndexOf("\\")+1); // 파일명+확장자 구하기
						String extension = filePath.substring(filePath.lastIndexOf(".")+1); // 확장자 구하기
						//System.out.println("fileName : " + fileName);
						
						BufferedImage image = ImageIO.read(imageFile);
						File file = new File("myImage/" + fileName);
						if(!file.exists()) { // 해당 경로의 폴더가 존재하지 않을 경우
							file.mkdirs(); // 해당 경로의 폴더 생성
						}
						
						ImageIO.write(image, extension, file); // image를 file로 업로드
						System.out.println("이미지 업로드 완료!");
						JOptionPane.showMessageDialog(null, "이미지 업로드 완료!!");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				  
				}
			}
    });
    
    // Exit메뉴아이템 클릭시..
    exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
    });
    
    
    // About메뉴아이템 클릭시..
    aboutItem.addActionListener(new ActionListener() {
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		JOptionPane.showMessageDialog(null, "Version 1.0.1");
    	}
    });
    
    // Help메뉴아이템 클릭시..
    helpItem.addActionListener(new ActionListener() {
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		JOptionPane.showMessageDialog(null, "무엇을 도와드릴까?");
    	}
    });
    
    
  }
	
	public static void main(String[] args) {
		new T6_fileUpload3();
	}
}
