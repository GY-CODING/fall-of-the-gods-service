package org.gycoding.fallofthegods.model.dto.worlds;

import lombok.Builder;
import org.gycoding.fallofthegods.model.entities.TranslatedString;

import java.util.List;
import java.util.Map;

@Builder
public record WorldRSDTO(
        String identifier,
        String name,
        String description,
        String image,
        String detailedIcon,
        List<PlaceRSDTO> places
) {
    public List<PlaceRSDTO> listPlaces() {
        return places;
    }

    public PlaceRSDTO getPlace(String id) {
        PlaceRSDTO placeFound = null;

        for(PlaceRSDTO place : places) {
            if(place.identifier().equals(id)) {
                placeFound = place;
                break;
            }
        }

        return placeFound;
    }

    public void addPlace(PlaceRSDTO place) {
        this.places.add(place);
    }

    public void removePlace(String id) {
        PlaceRSDTO placeFound = null;

        for(PlaceRSDTO place : places) {
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
