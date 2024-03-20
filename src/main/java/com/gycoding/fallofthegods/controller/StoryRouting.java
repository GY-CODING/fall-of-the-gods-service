package com.gycoding.fallofthegods.controller;

import org.springframework.web.bind.annotation.RestController;

import com.gycoding.fallofthegods.model.database.StoryService;
import com.gycoding.fallofthegods.model.entities.ServerStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/stories")
public class StoryRouting {
    private final StoryService storyService;

    public StoryRouting(StoryService storyService) {
        this.storyService = storyService;
    }

    @GetMapping("/get")
    public String getStory(@RequestParam String id) {
        try {
            return storyService.getStory(id).toString();
        } catch (Exception e) {
            return ServerStatus.NOT_FOUND.toString();
        }
    }

    @GetMapping("/list")
    public String listStories() {
        try {
            return storyService.listStories().toString();
        } catch (Exception e) {
            return ServerStatus.NOT_FOUND.toString();
        }
    }
}
