package com.gycoding.fallofthegods.model.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "World")
public class EntityWorld {
    @Id
    private String mongoId;
    private int id;
    private String name;
    private String description;
    private List<EntityPlace> places;
    
    public EntityWorld(String mongoId, String name, String description, List<EntityPlace> places) {
        this.mongoId = mongoId;
        this.name = name;
        this.description = description;
        this.places = places != null ? places : new ArrayList<EntityPlace>();
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
                "\"id\": \"" + id + "\"," +
                "\"name\": \"" + name + "\"," +
                "\"description\": \"" + description + "\"," +
                "\"places\": " + places.toString() +
                "}";
    }
}
