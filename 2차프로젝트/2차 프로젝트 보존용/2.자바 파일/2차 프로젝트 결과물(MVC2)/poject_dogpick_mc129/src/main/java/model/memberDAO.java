package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class memberDAO {

	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;

	public void connDB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String pass = "hr";
			conn = DriverManager.getConnection(url, user, pass);
			if (conn != null) {
				System.out.println("conn success");
			} else {
				System.out.println("conn fail");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("jarȮ�� driver���Ȯ��");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB���� ����");
			e.printStackTrace();
		}

	}

	public void closeDB() {
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
	}

	
	
	
	// {�α���,���� �޼ҵ� ����!}
	// 1. �����ε�~�ͽ�ťƮ���� �ϳ��� �޼ҵ�� ����� ����� ���ϰ����� ����
	// 2. ��Ʈ�ѷ�Ŭ���������� ��ɿ� �´� �޼ҵ带 ȣ���ϰ� �׿� ���� ���ϰ��� �������� ����������� ���� ���Ѵ�.
	// (�α����� null or not null, ������ cnt = 0 or 1)

	// �α��θ޼ҵ�
	public memberDTO logincheck(String id, String pw) {
		memberDTO member = null;
		// �α��� ĳġ��
		try {
			connDB();
			String sql1 = "select * from member_table where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql1);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			System.out.println(sql1);

			if (rs.next()) {
				
				String getId = rs.getString(1);
				String getName = rs.getString(2);
				String getPw = rs.getString(3);
				String getTel = rs.getString(4);
				String getEmail = rs.getString(5);
				String getAddress = rs.getString(6);
				member = new memberDTO(getId, getName, getPw, getTel,getEmail,getAddress);
				System.out.println("/rs.if������");
			}
		} catch (SQLException e) {
			System.out.println("Ŀ�ؿ���");
			e.printStackTrace();
		} finally {
			closeDB();
		} // �α���ĳġ��end
		return member;
	}// �α��θ޼ҵ�ed

	// ���θ޼ҵ�
	public int join(memberDTO member) {
		int cnt = 0;

		// ����ĳġ��
		try {
			connDB();
			String sql1 = "insert into member_table values (?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql1);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getPw());
			psmt.setString(4, member.getTel());
			psmt.setString(5, member.getEmail());
			psmt.setString(6, member.getAddress());
			
			System.out.println("Ŀ�ؼ���");
			cnt = psmt.executeUpdate();
			System.out.println("daocnt : "+cnt);
		} catch (SQLException e) {
			// Ŀ�ؿ���else
			System.out.println("Ŀ�ؿ���");
			e.printStackTrace();

		} finally {
			closeDB();
		} // ����ĳġ��ed
		return cnt;
	}// ���θ޼ҵ�ed

	// ������Ʈ �޼ҵ�
	public int update(memberDTO member) {
		int cnt = 0;
		// ������Ʈ ĳġ��
		try {
			connDB();

			String sql1 = "update member_table set pw = ?, tel = ?, email = ?, address = ? where id = ?";
			psmt = conn.prepareStatement(sql1);
			psmt.setString(1, member.getPw());
			psmt.setString(2, member.getTel());
			psmt.setString(3, member.getEmail());
			psmt.setString(4, member.getAddress());
			psmt.setString(5, member.getId());
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Ŀ�ؿ���");
			e.printStackTrace();
		} finally {
			closeDB();
		} // �α���ĳġ��end
		return cnt;
	}// ������Ʈ�޼ҵ�ed

	// ����Ʈ �޼ҵ�
	public ArrayList<memberDTO> select() {
		// ����Ʈ ĳġ��
		memberDTO member = null;
		ArrayList<memberDTO> list = new ArrayList<memberDTO>();
		
		try {
			connDB();
			String sql1 = "select * from member_table";
			psmt = conn.prepareStatement(sql1);
			rs = psmt.executeQuery();
			System.out.println(sql1);
			
			
				while(rs.next()) {
					String getId = rs.getString(1);
					String getName = rs.getString(2);
					String getPw = rs.getString(3);
					String getTel = rs.getString(4);
					String getEmail = rs.getString(5);
					String getAddress = rs.getString(6);
					member = new memberDTO(getId, getName, getPw, getTel,getEmail,getAddress);
					list.add(member);
				}	
			
			
		} catch (SQLException e) {
			System.out.println("Ŀ�ؿ���");
			e.printStackTrace();
		} finally {
			closeDB();
		} // ����Ʈĳġ��end
			
			
	return (ArrayList<memberDTO>) list;
	}


	// ����Ʈ �޼ҵ�
	public int delete(String id) {
			int cnt = 0;
			// ����Ʈ ĳġ��
			try {
				connDB();

				String sql1 = "delete from member_table where id = ?";
				psmt = conn.prepareStatement(sql1);
				psmt.setString(1, id);
				
				cnt = psmt.executeUpdate();

			} catch (SQLException e) {
				System.out.println("Ŀ�ؿ���");
				e.printStackTrace();
			} finally {
				closeDB();
			} // �α���ĳġ��end
			return cnt;
		}// �α��θ޼ҵ�ed

	//���̵� �ߺ�üũ �޼ҵ�	
	public boolean idCheck(String id) {
			// �ߺ� ĳġ��
		boolean check = false;
			try {
				connDB();
				String sql1 = "select * from member_table where id = ?";
				psmt = conn.prepareStatement(sql1);
				psmt.setString(1, id);
				
				rs = psmt.executeQuery();
				
				System.out.println(sql1);

				if (rs.next()) {
					check = true;
				}else{
					check = false;
				}
			} catch (SQLException e) {
				System.out.println("Ŀ�ؿ���");
				e.printStackTrace();
			} finally {
				closeDB();
			} // �ߺ�ĳġ��end
			return check;
		}// �ߺ��޼ҵ�ed	


}// Ŭ����ed
