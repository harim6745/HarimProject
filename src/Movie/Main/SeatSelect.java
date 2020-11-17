package Movie.Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author User
 * �¼� GUI Ŭ����
 *
 */
public class SeatSelect extends JFrame{
	
	public SeatSelect () {
		setTitle("�¼� ����");
		setDefaultCloseOperation(3);
		setBounds(100, 100, 500, 500);
		setLayout(new BorderLayout());
		
		JButton screen = new JButton("��ũ��");
		screen.setBackground(Color.white);
		
		JButton west = new JButton("���");
		JButton east = new JButton("���");
		
		add(screen, BorderLayout.NORTH);
		add(new SeatGrid(), BorderLayout.CENTER);
		
        JButton j1 = new JButton("����");

        
        add(j1, BorderLayout.SOUTH);

        
        j1.setBounds(125, 420, 60, 30);

		
		setVisible(true);
	}
	
	/**
	 * 
	 * @author User
	 * �¼���ư Grid ����
	 *
	 */
	class SeatGrid extends JPanel {
		
		SeatGrid() {
			setSize(20, 20);
			
			setLayout(new FlowLayout(0, 40, 40));
			char alpa = 65; // A


			for (int i = 0; i < 5; ++i) {
				String alpaseat = String.valueOf(alpa);
			for (int j = 0; j < 5; ++j) {

				add(new JButton(alpaseat + (j+1) + ""));
	}
			alpa ++;
			}
			

			setVisible(true);
		}
	}

			
	public static void main(String[] args) {
		new SeatSelect();
	
}
	
}



