//sửa package phù hợp với Project của bạn
//Hãy nhớ import thư viện JDBC.jar trước khi làm
package buoi2_sof2041.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {

    //sửa tên database cần làm trong bài sau "database="
    public static String URL = "jdbc:sqlserver://localhost:1433;database=BUOI2_SOF2041";
    public static String USERNAME = "sa";
    //hãy sửa phần dữ liệu PASS trùng với pass được set ở tài khoảng sa của bạn.
    public static String PASS = "kakiethy12";
    //sau khi sửa tất cả thì hãy chạy chương trình này
    //nếu báo done thì đã kết nối thành công với DB
    //Nếu báo error thì hãy check pass hoặc DB

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() {
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(URL, USERNAME, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    }

    public static void main(String[] args) {
        Connection cn = getConnection();
        if (cn != null) {
            System.out.println("Done!!");
        } else {
            System.out.println("Error !!");
        }
    }

}
