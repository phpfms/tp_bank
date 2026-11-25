import Builder.SqlQuery;
import Singleton.DatabaseConnection;

public class Application {
    public static void main(String[] args) {
    	
    	// Premier appel : la connexion est créée
        DatabaseConnection conn = DatabaseConnection.getInstance();
        
        
        // On construit la requête "à la carte"
        String request = new SqlQuery.Builder()
                                .table("operation")
                                .filter("type = 'DEPOT'")
                                .sort("montant")
                                .build();

        conn.executeRequest(request);
        
    }
}
