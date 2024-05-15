package com.gycoding.fallofthegods.controller.apimanagement;

import com.gycoding.fallofthegods.model.database.service.StoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stories/manage")
public class StoryManagementController {
    private final StoryService storyService;

    public StoryManagementController(StoryService storyService) {
        this.storyService = storyService;
    }
}
