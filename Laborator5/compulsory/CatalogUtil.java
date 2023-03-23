package compulsory;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CatalogUtil {

    public static void save(Catalog catalog, String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.writeValue(new File(path), catalog);
    }
    public static Catalog load(String path) throws InvalidCatalogException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(
                new File(path),
                Catalog.class);
    }
    public static void view(Document doc) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(doc.getLocation()));
    }

}
