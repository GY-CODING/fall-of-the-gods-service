package com.gycoding.fallofthegods.model.entities.characters;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Story")
public class EntityStory {
    @Id
    private String mongoId;
    private String identifier;
    private String title;
    private String text;
    private List<EntityCharacter> participants;

    public EntityStory(String mongoId, String identifier, String title, String text, List<EntityCharacter> participants) {
        this.mongoId        = mongoId;
        this.identifier     = identifier;
        this.title          = title;
        this.text           = text;
        this.participants   = participants;
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

    public List<EntityCharacter> getParticipants() {
        return participants;
    }
    public void setParticipants(List<EntityCharacter> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "{" +
                "\"mongoId\": \"" + mongoId + "\"," +
                "\"identifier\": \"" + identifier + "\"," +
                "\"title\": \"" + title + "\"," +
                "\"text\": \"" + text + "\"," +
                "\"participants\": " + participants.toString() +
                "}";
    }
}
