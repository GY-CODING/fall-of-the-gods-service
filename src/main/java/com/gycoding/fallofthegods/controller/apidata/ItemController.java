package com.gycoding.fallofthegods.controller.apidata;

import com.gycoding.fallofthegods.model.database.service.ItemService;
import com.gycoding.fallofthegods.model.entities.ServerStatus;
import com.gycoding.fallofthegods.model.entities.exceptions.FOTGAPIException;
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
    public ResponseEntity<?> getStoryItem(@RequestParam String id) throws FOTGAPIException {
        return ResponseEntity.ok(itemService.getStoryItem(id).toString());
    }

    @GetMapping("/story/list")
    public ResponseEntity<?> listStoryItems() throws FOTGAPIException {
        return ResponseEntity.ok(itemService.listStoryItems().toString());
    }

    @GetMapping("/story/page")
    public ResponseEntity<?> pageStoryItems(Pageable pageable) throws FOTGAPIException {
        return ResponseEntity.ok(itemService.pageStoryItems(pageable).getContent());
    }

    @GetMapping("/game/get")
    public ResponseEntity<?> getGameItem(@RequestParam String id) throws FOTGAPIException {
        return ResponseEntity.ok(itemService.getGameItem(id).toString());
    }

    @GetMapping("/game/list")
    public ResponseEntity<?> listGameItems() throws FOTGAPIException {
        return ResponseEntity.ok(itemService.listGameItems().toString());
    }

    @GetMapping("/game/page")
    public ResponseEntity<?> pageGameItems(Pageable pageable) throws FOTGAPIException {
        return ResponseEntity.ok(itemService.pageGameItems(pageable).getContent());
    }
}
