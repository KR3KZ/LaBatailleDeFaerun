package classes;

import classes.warriors.Warrior;

import java.util.LinkedList;

public class Cell {
    // Constructor ---
    public Cell(int id) {
        this.id = id;
    }

    // Constants ---
    private final LinkedList<Warrior> blueWarriors = new LinkedList<>();
    private final LinkedList<Warrior> redWarriors = new LinkedList<>();

    // Variables ---
    private int id;

    // Getters & setters ---
    public int getId() {
        return this.id;
    }

    public LinkedList<Warrior> getBlueWarriors() {
        return this.blueWarriors;
    }

    public LinkedList<Warrior> getRedWarriors() {
        return this.redWarriors;
    }
}
