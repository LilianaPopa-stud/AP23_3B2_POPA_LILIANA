package bonus.commands;

import bonus.Catalog;
import bonus.documents.Document;

public class ListCommand implements Command {
    public static void execute(Catalog catalog){
        for (Document doc : catalog.getDocs()) {
            System.out.println(doc);
        }
    }
}
