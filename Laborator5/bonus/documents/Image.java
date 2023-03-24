package bonus.documents;

import java.util.Map;

public class Image extends Document {
    public Image(String id, String name, String location) {
        super(id, name, location);
    }
    public Image(String id, String name, String location, Map<String, Object> tags) {
        super(id, name, location, tags);
    }
}
