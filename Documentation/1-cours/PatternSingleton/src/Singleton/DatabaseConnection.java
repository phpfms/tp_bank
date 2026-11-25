package Singleton;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    private static DatabaseConnection instance;
    private String url;
    private String user;
    private String password;

    //Constructeur privé : personne ne peut faire "new DatabaseConnection()"
    private DatabaseConnection() {
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

    // point d'accès unique getInstance() au lieu de new DatabaseConnection()
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void executeRequest(String sql) {
        System.out.println("Exécution sur [" + url + "] : " + sql);
    }
}