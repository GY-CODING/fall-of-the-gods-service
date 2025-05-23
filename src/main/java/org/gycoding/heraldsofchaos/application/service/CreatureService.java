package org.gycoding.heraldsofchaos.application.service;

import org.gycoding.exceptions.model.APIException;
import org.gycoding.heraldsofchaos.application.dto.in.creatures.CreatureIDTO;
import org.gycoding.heraldsofchaos.application.dto.out.creatures.CreatureODTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface CreatureService {
    CreatureODTO save(CreatureIDTO creature) throws APIException;
    CreatureODTO update(CreatureIDTO creature) throws APIException;
    void delete(String identifier) throws APIException;

    CreatureODTO get(String identifier, String language) throws APIException;
    List<CreatureODTO> list(String language) throws APIException;
    Page<Map<String, Object>> page(Pageable pageable, String language) throws APIException;
}
