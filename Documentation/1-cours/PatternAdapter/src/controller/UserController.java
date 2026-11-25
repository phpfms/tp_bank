package controller;

import model.User;
import view.UserView;
import userAdapter.UserAdapter;
import java.io.PrintWriter;
import java.util.List;

public class UserController {
	
	public void processData() {
        try {
            // Adapter (Système A -> Système B)
            UserAdapter adapter = new UserAdapter();
            List<User> users = adapter.xmlToUsers("users.xml");

            // View (Affichage JSON)
            new UserView().displayJson(users);

            // Storage (Système B écrit en TXT)
            PrintWriter writer = new PrintWriter("archive_users.txt");
            for (User u : users) {
                writer.println("USER_ID:" + u.id + "| FULLNAME:" + u.name + " " + u.surname+ "| Age: "+ u.age);
            }
            writer.close();
            System.out.println("\n Data saved");

        } catch (Exception e) { e.printStackTrace(); }
    }

}
