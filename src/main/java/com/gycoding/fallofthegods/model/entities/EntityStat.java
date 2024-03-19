package com.gycoding.fallofthegods.model.entities;

public class EntityStat<T> {
    private T attack;
    private T defense;
    private T accuracy;
    private T life;
    private T ether;
    private T movement;
    
    public EntityStat(T attack, T defense, T accuracy, T life, T ether, T movement) {
        this.attack     = attack;
        this.defense    = defense;
        this.accuracy   = accuracy;
        this.life       = life;
        this.ether      = ether;
        this.movement   = movement;
    }

    public T getAttack() {
        return attack;
    }
    public void setAttack(T attack) {
        this.attack = attack;
    }

    public T getDefense() {
        return defense;
    }
    public void setDefense(T defense) {
        this.defense = defense;
    }

    public T getAccuracy() {
        return accuracy;
    }
    public void setAccuracy(T accuracy) {
        this.accuracy = accuracy;
    }

    public T getLife() {
        return life;
    }
    public void setLife(T life) {
        this.life = life;
    }

    public T getEther() {
        return ether;
    }
    public void setEther(T ether) {
        this.ether = ether;
    }

    public T getMovement() {
        return movement;
    }
    public void setMovement(T movement) {
        this.movement = movement;
    }

    @Override
    public String toString() {
        return "{\"damage\": " + attack + ", \"defense\": " + defense + ", \"accuracy\": " + accuracy + ", \"life\": " + life + ", \"ether\": " + ether + ", \"movement\": " + movement + "}";
    }
}
