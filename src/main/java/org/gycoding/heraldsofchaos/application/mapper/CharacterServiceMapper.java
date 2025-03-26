package org.gycoding.heraldsofchaos.application.mapper;

import org.gycoding.heraldsofchaos.application.dto.in.characters.CharacterIDTO;
import org.gycoding.heraldsofchaos.application.dto.out.characters.CharacterODTO;
import org.gycoding.heraldsofchaos.domain.model.characters.CharacterMO;
import org.gycoding.heraldsofchaos.shared.mapper.CharacterMapperUtils;
import org.gycoding.heraldsofchaos.shared.mapper.WorldMapperUtils;
import org.gycoding.heraldsofchaos.shared.util.StringTranslator;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CharacterServiceMapper {
    default CharacterMO toMO(CharacterIDTO character) {
        if (character == null) {
            return null;
        }

        return CharacterMO.builder()
                .identifier(character.identifier())
                .name(character.name())
                .title(character.title())
                .description(character.description())
                .world(WorldMapperUtils.toWorldMO(character.world()))
                .inGame(character.inGame())
                .image(character.image())
                .stats(CharacterMapperUtils.toStatMO(character.stats()))
                .abilities(CharacterMapperUtils.toAbilityMOList(character.abilities()))
                .race(character.race())
                .attributes(CharacterMapperUtils.toAttributeMOList(character.attributes()))
                .build();
    }

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
                .stats(CharacterMapperUtils.toStatODTO(character.stats()))
                .abilities(CharacterMapperUtils.toAbilityODTOList(character.abilities(), language))
                .race(StringTranslator.translate(character.race(), language))
                .attributes(CharacterMapperUtils.toAttributeODTOList(character.attributes(), language))
                .build();
    }
}
