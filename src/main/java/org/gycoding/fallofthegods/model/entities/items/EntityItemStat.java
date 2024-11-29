package org.gycoding.fallofthegods.model.entities.items;

import lombok.Builder;

@Builder
public record EntityItemStat(
    String type,    // TODO. Make this enum.
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
