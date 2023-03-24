package homework.documents;

import homework.documents.Document;

import java.util.Map;

public class Video extends Document {
    public Video(String id, String name, String location) {
        super(id, name, location);
    }

    public Video(String id, String name, String location, Map<String, Object> tags) {
        super(id, name, location, tags);
    }
}
