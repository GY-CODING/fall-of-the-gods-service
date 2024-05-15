package com.gycoding.fallofthegods.controller.apimanagement;

import com.gycoding.fallofthegods.model.database.service.PlaceService;
import com.gycoding.fallofthegods.model.database.service.WorldService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/worlds/manage")
public class WorldManagementController {
    private final WorldService worldService;
    private final PlaceService placeService;

    public WorldManagementController(WorldService worldService, PlaceService placeService) {
        this.worldService   = worldService;
        this.placeService   = placeService;
    }

}
