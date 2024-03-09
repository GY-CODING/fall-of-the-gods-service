package com.gycoding.fallofthegods.controller;

import org.springframework.web.bind.annotation.RestController;

import com.gycoding.fallofthegods.model.database.ItemService;
import com.gycoding.fallofthegods.model.entities.ServerStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/items")
public class ItemRouting {
    private final ItemService itemService;

    public ItemRouting(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/story/get")
    public String getStoryCharacter(@RequestParam String id) {
        try {
            return itemService.getStoryItem(id).toString();
        } catch (Exception e) {
            return ServerStatus.NOT_FOUND.toString();
        }
    }

    @GetMapping("/story/list")
    public String listStoryCharacters() {
        try {
            return itemService.listStoryItems().toString();
        } catch (Exception e) {
            return ServerStatus.NOT_FOUND.toString();
        }
    }

    @GetMapping("/game/get")
    public String getGameCharacter(@RequestParam String id) {
        try {
            return itemService.getGameItem(id).toString();
        } catch (Exception e) {
            return ServerStatus.NOT_FOUND.toString();
        }
    }

    @GetMapping("/game/list")
    public String listGameCharacters() {
        try {
            return itemService.listGameItems().toString();
        } catch (Exception e) {
            return ServerStatus.NOT_FOUND.toString();
        }
    }
}
