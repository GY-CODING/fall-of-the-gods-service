package org.gycoding.fallofthegods.infrastructure.api.controller.management;

import lombok.AllArgsConstructor;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.application.service.PlaceService;
import org.gycoding.fallofthegods.application.service.WorldService;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.worlds.PlaceRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.worlds.WorldRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.mapper.PlaceControllerMapper;
import org.gycoding.fallofthegods.infrastructure.api.mapper.WorldControllerMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/worlds")
@AllArgsConstructor
public class WorldManagementController {
    private final WorldService worldService;

    private final WorldControllerMapper worldMapper;

    private final PlaceService placeService;

    private final PlaceControllerMapper placeMapper;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody WorldRQDTO world) throws APIException {
        return ResponseEntity.ok(worldMapper.toRSDTO(worldService.save(worldMapper.toIDTO(world))));
    }

    @PatchMapping("")
    public ResponseEntity<?> update(@RequestBody WorldRQDTO world, @RequestParam String id) throws APIException {
        return ResponseEntity.ok(worldMapper.toRSDTO(worldService.update(worldMapper.toIDTO(world, id))));
    }

    @DeleteMapping("")
    public ResponseEntity<?> removeWorld(@RequestParam String id) throws APIException {
        worldService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/places")
    public ResponseEntity<?> save(@RequestBody PlaceRQDTO place) throws APIException {
        return ResponseEntity.ok(placeMapper.toRSDTO(placeService.save(placeMapper.toIDTO(place))));
    }

    @PatchMapping("/places")
    public ResponseEntity<?> update(@RequestBody PlaceRQDTO place, @RequestParam String id) throws APIException {
        return ResponseEntity.ok(placeMapper.toRSDTO(placeService.update(placeMapper.toIDTO(place, id))));
    }

    @DeleteMapping("/places")
    public ResponseEntity<?> remove(@RequestParam String id) throws APIException {
        placeService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
