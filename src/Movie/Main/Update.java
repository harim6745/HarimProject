package Movie.Main;

import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class Update extends JFrame{ // ���� Ŭ�� ��
	public Update(){
	JPanel p = new JPanel();
    p.setLayout(null);
    Label l1= new Label("���̵�");
    Label l2 = new Label("��й�ȣ");
    Label l3= new Label("��й�ȣ Ȯ��");
    Label l4 = new Label("�޴��� ��ȣ");

    add(l1);
    add(l2);
    add(l3);
    add(l4);

    TextField t1 = new TextField();
    TextField t2 = new TextField();
    TextField t3 = new TextField();
    TextField t4 = new TextField();
    t2.setEchoChar('*');
    t3.setEchoChar('*');
    add(t1);
    add(t2);
    add(t3);
    add(t4);

    t1.setEditable(false);

    JButton j1 = new JButton("����");
    JButton j2 = new JButton("���");
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
setSize(400, 400);
setTitle("����");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

try { // ���� �� ȸ������ �ҷ�����
	   String s;

	   
	   } catch (Exception e2) { 
	   e2.printStackTrace(); 
	}

j1.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e7) {// �����Ѱ��� �ٽ� ����

		try{

			 JOptionPane.showMessageDialog(null, "�����Ͽ����ϴ�."); 
        } catch (Exception ex) { 
        JOptionPane.showMessageDialog(null, "���忡 �����Ͽ����ϴ�."); 
     } 
		}
});

j2.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {

		setVisible(false);
	}
});
	}
	public static void main(String[] args) {
		new Update();
	}
}