package Movie.Main;

import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 
 * @author User
 * 회원가입 클래스
 *
 */
public class Join extends JFrame {// 회원가입화면
	public Join(){
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
	        TextField t4 = new TextField();

	        add(t1);
	        add(t2);
	        add(t3);
	        add(t4);
	        
	        t2.setEchoChar('*');
	        t3.setEchoChar('*');
	        
	        JButton j1 = new JButton("가입");
	        JButton j2 = new JButton("취소");
	        
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
	        
	    add(p);
		setSize(400,400);
		setTitle("회원가입");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);
       
/**
 * 회원가입 클릭 시 기능 구현
 */
       j1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent T) { // 회원가입 데이터 저장
			

			MemberDao dao = null;
			MemberVo vo;

			try{
				
				dao = MemberDao.getInstance();
				vo = new MemberVo();
				
				vo.setId(t1.getText().trim());
				vo.setPassword1(t2.getText().trim());
			    vo.setPassword2(t3.getText().trim());
			    vo.setPhone(t4.getText().trim());
				dao.insertMember(vo);
				
				JOptionPane.showMessageDialog(null, "회원가입을 축하합니다!!");
				dispose();
			} catch (Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
			}
		}

	});
       
       
       j2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Main e1 = new Main();
			
		}
	});
	}    
}


