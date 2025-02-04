package org.gycoding.fallofthegods.domain.repository;

import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.domain.model.items.ItemMO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository {
    ItemMO save(ItemMO entity) throws APIException;
    Optional<ItemMO> get(String identifier) throws APIException;
    Optional<ItemMO> get(String identifier, Boolean inGame) throws APIException;
    List<ItemMO> list() throws APIException;
    List<ItemMO> list(Boolean inGame) throws APIException;
    Page<ItemMO> page(Pageable pageable) throws APIException;
    Page<ItemMO> page(Pageable pageable, Boolean inGame) throws APIException;
    void delete(String identifier) throws APIException;
}
