package org.gycoding.heraldsofchaos.infrastructure.api.controller.management;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.heraldsofchaos.application.service.CreatureService;
import org.gycoding.heraldsofchaos.infrastructure.api.dto.in.creatures.CreatureRQDTO;
import org.gycoding.heraldsofchaos.infrastructure.api.mapper.CreatureControllerMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/creatures")
@AllArgsConstructor
public class CreatureManagementController {
    private final CreatureService service;

    private final CreatureControllerMapper mapper;

    @PostMapping("")
    public ResponseEntity<?> save(@Valid @RequestBody CreatureRQDTO creature) throws APIException {
        return ResponseEntity.ok(mapper.toRSDTO(service.save(mapper.toIDTO(creature))));
    }

    @PatchMapping("")
    public ResponseEntity<?> update(@Valid @RequestBody CreatureRQDTO creature, @RequestParam String id) throws APIException {
        return ResponseEntity.ok(mapper.toRSDTO(service.update(mapper.toIDTO(creature, id))));
    }

    @DeleteMapping("")
    public ResponseEntity<?> removeCreature(@RequestParam String id) throws APIException {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
