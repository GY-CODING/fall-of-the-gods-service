package org.gycoding.heraldsofchaos.application.service;

import org.gycoding.exceptions.model.APIException;
import org.gycoding.heraldsofchaos.application.dto.in.worlds.PlaceIDTO;
import org.gycoding.heraldsofchaos.application.dto.out.worlds.PlaceODTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface PlaceService {
    PlaceODTO save(PlaceIDTO place) throws APIException;
    PlaceODTO update(PlaceIDTO place) throws APIException;
    void delete(String identifier) throws APIException;

    PlaceODTO get(String identifier, String language) throws APIException;
    List<PlaceODTO> list(String language) throws APIException;
    Page<Map<String, Object>> page(Pageable pageable, String language) throws APIException;
}
