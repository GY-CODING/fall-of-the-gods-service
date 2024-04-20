package com.gycoding.fallofthegods.model.entities.achievements;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@Document(collection = "User")
public record EntityUser(
        @Id
        String id,
        String username,
        String email,
        List<EntityAchievement> achievements
) {}
