package com.gycoding.fallofthegods.model.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Place")
public class EntityPlace {
    @Id
    private String mongoId;
    private int id;
    private String name;
    private String description;
    
    public EntityPlace(String mongoId, String name, String description) {
        this.mongoId        = mongoId;
        this.name           = name;
        this.description    = description;
    }

    public String getMongoId() {
        return mongoId;
    }
    public void setMongoId(String mongoId) {
        this.mongoId = mongoId;
    }

    public int getID() {
        return id;
    }
    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\": \"" + id + "\"," +
                "\"name\": \"" + name + "\"," +
                "\"description\": \"" + description + "\"" +
                "}";
    }
}
