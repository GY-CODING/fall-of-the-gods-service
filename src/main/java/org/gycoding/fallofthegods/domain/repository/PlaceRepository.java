package org.gycoding.fallofthegods.domain.repository;

import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.domain.model.achievements.AchievementMO;
import org.gycoding.fallofthegods.domain.model.worlds.PlaceMO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceRepository {
    PlaceMO save(PlaceMO entity) throws APIException;
    Optional<PlaceMO> get(String identifier) throws APIException;
    Optional<PlaceMO> get(String identifier, Boolean inGame) throws APIException;
    List<PlaceMO> list() throws APIException;
    List<PlaceMO> list(Boolean inGame) throws APIException;
    Page<PlaceMO> page(Pageable pageable) throws APIException;
    Page<PlaceMO> page(Pageable pageable, Boolean inGame) throws APIException;
    void delete(String identifier) throws APIException;
}
