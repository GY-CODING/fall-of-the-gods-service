package com.gycoding.fallofthegods.model.entities.worlds;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Builder
@Document(collection = "World")
public record EntityWorld(
    @Id
    String mongoId,
    String identifier,
    String name,
    String description,
    String image,
    String detailedIcon,
    List<EntityPlace> places
) {
    public List<EntityPlace> listPlaces() {
        return places;
    }

    public EntityPlace getPlace(String id) {
        EntityPlace placeFound = null;

        for(EntityPlace place : places) {
            if(place.identifier().equals(id)) {
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
            if(place.identifier().equals(id)) {
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
                "\"detailedIcon\": \"" + detailedIcon + "\"," +
                "\"places\": " + places.toString() +
                "}";
    }

    public Map<String, Object> toMap() {
        return Map.of(
                "identifier", identifier,
                "name", name,
                "description", description,
                "image", detailedIcon,
                "detailedIcon", detailedIcon,
                "places", places
        );
    }
}
