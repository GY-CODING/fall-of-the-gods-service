package com.gycoding.fallofthegods.model.database.repository;

import com.gycoding.fallofthegods.model.entities.achievements.EntityUser;
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
     * @param identifier
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see Optional
     * @see EntityUser
     */
    Optional<EntityUser> findByIdentifier(String identifier);
}
