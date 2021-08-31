package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;

public class bookChange {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtBorrow_book;
	private JTextField txtAuthor;
	private JTextField txtPublisher;
	private JTextField txtImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bookChange window = new bookChange();
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
	private JTextArea textArea;
	public bookChange() {
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
		
		textArea = new JTextArea();
		textArea.setFont(new Font("메이플스토리", Font.BOLD, 20));
		textArea.setLineWrap(true);
		textArea.setBorder(null);
		textArea.setOpaque(false);
		textArea.setBounds(219, 273, 571, 220);
		frame.getContentPane().add(textArea);
		
		txtName = new JTextField();
		txtName.setFont(new Font("메이플스토리", Font.BOLD, 18));
		txtName.setOpaque(false);
		txtName.setBorder(null);
		txtName.setBounds(219, 87, 256, 30);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtBorrow_book = new JTextField();
		txtBorrow_book.setFont(new Font("메이플스토리", Font.BOLD, 18));
		txtBorrow_book.setOpaque(false);
		txtBorrow_book.setBorder(null);
		txtBorrow_book.setBounds(649, 87, 107, 30);
		frame.getContentPane().add(txtBorrow_book);
		txtBorrow_book.setColumns(10);
		
		txtAuthor = new JTextField();
		txtAuthor.setFont(new Font("메이플스토리", Font.BOLD, 18));
		txtAuthor.setOpaque(false);
		txtAuthor.setBorder(null);
		txtAuthor.setBounds(219, 144, 256, 30);
		frame.getContentPane().add(txtAuthor);
		txtAuthor.setColumns(10);
		
		txtPublisher = new JTextField();
		txtPublisher.setFont(new Font("메이플스토리", Font.BOLD, 18));
		txtPublisher.setOpaque(false);
		txtPublisher.setBorder(null);
		txtPublisher.setBounds(649, 148, 141, 30);
		frame.getContentPane().add(txtPublisher);
		txtPublisher.setColumns(10);
		
		txtImage = new JTextField();
		txtImage.setFont(new Font("메이플스토리", Font.BOLD, 18));
		txtImage.setBorder(null);
		txtImage.setOpaque(false);
		txtImage.setBounds(219, 205, 569, 30);
		frame.getContentPane().add(txtImage);
		txtImage.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(bookChange.class.getResource("/image/manager_programadd.png")));
		lblNewLabel.setBounds(0, 0, 936, 583);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				bookManagement.main(null);
			}
		});
		btnNewButton.setOpaque(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(316, 10, 86, 55);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnChange = new JButton("");
		btnChange.setOpaque(false);
		btnChange.setBorder(null);
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String author =txtAuthor.getText();
				String publisher = txtPublisher.getText();
				String image = txtImage.getText();
				String story = textArea.getText();
				int borrow_book = Integer.parseInt(txtBorrow_book.getText());
				
				control.book_update(name, author, publisher, image, story, borrow_book);
				
				JOptionPane.showMessageDialog(null, "수정완료");
				
				frame.dispose();
				bookManagement.main(null);
			}
		});
		btnChange.setBounds(411, 513, 135, 36);
		frame.getContentPane().add(btnChange);
	}
}
