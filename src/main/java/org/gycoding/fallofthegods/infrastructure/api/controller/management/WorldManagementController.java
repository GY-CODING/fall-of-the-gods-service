package org.gycoding.fallofthegods.infrastructure.api.controller.management;

import lombok.AllArgsConstructor;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.application.service.WorldService;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.worlds.WorldRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.mapper.WorldControllerMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/worlds")
@AllArgsConstructor
public class WorldManagementController {
    private final WorldService service;

    private final WorldControllerMapper mapper;

    @PostMapping("")
    public ResponseEntity<?> saveWorld(@RequestBody WorldRQDTO world) throws APIException {
        return ResponseEntity.ok(mapper.toRSDTO(service.save(mapper.toIDTO(world))));
    }

    @DeleteMapping("")
    public ResponseEntity<?> removeWorld(@RequestParam String id) throws APIException {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
