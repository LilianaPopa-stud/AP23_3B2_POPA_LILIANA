package homework.commands;

import homework.Catalog;
import homework.documents.Document;
import homework.exceptions.InvalidCatalogException;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command{
    public static void execute(Catalog catalog, String id) throws InvalidCatalogException, IOException {
        Document doc = catalog.findById(id);
        if (doc == null) {
            System.out.println("Document not found!");
            return;
        }
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(doc.getLocation()));

    }
}
