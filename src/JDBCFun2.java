/**
 * Created by Shaw on 2015/9/3.
 */
//STEP 1. Import required packages

import java.sql.*;
import java.io.*;

public class JDBCFun2 {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://121.41.106.210:3306/51qed?useUnicode=true&characterEncoding=UTF-8";

    //  Database credentials
    static final String USER = "xiaotong";
    static final String PASS = "xtong18";
    static final String sql = "SELECT \n" +
            "    product_info.product_name AS '项目名称',\n" +
            "    user_info.real_name AS '用户姓名',\n" +
            "    user_info.telephone AS 手机号,\n" +
            "    ROUND(order_info.order_money) AS 订单金额,\n" +
            "    order_info.create_time AS 订单创建时间,\n" +
            "    order_info.pay_time AS 订单确认时间,\n" +
            "    Z.ord AS 个人序数,\n" +
            "    IF(Z.ord = 1, '\u662f', '\u5426') AS 是否首投,\n" +
            "    ifnull(H.real_name,'') AS 推荐人\n" +
            "FROM\n" +
            "    (SELECT @ord:=0, @pre_uid:=- 1) AS r,\n" +
            "    order_info\n" +
            "        INNER JOIN\n" +
            "    product_info ON order_info.order_product_tid = product_info.id\n" +
            "        AND order_info.order_status_id = 100567\n" +
            "        INNER JOIN\n" +
            "    user_info ON order_info.order_user_tid = user_info.id\n" +
            "        LEFT JOIN\n" +
            "    (SELECT \n" +
            "        user_info.id AS id, user_info.real_name AS real_name\n" +
            "    FROM\n" +
            "        user_info) AS H ON user_info.referrer_id = H.id\n" +
            "        LEFT JOIN\n" +
            "    (SELECT \n" +
            "        id,\n" +
            "            CASE\n" +
            "                WHEN @pre_uid = order_user_tid THEN @ord:=@ord + 1\n" +
            "                WHEN @pre_uid != order_user_tid THEN @ord:=1\n" +
            "            END AS ord,\n" +
            "            @pre_uid:=order_user_tid\n" +
            "    FROM\n" +
            "        order_info, (SELECT @ord, @pre_uid) AS r\n" +
            "    WHERE\n" +
            "        order_status_id = 100567\n" +
            "    ORDER BY order_user_tid , create_time) AS Z ON Z.id = order_info.id\n" +
            "WHERE\n" +
            "    order_info.create_time >= '2015-9-1'\n" +
            "ORDER BY order_info.create_time DESC\n" +
            ";";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            File file = new File("D:/a.txt");

            //STEP 5: Extract data from result set
            System.out.print(rsmd.getColumnLabel(1) + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t");
            System.out.print(rsmd.getColumnLabel(2) + "\t");
            System.out.print(rsmd.getColumnLabel(3) + "\t" + "\t" + "\t");
            System.out.print(rsmd.getColumnLabel(4) + "\t");
            System.out.print(rsmd.getColumnLabel(5) + "\t" + "\t" + "\t" + "\t");
            System.out.print(rsmd.getColumnLabel(6) + "\t" + "\t" + "\t" + "\t");
            System.out.print(rsmd.getColumnLabel(7) + "\t");
            System.out.print(rsmd.getColumnLabel(8) + "\t");
            System.out.print(rsmd.getColumnLabel(9) + "\t");
            System.out.println();
            while (rs.next()) {
                //Retrieve by column name
             /*   int id  = rs.getInt("id");
                String real_name = rs.getString("real_name");

                //Display values
                System.out.print(id+"\t");
                System.out.print(real_name+"\t");*/
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    if (i == 1) {
                        if (rs.getString(1).length() <= 12) {
                            System.out.print(rs.getString(i) + "\t" + "\t" + "\t" + "\t");
                        } else {
                            System.out.print(rs.getString(i) + "\t" + "\t");
                        }
                    } else if (i >= 7) {
                        System.out.print(rs.getString(i) + "\t" + "\t" + "\t");
                    } else {
                        System.out.print(rs.getString(i) + "\t" + "\t");
                    }
                }
                System.out.println();
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println();
    }//end main
}
