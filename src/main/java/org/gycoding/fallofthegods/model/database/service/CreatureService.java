package org.gycoding.fallofthegods.model.database.service;

import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.model.database.repository.CharacterRepository;
import org.gycoding.fallofthegods.model.database.repository.CreatureRepository;
import org.gycoding.fallofthegods.model.entities.characters.EntityCharacter;
import org.gycoding.fallofthegods.model.entities.creatures.EntityCreature;
import org.gycoding.fallofthegods.model.entities.exceptions.FOTGAPIError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CreatureService {
    @Autowired
    private final CreatureRepository creatureRepository = null;

    public EntityCreature getCreature(String id) throws APIException {
        return creatureRepository.findByIdentifier(id).orElseThrow(() ->
            new APIException(
                FOTGAPIError.CHARACTER_NOT_FOUND.code,
                FOTGAPIError.CHARACTER_NOT_FOUND.message,
                FOTGAPIError.CHARACTER_NOT_FOUND.status
            )
        );
    }

    public List<EntityCreature> listCreatures() throws APIException {
        try {
            return creatureRepository.findAll();
        } catch(NullPointerException e) {
            throw new APIException(
                FOTGAPIError.LIST_CHARACTER_NOT_FOUND.code,
                FOTGAPIError.LIST_CHARACTER_NOT_FOUND.message,
                FOTGAPIError.LIST_CHARACTER_NOT_FOUND.status
            );
        }
    }

    public Page<Map<String, Object>> pageCreatures(Pageable pageable) throws APIException {
        try {
            return creatureRepository.findAll(pageable)
                    .map(EntityCreature::toMap);
        } catch(NullPointerException e) {
            throw new APIException(
                FOTGAPIError.LIST_CHARACTER_NOT_FOUND.code,
                FOTGAPIError.LIST_CHARACTER_NOT_FOUND.message,
                FOTGAPIError.LIST_CHARACTER_NOT_FOUND.status
            );
        }
    }
}
