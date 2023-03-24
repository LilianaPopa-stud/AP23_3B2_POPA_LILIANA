package bonus.commands;

import bonus.Catalog;
import bonus.documents.Document;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;

import java.io.File;
import java.io.IOException;

public class InfoCommand implements Command {
    public static void execute(Catalog catalog) throws TikaException, IOException {
        TikaConfig tika = new TikaConfig();
        for (Document doc : catalog.getDocs()) {
            File file = new File(doc.getLocation());
            Metadata metadata = new Metadata();
            String type = tika.getDetector().detect(TikaInputStream.get(file,metadata), metadata).toString();
            System.out.println("File type: " + type);
        }

    }
}
