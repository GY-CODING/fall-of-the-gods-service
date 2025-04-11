package org.gycoding.fallofthegods.infrastructure.api.dto.in.worlds;

import lombok.Builder;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;

import java.util.List;
import java.util.Map;

@Builder
public record WorldRQDTO(
        String identifier,
        TranslatedString name,
        TranslatedString description,
        String image,
        String detailedIcon,
        String mainColor,
        List<PlaceRQDTO> places
) {
    public List<PlaceRQDTO> listPlaces() {
        return places;
    }

    public PlaceRQDTO getPlace(String id) {
        PlaceRQDTO placeFound = null;

        for(PlaceRQDTO place : places) {
            if(place.identifier().equals(id)) {
                placeFound = place;
                break;
            }
        }

        return placeFound;
    }

    public void addPlace(PlaceRQDTO place) {
        this.places.add(place);
    }

    public void removePlace(String id) {
        PlaceRQDTO placeFound = null;

        for(PlaceRQDTO place : places) {
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
                "\"mainColor\": \"" + mainColor + "\"," +
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
                "mainColor", mainColor,
                "places", places
        );
    }
}
