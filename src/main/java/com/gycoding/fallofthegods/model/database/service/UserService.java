package com.gycoding.fallofthegods.model.database.service;

import com.gycoding.fallofthegods.model.database.repository.AchievementRepository;
import com.gycoding.fallofthegods.model.database.repository.StoryRepository;
import com.gycoding.fallofthegods.model.database.repository.UserRepository;
import com.gycoding.fallofthegods.model.entities.ServerStatus;
import com.gycoding.fallofthegods.model.entities.achievements.EntityAchievement;
import com.gycoding.fallofthegods.model.entities.achievements.EntityUser;
import com.gycoding.fallofthegods.model.entities.characters.EntityStory;
import com.gycoding.fallofthegods.model.entities.exceptions.FOTGAPIException;
import com.gycoding.fallofthegods.model.entities.utiles.PagingConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.tags.form.FormTag;

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
     * @throws FOTGAPIException
     */
    public EntityUser getUser(String identifier) throws FOTGAPIException {
        return userRepository.findByIdentifier(identifier).orElseThrow(() ->
            new FOTGAPIException(ServerStatus.USER_NOT_FOUND)
        );
    }

    /**
     * Saves a User.
     * @param user
     * @return ServerStatus
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see EntityUser
     * @see ServerStatus
     * @see UserRepository
     * @throws FOTGAPIException
     */
    public EntityUser save(EntityUser user) throws FOTGAPIException {
        try {
            final EntityUser formattedUser = EntityUser.builder()
                    .identifier(user.identifier())
                    .username(user.username())
                    .email(user.email())
                    .achievements(List.of())
                    .build();

            return userRepository.save(formattedUser);
        } catch (Exception e) {
            throw new FOTGAPIException(ServerStatus.SERVER_ERROR);
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
     * @throws FOTGAPIException
     */
    public EntityUser addAchievement(String identifier, String achievement) throws FOTGAPIException {
        final EntityUser user                       = this.getUser(identifier);
        final EntityAchievement entityAchievement   = achievementRepository.findByIdentifier(achievement).orElseThrow(() ->
            new FOTGAPIException(ServerStatus.ACHIEVEMENT_NOT_FOUND)
        );

        user.achievements().add(entityAchievement);

        return userRepository.save(user);
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
     * @throws FOTGAPIException
     */
    public EntityUser removeAchievement(String identifier, String achievement) throws FOTGAPIException {
        final EntityUser user                       = this.getUser(identifier);
        final EntityAchievement entityAchievement   = achievementRepository.findByIdentifier(achievement).orElseThrow(() ->
            new FOTGAPIException(ServerStatus.ACHIEVEMENT_NOT_FOUND)
        );

        user.achievements().remove(entityAchievement);

        return userRepository.save(user);
    }

    /**
     * Finds a specific achievement unlocked by a specific User, both operations by their identifiers.
     * @param idUser
     * @param idAchievement
     * @return EntityAchievement
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see EntityAchievement
     * @see UserRepository
     * @throws FOTGAPIException
     */
    public EntityAchievement getAchievement(String idUser, String idAchievement) throws FOTGAPIException {
        final List<EntityAchievement> achievements = this.getUser(idUser).achievements();

        for(EntityAchievement achievement : achievements) {
            if(achievement.identifier().equals(idAchievement)) {
                return achievement;
            }
        }

        throw new FOTGAPIException(ServerStatus.ACHIEVEMENT_NOT_FOUND);
    }

    /**
     * Lists all the achievements unlocked by a specific User.
     * @param identifier
     * @return List of EntityAchievement
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see List
     * @see EntityAchievement
     * @see UserRepository
     * @throws FOTGAPIException
     */
    public List<EntityAchievement> listAchievements(String identifier) throws FOTGAPIException {
        return this.getUser(identifier).achievements();
    }

    /**
     * Lists all the achievements unlocked by a specific User with pagination.
     * @param identifier
     * @return List of EntityAchievement
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see Pageable
     * @see Page
     * @see Map
     * @see EntityAchievement
     * @see UserRepository
     * @throws FOTGAPIException
     */
    public Page<Map<String, Object>> pageAchievements(String identifier, Pageable pageable) throws FOTGAPIException {
        return PagingConverter.listToPage(this.getUser(identifier).achievements(), pageable)
                .map(EntityAchievement::toMap);
    }
}
