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
    CharacterMO save(CharacterMO character) throws APIException;
    void delete(String identifier);

    Optional<CharacterMO> get(String identifier);
    Optional<CharacterMO> get(String identifier, Boolean inGame);
    List<CharacterMO> list();
    List<CharacterMO> list(Boolean inGame);
    Page<CharacterMO> page(Pageable pageable);
    Page<CharacterMO> page(Pageable pageable, Boolean inGame);
}
