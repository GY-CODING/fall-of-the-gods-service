package com.gycoding.fallofthegods.controller.apiusers;


import com.gycoding.fallofthegods.model.database.service.UserService;
import com.gycoding.fallofthegods.model.entities.ServerStatus;
import com.gycoding.fallofthegods.model.entities.achievements.EntityUser;
import com.gycoding.fallofthegods.model.entities.dto.UnlockAchievementRQDTO;
import com.gycoding.fallofthegods.model.entities.exceptions.FOTGAPIException;
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
    public ResponseEntity<?> getUser(@RequestParam String id) throws FOTGAPIException {
        return ResponseEntity.ok(userService.getUser(id).toString());
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody EntityUser user) throws FOTGAPIException {
        return ResponseEntity.ok(userService.save(user).toString());
    }

    @PutMapping("/achievements/add")
    public ResponseEntity<?> addAchievement(@RequestBody UnlockAchievementRQDTO unlockAchievementRQDTO) throws FOTGAPIException {
        return ResponseEntity.ok(userService.addAchievement(unlockAchievementRQDTO.idUser(), unlockAchievementRQDTO.idAchievement()).toString());
    }

    @DeleteMapping("/achievements/remove")
    public ResponseEntity<?> removeAchievement(@RequestParam String idUser, @RequestParam String idAchievement) throws FOTGAPIException {
        return ResponseEntity.ok(userService.removeAchievement(idUser, idAchievement).toString());
    }

    @GetMapping("/achievements/get")
    public ResponseEntity<?> getAchievement(@RequestParam String idUser, @RequestParam String idAchievement) throws FOTGAPIException {
        return ResponseEntity.ok(userService.getAchievement(idUser, idAchievement).toString());
    }

    @GetMapping("/achievements/list")
    public ResponseEntity<?> listAchievements(@RequestParam String id) throws FOTGAPIException {
        return ResponseEntity.ok(userService.listAchievements(id).toString());
    }

    @GetMapping("/achievements/page")
    public ResponseEntity<?> pageAchievements(@RequestParam String id, Pageable pageable) throws FOTGAPIException {
        return ResponseEntity.ok(userService.pageAchievements(id, pageable).getContent());
    }
}