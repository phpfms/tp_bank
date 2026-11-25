package app;

import java.util.List;

import dao.OperationDAO;
import database.SqlQuery;
import model.Operation;

public class Application {
    public static void main(String[] args) {
        // On prépare la requête (Le Builder)
        String sql = new SqlQuery.Builder()
                        .table("operation")
                        .filter("type = 'RETRAIT'")
                        .sort("date")
                        .build();

        // On demande au DAO d'aller chercher les données
        OperationDAO dao = new OperationDAO();
        List<Operation> withdraw = dao.getOperation(sql);

        // On affiche le résultat
        System.out.println("--- LISTE DES RETRAITS ---");
        for (Operation op : withdraw) {
            System.out.println(op);
        }
    }
}