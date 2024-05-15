package com.gycoding.fallofthegods.controller.apidata;

import com.gycoding.fallofthegods.model.database.service.StoryService;
import com.gycoding.fallofthegods.model.entities.ServerStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stories")
public class StoryController {
    private final StoryService storyService;

    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getStory(@RequestParam String id) {
        try {
            return ResponseEntity.ok(storyService.getStory(id).toString());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.STORY_NOT_FOUND.status).body(ServerStatus.STORY_NOT_FOUND.toString());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> listStories() {
        try {
            return ResponseEntity.ok(storyService.listStories().toString());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.LIST_STORY_NOT_FOUND.status).body(ServerStatus.LIST_STORY_NOT_FOUND.toString());
        }
    }

    @GetMapping("/page")
    public ResponseEntity<?> listStories(Pageable pageable) {
        try {
            return ResponseEntity.ok(storyService.pageStories(pageable).getContent());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.LIST_STORY_NOT_FOUND.status).body(ServerStatus.LIST_STORY_NOT_FOUND.toString());
        }
    }
}
