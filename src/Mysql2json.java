import java.sql.*;
import java.io.*;

public class Mysql2json {
	static final String DB_URL = "jdbc:mysql://192.168.1.232:3306/51qed?useUnicode=true&characterEncoding=UTF-8";
	static final String USER = "testuser";
	static final String PASS = "kMvZR6zm5n7Z";
	static final String SQL = "select * from user_info where id = '13032';";

	public static void make() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			rs =  stmt.executeQuery(SQL);
			rsmd = rs.getMetaData();
			String[] strName = new String[rsmd.getColumnCount()];
			String[] strField = new String[rsmd.getColumnCount()];
			rs.next();

			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				strName[i - 1] = rsmd.getColumnLabel(i);
				strField[i - 1] = rs.getString(i);
			}

			StringBuffer sb = new StringBuffer("[{");
			for (int i = 0; i < strName.length; i++) {
				if (i != 0) {
					sb.append(",");
				}
				sb.append("\"").append(strName[i]).append("\"").append(":");
				if (strField[i] != null) {
					sb.append("\"").append(strField[i]).append("\"");
				} else {
					sb.append("null");
				}
			}
			sb.append("}]");
			System.out.println(sb);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		make();
	}

}
