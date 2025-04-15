package org.gycoding.fallofthegods.application.service;

import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.application.dto.in.achievements.AchievementIDTO;
import org.gycoding.fallofthegods.application.dto.out.achievements.AchievementODTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface AchievementService {
    AchievementODTO save(AchievementIDTO achievement) throws APIException;
    void delete(String identifier) throws APIException;

    AchievementODTO get(String identifier, String language) throws APIException;
    List<AchievementODTO> list(String language) throws APIException;
    Page<Map<String, Object>> page(Pageable pageable, String language) throws APIException;
}
