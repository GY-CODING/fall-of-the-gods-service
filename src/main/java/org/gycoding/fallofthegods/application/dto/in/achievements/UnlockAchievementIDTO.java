package org.gycoding.fallofthegods.application.dto.in.achievements;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record UnlockAchievementIDTO(
        @JsonProperty("id-user")
        String idUser,
        @JsonProperty("id-achievement")
        String idAchievement
) {}
