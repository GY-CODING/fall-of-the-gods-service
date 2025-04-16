package org.gycoding.heraldsofchaos.domain.repository;

import org.gycoding.exceptions.model.APIException;
import org.gycoding.heraldsofchaos.domain.model.worlds.PlaceMO;
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
    List<PlaceMO> list();
    Page<PlaceMO> page(Pageable pageable);
}
