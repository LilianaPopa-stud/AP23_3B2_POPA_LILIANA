package homework.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import homework.exceptions.InvalidCatalogException;
import homework.Catalog;

import java.io.File;
import java.io.IOException;

public class LoadCommand implements Command{
    public static Catalog execute(String path) throws InvalidCatalogException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(
                    new File(path),
                    Catalog.class);
        } catch (IOException e) {
            throw new InvalidCatalogException(e);
        }

    }
}
