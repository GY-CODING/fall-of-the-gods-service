package com.gycoding.fallofthegods.model.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Place")
public class EntityPlace {
    @Id
    private String mongoId;
    private String identifier;
    private String name;
    private String description;
    private String image;
    
    public EntityPlace(String mongoId, String name, String description, String image) {
        this.mongoId        = mongoId;
        this.name           = name;
        this.description    = description;
        this.image          = image;
    }

    public String getMongoId() {
        return mongoId;
    }
    public void setMongoId(String mongoId) {
        this.mongoId = mongoId;
    }

    public String getIdentifier() {
        return identifier;
    }
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
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

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\": \"" + identifier + "\"," +
                "\"name\": \"" + name + "\"," +
                "\"description\": \"" + description + "\"," +
                "\"image\": \"" + image + "\"" +
                "}";
    }
}
