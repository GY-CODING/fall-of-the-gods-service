package com.gycoding.fallofthegods.model.entities.worlds;

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
    public EntityPlace getPlace(String id) {
        EntityPlace placeFound = null;

        for(EntityPlace place : places) {
            if(place.getIdentifier().equals(id)) {
                placeFound = place;
                break;
            }
        }

        return placeFound;
    }
    public void addPlace(EntityPlace place) {
        this.places.add(place);
    }
    public void removePlace(String id) {
        EntityPlace placeFound = null;

        for(EntityPlace place : places) {
            if(place.getIdentifier().equals(id)) {
                placeFound = place;
                break;
            }
        }

        if(placeFound != null) {
            this.places.remove(placeFound);
        }
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
