package com.gycoding.fallofthegods.controller;

import com.gycoding.fallofthegods.model.database.TokenService;
import com.gycoding.fallofthegods.model.entities.accounts.GYToken;
import org.springframework.web.bind.annotation.*;

import com.gycoding.fallofthegods.model.database.ItemService;
import com.gycoding.fallofthegods.model.entities.ServerStatus;

@RestController
@RequestMapping("/{token}/items")
public class ItemRouting {
    private final ItemService itemService;
    private final TokenService tokenService;
    private GYToken token;

    public ItemRouting(ItemService itemService, TokenService tokenService) {
        this.itemService    = itemService;
        this.tokenService   = tokenService;
    }

    @ModelAttribute
    public void setToken(@PathVariable String token) {
        this.token = new GYToken(token);
    }

    @GetMapping("/story/get")
    public String getStoryCharacter(@RequestParam String id) {
        try {
            if(tokenService.checkToken(token)) {
                return itemService.getStoryItem(id).toString();
            } else{
                return ServerStatus.INVALID_TOKEN.toString();
            }
        } catch (Exception e) {
            return ServerStatus.NOT_FOUND.toString();
        }
    }

    @GetMapping("/story/list")
    public String listStoryCharacters() {
        try {
            if(tokenService.checkToken(token)) {
                return itemService.listStoryItems().toString();
            } else{
                return ServerStatus.INVALID_TOKEN.toString();
            }
        } catch (Exception e) {
            return ServerStatus.NOT_FOUND.toString();
        }
    }

    @GetMapping("/game/get")
    public String getGameCharacter(@RequestParam String id) {
        try {
            if(tokenService.checkToken(token)) {
                return itemService.getGameItem(id).toString();
            } else{
                return ServerStatus.INVALID_TOKEN.toString();
            }
        } catch (Exception e) {
            return ServerStatus.NOT_FOUND.toString();
        }
    }

    @GetMapping("/game/list")
    public String listGameCharacters() {
        try {
            if(tokenService.checkToken(token)) {
                return itemService.listGameItems().toString();
            } else{
                return ServerStatus.INVALID_TOKEN.toString();
            }
        } catch (Exception e) {
            return ServerStatus.NOT_FOUND.toString();
        }
    }
}
