package com.gycoding.fallofthegods.model.entities.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record UnlockAchievementRQDTO(
        @JsonProperty("id-user")
        String idUser,
        @JsonProperty("id-achievement")
        String idAchievement
) {}
