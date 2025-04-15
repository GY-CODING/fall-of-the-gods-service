package org.gycoding.fallofthegods.infrastructure.api.controller.data;

import lombok.AllArgsConstructor;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.application.service.CharacterService;
import org.gycoding.fallofthegods.infrastructure.api.mapper.CharacterControllerMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
@AllArgsConstructor
public class CharacterDataController {
    private final CharacterService service;

    private final CharacterControllerMapper mapper;

    @GetMapping("/story/get")
    public ResponseEntity<?> getStoryCharacter(@RequestParam String id, @RequestParam String lang) throws APIException {
        return ResponseEntity.ok(mapper.toRSDTO(service.get(id, false, lang)));
    }

    @GetMapping("/story/list")
    public ResponseEntity<?> listStoryCharacters(@RequestParam String lang) throws APIException {
        return ResponseEntity.ok(service.list(false, lang).stream().map(mapper::toRSDTO).toList());
    }

    @GetMapping("/story/page")
    public ResponseEntity<?> pageStoryCharacters(Pageable pageable, @RequestParam String lang) throws APIException {
        return ResponseEntity.ok(service.page(pageable, false, lang).getContent());
    }

    @GetMapping("/game/get")
    public ResponseEntity<?> getGameCharacter(@RequestParam String id, @RequestParam String lang) throws APIException {
        return ResponseEntity.ok(mapper.toRSDTO(service.get(id, true, lang)));
    }

    @GetMapping("/game/list")
    public ResponseEntity<?> listGameCharacters(@RequestParam String lang) throws APIException {
        return ResponseEntity.ok(service.list(true, lang).stream().map(mapper::toRSDTO).toList());
    }

    @GetMapping("/game/page")
    public ResponseEntity<?> pageGameCharacters(Pageable pageable, @RequestParam String lang) throws APIException {
        return ResponseEntity.ok(service.page(pageable, true, lang).getContent());
    }
}
