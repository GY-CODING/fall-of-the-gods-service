package org.gycoding.fallofthegods.infrastructure.api.controller.management;

import lombok.AllArgsConstructor;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.application.service.ItemService;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.items.ItemRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.mapper.ItemControllerMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
@AllArgsConstructor
public class ItemManagementController {
    private final ItemService service;

    private final ItemControllerMapper mapper;

    @PostMapping("")
    public ResponseEntity<?> saveItem(@RequestBody ItemRQDTO item) throws APIException {
        return ResponseEntity.ok(mapper.toRSDTO(service.save(mapper.toIDTO(item))));
    }

    @DeleteMapping("")
    public ResponseEntity<?> removeItem(@RequestParam String id) throws APIException {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
