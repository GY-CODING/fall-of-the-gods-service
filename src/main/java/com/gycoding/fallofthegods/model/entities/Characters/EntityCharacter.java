package com.gycoding.fallofthegods.model.entities.characters;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.gycoding.fallofthegods.model.entities.EntityStat;
import com.gycoding.fallofthegods.model.entities.items.EntityItemStat;
import com.gycoding.fallofthegods.model.entities.worlds.EntityWorld;

@Document(collection = "Character")
public class EntityCharacter {
    @Id
    private String mongoId;
    private String identifier;
    private String name;
    private String title;
    private String description;
    private EntityWorld world;
    private Boolean inGame;
    private String image;
    private EntityStat<Double> stats;
    private EntityAbility ability;
    private List<EntityStory> stories;

    public EntityCharacter(String mongoId, String identifier, String name, String title, String description, EntityWorld world, Boolean inGame, String image, EntityStat<Double> stats, EntityAbility ability, List<EntityStory> stories) {
        this.mongoId        = mongoId;
        this.identifier     = identifier;
        this.name           = name;
        this.title          = title;
        this.description    = description;
        this.world          = world;
        this.inGame         = inGame;
        this.image          = image;
        this.stats          = stats;
        this.ability        = ability;
        this.stories        = stories;
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

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
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
    
    public EntityStat<Double> getStats() {
        return stats;
    }
    public void setStats(EntityStat<Double> stats) {
        this.stats = stats;
    }
    
    public EntityAbility getAbility() {
        return ability;
    }
    public void setAbility(EntityAbility ability) {
        this.ability = ability;
    }

    public List<EntityStory> getStories() {
        return stories;
    }
    public void setStories(List<EntityStory> stories) {
        this.stories = stories;
    }

    @Override
    public String toString() {
        return "{" +
                "\"identifier\": \"" + identifier + "\"," +
                "\"name\": \"" + name + "\"," +
                "\"title\": \"" + title + "\"," +
                "\"description\": \"" + description + "\"," +
                "\"world\": " + world + "," +
                "\"image\": \"" + image + "\"," +
                "\"stats\": " + stats + "," +
                "\"ability\": " + ability + "," +
                "\"stories\": " + stories +
                "}";
    }
}
