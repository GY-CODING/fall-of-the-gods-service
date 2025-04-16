package org.gycoding.fallofthegods.domain.repository;

import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.domain.model.worlds.PlaceMO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceRepository {
    PlaceMO save(PlaceMO entity);
    PlaceMO update(PlaceMO entity) throws APIException;
    void delete(String identifier);

    Optional<PlaceMO> get(String identifier);
    Optional<PlaceMO> get(String identifier, Boolean inGame);
    List<PlaceMO> list();
    List<PlaceMO> list(Boolean inGame);
    Page<PlaceMO> page(Pageable pageable);
    Page<PlaceMO> page(Pageable pageable, Boolean inGame);
}
