package org.gycoding.fallofthegods.controller.apidata;

import org.gycoding.fallofthegods.model.database.service.AchievementService;
import org.gycoding.exceptions.model.APIException;
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
    public ResponseEntity<?> getAchievement(@RequestParam String id) throws APIException {
        return ResponseEntity.ok(achievementService.getAchievement(id).toString());
    }

    @GetMapping("/list")
    public ResponseEntity<?> listAchievements() throws APIException {
        return ResponseEntity.ok(achievementService.listAchievements().toString());
    }

    @GetMapping("/page")
    public ResponseEntity<?> pageAchievements(Pageable pageable) throws APIException {
        return ResponseEntity.ok(achievementService.pageAchievements(pageable).getContent());
    }
}