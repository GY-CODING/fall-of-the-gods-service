package org.gycoding.fallofthegods.infrastructure.api.controller.management;

import lombok.AllArgsConstructor;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.application.service.CreatureService;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.creatures.CreatureRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.mapper.CreatureControllerMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/creatures")
@AllArgsConstructor
public class CreatureManagementController {
    private final CreatureService service;

    private final CreatureControllerMapper mapper;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody CreatureRQDTO creature) throws APIException {
        return ResponseEntity.ok(mapper.toRSDTO(service.save(mapper.toIDTO(creature))));
    }

    @PatchMapping("")
    public ResponseEntity<?> update(@RequestBody CreatureRQDTO creature, @RequestParam String id) throws APIException {
        return ResponseEntity.ok(mapper.toRSDTO(service.update(mapper.toIDTO(creature, id))));
    }

    @DeleteMapping("")
    public ResponseEntity<?> removeCreature(@RequestParam String id) throws APIException {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
