package org.gycoding.heraldsofchaos.application.service;

import org.gycoding.exceptions.model.APIException;
import org.gycoding.heraldsofchaos.application.dto.out.characters.CharacterODTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface CharacterService {
    CharacterODTO get(String identifier, Boolean inGame, String language) throws APIException;
    List<CharacterODTO> list(Boolean inGame, String language) throws APIException;
    Page<Map<String, Object>> page(Pageable pageable, Boolean inGame, String language) throws APIException;
}
