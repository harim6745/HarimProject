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
 * 좌석 GUI 클래스
 *
 */
public class SeatSelect extends JFrame{
	
	public SeatSelect () {
		setTitle("좌석 선택");
		setDefaultCloseOperation(3);
		setBounds(100, 100, 500, 500);
		setLayout(new BorderLayout());
		
		JButton screen = new JButton("스크린");
		screen.setBackground(Color.white);
		
		JButton west = new JButton("통로");
		JButton east = new JButton("통로");
		
		add(screen, BorderLayout.NORTH);
		add(new SeatGrid(), BorderLayout.CENTER);
		
        JButton j1 = new JButton("선택");

        
        add(j1, BorderLayout.SOUTH);

        
        j1.setBounds(125, 420, 60, 30);

		
		setVisible(true);
	}
	
	/**
	 * 
	 * @author User
	 * 좌석버튼 Grid 생성
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



