package org.gycoding.fallofthegods.infrastructure.external.database.model.worlds;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.gycoding.fallofthegods.domain.model.TranslatedString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "World")
public class WorldEntity {
        @Id
        public String mongoId;
        public String identifier;
        public TranslatedString name;
        public TranslatedString description;
        public String image;
        public String detailedIcon;
        public String mainColor;
        @DBRef
        public List<PlaceEntity> places;

        @Builder
        public WorldEntity(String mongoId, String identifier, TranslatedString name, TranslatedString description, String image, String detailedIcon, String mainColor, List<PlaceEntity> places) {
            this.mongoId = mongoId;
            this.identifier = identifier;
            this.name = name;
            this.description = description;
            this.image = image;
            this.detailedIcon = detailedIcon;
            this.mainColor = mainColor;
            this.places = places;
        }
}