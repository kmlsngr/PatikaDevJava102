package Obstacles;

public abstract class Obstacle {

    private String name;
    private int ID;
    private int damage;
    private  int health;
    private int trophy;
    private int originalHealth;

    public Obstacle(String name, int ID, int damage, int health, int trophy) {
        this.name = name;
        this.ID = ID;
        this.damage = damage;
        this.health = health;
        this.trophy = trophy;
        this.originalHealth = health;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getTrophy() {
        return trophy;
    }

    public void setTrophy(int trophy) {
        this.trophy = trophy;
    }
}
