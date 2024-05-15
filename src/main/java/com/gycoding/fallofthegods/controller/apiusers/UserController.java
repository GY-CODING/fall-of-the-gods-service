package com.gycoding.fallofthegods.controller.apiusers;


import com.gycoding.fallofthegods.model.database.service.UserService;
import com.gycoding.fallofthegods.model.entities.ServerStatus;
import com.gycoding.fallofthegods.model.entities.achievements.EntityUser;
import com.gycoding.fallofthegods.model.entities.dto.UnlockAchievementRQDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getUser(@RequestParam String id) {
        try {
            return ResponseEntity.ok(userService.getUser(id).toString());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.USER_NOT_FOUND.status).body(ServerStatus.USER_NOT_FOUND.toString());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody EntityUser user) {
        try {
            System.out.println(user.toString());
            return ResponseEntity.ok(userService.save(user).toString());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.BAD_REQUEST.status).body(ServerStatus.BAD_REQUEST.toString());
        }
    }

    @PutMapping("/achievements/add")
    public ResponseEntity<?> addAchievement(@RequestBody UnlockAchievementRQDTO unlockAchievementRQDTO) {
        try {
            return ResponseEntity.ok(userService.addAchievement(unlockAchievementRQDTO.idUser(), unlockAchievementRQDTO.idAchievement()).toString());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.BAD_REQUEST.status).body(ServerStatus.BAD_REQUEST.toString());
        }
    }

    @DeleteMapping("/achievements/remove")
    public ResponseEntity<?> removeAchievement(@RequestParam String idUser, @RequestParam String idAchievement) {
        try {
            return ResponseEntity.ok(userService.removeAchievement(idUser, idAchievement).toString());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.BAD_REQUEST.status).body(ServerStatus.BAD_REQUEST.toString());
        }
    }

    @GetMapping("/achievements/get")
    public ResponseEntity<?> getAchievement(@RequestParam String idUser, @RequestParam String idAchievement) {
        try {
            return ResponseEntity.ok(userService.getAchievement(idUser, idAchievement).toString());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.ACHIEVEMENT_NOT_FOUND.status).body(ServerStatus.ACHIEVEMENT_NOT_FOUND.toString());
        }
    }

    @GetMapping("/achievements/list")
    public ResponseEntity<?> listAchievements(@RequestParam String id) {
        try {
            return ResponseEntity.ok(userService.listAchievements(id).toString());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.LIST_ACHIEVEMENT_NOT_FOUND.status).body(ServerStatus.LIST_ACHIEVEMENT_NOT_FOUND.toString());
        }
    }

    @GetMapping("/achievements/page")
    public ResponseEntity<?> pageAchievements(@RequestParam String id, Pageable pageable) {
        try {
            return ResponseEntity.ok(userService.pageAchievements(id, pageable).getContent());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.LIST_ACHIEVEMENT_NOT_FOUND.status).body(ServerStatus.LIST_ACHIEVEMENT_NOT_FOUND.toString());
        }
    }
}