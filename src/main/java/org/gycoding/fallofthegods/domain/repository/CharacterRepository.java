package org.gycoding.fallofthegods.domain.repository;

import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.domain.model.characters.CharacterMO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepository {
    CharacterMO save(CharacterMO entity) throws APIException;
    Optional<CharacterMO> get(String identifier) throws APIException;
    Optional<CharacterMO> get(String identifier, Boolean inGame) throws APIException;
    List<CharacterMO> list() throws APIException;
    List<CharacterMO> list(Boolean inGame) throws APIException;
    Page<CharacterMO> page(Pageable pageable) throws APIException;
    Page<CharacterMO> page(Pageable pageable, Boolean inGame) throws APIException;
    void delete(String identifier) throws APIException;
}
