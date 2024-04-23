package com.gycoding.fallofthegods.model.database.service;

import com.gycoding.fallofthegods.model.database.repository.AchievementRepository;
import com.gycoding.fallofthegods.model.database.repository.StoryRepository;
import com.gycoding.fallofthegods.model.database.repository.UserRepository;
import com.gycoding.fallofthegods.model.entities.ServerStatus;
import com.gycoding.fallofthegods.model.entities.achievements.EntityAchievement;
import com.gycoding.fallofthegods.model.entities.achievements.EntityUser;
import com.gycoding.fallofthegods.model.entities.characters.EntityStory;
import com.gycoding.fallofthegods.model.entities.utiles.PagingConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository                   = null;
    @Autowired
    private AchievementRepository achievementRepository     = null;

    /**
     * Finds a User by its identifier.
     * @param identifier
     * @return EntityUser
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see EntityStory
     * @see StoryRepository
     */
    public EntityUser getUser(String identifier) {
        return userRepository.findByIdentifier(identifier).orElse(null);
    }

    /**
     * Saves a User.
     * @param user
     * @return ServerStatus
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see EntityUser
     * @see ServerStatus
     * @see UserRepository
     */
    public ServerStatus save(EntityUser user) {
        try {
            final EntityUser formattedUser = EntityUser.builder()
                    .identifier(user.identifier())
                    .username(user.username())
                    .email(user.email())
                    .achievements(List.of())
                    .build();

            userRepository.save(formattedUser);
            return ServerStatus.USER_CREATED;
        } catch (Exception e) {
            return ServerStatus.SERVER_ERROR;
        }
    }

    /**
     * Adds a new achievement to a specific User. That meaning that the User has unlocked the achievement.
     * @param identifier
     * @param achievement
     * @return ServerStatus
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see EntityUser
     * @see EntityAchievement
     * @see ServerStatus
     * @see UserRepository
     */
    public ServerStatus addAchievement(String identifier, String achievement) {
        try {
            final EntityUser user = this.getUser(identifier);

            user.achievements().add(achievementRepository.findByIdentifier(achievement));

            userRepository.save(user);

            return ServerStatus.ACHIEVEMENT_ADDED;
        } catch (Exception e) {
            return ServerStatus.SERVER_ERROR;
        }
    }

    /**
     * Removes an existing achievement from a specific User. That meaning that the achievement has turned locked for the User.
     * @param identifier
     * @param achievement
     * @return ServerStatus
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see EntityUser
     * @see EntityAchievement
     * @see ServerStatus
     * @see UserRepository
     */
    public ServerStatus removeAchievement(String identifier, String achievement) {
        try {
            final EntityUser user = this.getUser(identifier);

            user.achievements().remove(achievementRepository.findByIdentifier(achievement));

            userRepository.save(user);

            return ServerStatus.ACHIEVEMENT_REMOVED;
        } catch (Exception e) {
            return ServerStatus.SERVER_ERROR;
        }
    }

    /**
     * Finds a specific achievement unlocked by a specific User, both operations by their identifiers.
     * @param idUser
     * @param idAchievement
     * @return EntityAchievement
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see EntityAchievement
     * @see UserRepository
     */
    public EntityAchievement getAchievement(String idUser, String idAchievement) throws Exception {
        final List<EntityAchievement> achievements = this.getUser(idUser).achievements();

        for(EntityAchievement achievement : achievements) {
            if(achievement.identifier().equals(idAchievement)) {
                return achievement;
            }
        }

        throw new Exception();
    }

    /**
     * Lists all the achievements unlocked by a specific User.
     * @param identifier
     * @return List of EntityAchievement
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see List
     * @see EntityAchievement
     * @see UserRepository
     */
    public Page<Map<String, Object>> listAchievements(String identifier, Pageable pageable) {
        return PagingConverter.listToPage(this.getUser(identifier).achievements(), pageable)
                .map(EntityAchievement::toMap);
    }
}