package Movie.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
/**
 * 
 * @author User
 * 로그인 클래스
 *
 */
public class Main extends JFrame{ // 로그인화면
	Image img = null;
	

	public Main(){
		JPanel p = new JPanel();
        p.setLayout(null);
        JLabel label = new JLabel(new ImageIcon("C:\\Users\\권하림\\Desktop\\2020_web_khr\\unnamed (1).png"));
		add(label);
		Label t1= new Label("안녕하세요.");
		add(t1);
		Label t2= new Label("CGV에 오신것을 환영합니다.");
		add(t2);
		Label b2= new Label("아이디");
		add(b2);
		Label b3= new Label("비밀번호");
		add(b3);
		TextField b4 = new TextField();
		add(b4);
		TextField b5 = new TextField();
		add(b5);
		b5.setEchoChar('*'); // 암호화
		JButton b6 = new JButton("로그인");
		add(b6);
		JButton b7 = new JButton("회원가입");
		add(b7);
		
		label.setBounds(0, -50, 400, 300);
		t1.setBounds(450, 40, 70, 40);
		t2.setBounds(450, 70, 280, 40);
		b2.setBounds(40, 265, 40, 40);
		b3.setBounds(40, 305, 60, 40);
		b4.setBounds(150, 265, 200, 30);
		b5.setBounds(150, 305, 200, 30);
		b6.setBounds(380, 265, 80, 30);
		b7.setBounds(380, 305, 90, 30);
		add(p);
		setSize(700, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("로그인 화면 ");
		setVisible(true);
		
		b7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {// 회원가입창으로 이동

				Join e2= new Join();
			}
		});;
		
		b6.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent a2) { // 로그인 할때 
				//Object o = a2.getSource();
				
				MemberDao dao;
				MemberVo vo;
				
				
				try {
					
					dao = MemberDao.getInstance();
					vo = new MemberVo();

					
					if (b4.getText().equals(vo.getId())
							&& b5.getText().equals(vo.getPassword1())){
					
						dao.loginMember(vo);
						JOptionPane.showMessageDialog(null, "");
					}
					
					else 
					{
						JOptionPane.showMessageDialog(null, "로그인 성공");
						Login e3 = new Login();
					}
					
//					dispose();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		
		});
	}
				

public static void main(String[] args) {//로그인화면으로 실행
	// TODO Auto-generated method stub
	Main e1 = new Main();
}
}


