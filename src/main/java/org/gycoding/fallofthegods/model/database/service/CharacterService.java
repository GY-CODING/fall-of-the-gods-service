package org.gycoding.fallofthegods.model.database.service;

import org.gycoding.fallofthegods.model.database.repository.CharacterRepository;
import org.gycoding.fallofthegods.model.dto.characters.AbilityRSDTO;
import org.gycoding.fallofthegods.model.dto.characters.AttributeRSDTO;
import org.gycoding.fallofthegods.model.dto.characters.CharacterRSDTO;
import org.gycoding.fallofthegods.model.dto.worlds.WorldRSDTO;
import org.gycoding.fallofthegods.model.entities.exceptions.FOTGAPIError;
import org.gycoding.fallofthegods.model.entities.characters.EntityCharacter;
import org.gycoding.exceptions.model.APIException;
import org.hibernate.validator.internal.constraintvalidators.bv.NotBlankValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CharacterService {
    @Autowired
    private final CharacterRepository characterRepository = null;

    public CharacterRSDTO getStoryCharacter(String id, String language) throws APIException {
        final var characterEntity = characterRepository.findByIdentifier(id).orElseThrow(() ->
            new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            )
        );

        return CharacterRSDTO.builder()
                .identifier(characterEntity.identifier())
                .name(characterEntity.name().get(language))
                .description(characterEntity.description().get(language))
                .race(characterEntity.race().get(language))
                .title(characterEntity.title().get(language))
                .image(characterEntity.image())
                .inGame(characterEntity.inGame())
                .world(characterEntity.world() != null ? WorldRSDTO.builder()
                        .identifier(characterEntity.world().identifier())
                        .name(characterEntity.world().name().get(language))
                        .description(characterEntity.world().description().get(language))
                        .image(characterEntity.world().image())
                        .detailedIcon(characterEntity.world().detailedIcon())
                        .build() : null)
                .stats(characterEntity.stats())
                .ability(characterEntity.ability() != null ? AbilityRSDTO.builder()
                        .identifier(characterEntity.ability().identifier())
                        .name(characterEntity.ability().name().get(language))
                        .description(characterEntity.ability().description().get(language))
                        .damage(characterEntity.ability().damage())
                        .life(characterEntity.ability().life())
                        .cooldown(characterEntity.ability().cooldown())
                        .timeToHit(characterEntity.ability().timeToHit())
                        .build() : null)
                .attributes(!characterEntity.attributes().isEmpty() ? characterEntity.attributes().stream().map(attribute -> AttributeRSDTO.builder()
                        .identifier(attribute != null ? attribute.identifier() : null)
                        .name(attribute != null ? attribute.name().get(language) : null)
                        .description(attribute != null ? attribute.description().get(language) : null)
                        .build()).toList() : List.of())
                .build();
    }

    public List<CharacterRSDTO> listStoryCharacters(String language) throws APIException {
        try {
            final var characterEntities = characterRepository.findAll();

            return characterEntities.stream().map(characterEntity -> CharacterRSDTO.builder()
                    .identifier(characterEntity.identifier())
                    .name(characterEntity.name().get(language))
                    .description(characterEntity.description().get(language))
                    .race(characterEntity.race().get(language))
                    .title(characterEntity.title().get(language))
                    .image(characterEntity.image())
                    .inGame(characterEntity.inGame())
                    .world(characterEntity.world() != null ? WorldRSDTO.builder()
                            .identifier(characterEntity.world().identifier())
                            .name(characterEntity.world().name().get(language))
                            .description(characterEntity.world().description().get(language))
                            .image(characterEntity.world().image())
                            .detailedIcon(characterEntity.world().detailedIcon())
                            .build() : null)
                    .stats(characterEntity.stats())
                    .ability(characterEntity.ability() != null ? AbilityRSDTO.builder()
                            .identifier(characterEntity.ability().identifier())
                            .name(characterEntity.ability().name().get(language))
                            .description(characterEntity.ability().description().get(language))
                            .damage(characterEntity.ability().damage())
                            .life(characterEntity.ability().life())
                            .cooldown(characterEntity.ability().cooldown())
                            .timeToHit(characterEntity.ability().timeToHit())
                            .build() : null)
                    .attributes(!characterEntity.attributes().isEmpty() ? characterEntity.attributes().stream().map(attribute -> AttributeRSDTO.builder()
                            .identifier(attribute != null ? attribute.identifier() : null)
                            .name(attribute != null ? attribute.name().get(language) : null)
                            .description(attribute != null ? attribute.description().get(language) : null)
                            .build()).toList() : List.of())
                    .build()
            ).toList();
        } catch(NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }
    }

    public Page<Map<String, Object>> pageStoryCharacters(Pageable pageable, String language) throws APIException {
        try {
            final var characterEntities = characterRepository.findAll(pageable);

            return characterEntities.map(characterEntity -> CharacterRSDTO.builder()
                    .identifier(characterEntity.identifier())
                    .name(characterEntity.name().get(language))
                    .description(characterEntity.description().get(language))
                    .race(characterEntity.race().get(language))
                    .title(characterEntity.title().get(language))
                    .image(characterEntity.image())
                    .inGame(characterEntity.inGame())
                    .world(characterEntity.world() != null ? WorldRSDTO.builder()
                            .identifier(characterEntity.world().identifier())
                            .name(characterEntity.world().name().get(language))
                            .description(characterEntity.world().description().get(language))
                            .image(characterEntity.world().image())
                            .detailedIcon(characterEntity.world().detailedIcon())
                            .build() : null)
                    .stats(characterEntity.stats())
                    .ability(characterEntity.ability() != null ? AbilityRSDTO.builder()
                            .identifier(characterEntity.ability().identifier())
                            .name(characterEntity.ability().name().get(language))
                            .description(characterEntity.ability().description().get(language))
                            .damage(characterEntity.ability().damage())
                            .life(characterEntity.ability().life())
                            .cooldown(characterEntity.ability().cooldown())
                            .timeToHit(characterEntity.ability().timeToHit())
                            .build() : null)
                    .attributes(!characterEntity.attributes().isEmpty() ? characterEntity.attributes().stream().map(attribute -> AttributeRSDTO.builder()
                            .identifier(attribute != null ? attribute.identifier() : null)
                            .name(attribute != null ? attribute.name().get(language) : null)
                            .description(attribute != null ? attribute.description().get(language) : null)
                            .build()).toList() : List.of())
                    .build().toMap()
            );
        } catch(NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }
    }

    public CharacterRSDTO getGameCharacter(String id, String language) throws APIException {
        final var characterEntity = characterRepository.findByIdentifierAndInGame(id, true).orElseThrow(() ->
            new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            )
        );

        return CharacterRSDTO.builder()
                .identifier(characterEntity.identifier())
                .name(characterEntity.name().get(language))
                .description(characterEntity.description().get(language))
                .race(characterEntity.race().get(language))
                .title(characterEntity.title().get(language))
                .image(characterEntity.image())
                .inGame(characterEntity.inGame())
                .world(characterEntity.world() != null ? WorldRSDTO.builder()
                        .identifier(characterEntity.world().identifier())
                        .name(characterEntity.world().name().get(language))
                        .description(characterEntity.world().description().get(language))
                        .image(characterEntity.world().image())
                        .detailedIcon(characterEntity.world().detailedIcon())
                        .build() : null)
                .stats(characterEntity.stats())
                .ability(characterEntity.ability() != null ? AbilityRSDTO.builder()
                        .identifier(characterEntity.ability().identifier())
                        .name(characterEntity.ability().name().get(language))
                        .description(characterEntity.ability().description().get(language))
                        .damage(characterEntity.ability().damage())
                        .life(characterEntity.ability().life())
                        .cooldown(characterEntity.ability().cooldown())
                        .timeToHit(characterEntity.ability().timeToHit())
                        .build() : null)
                .attributes(!characterEntity.attributes().isEmpty() ? characterEntity.attributes().stream().map(attribute -> AttributeRSDTO.builder()
                        .identifier(attribute != null ? attribute.identifier() : null)
                        .name(attribute != null ? attribute.name().get(language) : null)
                        .description(attribute != null ? attribute.description().get(language) : null)
                        .build()).toList() : List.of())
                .build();
    }

    public List<CharacterRSDTO> listGameCharacters(String language) throws APIException {
        final var characterEntities = characterRepository.findByInGame(true).orElseThrow(() ->
            new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            )
        );

        return characterEntities.stream().map(characterEntity -> CharacterRSDTO.builder()
                .identifier(characterEntity.identifier())
                .name(characterEntity.name().get(language))
                .description(characterEntity.description().get(language))
                .race(characterEntity.race().get(language))
                .title(characterEntity.title().get(language))
                .image(characterEntity.image())
                .inGame(characterEntity.inGame())
                .world(characterEntity.world() != null ? WorldRSDTO.builder()
                        .identifier(characterEntity.world().identifier())
                        .name(characterEntity.world().name().get(language))
                        .description(characterEntity.world().description().get(language))
                        .image(characterEntity.world().image())
                        .detailedIcon(characterEntity.world().detailedIcon())
                        .build() : null)
                .stats(characterEntity.stats())
                .ability(characterEntity.ability() != null ? AbilityRSDTO.builder()
                        .identifier(characterEntity.ability().identifier())
                        .name(characterEntity.ability().name().get(language))
                        .description(characterEntity.ability().description().get(language))
                        .damage(characterEntity.ability().damage())
                        .life(characterEntity.ability().life())
                        .cooldown(characterEntity.ability().cooldown())
                        .timeToHit(characterEntity.ability().timeToHit())
                        .build() : null)
                .attributes(!characterEntity.attributes().isEmpty() ? characterEntity.attributes().stream().map(attribute -> AttributeRSDTO.builder()
                        .identifier(attribute != null ? attribute.identifier() : null)
                        .name(attribute != null ? attribute.name().get(language) : null)
                        .description(attribute != null ? attribute.description().get(language) : null)
                        .build()).toList() : List.of())
                .build()
        ).toList();
    }

    public Page<Map<String, Object>> pageGameCharacters(Pageable pageable, String language) throws APIException {
        final var characterEntities = characterRepository.findByInGame(true, pageable).orElseThrow(() ->
            new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            )
        );

        return characterEntities.map(characterEntity -> CharacterRSDTO.builder()
                .identifier(characterEntity.identifier())
                .name(characterEntity.name().get(language))
                .description(characterEntity.description().get(language))
                .race(characterEntity.race().get(language))
                .title(characterEntity.title().get(language))
                .image(characterEntity.image())
                .inGame(characterEntity.inGame())
                .world(characterEntity.world() != null ? WorldRSDTO.builder()
                        .identifier(characterEntity.world().identifier())
                        .name(characterEntity.world().name().get(language))
                        .description(characterEntity.world().description().get(language))
                        .image(characterEntity.world().image())
                        .detailedIcon(characterEntity.world().detailedIcon())
                        .build() : null)
                .stats(characterEntity.stats())
                .ability(characterEntity.ability() != null ? AbilityRSDTO.builder()
                        .identifier(characterEntity.ability().identifier())
                        .name(characterEntity.ability().name().get(language))
                        .description(characterEntity.ability().description().get(language))
                        .damage(characterEntity.ability().damage())
                        .life(characterEntity.ability().life())
                        .cooldown(characterEntity.ability().cooldown())
                        .timeToHit(characterEntity.ability().timeToHit())
                        .build() : null)
                .attributes(!characterEntity.attributes().isEmpty() ? characterEntity.attributes().stream().map(attribute -> AttributeRSDTO.builder()
                        .identifier(attribute != null ? attribute.identifier() : null)
                        .name(attribute != null ? attribute.name().get(language) : null)
                        .description(attribute != null ? attribute.description().get(language) : null)
                        .build()).toList() : List.of())
                .build().toMap()
        );
    }
}
