package homework.commands;

import homework.Catalog;
import homework.documents.Document;

/**
 * This class represents the add command.
 * @author: Popa Liliana
 */
public class AddCommand implements Command {
    public static void execute(Catalog catalog, Document document){
        catalog.getDocs().add(document);
    }
}
