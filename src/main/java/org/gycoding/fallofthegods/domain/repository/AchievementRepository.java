package org.gycoding.fallofthegods.domain.repository;

import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.domain.model.achievements.AchievementMO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AchievementRepository {
    AchievementMO save(AchievementMO entity) throws APIException;
    Optional<AchievementMO> get(String identifier) throws APIException;
    List<AchievementMO> list() throws APIException;
    Page<AchievementMO> page(Pageable pageable) throws APIException;
    void delete(String identifier) throws APIException;
}
