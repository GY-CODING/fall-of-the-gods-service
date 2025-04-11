package org.gycoding.fallofthegods.application.mapper;

import org.gycoding.fallofthegods.application.dto.in.worlds.WorldIDTO;
import org.gycoding.fallofthegods.application.dto.out.worlds.WorldODTO;
import org.gycoding.fallofthegods.domain.model.worlds.WorldMO;
import org.gycoding.fallofthegods.shared.mapper.WorldMapperUtils;
import org.gycoding.fallofthegods.shared.util.StringTranslator;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorldServiceMapper {
    WorldMO toMO(WorldIDTO world);

    default WorldODTO toODTO(WorldMO world, String language) {
        if (world == null) {
            return null;
        }

        return WorldODTO.builder()
                .identifier(world.identifier())
                .name(StringTranslator.translate(world.name(), language))
                .description(StringTranslator.translate(world.description(), language))
                .image(world.image())
                .detailedIcon(world.detailedIcon())
                .mainColor(world.mainColor())
                .places(WorldMapperUtils.toPlaceODTOList(world.places(), language))
                .build();
    }
}
