package com.gycoding.fallofthegods.model.entities.characters;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Story")
public class EntityStory {
    @Id
    private String mongoId;
    private String identifier;
    private String title;
    private String text;

    public EntityStory(String mongoId, String identifier, String title, String text) {
        this.mongoId        = mongoId;
        this.identifier     = identifier;
        this.title          = title;
        this.text           = text;
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

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "{" +
                "\"mongoId\": \"" + mongoId + "\"," +
                "\"identifier\": \"" + identifier + "\"," +
                "\"title\": \"" + title + "\"," +
                "\"text\": \"" + text + "\"" +
                "}";
    }
}
