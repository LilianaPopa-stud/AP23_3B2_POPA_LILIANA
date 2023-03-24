package bonus.documents;

import java.util.Map;

public class Article extends Document {
    public Article(String id, String name, String location) {
        super(id, name, location);
    }
    public Article(String id, String name, String location, Map<String, Object> tags) {
        super(id, name, location, tags);
    }

}
