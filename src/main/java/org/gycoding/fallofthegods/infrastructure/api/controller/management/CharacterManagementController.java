package org.gycoding.fallofthegods.infrastructure.api.controller.management;

import lombok.AllArgsConstructor;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.application.service.CharacterService;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.characters.CharacterRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.mapper.CharacterControllerMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/characters")
@AllArgsConstructor
public class CharacterManagementController {
    private final CharacterService service;

    private final CharacterControllerMapper mapper;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody CharacterRQDTO character) throws APIException {
        return ResponseEntity.ok(mapper.toRSDTO(service.save(mapper.toIDTO(character))));
    }

    @PatchMapping("")
    public ResponseEntity<?> update(@RequestBody CharacterRQDTO character, @RequestParam String id) throws APIException {
        return ResponseEntity.ok(mapper.toRSDTO(service.update(mapper.toIDTO(character, id))));
    }

    @DeleteMapping("")
    public ResponseEntity<?> removeCharacter(@RequestParam String id) throws APIException {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
