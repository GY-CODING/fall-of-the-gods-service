package org.gycoding.fallofthegods.domain.repository;

import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.domain.model.creatures.CreatureMO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CreatureRepository {
    CreatureMO save(CreatureMO entity) throws APIException;
    Optional<CreatureMO> get(String identifier) throws APIException;
    Optional<CreatureMO> get(String identifier, Boolean inGame) throws APIException;
    List<CreatureMO> list() throws APIException;
    List<CreatureMO> list(Boolean inGame) throws APIException;
    Page<CreatureMO> page(Pageable pageable) throws APIException;
    Page<CreatureMO> page(Pageable pageable, Boolean inGame) throws APIException;
    void delete(String identifier) throws APIException;
}
