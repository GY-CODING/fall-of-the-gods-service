package com.gycoding.fallofthegods.model.entities.items;

import lombok.Builder;

@Builder
public record EntityItemStat(
    String type,
    double value
) {
    @Override 
    public String toString() {
        return "{" +
                "\"type\": \"" + type + "\"," +
                "\"value\": " + value +
                "}";
    }
}
