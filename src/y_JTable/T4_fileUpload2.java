package y_JTable;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class T4_fileUpload2 {
	public static void main(String[] args) {
		String imageURL = "https://blog.kakaocdn.net/dn/VIxFi/btqZqqf3QFS/n2otuLtHQo8TQVOwMAmmbk/img.png";
		
		try {
			URL imgURL = new URL(imageURL);
			String extension = imageURL.substring(imageURL.lastIndexOf(".")+1); // 확장자
			String fileName = "나를_업로드_해봐"; // 이미지 이름
			
			BufferedImage image = ImageIO.read(imgURL);
			File file = new File("myImage/" + fileName + "." + extension);
			if(!file.exists()) { // 해당 경로의 폴더가 존재하지 않을 경우
				file.mkdirs(); // 해당 경로의 폴더 생성
			}
			
			ImageIO.write(image, extension, file); // image를 file로 업로드
			System.out.println("이미지 업로드 완료!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
