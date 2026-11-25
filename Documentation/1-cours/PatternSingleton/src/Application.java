import Singleton.DatabaseConnection;

public class Application {
    public static void main(String[] args) {
        // Premier appel : la connexion est créée
        DatabaseConnection conn1 = DatabaseConnection.getInstance();
        conn1.executeRequest("SELECT * FROM comptes");

        // Deuxième appel : on réutilise la connexion existante, on n'en recrée pas !
        DatabaseConnection conn2 = DatabaseConnection.getInstance();
        conn2.executeRequest("SELECT * FROM operations");

        if (conn1 == conn2) {
            System.out.println("C'est exactement le même objet de connexion.");
        }else
        	 System.out.println("Les deux objets de connexion sont différents.");
    }
}