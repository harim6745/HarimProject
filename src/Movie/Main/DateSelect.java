package Movie.Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author User
 * ��¥ ���� Ŭ����
 *
 */
public class DateSelect extends JFrame implements ActionListener{


	//North

	JPanel topPane = new JPanel();

		JButton prevBtn = new JButton("��");
		JButton nextBtn = new JButton("��");
		
     	JLabel yearLbl = new JLabel("��");
		JLabel monthLbl = new JLabel("��");

		JComboBox<Integer> yearCombo = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>();

		JComboBox<Integer> monthCombo = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer>();

	//Center

		JPanel centerPane = new JPanel(new BorderLayout());
			JPanel titlePane = new JPanel(new GridLayout(1, 7));
				String titleStr[] = {"��", "��", "ȭ", "��", "��", "��", "��"};
			JPanel datePane = new JPanel(new GridLayout(0, 7));

	Calendar now;
	int year, month, date;

	
	public DateSelect() {

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	

		now = Calendar.getInstance();	// ���� ��¥
		year = now.get(Calendar.YEAR);
		month = now.get(Calendar.MONTH)+1;
		date = now.get(Calendar.DATE);

		topPane.add(prevBtn);

		for(int i = year - 5; i <= year + 5; i++){
			yearModel.addElement(i);
		}

		yearCombo.setModel(yearModel);
		yearCombo.setSelectedItem(year);	// ���� �⵵ ����
		topPane.add(yearCombo);
		topPane.add(yearLbl);


		for(int i=1; i<=12; i++){
			monthModel.addElement(i);
		}

		monthCombo.setModel(monthModel);
		monthCombo.setSelectedItem(month);	//���� �� ����
		
		topPane.add(monthCombo);
		topPane.add(monthLbl);
		topPane.add(nextBtn);	

		add(topPane, "North");

		//Center

		titlePane.setBackground(Color.white);

		for(int i=0; i<titleStr.length; i++){
			JLabel lbl = new JLabel(titleStr[i], JLabel.CENTER);
			if(i == 0){
				lbl.setForeground(Color.red);
			}else if(i == 6){
				lbl.setForeground(Color.blue);
			}
			titlePane.add(lbl);
		}
		centerPane.add(titlePane, "North");

		// ��¥ ���

		dayPrint(year, month);
		centerPane.add(datePane, "Center");

		add(centerPane, "Center");

		setTitle("��¥ ����");
		setSize(500, 400);
		setVisible(true);

		prevBtn.addActionListener(this);
		nextBtn.addActionListener(this);
		yearCombo.addActionListener(this);
		monthCombo.addActionListener(this);

	}

/**
 * ���� �޺��ڽ��� ��ư Ŭ�� �� ��� ����
 */
	public void actionPerformed(ActionEvent ae){

		Object obj = ae.getSource();

		if(obj instanceof JButton){

			JButton eventBtn = (JButton)obj;
			int yy = (Integer)yearCombo.getSelectedItem();
			int mm = (Integer)monthCombo.getSelectedItem();
			if(eventBtn.equals(prevBtn)){	//����

				if(mm==1){
					yy--; mm=12;
				}else{
					mm--;
				}				
			}else if(eventBtn.equals(nextBtn)){	//������

				if(mm==12){
					yy++; mm=1;
				}else{
					mm++;
				}

			}

			yearCombo.setSelectedItem(yy);
			monthCombo.setSelectedItem(mm);

		}else if(obj instanceof JComboBox){	// �޺��ڽ� �̺�Ʈ �߻���

			createDayStart();
		}

	}

	public void createDayStart(){

		datePane.setVisible(false);	//�г� �����
		datePane.removeAll();	//��¥ ����� �� �����
		dayPrint((Integer)yearCombo.getSelectedItem(), (Integer)monthCombo.getSelectedItem());
		datePane.setVisible(true);	//�г� �����				

	}

	

	public void dayPrint(int y, int m){

		Calendar cal = Calendar.getInstance();
		cal.set(y, m-1, 1);	// ����� ù���� ��ü �����.
		
		int week = cal.get(Calendar.DAY_OF_WEEK);	// 1�Ͽ� ���� ����	�Ͽ��� : 0
		int lastDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);	// �� ���� ������ ��
		for(int i=1; i<week; i++){	// ��¥ ��� �������� ���� ���

			datePane.add(new JLabel(" "));

		}

		for(int i=1; i<=lastDate; i++){

			JButton lbl = new JButton(String.valueOf(i));
			cal.set(y, m-1, i);

			int outWeek = cal.get(Calendar.DAY_OF_WEEK);
			if(outWeek==1){
				lbl.setForeground(Color.red);				
			}else if(outWeek==7){
				lbl.setForeground(Color.BLUE);
			}

			datePane.add(lbl);
			
			lbl.addActionListener(new ActionListener() { // �¼� ��������
				@Override
				public void actionPerformed(ActionEvent A) {
						SeatSelect e7 = new SeatSelect ();
				}
		});
		}

	}	

	public static void main(String[] args) {

		new DateSelect();

	}

}