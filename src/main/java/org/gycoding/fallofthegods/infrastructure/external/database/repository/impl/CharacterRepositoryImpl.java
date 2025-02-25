package org.gycoding.fallofthegods.infrastructure.external.database.repository.impl;

import lombok.AllArgsConstructor;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.domain.exceptions.FOTGAPIError;
import org.gycoding.fallofthegods.domain.model.characters.CharacterMO;
import org.gycoding.fallofthegods.domain.repository.CharacterRepository;
import org.gycoding.fallofthegods.infrastructure.external.database.mapper.CharacterDatabaseMapper;
import org.gycoding.fallofthegods.infrastructure.external.database.model.characters.CharacterEntity;
import org.gycoding.fallofthegods.infrastructure.external.database.repository.CharacterMongoRepository;
import org.gycoding.fallofthegods.shared.util.PagingConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CharacterRepositoryImpl implements CharacterRepository {
    private final CharacterMongoRepository repository;

    private final CharacterDatabaseMapper mapper;

    @Override
    public CharacterMO save(CharacterMO character) throws APIException {
        try {
            return mapper.toMO(repository.save(mapper.toEntity(character)));
        } catch (Exception e) {
            throw new APIException(
                    FOTGAPIError.CONFLICT.code,
                    FOTGAPIError.CONFLICT.message,
                    FOTGAPIError.CONFLICT.status
            );
        }
    }

    @Override
    public Optional<CharacterMO> get(String identifier) throws APIException {
        final var characterEntity = repository.findByIdentifier(identifier).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                )
        );

        return Optional.of(mapper.toMO(characterEntity));
    }

    public Optional<CharacterMO> get(String identifier, Boolean inGame) throws APIException {
        Optional<CharacterEntity> characterEntity;

        if(inGame) {
            characterEntity = repository.findByIdentifierAndInGame(identifier, inGame);
        } else {
            characterEntity = repository.findByIdentifier(identifier);
        }

        characterEntity.orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                )
        );

        return Optional.of(mapper.toMO(characterEntity.get()));
    }

    public List<CharacterMO> list() throws APIException {
        List<CharacterEntity> characterEntities;

        try {
            characterEntities = repository.findAll();
        } catch(NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }

        return characterEntities.stream().map(mapper::toMO).toList();
    }

    public List<CharacterMO> list(Boolean inGame) throws APIException {
        List<CharacterEntity> characterEntities;

        try {
            if(inGame) {
                characterEntities = repository.findByInGame(inGame);
            } else {
                characterEntities = repository.findAll();
            }
        } catch(NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }

        return characterEntities.stream().map(mapper::toMO).toList();
    }

    public Page<CharacterMO> page(Pageable pageable) throws APIException {
        Page<CharacterEntity> characterEntities;

        try {
            characterEntities = repository.findAll(pageable);
        } catch(NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }

        return PagingConverter.listToPage(characterEntities.stream().map(mapper::toMO).toList(), pageable);
    }

    public Page<CharacterMO> page(Pageable pageable, Boolean inGame) throws APIException {
        Page<CharacterEntity> characterEntities;

        try {
            if(inGame) {
                characterEntities = repository.findByInGame(inGame, pageable);
            } else {
                characterEntities = repository.findAll(pageable);
            }
        } catch(NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }

        return PagingConverter.listToPage(characterEntities.stream().map(mapper::toMO).toList(), pageable);
    }

    @Override
    public void delete(String identifier) throws APIException {
        try {
            repository.removeByIdentifier(identifier);
        } catch (Exception e) {
            throw new APIException(
                    FOTGAPIError.CONFLICT.code,
                    FOTGAPIError.CONFLICT.message,
                    FOTGAPIError.CONFLICT.status
            );
        }
    }
}
