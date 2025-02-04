package org.gycoding.fallofthegods.application.service;

import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.application.dto.out.worlds.PlaceODTO;
import org.gycoding.fallofthegods.application.dto.out.worlds.WorldODTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface WorldService {
    WorldODTO get(String identifier, String language) throws APIException;
    List<WorldODTO> list(String language) throws APIException;
    Page<Map<String, Object>> page(Pageable pageable, String language) throws APIException;
    PlaceODTO getPlace(String idWorld, String idPlace, String language) throws APIException;
    List<PlaceODTO> listPlaces(String idWorld, String language) throws APIException;
    Page<Map<String, Object>> pagePlaces(String idWorld, Pageable pageable, String language) throws APIException;
}
