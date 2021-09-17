package classes;

import classes.warriors.Dwarf;
import classes.warriors.Elf;
import classes.warriors.Warrior;

import java.util.ArrayList;
import java.util.LinkedList;

public class Board {
    // Constructor ---
    public Board(int length) {
        this.generateCells(length);
        this.blueCastle = new Castle(Team.BLUE);
        this.redCastle = new Castle(Team.RED);

        this.addWarriorToCastle(blueCastle, new Elf(blueCastle));
        this.addWarriorToCastle(blueCastle, new Elf(blueCastle));
        this.addWarriorToCastle(blueCastle, new Elf(blueCastle));

        LinkedList<Warrior> trainedW = this.blueCastle.trainWarriors();
        this.moveWarriors();
    }

    // Variables ---
    private ArrayList<Cell> cells = new ArrayList();
    private Castle blueCastle;
    private Castle redCastle;

    // Getters & setters ---
    public ArrayList<Cell> getCells() {
        return cells;
    }

    public Castle getBlueCastle() {
        return blueCastle;
    }

    public Castle getRedCastle() {
        return redCastle;
    }

    // Methods ---
    public Cell getBlueStartingCell() {
        //Blue are starting left side
        return this.cells.get(0);
    }

    public Cell getRedStartingCell() {
        // Red are starting right side
        return this.cells.get(this.cells.size() - 1);
    }

    private void generateCells(int length) {
        for (int i = 0; i < length; i++) {
            this.cells.add(new Cell(i));
        }
    }

    public void addWarriorToCastle(Castle castle, Warrior warrior) {
        castle.addWarrior(warrior);
    }

    public void moveWarriors() {
        for (int i = this.getCells().size(); i > 0; i--) {
            System.out.println(this.getCells().get(i - 1).getBlueWarriors());
        }
    }

    public void newRound() {

    }
}
