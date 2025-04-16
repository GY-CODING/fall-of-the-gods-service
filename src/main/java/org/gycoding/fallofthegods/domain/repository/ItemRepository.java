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
    ItemMO save(ItemMO item);
    ItemMO update(ItemMO item) throws APIException;
    void delete(String identifier);

    Optional<ItemMO> get(String identifier);
    Optional<ItemMO> get(String identifier, Boolean inGame);
    List<ItemMO> list();
    List<ItemMO> list(Boolean inGame);
    Page<ItemMO> page(Pageable pageable);
    Page<ItemMO> page(Pageable pageable, Boolean inGame);

}
