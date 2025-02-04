package org.gycoding.fallofthegods.infrastructure.api.dto.in.achievements;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record UnlockAchievementRQDTO(
        @JsonProperty("id-user")
        String idUser,
        @JsonProperty("id-achievement")
        String idAchievement
) {}
