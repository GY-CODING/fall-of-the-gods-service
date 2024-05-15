package com.gycoding.fallofthegods.controller.apiusers;

import com.gycoding.fallofthegods.model.database.service.AchievementService;
import com.gycoding.fallofthegods.model.entities.ServerStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/achievements")
public class AchievementController {
    private final AchievementService achievementService;

    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAchievement(@RequestParam String id) {
        try {
            return ResponseEntity.ok(achievementService.getAchievement(id).toString());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.ACHIEVEMENT_NOT_FOUND.status).body(ServerStatus.ACHIEVEMENT_NOT_FOUND.toString());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> listAchievements() {
        try {
            return ResponseEntity.ok(achievementService.listAchievements().toString());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.LIST_ACHIEVEMENT_NOT_FOUND.status).body(ServerStatus.LIST_ACHIEVEMENT_NOT_FOUND.toString());
        }
    }

    @GetMapping("/page")
    public ResponseEntity<?> pageAchievements(Pageable pageable) {
        try {
            return ResponseEntity.ok(achievementService.pageAchievements(pageable).getContent());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.LIST_ACHIEVEMENT_NOT_FOUND.status).body(ServerStatus.LIST_ACHIEVEMENT_NOT_FOUND.toString());
        }
    }
}