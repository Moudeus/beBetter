package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB implements DatabaseInfo{
    private static ConnectDB instance;
    public ConnectDB(){

    }
    public Connection openConnecion() throws Exception{
        Class.forName(driverName);
        Connection con = DriverManager.getConnection(url,user,password);
        return con;
    }
    public static ConnectDB getInstance(){
        if (instance == null){
            instance = new ConnectDB();
        }
        return  instance;
    }
}
