package org.gycoding.fallofthegods.infrastructure.api.controller.data;

import lombok.AllArgsConstructor;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.application.service.AchievementService;
import org.gycoding.fallofthegods.infrastructure.api.mapper.AchievementControllerMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/achievements")
@AllArgsConstructor
public class AchievementDataController {
    private final AchievementService service;

    private final AchievementControllerMapper mapper;

    @GetMapping("/get")
    public ResponseEntity<?> getAchievement(@RequestParam String id, @RequestParam String lang) throws APIException {
        return ResponseEntity.ok(mapper.toRSDTO(service.get(id, lang)));
    }

    @GetMapping("/list")
    public ResponseEntity<?> listAchievements(@RequestParam String lang) throws APIException {
        return ResponseEntity.ok(service.list(lang).stream().map(mapper::toRSDTO).toList());
    }

    @GetMapping("/page")
    public ResponseEntity<?> pageAchievements(Pageable pageable, @RequestParam String lang) throws APIException {
        return ResponseEntity.ok(service.page(pageable, lang).getContent());
    }
}