package model;

public class Operation {
    private int id;
    private String accountNumber;
    private String typeOp;
    private double amount;
    private String dateOp;

    // Constructeur
    public Operation(int id, String account, String type, double amount, String dateOp ) {
        this.id = id;
        this.accountNumber = account;
        this.typeOp = type;
        this.amount = amount;
        this.dateOp = dateOp;
    }

    // Une méthode pour afficher joliment l'opération
    @Override
    public String toString() {
        return id + " | " + accountNumber + " | " + typeOp + " | " + amount + "€" + " | " + dateOp;
    }
}
