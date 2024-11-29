package org.gycoding.fallofthegods.model.dto.achievements;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record UnlockAchievementRQDTO(
        @JsonProperty("id-user")
        String idUser,
        @JsonProperty("id-achievement")
        String idAchievement
) {}
