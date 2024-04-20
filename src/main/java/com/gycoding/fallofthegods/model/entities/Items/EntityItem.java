package com.gycoding.fallofthegods.model.entities.items;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.gycoding.fallofthegods.model.entities.EntityStat;

@Document(collection = "Item")
public class EntityItem {
    @Id
    private String mongoId;
    private String identifier;
    private String name;
    private String description;
    private String image;
    private Boolean inGame;
    private EntityStat<EntityItemStat> stats;
    
    public EntityItem(String mongoId, String name, String description, String image, Boolean inGame, EntityStat<EntityItemStat> stats) {
        this.mongoId        = mongoId;
        this.name           = name;
        this.description    = description;
        this.image          = image;
        this.inGame         = inGame;
        this.stats          = stats;
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

    public Boolean getInGame() {
        return inGame;
    }
    public void setInGame(Boolean inGame) {
        this.inGame = inGame;
    }

    public EntityStat<EntityItemStat> getStats() {
        return stats;
    }
    public void setStats(EntityStat<EntityItemStat> stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "{" +
                "\"identifier\": \"" + identifier + "\"," +
                "\"name\": \"" + name + "\"," +
                "\"description\": \"" + description + "\"," +
                "\"image\": \"" + image + "\"" +
                "\"stats\": " + stats +
                "}";
    }
}
