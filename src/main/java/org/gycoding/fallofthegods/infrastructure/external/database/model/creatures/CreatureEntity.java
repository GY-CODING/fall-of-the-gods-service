package org.gycoding.fallofthegods.infrastructure.external.database.model.creatures;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.gycoding.fallofthegods.domain.model.TranslatedString;
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
        public Boolean inGame;
        public String image;

        @Builder
        public CreatureEntity(String mongoId, String identifier, TranslatedString name, TranslatedString description, Boolean inGame, String image) {
            this.mongoId = mongoId;
            this.identifier = identifier;
            this.name = name;
            this.description = description;
            this.inGame = inGame;
            this.image = image;
        }
}