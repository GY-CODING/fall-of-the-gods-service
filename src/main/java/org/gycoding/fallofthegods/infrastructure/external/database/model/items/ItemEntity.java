package org.gycoding.fallofthegods.infrastructure.external.database.model.items;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.gycoding.fallofthegods.domain.model.TranslatedString;
import org.gycoding.fallofthegods.domain.model.items.ItemType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Item")
public class ItemEntity {
    @Id
    public String mongoId;
    public String identifier;
    public TranslatedString name;
    public TranslatedString description;
    public String image;
    public Boolean inGame;
    public ItemType type;

    @Builder
    public ItemEntity(String mongoId, String identifier, TranslatedString name, TranslatedString description, String image, Boolean inGame, ItemType type) {
        this.mongoId = mongoId;
        this.identifier = identifier;
        this.name = name;
        this.description = description;
        this.image = image;
        this.inGame = inGame;
        this.type = type;
    }
}