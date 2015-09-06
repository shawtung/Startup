/**
 * Created by Shaw on 2015/9/3.
 */
//STEP 1. Import required packages
import com.mysql.jdbc.*;

import java.sql.*;
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JDBCFun2 {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://121.41.106.210:3306/51qed?useUnicode=true&characterEncoding=UTF-8";
    static String sql = "SELECT id, @i := @i + 1 as ord FROM user_info, (SELECT @i := 0) AS t;";
    //  Database credentials
    static final String USER = "xiaotong";
    static final String PASS = "xtong18";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            File file = new File("D:/a.txt");
            ResultSetMetaData rsmd = rs.getMetaData();

            //STEP 5: Extract data from result set
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.print(rsmd.getColumnLabel(i) + "\t");
            }
            System.out.println();
            while(rs.next()){
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    System.out.print(rs.getString(i)+"\t");
                }
                System.out.println();
//                System.out.println(rs.getInt(1) + " " + rs.getInt(2)+ " " +rs.getInt(3));
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println();
    }//end main
}
