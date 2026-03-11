package DatabaseProgramming.test;

import java.sql.*;

public class TestDB1 {
public static void main(String[] args) throws SQLException {
    String url = "jdbc:mysql://localhost:3306/COREJAVA";
    String username = "neekon2508";
    String password = "Nghia2508@";
    Connection conn = DriverManager.getConnection(url, username, password);
    Statement sta = conn.createStatement();
    String command = "select * from AUTHORS";
    ResultSet result = sta.executeQuery(command);
    while(result.next())
    {
        String id = result.getString(1);
        String name = result.getString(2);
        String fname = result.getString(3);
        System.out.println(id+" "+name+" "+fname);
    }
    conn.close();
}
}
