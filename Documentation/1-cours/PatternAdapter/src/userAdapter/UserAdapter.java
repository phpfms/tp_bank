package userAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document; 
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.User;

public class UserAdapter {
	public List<User> xmlToUsers(String filePath) throws Exception {
        List<User> users = new ArrayList<>();
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(filePath));
        NodeList nList = doc.getElementsByTagName("utilisateur");

        for (int i = 0; i < nList.getLength(); i++) {
            Element e = (Element) nList.item(i);
            users.add(new User(
                Integer.parseInt(e.getElementsByTagName("id").item(0).getTextContent()),
                e.getElementsByTagName("nom").item(0).getTextContent(),
                e.getElementsByTagName("prenom").item(0).getTextContent(),
                Integer.parseInt(e.getElementsByTagName("age").item(0).getTextContent())
            ));
        }
        return users;
    }
}
