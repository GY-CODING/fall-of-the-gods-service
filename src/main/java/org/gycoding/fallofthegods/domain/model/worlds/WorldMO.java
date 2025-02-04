package org.gycoding.fallofthegods.domain.model.worlds;

import lombok.Builder;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;

import java.util.List;

@Builder
public record WorldMO(
        String identifier,
        TranslatedString name,
        TranslatedString description,
        String image,
        String detailedIcon,
        List<PlaceMO> places
) {
    public List<PlaceMO> listPlaces() {
        return places;
    }

    public PlaceMO getPlace(String id) {
        PlaceMO placeFound = null;

        for(PlaceMO place : places) {
            if(place.identifier().equals(id)) {
                placeFound = place;
                break;
            }
        }

        return placeFound;
    }

    public void addPlace(PlaceMO place) {
        this.places.add(place);
    }

    public void removePlace(String id) {
        PlaceMO placeFound = null;

        for(PlaceMO place : places) {
            if(place.identifier().equals(id)) {
                placeFound = place;
                break;
            }
        }

        if(placeFound != null) {
            this.places.remove(placeFound);
        }
    }
}
