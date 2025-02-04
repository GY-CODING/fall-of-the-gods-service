package org.gycoding.fallofthegods.infrastructure.api.mapper;

import org.gycoding.fallofthegods.application.dto.in.achievements.AchievementIDTO;
import org.gycoding.fallofthegods.application.dto.in.characters.CharacterIDTO;
import org.gycoding.fallofthegods.application.dto.out.achievements.AchievementODTO;
import org.gycoding.fallofthegods.application.dto.out.characters.CharacterODTO;
import org.gycoding.fallofthegods.domain.model.characters.CharacterMO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.achievements.AchievementRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.characters.CharacterRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.achievements.AchievementRSDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.characters.CharacterRSDTO;
import org.gycoding.fallofthegods.shared.mapper.CharacterMapperUtils;
import org.gycoding.fallofthegods.shared.mapper.WorldMapperUtils;
import org.gycoding.fallofthegods.shared.util.StringTranslator;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CharacterControllerMapper {
    default CharacterIDTO toIDTO(CharacterRQDTO character) {
        if (character == null) {
            return null;
        }

        return CharacterIDTO.builder()
                .identifier(character.identifier())
                .name(character.name())
                .title(character.title())
                .description(character.description())
                .world(WorldMapperUtils.toWorldIDTO(character.world()))
                .inGame(character.inGame())
                .image(character.image())
                .stats(CharacterMapperUtils.toStatIDTO(character.stats()))
                .abilities(CharacterMapperUtils.toAbilityIDTOList(character.abilities()))
                .race(character.race())
                .attributes(CharacterMapperUtils.toAttributeIDTOList(character.attributes()))
                .build();
    }
    default CharacterRSDTO toRSDTO(CharacterODTO character) {
        if (character == null) {
            return null;
        }

        return CharacterRSDTO.builder()
                .identifier(character.identifier())
                .name(character.name())
                .title(character.title())
                .description(character.description())
                .world(character.world().identifier())
                .inGame(character.inGame())
                .image(character.image())
                .stats(CharacterMapperUtils.toStatRSDTO(character.stats()))
                .abilities(CharacterMapperUtils.toAbilityRSDTOList(character.abilities()))
                .race(character.race())
                .attributes(CharacterMapperUtils.toAttributeRSDTOList(character.attributes()))
                .build();
    }
}
