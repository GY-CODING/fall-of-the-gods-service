package com.gycoding.fallofthegods.model.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class EntityStat<T> {
    private T physicalDamage;
    private T magicalDamage;
    private T physicalArmor;
    private T magicalArmor;
    private T movementSpeed;
    private T attackSpeed;
    private T criticalStrike;
    private T criticalStrikeProbability;
    private T health;
    private T ether;

    @Override
    public String toString() {
        return "{" +
                "\"physicalDamage\": " + physicalDamage + "," +
                "\"magicalDamage\": " + magicalDamage + "," +
                "\"physicalArmor\": " + physicalArmor + "," +
                "\"magicalArmor\": " + magicalArmor + "," +
                "\"movementSpeed\": " + movementSpeed + "," +
                "\"attackSpeed\": " + attackSpeed + "," +
                "\"criticalStrike\": " + criticalStrike + "," +
                "\"criticalStrikeProbability\": " + criticalStrikeProbability + "," +
                "\"health\": " + health + "," +
                "\"ether\": " + ether +
                "}";
    }
}
