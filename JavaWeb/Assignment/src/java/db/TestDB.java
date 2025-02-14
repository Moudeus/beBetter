package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDB implements DatabaseInfo{
    public static void main(String[] args) throws Exception {
        ConnectDB db = ConnectDB.getInstance();
        Connection con = db.openConnecion();
        String sql = "SELECT * FROM master.users;";
        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            String userid = rs.getString(1);
            String Username = rs.getString(2);
            String Email = rs.getString(3);
            String Dob = rs.getString(4);
            String Active = rs.getString(5);
            String Pass = rs.getString(6);
            String PhoneNumber = rs.getString(7);
            System.out.println(userid + " " + Username + " "+Email + " "+Dob + " "+Active + " "+Pass + " "+PhoneNumber + " ");
        }
        con.close();
        stmt.close();
        rs.close();
    }

}
