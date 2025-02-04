package org.gycoding.fallofthegods.application.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class StatIDTO<T> {
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

    public Class<?> getParametrizedClass() {
        return physicalDamage.getClass();
    }
}
