package com.gycoding.fallofthegods.model.entities.Characters;

public class EntityStat {
    private Double attack;
    private Double defense;
    private Double accuracy;
    private Double life;
    private Double ether;
    private Double movement;

    public EntityStat(Double attack, Double defense, Double accuracy, Double life, Double ether, Double movement) {
        this.attack     = attack;
        this.defense    = defense;
        this.accuracy   = accuracy;
        this.life       = life;
        this.ether      = ether;
        this.movement   = movement;
    }

    public Double getAttack() {
        return attack;
    }
    public void setAttack(Double attack) {
        this.attack = attack;
    }

    public Double getDefense() {
        return defense;
    }
    public void setDefense(Double defense) {
        this.defense = defense;
    }

    public Double getAccuracy() {
        return accuracy;
    }
    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

    public Double getLife() {
        return life;
    }
    public void setLife(Double life) {
        this.life = life;
    }

    public Double getEther() {
        return ether;
    }
    public void setEther(Double ether) {
        this.ether = ether;
    }

    public Double getMovement() {
        return movement;
    }
    public void setMovement(Double movement) {
        this.movement = movement;
    }

    @Override
    public String toString() {
        return "{" +
                "\"attack\": " + attack + "," +
                "\"defense\": " + defense + "," +
                "\"accuracy\": " + accuracy + "," +
                "\"life\": " + life + "," +
                "\"ether\": " + ether + "," +
                "\"movement\": " + movement +
                "}";
    }
}
