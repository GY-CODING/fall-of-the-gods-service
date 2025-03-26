package org.gycoding.heraldsofchaos.application.service;

import org.gycoding.exceptions.model.APIException;
import org.gycoding.heraldsofchaos.application.dto.out.achievements.AchievementODTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface AchievementService {
    AchievementODTO get(String identifier, String language) throws APIException;
    List<AchievementODTO> list(String language) throws APIException;
    Page<Map<String, Object>> page(Pageable pageable, String language) throws APIException;
}
