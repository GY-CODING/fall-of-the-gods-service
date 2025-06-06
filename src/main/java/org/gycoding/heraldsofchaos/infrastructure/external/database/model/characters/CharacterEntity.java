package org.gycoding.heraldsofchaos.infrastructure.external.database.model.characters;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.gycoding.heraldsofchaos.domain.model.TranslatedString;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.worlds.WorldEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Character")
public class CharacterEntity {
        @Id
        public String mongoId;
        public String identifier;
        public TranslatedString name;
        public TranslatedString title;
        public TranslatedString description;
        @DBRef
        public WorldEntity world;
        public String image;
        public TranslatedString race;

        @Builder
        public CharacterEntity(String mongoId, String identifier, TranslatedString name, TranslatedString title, TranslatedString description, WorldEntity world, String image, TranslatedString race) {
                this.mongoId = mongoId;
                this.identifier = identifier;
                this.name = name;
                this.title = title;
                this.description = description;
                this.world = world;
                this.image = image;
                this.race = race;
        }
}