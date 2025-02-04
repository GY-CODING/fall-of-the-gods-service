package org.gycoding.fallofthegods.application.dto.out.worlds;

import lombok.Builder;

import java.util.List;
import java.util.Map;

@Builder
public record WorldODTO(
        String identifier,
        String name,
        String description,
        String image,
        String detailedIcon,
        List<PlaceODTO> places
) {
    public List<PlaceODTO> listPlaces() {
        return places;
    }

    public PlaceODTO getPlace(String id) {
        PlaceODTO placeFound = null;

        for(PlaceODTO place : places) {
            if(place.identifier().equals(id)) {
                placeFound = place;
                break;
            }
        }

        return placeFound;
    }

    public void addPlace(PlaceODTO place) {
        this.places.add(place);
    }

    public void removePlace(String id) {
        PlaceODTO placeFound = null;

        for(PlaceODTO place : places) {
            if(place.identifier().equals(id)) {
                placeFound = place;
                break;
            }
        }

        if(placeFound != null) {
            this.places.remove(placeFound);
        }
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
