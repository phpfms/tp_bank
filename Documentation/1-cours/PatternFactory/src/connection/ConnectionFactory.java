package connection;
import database.Database;

public class ConnectionFactory {
    public Database CreateConnection(String type) {
        if (type.equalsIgnoreCase("MYSQL")) {
            return new ConnectionMySQL();
        } else if (type.equalsIgnoreCase("ORACLE")) {
            return new ConnectionOracle();
        }else
        	throw new UnsupportedOperationException("Type de base de données non supporté : " + type);
        
    }
}