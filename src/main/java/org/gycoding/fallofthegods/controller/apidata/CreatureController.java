package org.gycoding.fallofthegods.controller.apidata;

import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.model.database.service.CreatureService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/creatures")
public class CreatureController {
    private final CreatureService creatureService;

    public CreatureController(CreatureService creatureService) {
        this.creatureService = creatureService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getCreature(@RequestParam String id) throws APIException {
        return ResponseEntity.ok(creatureService.getCreature(id).toString());
    }

    @GetMapping("/list")
    public ResponseEntity<?> listCreatures() throws APIException {
        return ResponseEntity.ok(creatureService.listCreatures().toString());
    }

    @GetMapping("/page")
    public ResponseEntity<?> pageCreatures(Pageable pageable) throws APIException {
        return ResponseEntity.ok(creatureService.pageCreatures(pageable).getContent());
    }
}
