package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import model.Operation;

public class OperationDAO {
    
    public List<Operation> getOperation(String sql) {
        List<Operation> operation = new ArrayList<>();
        
        try {
            // On utilise notre Singleton pour obtenir les infos de connexion
        	Connection conn = DatabaseConnection.getInstance().getConnection();
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
            	operation.add(new Operation(
                    rs.getInt("id"),
                    rs.getString("compte_source_id"),
                    rs.getString("type"),
                    rs.getDouble("montant"),
                    rs.getString("date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return operation;
    }
}
