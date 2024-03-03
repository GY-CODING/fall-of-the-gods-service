package com.gycoding.fallofthegods.model.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Character")
public class EntityCharacter {
    @Id
    private String mongoId;
    private int id;
    private String name;
    private String description;
    private EntityWorld world;
    
    public EntityCharacter(String mongoId, String name, String description, EntityWorld world) {
        this.mongoId        = mongoId;
        this.name           = name;
        this.description    = description;
        this.world          = world;
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

    public EntityWorld getWorld() {
        return world;
    }
    public void setWorld(EntityWorld world) {
        this.world = world;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\": \"" + id + "\"," +
                "\"name\": \"" + name + "\"," +
                "\"description\": \"" + description + "\"," +
                "\"world\": " + world.toString() +
                "}";
    }
}
