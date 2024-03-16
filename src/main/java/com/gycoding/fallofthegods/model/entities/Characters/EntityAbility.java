package com.gycoding.fallofthegods.model.entities.characters;

public class EntityAbility {
    private String abilityName;
    private String abilityDesc;

    public EntityAbility(String abilityName, String abilityDesc) {
        this.abilityName = abilityName;
        this.abilityDesc = abilityDesc;
    }

    public String getAbilityName() {
        return abilityName;
    }
    public void setAbilityName(String abilityName) {
        this.abilityName = abilityName;
    }

    public String getAbilityDesc() {
        return abilityDesc;
    }
    public void setAbilityDesc(String abilityDesc) {
        this.abilityDesc = abilityDesc;
    }

    @Override
    public String toString() {
        return "{" +
                "\"abilityName\": \"" + abilityName + "\"," +
                "\"abilityDesc\": \"" + abilityDesc + "\"" +
                "}";
    }
}
