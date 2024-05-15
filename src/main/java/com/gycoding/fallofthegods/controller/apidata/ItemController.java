package com.gycoding.fallofthegods.controller.apidata;

import com.gycoding.fallofthegods.model.database.service.ItemService;
import com.gycoding.fallofthegods.model.entities.ServerStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/story/get")
    public ResponseEntity<?> getStoryItem(@RequestParam String id) {
        try {
            return ResponseEntity.ok(itemService.getStoryItem(id).toString());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.ITEM_NOT_FOUND.status).body(ServerStatus.ITEM_NOT_FOUND.toString());
        }
    }

    @GetMapping("/story/list")
    public ResponseEntity<?> listStoryItems() {
        try {
            return ResponseEntity.ok(itemService.listStoryItems().toString());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.LIST_ITEM_NOT_FOUND.status).body(ServerStatus.LIST_ITEM_NOT_FOUND.toString());
        }
    }

    @GetMapping("/story/page")
    public ResponseEntity<?> pageStoryItems(Pageable pageable) {
        try {
            return ResponseEntity.ok(itemService.pageStoryItems(pageable).getContent());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.LIST_ITEM_NOT_FOUND.status).body(ServerStatus.LIST_ITEM_NOT_FOUND.toString());
        }
    }

    @GetMapping("/game/get")
    public ResponseEntity<?> getGameItem(@RequestParam String id) {
        try {
            return ResponseEntity.ok(itemService.getGameItem(id).toString());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.ITEM_NOT_FOUND.status).body(ServerStatus.ITEM_NOT_FOUND.toString());
        }
    }

    @GetMapping("/game/list")
    public ResponseEntity<?> listGameItems() {
        try {
            return ResponseEntity.ok(itemService.listGameItems().toString());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.LIST_ITEM_NOT_FOUND.status).body(ServerStatus.LIST_ITEM_NOT_FOUND.toString());
        }
    }

    @GetMapping("/game/page")
    public ResponseEntity<?> pageGameItems(Pageable pageable) {
        try {
            return ResponseEntity.ok(itemService.pageGameItems(pageable).getContent());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.LIST_ITEM_NOT_FOUND.status).body(ServerStatus.LIST_ITEM_NOT_FOUND.toString());
        }
    }
}
