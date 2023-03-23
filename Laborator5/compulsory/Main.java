package compulsory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        try {
            app.testCreateSave();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            app.testLoadView();
        } catch (InvalidCatalogException | IOException e) {
            e.printStackTrace();
        }

    }
    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("Java Resources");
        Document doc = new Document("00001", "Orar", "/Users/lilschnapsidee/Desktop/ORAR.png");
        doc.addTag("type", "Image");
        Document doc2 = new Document("00002", "Orar", "/Users/lilschnapsidee/Desktop/Punctaje.png");
        doc2.addTag("type", "Image");
        Document doc3 = new Document("00003", "Orar", "/Users/lilschnapsidee/Desktop/Video.mov");
        doc3.addTag("type", "Video");
        catalog.add(doc3);
        catalog.add(doc);
        catalog.add(doc2);
        CatalogUtil.save(catalog,"/Users/lilschnapsidee/Documents/Facultate/Anul3_Sem2/Laborator5/Java.json");
    }
    private void testLoadView() throws InvalidCatalogException, IOException {
        Catalog catalog = CatalogUtil.load("/Users/lilschnapsidee/Documents/Facultate/Anul3_Sem2/Laborator5/Java.json");
        CatalogUtil.view(catalog.findById("00003"));
    }
}
