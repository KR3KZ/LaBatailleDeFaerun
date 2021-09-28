package classes.warriors;

import classes.Castle;
import classes.Team;
import classes.Utils;

public abstract class Warrior {
    /**
     * Warrior constructor
     *
     * @param castle
     */
    public Warrior(Castle castle) {
        this.setCastle(castle);
    }

    /**
     * Constants
     */
    private static final int BASE_STRENGTH = 10;
    private static final int BASE_LIFE = 100;
    private static final int RESOURCE_COST = 1;

    /**
     * Attributes
     */
    private int strength = 10;
    private int life = 100;
    private Castle castle;

    /**
     * Get strength of a warrior
     *
     * @return strength
     */
    public int getStrength() {
        return this.strength;
    }

    /**
     * Set strength of a warrior
     *
     * @param strength
     * @return strength
     */
    public int setStrength(int strength) {
        return this.strength = strength;
    }

    public int getLife() {
        return this.life;
    }

    public int setLife(int life) {
        return this.life = life;
    }

    public int getCost() {
        return Warrior.RESOURCE_COST;
    }

    public Castle getCastle() {
        return this.castle;
    }

    public void setCastle(Castle castle) {
        this.castle = castle;
    }

    // Methods ---
    // Return true if the warrior is alive
    public boolean isAlive() {
        return this.life > 0;
    }

    // Attack the given warrior
    public void attackWarrior(Warrior warrior) {
        int damage = this.calculateDamage();
        if (damage > 0) {
            warrior.setDamage(damage);
        }
    }

    // Calculate damage based on n times, where n is strength
    public int calculateDamage() {
        int total_damage = 0;
        for (int i = 0; i < this.getStrength(); i++) {
            total_damage += Utils.dice();
        }
        return total_damage;
    }

    // Set damage
    public void setDamage(int damage) {
        if ((this.getLife() - damage) < 0) {
            this.setLife(0);
        } else {
            this.setLife(this.getLife() - damage);
        }
    }

    // Get castle's team
    public Team getTeam() {
        return this.getCastle().getTeam();
    }
}
