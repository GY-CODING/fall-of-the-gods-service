package org.gycoding.heraldsofchaos.application.mapper;

import org.gycoding.heraldsofchaos.application.dto.in.worlds.WorldIDTO;
import org.gycoding.heraldsofchaos.application.dto.out.worlds.WorldODTO;
import org.gycoding.heraldsofchaos.domain.model.worlds.WorldMO;
import org.gycoding.heraldsofchaos.shared.mapper.WorldMapperUtils;
import org.gycoding.heraldsofchaos.shared.util.StringTranslator;
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
                .places(WorldMapperUtils.toPlaceODTOList(world.places(), language))
                .build();
    }
}
