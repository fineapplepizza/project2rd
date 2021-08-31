package project;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.ComponentOrientation;

public class bookManagement {

	private JFrame frame;
	private JTextField txtSearch;

	// Tableview에서 사용될 ArrayList생성
	ArrayList<bookManagementVO> list = new ArrayList<>();
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bookManagement window = new bookManagement();
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
	public bookManagement() {
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

		JCheckBox chc_book_num = new JCheckBox("New check box");
		chc_book_num.setBounds(174, 134, 15, 23);
		chc_book_num.setOpaque(false);
		chc_book_num.setBorder(null);
		frame.getContentPane().add(chc_book_num);

		JCheckBox chc_author = new JCheckBox("New check box");
		chc_author.setOpaque(false);
		chc_author.setBorder(null);
		chc_author.setBounds(92, 159, 15, 23);
		frame.getContentPane().add(chc_author);

		JCheckBox chc_public = new JCheckBox("New check box");
		chc_public.setOpaque(false);
		chc_public.setBorder(null);
		chc_public.setBounds(174, 159, 15, 23);
		frame.getContentPane().add(chc_public);

		JCheckBox chc_book_name = new JCheckBox("New check box");
		chc_book_name.setBorder(null);
		chc_book_name.setOpaque(false);
		chc_book_name.setBounds(92, 134, 21, 23);
		frame.getContentPane().add(chc_book_name);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 263, 830, 288);
		frame.getContentPane().add(scrollPane);
		Controller controll = new Controller();
		table = new JTable();
		String[] col = { "제목", "저자", "출판사", "내용", "대출여부" };
		ArrayList<bookManagementVO> list = controll.book_selectAll();
		Object[][] data = new Object[list.size()][5];

		// list의 내용을 JTable에 저장하기 -> 실제 data에 삽입
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (j == 0) {
					data[i][j] = list.get(i).getName(); // 아이디
				}
				if (j == 1) {
					data[i][j] = list.get(i).getAuthor();
				}
				if (j == 2) {
					data[i][j] = list.get(i).getPublisher();
				}
				if (j == 3) {
					data[i][j] = list.get(i).getStory();
				}
				if (j == 4) {
					data[i][j] = list.get(i).getBorrow_book();
				}
			}
		}

		table_1 = new JTable(data, col);
		table_1.setFont(new Font("메이플스토리", Font.BOLD, 15));
		scrollPane.setViewportView(table_1);

		txtSearch = new JTextField();
		txtSearch.setFont(new Font("메이플스토리", Font.BOLD, 18));
		// 테두리 없애기 setBorder(null)
		txtSearch.setBorder(null);
		txtSearch.setBounds(277, 144, 504, 27);
		frame.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);

		JLabel lblManagement = new JLabel("New label");
		lblManagement.setFont(new Font("굴림", Font.PLAIN, 19));
		lblManagement.setIcon(new ImageIcon(bookManagement.class.getResource("/image/book_mg.png")));
		lblManagement.setBounds(0, 0, 934, 584);
		frame.getContentPane().add(lblManagement);

		JButton btnSearch = new JButton("");
		btnSearch.setOpaque(false);
		btnSearch.setBorder(null);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String sc = txtSearch.getText();

				controll.book_search(sc);

				String[] col = { "제목", "저자", "출판사", "내용", "대출여부" };
				Controller controll = new Controller();
				ArrayList<bookManagementVO> list = controll.book_search(sc);
				Object[][] data = new Object[list.size()][5];

				// list의 내용을 JTable에 저장하기 -> 실제 data에 삽입
				for (int i = 0; i < data.length; i++) {
					for (int j = 0; j < data[i].length; j++) {
						if (j == 0) {
							data[i][j] = list.get(i).getName(); // 아이디
						}
						if (j == 1) {
							data[i][j] = list.get(i).getAuthor();
						}
						if (j == 2) {
							data[i][j] = list.get(i).getPublisher();
						}
						if (j == 3) {
							data[i][j] = list.get(i).getStory();
						}
						if (j == 4) {
							data[i][j] = list.get(i).getStory();
						}
					}
				}

				table = new JTable(data, col);
				scrollPane.setViewportView(table);

			}
		});
		btnSearch.setFont(new Font("굴림", Font.BOLD, 18));
		// 버튼 투명하게 만들기
		btnSearch.setOpaque(false);
		btnSearch.setBounds(804, 137, 55, 42);
		frame.getContentPane().add(btnSearch);

		JButton btnChange = new JButton("");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				bookChange.main(null);
			}
		});
		// 버튼투명하게 만들기
		btnChange.setOpaque(false);
		btnChange.setBorder(null);
		btnChange.setBounds(733, 200, 55, 42);
		frame.getContentPane().add(btnChange);

		JButton btnAdd = new JButton("");
		btnAdd.setOpaque(false);
		btnAdd.setBorder(null);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 도서추가 창 띄우기
				Server_book_add add = new Server_book_add();
				add.main(null);
				frame.dispose();
			}
		});

		btnAdd.setOpaque(false);
		btnAdd.setBounds(804, 200, 50, 42);
		frame.getContentPane().add(btnAdd);

		JButton btnNewButton = new JButton("");

		btnNewButton.setOpaque(false);
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Server_main.main(null);
			}
		});
		btnNewButton.setBounds(423, 10, 97, 55);

		frame.getContentPane().add(btnNewButton);

		JButton btnDelete = new JButton("");
		btnDelete.setBorder(null);
		btnDelete.setOpaque(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();

				int col = table.getSelectedColumn();
				Object value = table.getValueAt(row, col);
				controll.delete_book(value);

				frame.dispose();
				bookManagement.main(null);

			}
		});
		// 버튼투명하게 만들기
		btnDelete.setOpaque(false);
		btnDelete.setBounds(666, 200, 55, 42);
		frame.getContentPane().add(btnDelete);

	}
}
