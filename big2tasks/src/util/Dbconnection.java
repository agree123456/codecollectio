package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Dbconnection {//����̺� ��������
static final String driver = "oracle.jdbc.driver.OracleDriver";
	static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static final String userid = "ora_user";
	static final String password = "1234";
	
	
	
	
	private Dbconnection() {
	}
	public static Connection getConnection() {
		
	Connection conn = null;
			try {//����̺� �ε�
				Class.forName(driver);
				conn = DriverManager.getConnection(url, userid, password);
			} catch (ClassNotFoundException e) {//�����߻��� ������ ������
				e.printStackTrace();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		
		return conn;
	}//db�� java��������� Ŭ���� ��Ų��.
	public static void close(Connection conn
			, PreparedStatement pstmt
			, ResultSet rs) {
		try {
			if(rs != null) rs.close(); 
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		catch(SQLException e) {//�����߻��ϸ� ������ �������� �����ش�
			e.printStackTrace();
		}
	}// conn Ŭ���
	public static void close(Connection conn) {
		
			try {
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}