package com.gycoding.fallofthegods.controller.apidata;

import com.gycoding.fallofthegods.model.database.service.StoryService;
import com.gycoding.fallofthegods.model.entities.ServerStatus;
import com.gycoding.fallofthegods.model.entities.exceptions.FOTGAPIException;
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
    public ResponseEntity<?> getStory(@RequestParam String id) throws FOTGAPIException {
        return ResponseEntity.ok(storyService.getStory(id).toString());
    }

    @GetMapping("/list")
    public ResponseEntity<?> listStories() throws FOTGAPIException {
        return ResponseEntity.ok(storyService.listStories().toString());
    }

    @GetMapping("/page")
    public ResponseEntity<?> listStories(Pageable pageable) throws FOTGAPIException {
        return ResponseEntity.ok(storyService.pageStories(pageable).getContent());
    }
}
