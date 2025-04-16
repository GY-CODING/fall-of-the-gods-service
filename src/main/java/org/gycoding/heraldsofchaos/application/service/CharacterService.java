package org.gycoding.heraldsofchaos.application.service;

import org.gycoding.exceptions.model.APIException;
import org.gycoding.heraldsofchaos.application.dto.in.characters.CharacterIDTO;
import org.gycoding.heraldsofchaos.application.dto.out.characters.CharacterODTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface CharacterService {
    CharacterODTO save(CharacterIDTO character) throws APIException;
    CharacterODTO update(CharacterIDTO character) throws APIException;
    void delete(String identifier) throws APIException;

    CharacterODTO get(String identifier, String language) throws APIException;
    List<CharacterODTO> list(String language) throws APIException;
    Page<Map<String, Object>> page(Pageable pageable, String language) throws APIException;
}
