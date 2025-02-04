package org.gycoding.fallofthegods.infrastructure.external.database.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class StatEntity<T> {
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

    public StatEntity(
            T physicalDamage,
            T magicalDamage,
            T physicalArmor,
            T magicalArmor,
            T movementSpeed,
            T attackSpeed,
            T criticalStrike,
            T criticalStrikeProbability,
            T health,
            T ether
    ) {
        this.physicalDamage = physicalDamage;
        this.magicalDamage = magicalDamage;
        this.physicalArmor = physicalArmor;
        this.magicalArmor = magicalArmor;
        this.movementSpeed = movementSpeed;
        this.attackSpeed = attackSpeed;
        this.criticalStrike = criticalStrike;
        this.criticalStrikeProbability = criticalStrikeProbability;
        this.health = health;
        this.ether = ether;
    }

    public T getPhysicalDamage() { return physicalDamage; }
    public T getMagicalDamage() { return magicalDamage; }
    public T getPhysicalArmor() { return physicalArmor; }
    public T getMagicalArmor() { return magicalArmor; }
    public T getMovementSpeed() { return movementSpeed; }
    public T getAttackSpeed() { return attackSpeed; }
    public T getCriticalStrike() { return criticalStrike; }
    public T getCriticalStrikeProbability() { return criticalStrikeProbability; }
    public T getHealth() { return health; }
    public T getEther() { return ether; }
}
