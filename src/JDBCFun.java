/**
 * Created by Shaw on 2015/9/3.
 */

import java.sql.*;

public class JDBCFun {
    static final String USER = "xiaotong";
    static final String PASS = null;
    static final String DB_URL = "jdbc:mysql://121.41.106.210:3306/51qed";

    public static void main(String[] args){
        // Register JDBC driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        // Open a connection
        // Database credentials

        System.out.println("Connecting to database...");
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Creating statement...");
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, real_name FROM 51qed.user_info LIMIT 15;";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String real_name = rs.getString("real_name");

                //Display values
                System.out.print("ID: " + id);
                System.out.print("real_name: " + real_name);
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch (java.sql.SQLException e){
            e.printStackTrace();
        }






    }
}
