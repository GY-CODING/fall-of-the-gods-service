package com.gycoding.fallofthegods.model.database.repository;

import com.gycoding.fallofthegods.model.entities.accounts.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TokenRepository extends JpaRepository<User, Integer> {
    @Query("SELECT token FROM User")
    public Optional<List<UUID>> findAllTokens();
}
