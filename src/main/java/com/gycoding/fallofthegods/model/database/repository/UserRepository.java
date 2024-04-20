package com.gycoding.fallofthegods.model.database.repository;

import com.gycoding.fallofthegods.model.entities.achievements.EntityUser;
import com.gycoding.fallofthegods.model.entities.characters.EntityStory;
import com.gycoding.fallofthegods.model.entities.worlds.EntityPlace;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for the User entity.
 * @see EntityUser
 * @see MongoRepository
 * @see Repository
 * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
 */
@Repository
public interface UserRepository extends MongoRepository<EntityUser, String>{
    /**
     * Finds a User by its identifier.
     * @param id
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see Optional
     * @see EntityStory
     */
    Optional<EntityUser> findById(String id);

    /**
     * Finds a User by its username.
     * @param username
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see Optional
     * @see EntityStory
     */
    Optional<EntityUser> findByUsername(String username);

    /**
     * Finds a User by its email.
     * @param email
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see Optional
     * @see EntityStory
     */
    Optional<EntityUser> findByEmail(String email);
}
