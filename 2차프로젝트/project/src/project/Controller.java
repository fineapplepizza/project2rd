package project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Controller {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int cnt = 0;
    latecomerVO ls =null;
	// bookManagementVO�� ���� ��ü ����
	memberVO vo = null;
	bookManagementVO vo1 = null;

	// 1.mysql��������
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
		} catch (ClassNotFoundException e) {
			System.out.println("�����������");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL������");
			e.printStackTrace();
		}
	}// connect()����

	// ��ü�� ������ �����ϴ� �޼ҵ�
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}// close()����
		// �����߰��� ���� �޼ҵ� -insert()
	
	public ArrayList<latecomerVO> latecomer(){
		//arraylist����
		ArrayList<latecomerVO>list = new ArrayList<latecomerVO>();
		//�����ͺ��̽�����
		connect();
		
		//sql�� �ۼ�
		String sql = "SELECT * from book_borrow where (DATEDIFF(now(), book_date) >= 14) = 1;";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String bookrental = rs.getString(3);
				String bookreturn = rs.getString(4);
				String returnstatus ="X";
				ls = new latecomerVO(id,name,bookrental,bookreturn,returnstatus);
				list.add(ls);				
			}
			sql = "select * from return_table where (DATEDIFF(book_return, book_date) >= 14) = 1";
			
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String bookrental = rs.getString(3);
				String bookreturn = rs.getString(4);
				String returnstatus ="O";
				ls = new latecomerVO(id,name,bookrental,bookreturn,returnstatus);
				list.add(ls);				
			}
			
		} catch (SQLException e) {
			System.out.println("��ü����ȸSQL������");
			e.printStackTrace();
		}finally
		{
			close();
		}
		return list;
	}

	public int book_insert(String name, String author, String publisher, String image, String story, int borrow_book) {
		connect();// �����ͺ��̽� ����

		// sql�� �ѱ��

		try {
			String sql = "insert into book values(?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);

			// ���ð� ����
			psmt.setString(1, name);
			psmt.setString(2, author);
			psmt.setString(3, publisher);
			psmt.setString(4, image);
			psmt.setString(5, story);
			psmt.setInt(6, borrow_book);

			// ���̺��� ��ȭ�� �������ִ� �޼ҵ� executeUpdate()
			cnt = psmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("SQL������");
			e.printStackTrace();
		}

		// ��ü �ݾ��ֱ�
		finally {
			close();
		}
		return cnt;
	}// insert();
	
	
	
	
	public int member_insert(String name, String id, String pw, String address) {
		connect();// �����ͺ��̽� ����

		// sql�� �ѱ��

		try {
			String sql = "insert into member values(?,?,?,?)";
			psmt = conn.prepareStatement(sql);


			// ���ð� ����
			psmt.setString(1, name);
			psmt.setString(2, id);
			psmt.setString(3, pw);
			psmt.setString(4, address);


			// ���̺��� ��ȭ�� �������ִ� �޼ҵ� executeUpdate()
			cnt = psmt.executeUpdate();
			System.out.println(sql);
		} catch (SQLException e) {
			System.out.println("SQL������");
			e.printStackTrace();
		}

		// ��ü �ݾ��ֱ�
		finally {
			close();
		}
		return cnt;
	}// insert();
	
	
	

	// ������ȸ selectAll()
	public ArrayList<bookManagementVO> book_selectAll() {
		// ���̺�κ��� �� �� �� �о���� ������� �����ϱ� ���� ArrayList
		ArrayList<bookManagementVO> list = new ArrayList<>();
		// 1.�����ε�,�����ͺ��̽� ����
		connect();
		// 2.��ü��ȸ sql�� �ۼ�

		// sql�� psmt�� ����ֱ�
		try {
			
			String sql = "select * from book";
			psmt = conn.prepareStatement(sql);
			// ���̺��� ��ȸ/�˻� ��������ֱ� ���� �޼ҵ� executeQuery()����ϱ�
			// �˻��� ������ console�� ����ϱ� ���� �޼ҵ� ResultSet ����ϱ�
			rs = psmt.executeQuery();
			// 3.rs��ü�� ���� �� �÷� �� �������� ->rs.get(index)
			while (rs.next()) {
				String name = rs.getString(1);
				String author = rs.getString(2);
				String publisher = rs.getString(3);
				String image = rs.getString(4);
				String story = rs.getString(5);
				int borrow_book = rs.getInt(6);

				// 4.������ �޼ҵ忡 �ٽ� ����
				vo1 = new bookManagementVO(name, author, publisher,image, story, borrow_book);
				// 5.ArrayList�� �������� �߰� -> add()
				list.add(vo1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;

	}//selectAll()����
	
	
	public ArrayList<memberVO> member_search() {
		// ���̺�κ��� �� �� �� �о���� ������� �����ϱ� ���� ArrayList
		ArrayList<memberVO> list = new ArrayList<>();
		// 1.�����ε�,�����ͺ��̽� ����
		connect();
		// 2.��ü��ȸ sql�� �ۼ�

		// sql�� psmt�� ����ֱ�
		try {
			String sql = "select name, id, address from member";
			psmt = conn.prepareStatement(sql);
			// ���̺��� ��ȸ/�˻� ��������ֱ� ���� �޼ҵ� executeQuery()����ϱ�
			// �˻��� ������ console�� ����ϱ� ���� �޼ҵ� ResultSet ����ϱ�
			rs = psmt.executeQuery();
			// 3.rs��ü�� ���� �� �÷� �� �������� ->rs.get(index)
			while (rs.next()) {
				String name = rs.getString(1);
				String id2 = rs.getString(2);
				String address = rs.getString(3);
			
				// 4.������ �޼ҵ忡 �ٽ� ����
				vo = new memberVO(name, id2, address);
				// 5.ArrayList�� �������� �߰� -> add()
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;

	}//selectAll()����
	
	
	public ArrayList<memberVO> member_search_name(String name) {
		// ���̺�κ��� �� �� �� �о���� ������� �����ϱ� ���� ArrayList
		ArrayList<memberVO> list = new ArrayList<>();
		// 1.�����ε�,�����ͺ��̽� ����
		connect();
		// 2.��ü��ȸ sql�� �ۼ�

		// sql�� psmt�� ����ֱ�
		try {
			String sql = "select id, pw, address from member where name = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			// ���̺��� ��ȸ/�˻� ��������ֱ� ���� �޼ҵ� executeQuery()����ϱ�
			// �˻��� ������ console�� ����ϱ� ���� �޼ҵ� ResultSet ����ϱ�
			rs = psmt.executeQuery();
			// 3.rs��ü�� ���� �� �÷� �� �������� ->rs.get(index)
			while (rs.next()) {
				String name1 = rs.getString(1);
				String id = rs.getString(2);
				String address = rs.getString(3);
			
				// 4.������ �޼ҵ忡 �ٽ� ����
				vo = new memberVO(name1, id, address);
				// 5.ArrayList�� �������� �߰� -> add()
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;

	}//selectAll()����
	
	
	
	// ������ȸ selectAll()
	public ArrayList<bookManagementVO> borrow_book_see(String a) {
		// ���̺�κ��� �� �� �� �о���� ������� �����ϱ� ���� ArrayList
		ArrayList<bookManagementVO> list = new ArrayList<>();
		// 1.�����ε�,�����ͺ��̽� ����
		connect();
		// 2.��ü��ȸ sql�� �ۼ�
		
	
		// sql�� psmt�� ����ֱ�
		try {
			String sql = "select book_name, book_date, book_return_date from book_borrow where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, a);
			// ���̺��� ��ȸ/�˻� ��������ֱ� ���� �޼ҵ� executeQuery()����ϱ�
			// �˻��� ������ console�� ����ϱ� ���� �޼ҵ� ResultSet ����ϱ�
			//psmt.setString(1, a);
			rs = psmt.executeQuery();
			// 3.rs��ü�� ���� �� �÷� �� �������� ->rs.get(index)
			while (rs.next()) {
			
				String book_name = rs.getString(1);
				Date book_date = rs.getDate(2);
				Date book_return_date = rs.getDate(3);

				// 4.������ �޼ҵ忡 �ٽ� ����
				vo1 = new bookManagementVO(book_name, book_date,  book_return_date);
				// 5.ArrayList�� �������� �߰� -> add()
				list.add(vo1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;

	}//selectAll()����
	
	public ArrayList<bookManagementVO> book_delivery_view() {
		// ���̺�κ��� �� �� �� �о���� ������� �����ϱ� ���� ArrayList
		ArrayList<bookManagementVO> list = new ArrayList<>();
		// 1.�����ε�,�����ͺ��̽� ����
		connect();
		// 2.��ü��ȸ sql�� �ۼ�
		
	
		// sql�� psmt�� ����ֱ�
		try {
			String sql = "select * from book_delivery";
			psmt = conn.prepareStatement(sql);
			// ���̺��� ��ȸ/�˻� ��������ֱ� ���� �޼ҵ� executeQuery()����ϱ�
			// �˻��� ������ console�� ����ϱ� ���� �޼ҵ� ResultSet ����ϱ�
			//psmt.setString(1, a);
			rs = psmt.executeQuery();
			// 3.rs��ü�� ���� �� �÷� �� �������� ->rs.get(index)
			while (rs.next()) {
			
				String id = rs.getString(1);
				String book_name=rs.getString(2);
				String number=rs.getString(3);
				String address=rs.getString(4);
				String delivery_date=rs.getString(5);
				// 4.������ �޼ҵ忡 �ٽ� ����
				vo1 = new bookManagementVO(id, book_name,  number, address, delivery_date);
				// 5.ArrayList�� �������� �߰� -> add()
				list.add(vo1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;

	}//selectAll()����

	
	
	// ������ȸ selectAll()
		public ArrayList<bookManagementVO> book_search(String name) {
			// ���̺�κ��� �� �� �� �о���� ������� �����ϱ� ���� ArrayList
			ArrayList<bookManagementVO> list = new ArrayList<>();
			// 1.�����ε�,�����ͺ��̽� ����
			connect();
			// 2.��ü��ȸ sql�� �ۼ�
			
			
			// sql�� psmt�� ����ֱ�
			try {
				String sql = "select* from book where book_name like concat ('%', ?, '%')";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, name);
				// ���̺��� ��ȸ/�˻� ��������ֱ� ���� �޼ҵ� executeQuery()����ϱ�
				// �˻��� ������ console�� ����ϱ� ���� �޼ҵ� ResultSet ����ϱ�
				rs = psmt.executeQuery();
				// 3.rs��ü�� ���� �� �÷� �� �������� ->rs.get(index)
				while (rs.next()) {
					String name1 = rs.getString(1);
					String author = rs.getString(2);
					String publisher = rs.getString(3);
					String image = rs.getString(4);
					String story = rs.getString(5);
					int borrow_book = rs.getInt(6);
					// 4.������ �޼ҵ忡 �ٽ� ����
			
					vo1 = new bookManagementVO(name1, author, publisher, image, story, borrow_book);
					
					
					// 5.ArrayList�� �������� �߰� -> add()
					list.add(vo1);
			
				}
			} catch (SQLException e) {
				e.printStackTrace();
				
			} 

		
			return list;

		}//selectAll()����
		
		public ArrayList<bookManagementVO> book_search_check(int a, String name) {
			// ���̺�κ��� �� �� �� �о���� ������� �����ϱ� ���� ArrayList
			ArrayList<bookManagementVO> list = new ArrayList<>();
			// 1.�����ε�,�����ͺ��̽� ����
			connect();
		
			try {
				String sql="";
				if(a==0) {
				sql = "select * from book where book_name like concat ('%', ?, '%')";
				}
				
				if(a==1) {
					sql = "select * from book_nmae where book_author like concat ('%', ?, '%')";
				}
				
				if(a==2) {
					sql = "select * from book_nmae where book_publisher like concat ('%', ?, '%')";
				}
				
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, name);
				
				// ���̺��� ��ȸ/�˻� ��������ֱ� ���� �޼ҵ� executeQuery()����ϱ�
				// �˻��� ������ console�� ����ϱ� ���� �޼ҵ� ResultSet ����ϱ�
				rs = psmt.executeQuery();
				// 3.rs��ü�� ���� �� �÷� �� �������� ->rs.get(index)
				while (rs.next()) {
					String name1 = rs.getString(1);
					String author = rs.getString(2);
					String publisher = rs.getString(3);
					String image = rs.getString(4);
					String story = rs.getString(5);
					int borrow_book = rs.getInt(6);
					// 4.������ �޼ҵ忡 �ٽ� ����
			
					vo1 = new bookManagementVO(name1, author, publisher, image, story, borrow_book);
					
					
					// 5.ArrayList�� �������� �߰� -> add()
					list.add(vo1);
			
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("��������");
				
			} 

		
			return list;

		}//selectAll()����
		
		
		public ArrayList<memberVO> memeber_search_like(String name) {
			// ���̺�κ��� �� �� �� �о���� ������� �����ϱ� ���� ArrayList
			ArrayList<memberVO> list = new ArrayList<>();
			// 1.�����ε�,�����ͺ��̽� ����
			connect();
			// 2.��ü��ȸ sql�� �ۼ�

			// sql�� psmt�� ����ֱ�
			try {
				String sql = "select name, id, address from member where name like concat ('%', ?, '%')";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, name);
				// ���̺��� ��ȸ/�˻� ��������ֱ� ���� �޼ҵ� executeQuery()����ϱ�
				// �˻��� ������ console�� ����ϱ� ���� �޼ҵ� ResultSet ����ϱ�
				rs = psmt.executeQuery();
				// 3.rs��ü�� ���� �� �÷� �� �������� ->rs.get(index)
				while (rs.next()) {
					String name1 = rs.getString(1);
					String id = rs.getString(2);
					String address = rs.getString(3);
					
					// 4.������ �޼ҵ忡 �ٽ� ����
			
					vo = new memberVO(name1, id, address);
					
					
					// 5.ArrayList�� �������� �߰� -> add()
					list.add(vo);
			
				}
			} catch (SQLException e) {
				e.printStackTrace();
				
			} 

		
			return list;

		}//selectAll()����
		
		
		
		
		public void book_borrow(String name) {
			
			String sql = "update book set borrow_book  = borrow_book-1 where book_name = ? ";
			
			
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, name);
				
				cnt = psmt.executeUpdate();
				
	
				JOptionPane.showMessageDialog(null, "���⼺���߽��ϴ�.");
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			finally {
				close();
			}
			
			
		}
		
		public int book_borrow_insert(String id, String book_name, String now, String return_date, int a) {
			connect();// �����ͺ��̽� ����

			// sql�� �ѱ��
			
			try {
				String sql = "insert into book_borrow values(?,?,?,?,?)";
				psmt = conn.prepareStatement(sql);

				System.out.println("sql����");
	
				
				// ���ð� ����
				psmt.setString(1, id);
				psmt.setString(2, book_name);
				psmt.setString(3, now);
				psmt.setString(4, return_date);
				psmt.setInt(5, a);

				// ���̺��� ��ȭ�� �������ִ� �޼ҵ� executeUpdate()
				cnt = psmt.executeUpdate();
				System.out.println(sql);
			} catch (SQLException e) {
				System.out.println("SQL������");
				e.printStackTrace();
			}

			// ��ü �ݾ��ֱ�
			finally {
				close();
			}
			return cnt;
		}// insert();
		
		
		
		
		public int book_delivery_insert(String id, String book_name, String number, String address, String date) {
			connect();// �����ͺ��̽� ����

			// sql�� �ѱ��
			
			try {
				String sql = "insert into book_delivery values(?,?,?,?,?)";
				psmt = conn.prepareStatement(sql);

				System.out.println("sql����");
	
				
				// ���ð� ����
				psmt.setString(1, id);
				psmt.setString(2, book_name);
				psmt.setString(3, number);
				psmt.setString(4, address);
				psmt.setString(5, date);

				// ���̺��� ��ȭ�� �������ִ� �޼ҵ� executeUpdate()
				cnt = psmt.executeUpdate();
				System.out.println(sql);
			} catch (SQLException e) {
				System.out.println("SQL������");
				e.printStackTrace();
			}

			// ��ü �ݾ��ֱ�
			finally {
				close();
			}
			return cnt;
		}// insert();
		
	
	
	public ArrayList<memberVO> member_selectAll() {
		// ���̺�κ��� �� �� �� �о���� ������� �����ϱ� ���� ArrayList
		ArrayList<memberVO> list = new ArrayList<>();
		// 1.�����ε�,�����ͺ��̽� ����
		connect();
		// 2.��ü��ȸ sql�� �ۼ�

		// sql�� psmt�� ����ֱ�
		try {
			String sql = "select* from member";
			psmt = conn.prepareStatement(sql);
			// ���̺��� ��ȸ/�˻� ��������ֱ� ���� �޼ҵ� executeQuery()����ϱ�
			// �˻��� ������ console�� ����ϱ� ���� �޼ҵ� ResultSet ����ϱ�
			rs = psmt.executeQuery();
			// 3.rs��ü�� ���� �� �÷� �� �������� ->rs.get(index)
			while (rs.next()) {
				String name = rs.getString(1);
				String id = rs.getString(2);
				String pw = rs.getString(3);
				String address = rs.getString(4);
				
				// 4.������ �޼ҵ忡 �ٽ� ����
				vo = new memberVO(name, id, pw, address);
				// 5.ArrayList�� �������� �߰� -> add()
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
		
	

	}//selectAll()����

	
	public ArrayList<bookManagementVO> read_book_king() {
		// ���̺�κ��� �� �� �� �о���� ������� �����ϱ� ���� ArrayList
		ArrayList<bookManagementVO> list = new ArrayList<>();
		// 1.�����ε�,�����ͺ��̽� ����
		connect();
		// 2.��ü��ȸ sql�� �ۼ�

		// sql�� psmt�� ����ֱ�
		try {
			String sql = "select id, COUNT(*) as cnt from book_borrow group by id order by cnt asc";
			psmt = conn.prepareStatement(sql);
			// ���̺��� ��ȸ/�˻� ��������ֱ� ���� �޼ҵ� executeQuery()����ϱ�
			// �˻��� ������ console�� ����ϱ� ���� �޼ҵ� ResultSet ����ϱ�
			rs = psmt.executeQuery();
			// 3.rs��ü�� ���� �� �÷� �� �������� ->rs.get(index)
			while (rs.next()) {
				String id = rs.getString(1);
				String count = rs.getString(2);
				// 4.������ �޼ҵ忡 �ٽ� ����
				vo1 = new bookManagementVO(id, count);
				// 5.ArrayList�� �������� �߰� -> add()
				list.add(vo1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
		
	

	}//selectAll()����
	

	
	
	public int delete_member(String name) {
		
		String s;
		s = name;
		
		connect();

		
		String sql = "delete from member where name = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, name);
			
			System.out.println("�̸� ��� : " + name);
			
			cnt = psmt.executeUpdate();
			
			System.out.println(sql);
			
			if(cnt >0) {
				
				JOptionPane.showMessageDialog(null, "��������");
			}else {
				JOptionPane.showMessageDialog(null,"��������");
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		return cnt;
		// ��ü �ݾ��ֱ�

	}// insert();	
		
	
	public int book_borrow_return(Object value) {
		
	
		connect();

		
		String sql = "delete from book_borrow where book_name = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			
			psmt.setString(1,  (String) value);
			
			
			cnt = psmt.executeUpdate();
			
			System.out.println(sql);
			
			if(cnt >0) {
				
				JOptionPane.showMessageDialog(null, "��������");
			}else {
				JOptionPane.showMessageDialog(null,"��������");
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		return cnt;
		// ��ü �ݾ��ֱ�

	}// insert();	
	
	
	public void book_return_update(Object book_name) {
		
		String sql = "update book set borrow_book  = borrow_book + 1 where book_name = ? ";
		
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, (String) book_name);
			
			cnt = psmt.executeUpdate();
			

			JOptionPane.showMessageDialog(null, "�ݳ������߽��ϴ�.");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		finally {
			close();
		}
		
		
	}
	

	public int delete_book(Object value) {
		
		Object s;
		s = value;
		
		connect();

		
		String sql = "delete from book where book_name = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, (String) value);
			
			
			cnt = psmt.executeUpdate();
			
			System.out.println(sql);
			
			if(cnt >0) {
				
				JOptionPane.showMessageDialog(null, "��������");
			}else {
				JOptionPane.showMessageDialog(null,"��������");
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		return cnt;
		// ��ü �ݾ��ֱ�

	}// insert();	
		
	
	public int delete_member(Object value) {
		
		Object s;
		s = value;
		
		connect();

		
		String sql = "delete from member where name = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, (String) value);
			
			
			cnt = psmt.executeUpdate();
			
			System.out.println(sql);
			
			if(cnt >0) {
				
				JOptionPane.showMessageDialog(null, "��������");
			}else {
				JOptionPane.showMessageDialog(null,"��������");
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		return cnt;
		// ��ü �ݾ��ֱ�

	}// insert();	

		
	
	  public int book_update(String name, String author, String publisher, String image, String story, int borrow_book) {
	      //��������
	      connect();
	      //sql�� 
	      
	      try {
	         String sql = "update book set book_author = ? , 	book_publisher =? , book_image =? , book_story= ? , borrow_book =?  where book_name =?";
	         PreparedStatement psmt =  conn.prepareStatement(sql);
	         
	         psmt.setString(1, author);
	         psmt.setString(2, publisher);
	         psmt.setString(3, image);
	         psmt.setString(4, story);
	         psmt.setInt(5, borrow_book);
	         psmt.setString(6, name);
	         
	         cnt = psmt.executeUpdate();
	         if(cnt>0) {
	            System.out.println("��������");
	         }else {
	            System.out.println("��������");
	         }
	      } catch (SQLException e) {
	         System.out.println("SQL������");
	         e.printStackTrace();
	      }
	      finally {
	         close();
	      }
	      
	      return cnt;
	   }//update()����
	
		
		
	}



