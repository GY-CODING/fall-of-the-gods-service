package org.gycoding.fallofthegods.model.database.service;

import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.model.database.repository.CharacterRepository;
import org.gycoding.fallofthegods.model.database.repository.CreatureRepository;
import org.gycoding.fallofthegods.model.dto.achievements.AchievementRSDTO;
import org.gycoding.fallofthegods.model.dto.creatures.CreatureRSDTO;
import org.gycoding.fallofthegods.model.entities.characters.EntityCharacter;
import org.gycoding.fallofthegods.model.entities.creatures.EntityCreature;
import org.gycoding.fallofthegods.model.entities.exceptions.FOTGAPIError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Service
public class CreatureService {
    @Autowired
    private final CreatureRepository creatureRepository = null;

    public CreatureRSDTO getCreature(String id, String language) throws APIException {
        final var creatureEntity = creatureRepository.findByIdentifier(id).orElseThrow(() ->
            new APIException(
                FOTGAPIError.CREATURE_NOT_FOUND.code,
                FOTGAPIError.CREATURE_NOT_FOUND.message,
                FOTGAPIError.CREATURE_NOT_FOUND.status
            )
        );

        return CreatureRSDTO.builder()
                .identifier(creatureEntity.identifier())
                .name(creatureEntity.name().get(language))
                .description(creatureEntity.description().get(language))
                .image(creatureEntity.image())
                .inGame(creatureEntity.inGame())
                .build();
    }

    public List<CreatureRSDTO> listCreatures(String language) throws APIException {
        try {
            final var creatureEntities =  creatureRepository.findAll();

            return creatureEntities.stream().map(creatureEntity ->
                    CreatureRSDTO.builder()
                            .identifier(creatureEntity.identifier())
                            .name(creatureEntity.name().get(language))
                            .description(creatureEntity.description().get(language))
                            .image(creatureEntity.image())
                            .inGame(creatureEntity.inGame())
                            .build()).toList();
        } catch(NullPointerException e) {
            throw new APIException(
                FOTGAPIError.LIST_CREATURE_NOT_FOUND.code,
                FOTGAPIError.LIST_CREATURE_NOT_FOUND.message,
                FOTGAPIError.LIST_CREATURE_NOT_FOUND.status
            );
        }
    }

    public Page<Map<String, Object>> pageCreatures(Pageable pageable, String language) throws APIException {
        try {
            final var creatureEntities = creatureRepository.findAll(pageable);

            return creatureEntities.map(creatureEntity ->
                CreatureRSDTO.builder()
                    .identifier(creatureEntity.identifier())
                    .name(creatureEntity.name().get(language))
                    .description(creatureEntity.description().get(language))
                    .image(creatureEntity.image())
                    .inGame(creatureEntity.inGame())
                    .build().toMap()
            );
        } catch(NullPointerException e) {
            throw new APIException(
                FOTGAPIError.LIST_CREATURE_NOT_FOUND.code,
                FOTGAPIError.LIST_CREATURE_NOT_FOUND.message,
                FOTGAPIError.LIST_CREATURE_NOT_FOUND.status
            );
        }
    }
}
