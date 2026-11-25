package view;
import model.User;
import java.util.List;

public class UserView {
    public void displayJson(List<User> users) {
        System.out.println("--- AFFICHAGE SYSTEME B (JSON) ---");
        for (User u : users) {
            System.out.printf("{\"id\": %d, \"name\": \"%s %s\", \"age\": %d}%n", u.id, u.surname, u.name, u.age);
        }
    }
}