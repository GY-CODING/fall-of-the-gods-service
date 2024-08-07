package org.gycoding.fallofthegods.model.database.service;

import org.gycoding.fallofthegods.model.database.repository.CharacterRepository;
import org.gycoding.fallofthegods.model.entities.exceptions.FOTGAPIError;
import org.gycoding.fallofthegods.model.entities.characters.EntityCharacter;
import org.gycoding.exceptions.model.APIException;
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

    public EntityCharacter getStoryCharacter(String id) throws APIException {
        return characterRepository.findByIdentifier(id).orElseThrow(() ->
            new APIException(
                FOTGAPIError.CHARACTER_NOT_FOUND.code,
                FOTGAPIError.CHARACTER_NOT_FOUND.message,
                FOTGAPIError.CHARACTER_NOT_FOUND.status
            )
        );
    }

    public List<EntityCharacter> listStoryCharacters() throws APIException {
        try {
            return characterRepository.findAll();
        } catch(NullPointerException e) {
            throw new APIException(
                FOTGAPIError.LIST_CHARACTER_NOT_FOUND.code,
                FOTGAPIError.LIST_CHARACTER_NOT_FOUND.message,
                FOTGAPIError.LIST_CHARACTER_NOT_FOUND.status
            );
        }
    }

    public Page<Map<String, Object>> pageStoryCharacters(Pageable pageable) throws APIException {
        try {
            return characterRepository.findAll(pageable)
                    .map(EntityCharacter::toMap);
        } catch(NullPointerException e) {
            throw new APIException(
                FOTGAPIError.LIST_CHARACTER_NOT_FOUND.code,
                FOTGAPIError.LIST_CHARACTER_NOT_FOUND.message,
                FOTGAPIError.LIST_CHARACTER_NOT_FOUND.status
            );
        }
    }

    public EntityCharacter getGameCharacter(String id) throws APIException {
        return characterRepository.findByIdentifierAndInGame(id, true).orElseThrow(() ->
            new APIException(
                FOTGAPIError.CHARACTER_NOT_FOUND.code,
                FOTGAPIError.CHARACTER_NOT_FOUND.message,
                FOTGAPIError.CHARACTER_NOT_FOUND.status
            )
        );
    }

    public List<EntityCharacter> listGameCharacters() throws APIException {
        return characterRepository.findByInGame(true).orElseThrow(() ->
            new APIException(
                FOTGAPIError.LIST_CHARACTER_NOT_FOUND.code,
                FOTGAPIError.LIST_CHARACTER_NOT_FOUND.message,
                FOTGAPIError.LIST_CHARACTER_NOT_FOUND.status
            )
        );
    }

    public Page<Map<String, Object>> pageGameCharacters(Pageable pageable) throws APIException {
        final var characters = characterRepository.findByInGame(true, pageable).orElseThrow(() ->
            new APIException(
                FOTGAPIError.LIST_CHARACTER_NOT_FOUND.code,
                FOTGAPIError.LIST_CHARACTER_NOT_FOUND.message,
                FOTGAPIError.LIST_CHARACTER_NOT_FOUND.status
            )
        );

        return characters.map(EntityCharacter::toMap);
    }
}
