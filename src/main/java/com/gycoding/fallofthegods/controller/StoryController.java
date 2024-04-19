package com.gycoding.fallofthegods.controller;

import com.gycoding.fallofthegods.model.database.service.StoryService;
import com.gycoding.fallofthegods.model.database.service.TokenService;
import com.gycoding.fallofthegods.model.entities.ServerStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/{token}/stories")
public class StoryController {
    private final StoryService storyService;
    private final TokenService tokenService;
    private UUID token;

    public StoryController(StoryService storyService, TokenService tokenService) {
        this.storyService   = storyService;
        this.tokenService   = tokenService;
    }

    @ModelAttribute
    public void setToken(@PathVariable String token) {
        this.token = UUID.fromString(token);
    }

    @GetMapping("/get")
    public ResponseEntity<String> getStory(@RequestParam String id) {
        try {
            if(tokenService.checkToken(token)) {
                return ResponseEntity.ok(storyService.getStory(id).toString());
            } else{
                return ResponseEntity.status(ServerStatus.INVALID_TOKEN.status).body(ServerStatus.INVALID_TOKEN.toString());
            }
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.STORY_NOT_FOUND.status).body(ServerStatus.STORY_NOT_FOUND.toString());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<String> listStories() {
        try {
            if(tokenService.checkToken(token)) {
                return ResponseEntity.ok(storyService.listStories().toString());
            } else{
                return ResponseEntity.status(ServerStatus.INVALID_TOKEN.status).body(ServerStatus.INVALID_TOKEN.toString());
            }
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.STORY_NOT_FOUND.status).body(ServerStatus.STORY_NOT_FOUND.toString());
        }
    }
}
