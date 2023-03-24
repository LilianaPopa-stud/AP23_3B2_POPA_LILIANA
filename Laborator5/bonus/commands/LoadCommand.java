package bonus.commands;

import bonus.Catalog;
import bonus.exceptions.InvalidCatalogException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class LoadCommand implements Command {
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
