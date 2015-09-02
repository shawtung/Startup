/**
 * Created by Shaw on 2015/9/3.
 */
//STEP 1. Import required packages
import java.sql.*;
import java.io.*;

public class JDBCFun2 {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://121.41.106.210:3306/51qed";

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
            String sql;
            sql = "SELECT * FROM user_info limit 15";
            ResultSet rs = stmt.executeQuery(sql);
            File file = new File("D:/a.txt");

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
             /*   int id  = rs.getInt("id");
                String real_name = rs.getString("real_name");

                //Display values
                System.out.print(id+"\t");
                System.out.print(real_name+"\t");*/
                System.out.println(rs);
                System.out.println();
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
