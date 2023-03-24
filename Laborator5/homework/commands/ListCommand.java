package homework.commands;

import homework.Catalog;
import homework.documents.Document;

public class ListCommand implements Command{
    public static void execute(Catalog catalog){
        for (Document doc : catalog.getDocs()) {
            System.out.println(doc);
        }
    }
}
