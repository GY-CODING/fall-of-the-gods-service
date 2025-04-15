package org.gycoding.fallofthegods.infrastructure.external.database.model.items;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.items.ItemType;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@Document(collection = "Item")
public record ItemEntity(
    @Id
    String mongoId,
    String identifier,
    TranslatedString name,
    TranslatedString description,
    String image,
    Boolean inGame,
    ItemType type,
    List<ItemEntity> fragments
) {}
