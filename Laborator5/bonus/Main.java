package bonus;

import bonus.commands.*;
import bonus.documents.Document;
import bonus.documents.Image;
import bonus.documents.Video;
import bonus.exceptions.InvalidCatalogException;
import org.apache.tika.exception.TikaException;

import java.io.IOException;

public class Main {
    private static final String PATH = "/Users/lilschnapsidee/Documents/Facultate/Anul3_Sem2/Laborator5/Java.json" ;
    public static void main(String[] args) {
        Main app = new Main();
        try {
            app.testCreateSave();
            app.testLoadView();
            app.getReport();
            app.testList();
            app.testInfo();
        } catch (Exception e) {
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
        SaveCommand.execute(catalog, PATH);
    }
    private void testLoadView() throws InvalidCatalogException, IOException, TikaException {
        Catalog catalog = LoadCommand.execute(PATH);
        ViewCommand.execute(catalog, "00001");
    }
    private void getReport() throws InvalidCatalogException, IOException {
        Catalog catalog = LoadCommand.execute(PATH);
        ReportCommand.execute(catalog, "/Users/lilschnapsidee/Documents/Facultate/Anul3_Sem2/Laborator5/Report.html");
    }
    private void testList() throws InvalidCatalogException, IOException {
        Catalog catalog = LoadCommand.execute(PATH);
        ListCommand.execute(catalog);
    }
    private void testInfo() throws InvalidCatalogException, IOException, TikaException {
        Catalog catalog = LoadCommand.execute(PATH);
        InfoCommand.execute(catalog);
    }
}
