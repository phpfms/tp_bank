package connection;
import database.Database;

public class ConnectionOracle implements Database {
	public void connected() {
		System.out.println("Connexion à Oracle réussie");
	}
}
