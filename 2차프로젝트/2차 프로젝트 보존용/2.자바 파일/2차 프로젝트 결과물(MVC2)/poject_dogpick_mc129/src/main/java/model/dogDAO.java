package model;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class dogDAO {
	
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	
	//DB연결
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
			System.out.println("jar확인 driver경로확인");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB연결 실패");
			e.printStackTrace();
		}

	}

	//DB종료
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
	
	//강아지 전체 조회 셀렉트 메소드
		public ArrayList<dogDTO> dogSelect() {
			// 셀렉트 캐치문
			dogDTO dog = null;
			ArrayList<dogDTO> list = new ArrayList<dogDTO>();
			
			try {
				connDB();
				 
				
				String sql = "select * from dog_info";
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				System.out.println(sql);
				
				
					while(rs.next()) {
						String getDogName = rs.getString(1);
						String getSize = rs.getString(2);
						String getWeight = rs.getString(3);
						String getSick = rs.getString(4);
						String getChr = rs.getString(5);
	
						dog = new dogDTO(getDogName, getSize, getWeight, getSick,getChr);
						list.add(dog);
					}	
				System.out.println("도그셀렉 마지막지점");
				
			} catch (SQLException e) {
				System.out.println("커넥오류");
				e.printStackTrace();
			} finally {
				closeDB();
			} // 셀렉트캐치문end
				
				
		return  list;
		}
		
		// 강아지 검색 셀렉트 메소드
		public ArrayList<dogDTO> dogTextSelect(String dogName) {
			// 셀렉트 캐치문
			dogDTO dog = null;
			ArrayList<dogDTO> list = new ArrayList<dogDTO>();
			
			try {
				connDB();
				 
				
				String sql = "select * from dog_info where dg_name= ? ";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, dogName);
				rs = psmt.executeQuery();
				System.out.println(sql);
				
				
					if(rs.next()) {
						String getDogName = rs.getString(1);
						String getSize = rs.getString(2);
						String getWeight = rs.getString(3);
						String getSick = rs.getString(4);
						String getChr = rs.getString(5);
	
						dog = new dogDTO(getDogName, getSize, getWeight, getSick,getChr);
						list.add(dog);
						
					
					}	
				
				
			} catch (SQLException e) {
				System.out.println("커넥오류");
				e.printStackTrace();
			} finally {
				closeDB();
			} // 셀렉트캐치문end
				
				
		return  list;
		}

}
