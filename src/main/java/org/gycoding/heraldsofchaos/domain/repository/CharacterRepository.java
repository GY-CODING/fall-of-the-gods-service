package org.gycoding.heraldsofchaos.domain.repository;

import org.gycoding.exceptions.model.APIException;
import org.gycoding.heraldsofchaos.domain.model.characters.CharacterMO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepository {
    CharacterMO save(CharacterMO character) throws APIException;
    CharacterMO update(CharacterMO character) throws APIException;
    void delete(String identifier);

    Optional<CharacterMO> get(String identifier);
    List<CharacterMO> list();
    Page<CharacterMO> page(Pageable pageable);
}
