package org.gycoding.fallofthegods.infrastructure.api.controller.management;

import lombok.AllArgsConstructor;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.application.service.AchievementService;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.achievements.AchievementRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.mapper.AchievementControllerMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/achievements")
@AllArgsConstructor
public class AchievementManagementController {
    private final AchievementService service;

    private final AchievementControllerMapper mapper;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody AchievementRQDTO achievement) throws APIException {
        return ResponseEntity.ok(mapper.toRSDTO(service.save(mapper.toIDTO(achievement))));
    }

    @DeleteMapping("")
    public ResponseEntity<?> removeAchievement(@RequestParam String id) throws APIException {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
