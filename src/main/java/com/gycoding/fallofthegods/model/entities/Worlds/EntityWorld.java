package com.gycoding.fallofthegods.model.entities.Worlds;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "World")
public class EntityWorld {
    @Id
    private String mongoId;
    private String identifier;
    private String name;
    private String description;
    private String image;
    private List<EntityPlace> places;
    
    public EntityWorld(String mongoId, String identifier, String name, String description, String image, List<EntityPlace> places) {
        this.mongoId        = mongoId;
        this.identifier     = identifier;
        this.name           = name;
        this.description    = description;
        this.image          = image;
        this.places         = places != null ? places : new ArrayList<EntityPlace>();
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

    public List<EntityPlace> listPlaces() {
        return places;
    }
    public EntityPlace getPlace(int id) {
        return places.get(id);
    }
    public void addPlace(EntityPlace place) {
        this.places.add(place);
    }
    public void removePlace(int id) {
        this.places.remove(id);
    }

    @Override
    public String toString() {
        return "{" +
                "\"identifier\": \"" + identifier + "\"," +
                "\"name\": \"" + name + "\"," +
                "\"description\": \"" + description + "\"," +
                "\"image\": \"" + image + "\"," +
                "\"places\": " + places.toString() +
                "}";
    }
}
