package org.gycoding.fallofthegods.infrastructure.api.dto.out;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class StatRSDTO<T> {
    public T physicalDamage;
    public T magicalDamage;
    public T physicalArmor;
    public T magicalArmor;
    public T movementSpeed;
    public T attackSpeed;
    public T criticalStrike;
    public T criticalStrikeProbability;
    public T health;
    public T ether;
}
