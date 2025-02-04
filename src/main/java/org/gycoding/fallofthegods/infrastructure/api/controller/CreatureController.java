package org.gycoding.fallofthegods.infrastructure.api.controller;

import lombok.AllArgsConstructor;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.application.service.CreatureService;
import org.gycoding.fallofthegods.infrastructure.api.mapper.CreatureControllerMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/creatures")
@AllArgsConstructor
public class CreatureController {
    private final CreatureService service;

    private final CreatureControllerMapper mapper;

    @GetMapping("/story/get")
    public ResponseEntity<?> getStoryCreature(@RequestParam String id, @RequestParam String lang) throws APIException {
        return ResponseEntity.ok(mapper.toRSDTO(service.get(id, false, lang)));
    }

    @GetMapping("/story/list")
    public ResponseEntity<?> listStoryCreatures(@RequestParam String lang) throws APIException {
        return ResponseEntity.ok(service.list(false, lang).stream().map(mapper::toRSDTO).toList());
    }

    @GetMapping("/story/page")
    public ResponseEntity<?> pageStoryCreatures(Pageable pageable, @RequestParam String lang) throws APIException {
        return ResponseEntity.ok(service.page(pageable, false, lang).getContent());
    }

    @GetMapping("/game/get")
    public ResponseEntity<?> getGameCreature(@RequestParam String id, @RequestParam String lang) throws APIException {
        return ResponseEntity.ok(mapper.toRSDTO(service.get(id, true, lang)));
    }

    @GetMapping("/game/list")
    public ResponseEntity<?> listGameCreatures(@RequestParam String lang) throws APIException {
        return ResponseEntity.ok(service.list(true, lang).stream().map(mapper::toRSDTO).toList());
    }

    @GetMapping("/game/page")
    public ResponseEntity<?> pageGameCreatures(Pageable pageable, @RequestParam String lang) throws APIException {
        return ResponseEntity.ok(service.page(pageable, true, lang).getContent());
    }
}
