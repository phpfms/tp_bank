package app;

import controller.UserController;
import java.io.File;

public class Application {
	
	public static void main(String[] args) {
        System.out.println("========== DÉBUT DU TEST SYSTÈME B ==========");

        // Vérification de la présence du fichier source du Système A
        File xmlFile = new File("users.xml");
        if (!xmlFile.exists()) {
            System.err.println("Erreur : Le fichier 'users.xml' est introuvable à la racine du projet.");
            return;
        }

        try {
            // Initialisation du Contrôleur (C de MVC)
            // Le contrôleur va orchestrer l'Adapter, la View et le stockage
            UserController controller = new UserController();

            System.out.println("Action : Lancement du traitement des données utilisateurs...");
            
            controller.processData();

            System.out.println("\n========== TEST RÉUSSI ==========");
            

        } catch (Exception e) {
            System.err.println("\n========== ÉCHEC DU TEST ==========");
            e.printStackTrace();
        }
    }

}
