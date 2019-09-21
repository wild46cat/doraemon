package com.example.demo.controller;

//import com.mongodb.MongoClient;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//import org.bson.Document;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@RestController
@RequestMapping("/mongo")
public class MongoController {
    /*private static MongoClient mongoClient;

    static {
        mongoClient = new MongoClient("", 27017);
    }

    @RequestMapping("/insert")
    public void insert() {
        MongoDatabase mongoDatabase = mongoClient.getDatabase("xytest");
        MongoCollection<Document> collection = mongoDatabase.getCollection("user");
        Document document = new Document("title", "MongoDB").
                append("description", "database").
                append("likes", 100).
                append("by", "Fly");
        List<Document> documents = new ArrayList<Document>();
        documents.add(document);
        collection.insertMany(documents);
        System.out.println("文档插入成功");
    }
*/

}
