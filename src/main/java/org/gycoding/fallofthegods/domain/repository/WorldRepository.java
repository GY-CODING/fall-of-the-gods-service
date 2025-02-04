package org.gycoding.fallofthegods.domain.repository;

import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.domain.model.worlds.WorldMO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorldRepository {
    WorldMO save(WorldMO entity) throws APIException;
    Optional<WorldMO> get(String identifier) throws APIException;
    List<WorldMO> list() throws APIException;
    Page<WorldMO> page(Pageable pageable) throws APIException;
    void delete(String identifier) throws APIException;
}
