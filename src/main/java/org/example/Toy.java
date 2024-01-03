package org.example;

public class Toy {
    private Integer toyId;
    private String toyName;
    private Integer toyCount;
    private Integer dropChance;

    public Toy(Integer toyId, String toyName, Integer toyCount, Integer dropChance) {
        this.toyId = toyId;
        this.toyName = toyName;
        this.toyCount = toyCount;
        this.dropChance = dropChance;
    }

    public Integer getDropChance() {
        return dropChance;
    }

    public Integer getToyCount() {
        return toyCount;
    }

    public String getToyName() {
        return toyName;
    }

    public void setToyCount(Integer toyCount) {
        this.toyCount = toyCount;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "toyId=" + toyId +
                ", toyName='" + toyName + '\'' +
                ", toyCount=" + toyCount +
                ", dropChance=" + dropChance +
                '}';
    }
}
