package project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;

public class Server_book_add {

	private JFrame frame;
	private JTextField txt_name;
	private JTextField txt_author;
	private JTextField txt_pulic;
	private JTextField txt_img;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server_book_add window = new Server_book_add();
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
	
	Controller control = new Controller();
	private JTextField txt_borrow_book;
	public Server_book_add() {
		initialize();
		control.connect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(965, 200, 952, 622);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("메이플스토리", Font.BOLD, 18));
		textArea.setBounds(224, 278, 558, 210);
		textArea.setOpaque(false);
		textArea.setBorder(null);
		frame.getContentPane().add(textArea);
		
		txt_borrow_book = new JTextField();
		txt_borrow_book.setFont(new Font("메이플스토리", Font.BOLD, 18));
		txt_borrow_book.setBorder(null);
		txt_borrow_book.setOpaque(false);
		txt_borrow_book.setBounds(650, 89, 108, 33);
		frame.getContentPane().add(txt_borrow_book);
		txt_borrow_book.setColumns(10);
		
		txt_name = new JTextField();
		txt_name.setFont(new Font("메이플스토리", Font.BOLD, 18));
		txt_name.setOpaque(false);
		txt_name.setBorder(null);
		txt_name.setBounds(224, 89, 231, 33);
		frame.getContentPane().add(txt_name);
		txt_name.setColumns(10);
		
		txt_author = new JTextField();
		txt_author.setFont(new Font("메이플스토리", Font.BOLD, 18));
		txt_author.setOpaque(false);
		txt_author.setBorder(null);
		txt_author.setColumns(10);
		txt_author.setBounds(224, 146, 231, 33);
		frame.getContentPane().add(txt_author);
		
		txt_pulic = new JTextField();
		txt_pulic.setFont(new Font("메이플스토리", Font.BOLD, 18));
		txt_pulic.setOpaque(false);
		txt_pulic.setBorder(null);
		txt_pulic.setColumns(10);
		txt_pulic.setBounds(650, 146, 132, 33);
		frame.getContentPane().add(txt_pulic);
		
		txt_img = new JTextField();
		txt_img.setFont(new Font("메이플스토리", Font.BOLD, 18));
		txt_img.setOpaque(false);
		txt_img.setBorder(null);
		txt_img.setColumns(10);
		txt_img.setBounds(224, 206, 523, 33);
		frame.getContentPane().add(txt_img);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Server_book_add.class.getResource("/image/book_add_1.png")));
		lblNewLabel.setBounds(0, 0, 936, 583);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btn_book_add = new JButton("");
		btn_book_add.setOpaque(false);
		btn_book_add.setBorder(null);
		btn_book_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String name	= txt_name.getText();
			String author = txt_author.getText();
			String publicher = txt_pulic.getText();
			String image = txt_img.getText();
			String story = textArea.getText();
			int book_borrow = Integer.parseInt(txt_borrow_book.getText());
			
			control.book_insert(name, author, publicher, image, story, book_borrow);
			
			JOptionPane.showMessageDialog(null, "추가완료");
			
			frame.dispose();
			bookManagement.main(null);
				
			}
		});
		btn_book_add.setBounds(414, 516, 132, 33);
		frame.getContentPane().add(btn_book_add);
		
		JButton btn_back = new JButton("");
		btn_back.setOpaque(false);
		btn_back.setBorder(null);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Server_main.main(null);
			}
		});
		btn_back.setBounds(346, 10, 55, 48);
		frame.getContentPane().add(btn_back);
	}
}
