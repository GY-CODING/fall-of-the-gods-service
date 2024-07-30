package org.gycoding.fallofthegods.controller.apidata;

import org.gycoding.fallofthegods.model.database.service.CharacterService;
import org.gycoding.springexceptions.model.APIException;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class CharacterController {
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/story/get")
    public ResponseEntity<?> getStoryCharacter(@RequestParam String id) throws APIException {
        return ResponseEntity.ok(characterService.getStoryCharacter(id).toString());
    }

    @GetMapping("/story/list")
    public ResponseEntity<?> listStoryCharacters() throws APIException {
        return ResponseEntity.ok(characterService.listStoryCharacters().toString());
    }

    @GetMapping("/story/page")
    public ResponseEntity<?> pageStoryCharacters(Pageable pageable) throws APIException {
        return ResponseEntity.ok(characterService.pageStoryCharacters(pageable).getContent());
    }

    @GetMapping("/game/get")
    public ResponseEntity<?> getGameCharacter(@RequestParam String id) throws APIException {
        return ResponseEntity.ok(characterService.getGameCharacter(id).toString());
    }

    @GetMapping("/game/list")
    public ResponseEntity<?> listGameCharacters() throws APIException {
        return ResponseEntity.ok(characterService.listGameCharacters().toString());
    }

    @GetMapping("/game/page")
    public ResponseEntity<?> pageGameCharacters(Pageable pageable) throws APIException {
        return ResponseEntity.ok(characterService.pageGameCharacters(pageable).getContent());
    }
}
