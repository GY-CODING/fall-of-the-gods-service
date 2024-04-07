package com.gycoding.fallofthegods.controller;

import com.gycoding.fallofthegods.model.database.TokenService;
import com.gycoding.fallofthegods.model.entities.accounts.GYToken;
import org.springframework.web.bind.annotation.*;

import com.gycoding.fallofthegods.model.database.StoryService;
import com.gycoding.fallofthegods.model.entities.ServerStatus;

@RestController
@RequestMapping("/{token}/stories")
public class StoryRouting {
    private final StoryService storyService;
    private final TokenService tokenService;
    private GYToken token;

    public StoryRouting(StoryService storyService, TokenService tokenService) {
        this.storyService   = storyService;
        this.tokenService   = tokenService;
    }

    @ModelAttribute
    public void setToken(@PathVariable String token) {
        this.token = new GYToken(token);
    }

    @GetMapping("/get")
    public String getStory(@RequestParam String id) {
        try {
            if(tokenService.checkToken(token)) {
                return storyService.getStory(id).toString();
            } else{
                return ServerStatus.INVALID_TOKEN.toString();
            }
        } catch (Exception e) {
            return ServerStatus.NOT_FOUND.toString();
        }
    }

    @GetMapping("/list")
    public String listStories() {
        try {
            if(tokenService.checkToken(token)) {
                return storyService.listStories().toString();
            } else{
                return ServerStatus.INVALID_TOKEN.toString();
            }
        } catch (Exception e) {
            return ServerStatus.NOT_FOUND.toString();
        }
    }
}
