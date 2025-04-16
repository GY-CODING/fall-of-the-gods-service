package org.gycoding.fallofthegods.application.service;

import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.application.dto.in.items.ItemIDTO;
import org.gycoding.fallofthegods.application.dto.out.items.ItemODTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ItemService {
    ItemODTO save(ItemIDTO item) throws APIException;
    ItemODTO update(ItemIDTO item) throws APIException;
    void delete(String identifier) throws APIException;

    ItemODTO get(String identifier, String language) throws APIException;
    List<ItemODTO> list(String language) throws APIException;
    Page<Map<String, Object>> page(Pageable pageable, String language) throws APIException;
}
