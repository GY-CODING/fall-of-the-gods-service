package org.gycoding.heraldsofchaos.infrastructure.external.database.model.creatures;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.gycoding.heraldsofchaos.domain.model.TranslatedString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Creature")
public class CreatureEntity {
        @Id
        public String mongoId;
        public String identifier;
        public TranslatedString name;
        public TranslatedString description;
        public String image;
        public TranslatedString race;

        @Builder
        public CreatureEntity(String mongoId, String identifier, TranslatedString name, TranslatedString description, String image, TranslatedString race) {
            this.mongoId = mongoId;
            this.identifier = identifier;
            this.name = name;
            this.description = description;
            this.image = image;
            this.race = race;
        }
}