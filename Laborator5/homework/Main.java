package homework;

import homework.commands.*;
import homework.documents.Document;
import homework.documents.Image;
import homework.documents.Video;
import homework.exceptions.InvalidCatalogException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        try {
            app.testCreateSave();
        } catch (IOException  e) {
            e.printStackTrace();
        }
        try {
            app.testLoadView();
        } catch (InvalidCatalogException | IOException e) {
            e.printStackTrace();
        }

    }
    private void testCreateSave() throws IOException{
        Catalog catalog = new Catalog("Java Resources");
        Document doc = new Image("00001", "Orar", "/Users/lilschnapsidee/Documents/Facultate/Anul3_Sem2/Laborator5/files/ORAR.png");
        doc.addTag("type", "Image");
        Document doc2 = new Image("00002", "Punctaje", "/Users/lilschnapsidee/Documents/Facultate/Anul3_Sem2/Laborator5/files/Punctaje.png");
        doc2.addTag("type", "Image");
        Document doc3 = new Video("00003", "Video", "/Users/lilschnapsidee/Documents/Facultate/Anul3_Sem2/Laborator5/files/Video.mov");
        doc3.addTag("type", "Video");
        AddCommand.execute(catalog, doc);
        AddCommand.execute(catalog, doc2);
        AddCommand.execute(catalog, doc3);
        SaveCommand.execute(catalog, "/Users/lilschnapsidee/Documents/Facultate/Anul3_Sem2/Laborator5/Java.json");
    }
    private void testLoadView() throws InvalidCatalogException, IOException {
        Catalog catalog = LoadCommand.execute("/Users/lilschnapsidee/Documents/Facultate/Anul3_Sem2/Laborator5/Java.json");
        ViewCommand.execute(catalog, "00001");
        ReportCommand.execute(catalog, "/Users/lilschnapsidee/Documents/Facultate/Anul3_Sem2/Laborator5/Report.html");
    }
}
