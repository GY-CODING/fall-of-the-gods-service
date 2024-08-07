package org.gycoding.fallofthegods.controller.apidata;

import org.gycoding.fallofthegods.model.database.service.PlaceService;
import org.gycoding.fallofthegods.model.database.service.WorldService;
import org.gycoding.exceptions.model.APIException;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/worlds")
public class WorldController {
    private final WorldService worldService;
    private final PlaceService placeService;

    public WorldController(WorldService worldService, PlaceService placeService) {
        this.worldService   = worldService;
        this.placeService   = placeService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getWorld(@RequestParam String id) throws APIException {
        return ResponseEntity.ok(worldService.getWorld(id).toString());
    }

    @GetMapping("/list")
    public ResponseEntity<?> listWorlds() throws APIException {
        return ResponseEntity.ok(worldService.listWorlds().toString());
    }

    @GetMapping("/page")
    public ResponseEntity<?> pageWorlds(Pageable pageable) throws APIException {
        return ResponseEntity.ok(worldService.pageWorlds(pageable).getContent());
    }

    @GetMapping("/places/get")
    public ResponseEntity<?> getPlace(@RequestParam String id) throws APIException {
        return ResponseEntity.ok(placeService.getPlace(id).toString());
    }

    @GetMapping("/places/listAll")
    public ResponseEntity<?> listPlaces() throws APIException {
        return ResponseEntity.ok(placeService.listPlaces().toString());
    }

    @GetMapping("/places/pageAll")
    public ResponseEntity<?> pagePlaces(Pageable pageable) throws APIException {
        return ResponseEntity.ok(placeService.pagePlaces(pageable).getContent());
    }

    @GetMapping("/places/list")
    public ResponseEntity<?> listWorldPlaces(@RequestParam String id) throws APIException {
        return ResponseEntity.ok(worldService.listWorldPlaces(id).toString());
    }

    @GetMapping("/places/page")
    public ResponseEntity<?> pageWorldPlaces(@RequestParam String id, Pageable pageable) throws APIException {
        return ResponseEntity.ok(worldService.pageWorldPlaces(id, pageable).getContent());
    }
}
