package com.gycoding.fallofthegods.model.entities.achievements;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "Achievement")
public record EntityAchievement(

) {}
