package homework.v3;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.MongoClient;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HomeWork {
    public static final String SOURCE_FILE = "homework.parameters.json";

    public static void main(String[] args) throws IOException {

        MongoClient client = new MongoClient("localhost", 2717);
        MongoDatabase database = client.getDatabase("serialize-data");
        MongoCollection<Document> collection = database.getCollection("parameters");

        String content = new String (Files.readAllBytes(Paths.get(SOURCE_FILE)));

        Document document = Document.parse(content);
        collection.insertOne(document);
    }
}
