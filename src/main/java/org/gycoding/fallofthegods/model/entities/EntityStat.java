package org.gycoding.fallofthegods.model.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class EntityStat<T> {
    private T attack;
    private T defense;
    private T accuracy;
    private T life;
    private T ether;
    private T movement;

    @Override
    public String toString() {
        return "{\"attack\": " + attack + ", \"defense\": " + defense + ", \"accuracy\": " + accuracy + ", \"life\": " + life + ", \"ether\": " + ether + ", \"movement\": " + movement + "}";
    }
}
