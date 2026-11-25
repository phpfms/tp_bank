package app;
import connection.ConnectionFactory;
import database.Database;

public class Application {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();

        // Je veux du MySQL
        Database db = factory.CreateConnection("MYSQL");
        db.connected(); 

        // je change juste un mot ici :
        Database db2 = factory.CreateConnection("ORACLE");
        db2.connected();
        
    }
}