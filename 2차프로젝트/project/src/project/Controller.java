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
	// bookManagementVO에 대한 객체 생성
	memberVO vo = null;
	bookManagementVO vo1 = null;

	// 1.mysql동적연결
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
		} catch (ClassNotFoundException e) {
			System.out.println("동적연결오류");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL문오류");
			e.printStackTrace();
		}
	}// connect()종료

	// 객체의 연결을 종료하는 메소드
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
		
		
	}// close()종료
		// 도서추가를 위한 메소드 -insert()
	
	public ArrayList<latecomerVO> latecomer(){
		//arraylist생성
		ArrayList<latecomerVO>list = new ArrayList<latecomerVO>();
		//데이터베이스연결
		connect();
		
		//sql문 작성
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
			System.out.println("연체자조회SQL문오류");
			e.printStackTrace();
		}finally
		{
			close();
		}
		return list;
	}

	public int book_insert(String name, String author, String publisher, String image, String story, int borrow_book) {
		connect();// 데이터베이스 연결

		// sql문 넘기기

		try {
			String sql = "insert into book values(?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);

			// 셋팅값 설정
			psmt.setString(1, name);
			psmt.setString(2, author);
			psmt.setString(3, publisher);
			psmt.setString(4, image);
			psmt.setString(5, story);
			psmt.setInt(6, borrow_book);

			// 테이블의 변화를 실행해주는 메소드 executeUpdate()
			cnt = psmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("SQL문오류");
			e.printStackTrace();
		}

		// 객체 닫아주기
		finally {
			close();
		}
		return cnt;
	}// insert();
	
	
	
	
	public int member_insert(String name, String id, String pw, String address) {
		connect();// 데이터베이스 연결

		// sql문 넘기기

		try {
			String sql = "insert into member values(?,?,?,?)";
			psmt = conn.prepareStatement(sql);


			// 셋팅값 설정
			psmt.setString(1, name);
			psmt.setString(2, id);
			psmt.setString(3, pw);
			psmt.setString(4, address);


			// 테이블의 변화를 실행해주는 메소드 executeUpdate()
			cnt = psmt.executeUpdate();
			System.out.println(sql);
		} catch (SQLException e) {
			System.out.println("SQL문오류");
			e.printStackTrace();
		}

		// 객체 닫아주기
		finally {
			close();
		}
		return cnt;
	}// insert();
	
	
	

	// 도서조회 selectAll()
	public ArrayList<bookManagementVO> book_selectAll() {
		// 테이블로부터 한 줄 씩 읽어오는 내용들을 저장하기 위해 ArrayList
		ArrayList<bookManagementVO> list = new ArrayList<>();
		// 1.동적로딩,데이터베이스 연결
		connect();
		// 2.전체조회 sql문 작성

		// sql을 psmt에 담아주기
		try {
			
			String sql = "select * from book";
			psmt = conn.prepareStatement(sql);
			// 테이블을 조회/검색 실행시켜주기 위한 메소드 executeQuery()사용하기
			// 검색된 내용을 console에 출력하기 위한 메소드 ResultSet 사용하기
			rs = psmt.executeQuery();
			// 3.rs객체를 통해 각 컬럼 값 가져오기 ->rs.get(index)
			while (rs.next()) {
				String name = rs.getString(1);
				String author = rs.getString(2);
				String publisher = rs.getString(3);
				String image = rs.getString(4);
				String story = rs.getString(5);
				int borrow_book = rs.getInt(6);

				// 4.생성자 메소드에 다시 전달
				vo1 = new bookManagementVO(name, author, publisher,image, story, borrow_book);
				// 5.ArrayList에 생성내용 추가 -> add()
				list.add(vo1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;

	}//selectAll()종료
	
	
	public ArrayList<memberVO> member_search() {
		// 테이블로부터 한 줄 씩 읽어오는 내용들을 저장하기 위해 ArrayList
		ArrayList<memberVO> list = new ArrayList<>();
		// 1.동적로딩,데이터베이스 연결
		connect();
		// 2.전체조회 sql문 작성

		// sql을 psmt에 담아주기
		try {
			String sql = "select name, id, address from member";
			psmt = conn.prepareStatement(sql);
			// 테이블을 조회/검색 실행시켜주기 위한 메소드 executeQuery()사용하기
			// 검색된 내용을 console에 출력하기 위한 메소드 ResultSet 사용하기
			rs = psmt.executeQuery();
			// 3.rs객체를 통해 각 컬럼 값 가져오기 ->rs.get(index)
			while (rs.next()) {
				String name = rs.getString(1);
				String id2 = rs.getString(2);
				String address = rs.getString(3);
			
				// 4.생성자 메소드에 다시 전달
				vo = new memberVO(name, id2, address);
				// 5.ArrayList에 생성내용 추가 -> add()
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;

	}//selectAll()종료
	
	
	public ArrayList<memberVO> member_search_name(String name) {
		// 테이블로부터 한 줄 씩 읽어오는 내용들을 저장하기 위해 ArrayList
		ArrayList<memberVO> list = new ArrayList<>();
		// 1.동적로딩,데이터베이스 연결
		connect();
		// 2.전체조회 sql문 작성

		// sql을 psmt에 담아주기
		try {
			String sql = "select id, pw, address from member where name = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			// 테이블을 조회/검색 실행시켜주기 위한 메소드 executeQuery()사용하기
			// 검색된 내용을 console에 출력하기 위한 메소드 ResultSet 사용하기
			rs = psmt.executeQuery();
			// 3.rs객체를 통해 각 컬럼 값 가져오기 ->rs.get(index)
			while (rs.next()) {
				String name1 = rs.getString(1);
				String id = rs.getString(2);
				String address = rs.getString(3);
			
				// 4.생성자 메소드에 다시 전달
				vo = new memberVO(name1, id, address);
				// 5.ArrayList에 생성내용 추가 -> add()
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;

	}//selectAll()종료
	
	
	
	// 도서조회 selectAll()
	public ArrayList<bookManagementVO> borrow_book_see(String a) {
		// 테이블로부터 한 줄 씩 읽어오는 내용들을 저장하기 위해 ArrayList
		ArrayList<bookManagementVO> list = new ArrayList<>();
		// 1.동적로딩,데이터베이스 연결
		connect();
		// 2.전체조회 sql문 작성
		
	
		// sql을 psmt에 담아주기
		try {
			String sql = "select book_name, book_date, book_return_date from book_borrow where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, a);
			// 테이블을 조회/검색 실행시켜주기 위한 메소드 executeQuery()사용하기
			// 검색된 내용을 console에 출력하기 위한 메소드 ResultSet 사용하기
			//psmt.setString(1, a);
			rs = psmt.executeQuery();
			// 3.rs객체를 통해 각 컬럼 값 가져오기 ->rs.get(index)
			while (rs.next()) {
			
				String book_name = rs.getString(1);
				Date book_date = rs.getDate(2);
				Date book_return_date = rs.getDate(3);

				// 4.생성자 메소드에 다시 전달
				vo1 = new bookManagementVO(book_name, book_date,  book_return_date);
				// 5.ArrayList에 생성내용 추가 -> add()
				list.add(vo1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;

	}//selectAll()종료
	
	public ArrayList<bookManagementVO> book_delivery_view() {
		// 테이블로부터 한 줄 씩 읽어오는 내용들을 저장하기 위해 ArrayList
		ArrayList<bookManagementVO> list = new ArrayList<>();
		// 1.동적로딩,데이터베이스 연결
		connect();
		// 2.전체조회 sql문 작성
		
	
		// sql을 psmt에 담아주기
		try {
			String sql = "select * from book_delivery";
			psmt = conn.prepareStatement(sql);
			// 테이블을 조회/검색 실행시켜주기 위한 메소드 executeQuery()사용하기
			// 검색된 내용을 console에 출력하기 위한 메소드 ResultSet 사용하기
			//psmt.setString(1, a);
			rs = psmt.executeQuery();
			// 3.rs객체를 통해 각 컬럼 값 가져오기 ->rs.get(index)
			while (rs.next()) {
			
				String id = rs.getString(1);
				String book_name=rs.getString(2);
				String number=rs.getString(3);
				String address=rs.getString(4);
				String delivery_date=rs.getString(5);
				// 4.생성자 메소드에 다시 전달
				vo1 = new bookManagementVO(id, book_name,  number, address, delivery_date);
				// 5.ArrayList에 생성내용 추가 -> add()
				list.add(vo1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;

	}//selectAll()종료

	
	
	// 도서조회 selectAll()
		public ArrayList<bookManagementVO> book_search(String name) {
			// 테이블로부터 한 줄 씩 읽어오는 내용들을 저장하기 위해 ArrayList
			ArrayList<bookManagementVO> list = new ArrayList<>();
			// 1.동적로딩,데이터베이스 연결
			connect();
			// 2.전체조회 sql문 작성
			
			
			// sql을 psmt에 담아주기
			try {
				String sql = "select* from book where book_name like concat ('%', ?, '%')";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, name);
				// 테이블을 조회/검색 실행시켜주기 위한 메소드 executeQuery()사용하기
				// 검색된 내용을 console에 출력하기 위한 메소드 ResultSet 사용하기
				rs = psmt.executeQuery();
				// 3.rs객체를 통해 각 컬럼 값 가져오기 ->rs.get(index)
				while (rs.next()) {
					String name1 = rs.getString(1);
					String author = rs.getString(2);
					String publisher = rs.getString(3);
					String image = rs.getString(4);
					String story = rs.getString(5);
					int borrow_book = rs.getInt(6);
					// 4.생성자 메소드에 다시 전달
			
					vo1 = new bookManagementVO(name1, author, publisher, image, story, borrow_book);
					
					
					// 5.ArrayList에 생성내용 추가 -> add()
					list.add(vo1);
			
				}
			} catch (SQLException e) {
				e.printStackTrace();
				
			} 

		
			return list;

		}//selectAll()종료
		
		public ArrayList<bookManagementVO> book_search_check(int a, String name) {
			// 테이블로부터 한 줄 씩 읽어오는 내용들을 저장하기 위해 ArrayList
			ArrayList<bookManagementVO> list = new ArrayList<>();
			// 1.동적로딩,데이터베이스 연결
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
				
				// 테이블을 조회/검색 실행시켜주기 위한 메소드 executeQuery()사용하기
				// 검색된 내용을 console에 출력하기 위한 메소드 ResultSet 사용하기
				rs = psmt.executeQuery();
				// 3.rs객체를 통해 각 컬럼 값 가져오기 ->rs.get(index)
				while (rs.next()) {
					String name1 = rs.getString(1);
					String author = rs.getString(2);
					String publisher = rs.getString(3);
					String image = rs.getString(4);
					String story = rs.getString(5);
					int borrow_book = rs.getInt(6);
					// 4.생성자 메소드에 다시 전달
			
					vo1 = new bookManagementVO(name1, author, publisher, image, story, borrow_book);
					
					
					// 5.ArrayList에 생성내용 추가 -> add()
					list.add(vo1);
			
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("쿼리실패");
				
			} 

		
			return list;

		}//selectAll()종료
		
		
		public ArrayList<memberVO> memeber_search_like(String name) {
			// 테이블로부터 한 줄 씩 읽어오는 내용들을 저장하기 위해 ArrayList
			ArrayList<memberVO> list = new ArrayList<>();
			// 1.동적로딩,데이터베이스 연결
			connect();
			// 2.전체조회 sql문 작성

			// sql을 psmt에 담아주기
			try {
				String sql = "select name, id, address from member where name like concat ('%', ?, '%')";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, name);
				// 테이블을 조회/검색 실행시켜주기 위한 메소드 executeQuery()사용하기
				// 검색된 내용을 console에 출력하기 위한 메소드 ResultSet 사용하기
				rs = psmt.executeQuery();
				// 3.rs객체를 통해 각 컬럼 값 가져오기 ->rs.get(index)
				while (rs.next()) {
					String name1 = rs.getString(1);
					String id = rs.getString(2);
					String address = rs.getString(3);
					
					// 4.생성자 메소드에 다시 전달
			
					vo = new memberVO(name1, id, address);
					
					
					// 5.ArrayList에 생성내용 추가 -> add()
					list.add(vo);
			
				}
			} catch (SQLException e) {
				e.printStackTrace();
				
			} 

		
			return list;

		}//selectAll()종료
		
		
		
		
		public void book_borrow(String name) {
			
			String sql = "update book set borrow_book  = borrow_book-1 where book_name = ? ";
			
			
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, name);
				
				cnt = psmt.executeUpdate();
				
	
				JOptionPane.showMessageDialog(null, "대출성공했습니다.");
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			finally {
				close();
			}
			
			
		}
		
		public int book_borrow_insert(String id, String book_name, String now, String return_date, int a) {
			connect();// 데이터베이스 연결

			// sql문 넘기기
			
			try {
				String sql = "insert into book_borrow values(?,?,?,?,?)";
				psmt = conn.prepareStatement(sql);

				System.out.println("sql전송");
	
				
				// 셋팅값 설정
				psmt.setString(1, id);
				psmt.setString(2, book_name);
				psmt.setString(3, now);
				psmt.setString(4, return_date);
				psmt.setInt(5, a);

				// 테이블의 변화를 실행해주는 메소드 executeUpdate()
				cnt = psmt.executeUpdate();
				System.out.println(sql);
			} catch (SQLException e) {
				System.out.println("SQL문오류");
				e.printStackTrace();
			}

			// 객체 닫아주기
			finally {
				close();
			}
			return cnt;
		}// insert();
		
		
		
		
		public int book_delivery_insert(String id, String book_name, String number, String address, String date) {
			connect();// 데이터베이스 연결

			// sql문 넘기기
			
			try {
				String sql = "insert into book_delivery values(?,?,?,?,?)";
				psmt = conn.prepareStatement(sql);

				System.out.println("sql전송");
	
				
				// 셋팅값 설정
				psmt.setString(1, id);
				psmt.setString(2, book_name);
				psmt.setString(3, number);
				psmt.setString(4, address);
				psmt.setString(5, date);

				// 테이블의 변화를 실행해주는 메소드 executeUpdate()
				cnt = psmt.executeUpdate();
				System.out.println(sql);
			} catch (SQLException e) {
				System.out.println("SQL문오류");
				e.printStackTrace();
			}

			// 객체 닫아주기
			finally {
				close();
			}
			return cnt;
		}// insert();
		
	
	
	public ArrayList<memberVO> member_selectAll() {
		// 테이블로부터 한 줄 씩 읽어오는 내용들을 저장하기 위해 ArrayList
		ArrayList<memberVO> list = new ArrayList<>();
		// 1.동적로딩,데이터베이스 연결
		connect();
		// 2.전체조회 sql문 작성

		// sql을 psmt에 담아주기
		try {
			String sql = "select* from member";
			psmt = conn.prepareStatement(sql);
			// 테이블을 조회/검색 실행시켜주기 위한 메소드 executeQuery()사용하기
			// 검색된 내용을 console에 출력하기 위한 메소드 ResultSet 사용하기
			rs = psmt.executeQuery();
			// 3.rs객체를 통해 각 컬럼 값 가져오기 ->rs.get(index)
			while (rs.next()) {
				String name = rs.getString(1);
				String id = rs.getString(2);
				String pw = rs.getString(3);
				String address = rs.getString(4);
				
				// 4.생성자 메소드에 다시 전달
				vo = new memberVO(name, id, pw, address);
				// 5.ArrayList에 생성내용 추가 -> add()
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
		
	

	}//selectAll()종료

	
	public ArrayList<bookManagementVO> read_book_king() {
		// 테이블로부터 한 줄 씩 읽어오는 내용들을 저장하기 위해 ArrayList
		ArrayList<bookManagementVO> list = new ArrayList<>();
		// 1.동적로딩,데이터베이스 연결
		connect();
		// 2.전체조회 sql문 작성

		// sql을 psmt에 담아주기
		try {
			String sql = "select id, COUNT(*) as cnt from book_borrow group by id order by cnt asc";
			psmt = conn.prepareStatement(sql);
			// 테이블을 조회/검색 실행시켜주기 위한 메소드 executeQuery()사용하기
			// 검색된 내용을 console에 출력하기 위한 메소드 ResultSet 사용하기
			rs = psmt.executeQuery();
			// 3.rs객체를 통해 각 컬럼 값 가져오기 ->rs.get(index)
			while (rs.next()) {
				String id = rs.getString(1);
				String count = rs.getString(2);
				// 4.생성자 메소드에 다시 전달
				vo1 = new bookManagementVO(id, count);
				// 5.ArrayList에 생성내용 추가 -> add()
				list.add(vo1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
		
	

	}//selectAll()종료
	

	
	
	public int delete_member(String name) {
		
		String s;
		s = name;
		
		connect();

		
		String sql = "delete from member where name = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, name);
			
			System.out.println("이름 출력 : " + name);
			
			cnt = psmt.executeUpdate();
			
			System.out.println(sql);
			
			if(cnt >0) {
				
				JOptionPane.showMessageDialog(null, "삭제성공");
			}else {
				JOptionPane.showMessageDialog(null,"삭제실패");
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		return cnt;
		// 객체 닫아주기

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
				
				JOptionPane.showMessageDialog(null, "삭제성공");
			}else {
				JOptionPane.showMessageDialog(null,"삭제실패");
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		return cnt;
		// 객체 닫아주기

	}// insert();	
	
	
	public void book_return_update(Object book_name) {
		
		String sql = "update book set borrow_book  = borrow_book + 1 where book_name = ? ";
		
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, (String) book_name);
			
			cnt = psmt.executeUpdate();
			

			JOptionPane.showMessageDialog(null, "반납성공했습니다.");
		
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
				
				JOptionPane.showMessageDialog(null, "삭제성공");
			}else {
				JOptionPane.showMessageDialog(null,"삭제실패");
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		return cnt;
		// 객체 닫아주기

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
				
				JOptionPane.showMessageDialog(null, "삭제성공");
			}else {
				JOptionPane.showMessageDialog(null,"삭제실패");
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		return cnt;
		// 객체 닫아주기

	}// insert();	

		
	
	  public int book_update(String name, String author, String publisher, String image, String story, int borrow_book) {
	      //동적연결
	      connect();
	      //sql문 
	      
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
	            System.out.println("수정성공");
	         }else {
	            System.out.println("수정실패");
	         }
	      } catch (SQLException e) {
	         System.out.println("SQL문오류");
	         e.printStackTrace();
	      }
	      finally {
	         close();
	      }
	      
	      return cnt;
	   }//update()종료
	
		
		
	}



