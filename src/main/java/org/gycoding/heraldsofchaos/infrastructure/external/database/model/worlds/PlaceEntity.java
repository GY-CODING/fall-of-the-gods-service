package org.gycoding.heraldsofchaos.infrastructure.external.database.model.worlds;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.gycoding.heraldsofchaos.domain.model.TranslatedString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Place")
public class PlaceEntity {
        @Id
        public String mongoId;
        public String identifier;
        public TranslatedString name;
        public TranslatedString description;
        public String image;

        @Builder
        public PlaceEntity(String mongoId, String identifier, TranslatedString name, TranslatedString description, String image) {
            this.mongoId = mongoId;
            this.identifier = identifier;
            this.name = name;
            this.description = description;
            this.image = image;
        }
}