package org.gycoding.fallofthegods.application.mapper;

import org.gycoding.fallofthegods.application.dto.in.characters.CharacterIDTO;
import org.gycoding.fallofthegods.application.dto.out.characters.CharacterODTO;
import org.gycoding.fallofthegods.domain.model.characters.CharacterMO;
import org.gycoding.fallofthegods.shared.mapper.WorldMapperUtils;
import org.gycoding.fallofthegods.shared.util.StringTranslator;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CharacterServiceMapper {
    CharacterMO toMO(CharacterIDTO character);

    default CharacterODTO toODTO(CharacterMO character, String language) {
        if (character == null) {
            return null;
        }

        return CharacterODTO.builder()
                .identifier(character.identifier())
                .name(StringTranslator.translate(character.name(), language))
                .title(StringTranslator.translate(character.title(), language))
                .description(StringTranslator.translate(character.description(), language))
                .world(WorldMapperUtils.toWorldODTO(character.world(), language))
                .inGame(character.inGame())
                .image(character.image())
                .race(StringTranslator.translate(character.race(), language))
                .build();
    }
}
