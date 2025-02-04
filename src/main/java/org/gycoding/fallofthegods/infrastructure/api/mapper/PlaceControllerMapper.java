package org.gycoding.fallofthegods.infrastructure.api.mapper;

import org.gycoding.fallofthegods.application.dto.in.worlds.PlaceIDTO;
import org.gycoding.fallofthegods.application.dto.out.items.ItemODTO;
import org.gycoding.fallofthegods.application.dto.out.worlds.PlaceODTO;
import org.gycoding.fallofthegods.domain.model.items.ItemMO;
import org.gycoding.fallofthegods.domain.model.worlds.PlaceMO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.items.ItemRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.worlds.PlaceRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.items.ItemRSDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.worlds.PlaceRSDTO;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;
import org.gycoding.fallofthegods.shared.util.StringTranslator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlaceControllerMapper {
    PlaceIDTO toIDTO(PlaceRQDTO place);

    PlaceRSDTO toRSDTO(PlaceODTO place);
}
