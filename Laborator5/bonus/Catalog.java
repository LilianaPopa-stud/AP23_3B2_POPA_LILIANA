package bonus;

import bonus.documents.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private List<Document> docs = new ArrayList<>();

    public Catalog() {
    }
    public Catalog(String name) {
        this.name = name;
    }

    public Catalog(String name, List<Document> docs) {
        this.name = name;
        this.docs = docs;
    }

    public Document findById(String id) {
        return docs.stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Document> getDocs() {
        return docs;
    }

    public void setDocs(List<Document> docs) {
        this.docs = docs;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", docs=" + docs +
                '}';
    }
}