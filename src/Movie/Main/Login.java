package Movie.Main;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.json.simple.parser.ParseException;
/**
 * 
 * @author User
 * 로그인 성공 후 확인 클래스
 *
 */
public class Login extends JFrame{ // 로그인 성공시
	public Login(){
	JPanel p = new JPanel();
    Label l1= new Label("아이디");
    Label l2 = new Label("비밀번호");
    Label l3= new Label("비밀번호 확인");
    Label l4 = new Label("휴대폰 번호");

    add(l1);
    add(l2);
    add(l3);
    add(l4);

    TextField t1 = new TextField();
    TextField t2 = new TextField();
    TextField t3 = new TextField();
    t2.setEchoChar('*');
    t3.setEchoChar('*');
    TextField t4 = new TextField();
    TextField t5 = new TextField();
    add(t1);
    add(t2);
    add(t3);
    add(t4);

    t1.setEditable(false);
    t2.setEditable(false);
    t3.setEditable(false);
    t4.setEditable(false);

    JButton j1 = new JButton("확인");
    JButton j2 = new JButton("수정");
    
    add(j1);
    add(j2);
    l1.setBounds(20, 10, 80, 40);
    l2.setBounds(20, 50, 80, 40);
    l3.setBounds(20, 90, 80,40);
    l4.setBounds(20, 130, 80, 40);

    t1.setBounds(120, 10, 200, 30);
    t2.setBounds(120, 50, 200, 30);
    t3.setBounds(120, 90, 200, 30);
    t4.setBounds(120, 130, 200, 30);

    j1.setBounds(100, 200, 80, 30);
    j2.setBounds(200, 200, 80, 30);
    
    try { // 로그인하고 회원정보 데이터 입력
 	   String s; 
  

 	   } catch (Exception e2) { 
 	   e2.printStackTrace(); 
 	} 
 	   
 	   
add(p);
setSize(400,400);
setTitle("로그인 성공");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

/**
 * 확인 버튼 클릭 후 영화 리스트 클래스로
 */
j1.addActionListener(new ActionListener() {// 영화 리스트로
	@Override
	public void actionPerformed(ActionEvent a3) {
			try {
				MovieSelect s = new MovieSelect ();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
});
j2.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent a4) {// 수정 버튼 눌렀을 때
		// TODO Auto-generated method stub
		Update e4 = new Update();
	}
});
	}
	
	public static void main(String[] args) {
		new Login();
	}
}