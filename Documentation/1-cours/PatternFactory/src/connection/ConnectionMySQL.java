package connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import database.Database;

public class ConnectionMySQL implements Database {
	private String url;
    private String user;
    private String password;
    
	public void connected() {
		this.url = "jdbc:mysql://localhost:3306/tp_bank";
        this.user = "tp_bank";
        this.password = "8ePP[S[uFtxpAgWd";
        
        try {
			DriverManager.getConnection(url, user, password);
			System.out.println("Connection OK !!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
