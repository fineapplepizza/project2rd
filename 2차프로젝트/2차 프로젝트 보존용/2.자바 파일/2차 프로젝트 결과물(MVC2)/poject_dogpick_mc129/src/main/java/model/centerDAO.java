package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class centerDAO {

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
			System.out.println("jar확인 driver경로확인");
		} catch (SQLException e) {
			System.out.println("DB연결 실패");
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
	
	public ArrayList<centerDTO> getCenter_map(){
		centerDTO c_dto = null;
		ArrayList<centerDTO> center_map = new ArrayList<centerDTO>();
		
		connDB();
		
		String sql = "SELECT * FROM centerlist";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String getDo = rs.getString(1);
				String getSiGoon = rs.getString(2);
				String getName = rs.getString(3);
				String getTel = rs.getString(4);
				String getAddr = rs.getString(5);
				
				c_dto = new centerDTO(getDo, getSiGoon, getName, getTel, getAddr);
				center_map.add(c_dto);
				
			}
		
		} catch (SQLException e) {
		}

		finally {
			closeDB();
		}
		
		return center_map;
		
	}
}