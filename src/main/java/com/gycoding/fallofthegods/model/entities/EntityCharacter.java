package com.gycoding.fallofthegods.model.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Character")
public class EntityCharacter {
    @Id
    private String mongoId;
    private String identifier;
    private String name;
    private String description;
    private EntityWorld world;
    private Boolean inGame;
    private String image;

    public EntityCharacter(String mongoId, String identifier, String name, String description, EntityWorld world, Boolean inGame, String image) {
        this.mongoId        = mongoId;
        this.identifier     = identifier;
        this.name           = name;
        this.description    = description;
        this.world          = world;
        this.inGame         = inGame;
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

    public EntityWorld getWorld() {
        return world;
    }
    public void setWorld(EntityWorld world) {
        this.world = world;
    }
    
    public Boolean getInGame() {
        return inGame;
    }
    public void setInGame(Boolean inGame) {
        this.inGame = inGame;
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
                "\"identifier\": \"" + identifier + "\"," +
                "\"name\": \"" + name + "\"," +
                "\"description\": \"" + description + "\"," +
                "\"world\": " + "\"" + world.getIdentifier() + "\"," +
                "\"image\": \"" + image + "\"" +
                "}";
    }
}
