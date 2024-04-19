package com.gycoding.fallofthegods.controller;

import com.gycoding.fallofthegods.model.database.service.ItemService;
import com.gycoding.fallofthegods.model.database.service.TokenService;
import com.gycoding.fallofthegods.model.entities.ServerStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/{token}/items")
public class ItemController {
    private final ItemService itemService;
    private final TokenService tokenService;
    private UUID token;

    public ItemController(ItemService itemService, TokenService tokenService) {
        this.itemService    = itemService;
        this.tokenService   = tokenService;
    }

    @ModelAttribute
    public void setToken(@PathVariable String token) {
        this.token = UUID.fromString(token);
    }

    @GetMapping("/story/get")
    public ResponseEntity<String> getStoryCharacter(@RequestParam String id) {
        try {
            if(tokenService.checkToken(token)) {
                return ResponseEntity.ok(itemService.getStoryItem(id).toString());
            } else{
                return ResponseEntity.status(ServerStatus.INVALID_TOKEN.status).body(ServerStatus.INVALID_TOKEN.toString());
            }
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.ITEM_NOT_FOUND.status).body(ServerStatus.ITEM_NOT_FOUND.toString());
        }
    }

    @GetMapping("/story/list")
    public ResponseEntity<String> listStoryCharacters() {
        try {
            if(tokenService.checkToken(token)) {
                return ResponseEntity.ok(itemService.listStoryItems().toString());
            } else{
                return ResponseEntity.status(ServerStatus.INVALID_TOKEN.status).body(ServerStatus.INVALID_TOKEN.toString());
            }
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.ITEM_NOT_FOUND.status).body(ServerStatus.ITEM_NOT_FOUND.toString());
        }
    }

    @GetMapping("/game/get")
    public ResponseEntity<String> getGameCharacter(@RequestParam String id) {
        try {
            if(tokenService.checkToken(token)) {
                return ResponseEntity.ok(itemService.getGameItem(id).toString());
            } else{
                return ResponseEntity.status(ServerStatus.INVALID_TOKEN.status).body(ServerStatus.INVALID_TOKEN.toString());
            }
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.ITEM_NOT_FOUND.status).body(ServerStatus.ITEM_NOT_FOUND.toString());
        }
    }

    @GetMapping("/game/list")
    public ResponseEntity<String> listGameCharacters() {
        try {
            if(tokenService.checkToken(token)) {
                return ResponseEntity.ok(itemService.listGameItems().toString());
            } else{
                return ResponseEntity.status(ServerStatus.INVALID_TOKEN.status).body(ServerStatus.INVALID_TOKEN.toString());
            }
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.ITEM_NOT_FOUND.status).body(ServerStatus.ITEM_NOT_FOUND.toString());
        }
    }
}
