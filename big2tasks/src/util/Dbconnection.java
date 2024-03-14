package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Dbconnection {//드라이브 변수선언
static final String driver = "oracle.jdbc.driver.OracleDriver";
	static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static final String userid = "ora_user";
	static final String password = "1234";
	
	
	
	
	private Dbconnection() {
	}
	public static Connection getConnection() {
		
	Connection conn = null;
			try {//드라이브 로딩
				Class.forName(driver);
				conn = DriverManager.getConnection(url, userid, password);
			} catch (ClassNotFoundException e) {//오류발생시 오류를 보여줌
				e.printStackTrace();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		
		return conn;
	}//db와 java연동종료시 클로즈 시킨다.
	public static void close(Connection conn
			, PreparedStatement pstmt
			, ResultSet rs) {
		try {
			if(rs != null) rs.close(); 
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		catch(SQLException e) {//오류발생하면 무엇이 문제인지 보여준단
			e.printStackTrace();
		}
	}// conn 클로즈문
	public static void close(Connection conn) {
		
			try {
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}