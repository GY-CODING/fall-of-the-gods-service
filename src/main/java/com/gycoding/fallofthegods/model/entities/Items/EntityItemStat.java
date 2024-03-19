package com.gycoding.fallofthegods.model.entities.items;

public class EntityItemStat {
    private String type;
    private double value;

    public EntityItemStat(String type, double value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    
    @Override 
    public String toString() {
        return "{\"type\": \"" + type + "\", \"value\": " + value + "}";
    }
}
