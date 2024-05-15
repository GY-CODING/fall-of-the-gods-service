package com.gycoding.fallofthegods.controller.apimanagement;

import com.gycoding.fallofthegods.model.database.service.ItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items/manage")
public class ItemManagementController {
    private final ItemService itemService;

    public ItemManagementController(ItemService itemService) {
        this.itemService = itemService;
    }
}
