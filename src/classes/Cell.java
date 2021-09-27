package classes;

import classes.warriors.Warrior;

import java.util.LinkedList;

public class Cell {
    // Constructor ---
    public Cell(int id) {
        this.id = id;
    }

    // Constants ---
    private LinkedList<Warrior> blueWarriors = new LinkedList<>();
    private LinkedList<Warrior> redWarriors = new LinkedList<>();

    // Variables ---
    private int id;

    // Getters & setters ---
    public int getId() {
        return this.id;
    }

    public void setBlueWarriors(LinkedList<Warrior> blueWarriors) {
        this.blueWarriors = blueWarriors;
    }

    public void setRedWarriors(LinkedList<Warrior> redWarriors) {
        this.redWarriors = redWarriors;
    }

    // Methods ---
    public LinkedList<Warrior> getBlueWarriors() {
        return this.blueWarriors;
    }

    public LinkedList<Warrior> getRedWarriors() {
        return this.redWarriors;
    }

    public boolean isBlue() {
        return this.getBlueWarriors().size() > 0;
    }

    public boolean isRed() {
        return this.getRedWarriors().size() > 0;
    }

    public void addBlueWarrior(LinkedList<Warrior> movingWarriors) {
        if (movingWarriors != null) {
            this.getBlueWarriors().addAll(movingWarriors);
        }
    }

    public void addRedWarrior(LinkedList<Warrior> movingWarriors) {
        if (movingWarriors != null) {
            this.getRedWarriors().addAll(movingWarriors);
        }
    }

    public LinkedList<Warrior> deleteBlueWarriors() {
        LinkedList<Warrior> movingWarriors = this.getBlueWarriors();
        this.setBlueWarriors(new LinkedList<Warrior>());
        return movingWarriors;
    }

    public LinkedList<Warrior> deleteRedWarriors() {
        LinkedList<Warrior> movingWarriors = this.getRedWarriors();
        this.setRedWarriors(new LinkedList<Warrior>());
        return movingWarriors;
    }
}
