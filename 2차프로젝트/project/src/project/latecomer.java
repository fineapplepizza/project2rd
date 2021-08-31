package project;

import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class latecomer {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					latecomer window = new latecomer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public latecomer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(965, 200, 952, 622);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 167, 824, 364);
		frame.getContentPane().add(scrollPane);
		
		Controller control = new Controller();
		ArrayList<latecomerVO>list = control.latecomer();
		Object col[] = {"ID","도서제목","대여일자","반납일자","반납여부"};
		Object data[][] = new Object[list.size()][5];
		
		for(int i= 0;i<data.length;i++) {
			for(int j=0;j<data[i].length;j++) {
				if(j==0) {
					data[i][j] = list.get(i).getId();
				}if(j==1) {
					data[i][j] = list.get(i).getName();
				}if(j==2) {
					data[i][j] = list.get(i).getBookRental();
				}if(j==3) {
					data[i][j] = list.get(i).getBookreturn();
				}if(j==4) {
					data[i][j] = list.get(i).getReturnStatus();
				}
			}
		}

		
		table = new JTable(data, col);
		scrollPane.setViewportView(table);
		
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\SM2130\\eclipse-workspace\\project\\src\\image\\manager_dateover.png"));
		lblNewLabel.setBounds(0, 0, 936, 583);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btn_back = new JButton("");
		btn_back.setOpaque(false);
		btn_back.setBorder(null);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.dispose();
			Server_main.main(null);
				
			}
		});
		btn_back.setBounds(329, 10, 97, 51);
		frame.getContentPane().add(btn_back);
	}
}
