package Singleton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    private static DatabaseConnection instance;
    private Connection connection;
    private String url;
    private String user;
    private String password;

    private DatabaseConnection() {
    	this.url = "jdbc:mysql://localhost:3306/tp_bank";
        this.user = "tp_bank";
        this.password = "8ePP[S[uFtxpAgWd";
        try {
        	this.connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connection OK !!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    }

    // point d'accès unique
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void executeRequest(String sql) {
    	try {
            // On récupère la connexion réelle
            var conn = DatabaseConnection.getInstance().connection;
            
            // On prépare et on exécute la requête
            var statement = conn.createStatement();
            var resultat = statement.executeQuery(sql);

            
            System.out.println("ID | COMPTE | TYPE | MONTANT");
            while (resultat.next()) {
                int id = resultat.getInt("id");
                String compte = resultat.getString("compte_source_id");
                String type = resultat.getString("type");
                double montant = resultat.getDouble("montant");

                System.out.println(id + " | " + compte + " | " + type + " | " + montant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}