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
    WorldMO save(WorldMO world, List<String> places) throws APIException;
    void delete(String identifier);

    Optional<WorldMO> get(String identifier);
    List<WorldMO> list();
    Page<WorldMO> page(Pageable pageable);
}
