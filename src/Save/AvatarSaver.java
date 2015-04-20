package Save;

import model.entity.avatar.Avatar;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class AvatarSaver {

    private static AvatarSaver instance = null;

    public static AvatarSaver getInstance() {
        if(instance != null) {
            return instance;
        }
        else {
            instance = new AvatarSaver();
            return instance;
        }
    }

    public AvatarSaver(){}

    public Element createElement(Document doc, Avatar avatar) {
        Element avatarElement = doc.createElement("avatar");

        Element name = doc.createElement("name");
        name.appendChild(doc.createTextNode(avatar.getName()));
        avatarElement.appendChild(name);

        Element description = doc.createElement("description");
        name.appendChild(doc.createTextNode(avatar.getDescription()));
        avatarElement.appendChild(description);

        return avatarElement;

    }
}
