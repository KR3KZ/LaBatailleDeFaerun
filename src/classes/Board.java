package classes;

import classes.warriors.Warrior;

import java.util.ArrayList;
import java.util.LinkedList;

public class Board {
    // Constructor ---
    public Board(int length) {
        // Generate the cells on the board
        this.generateCells(length);

        // Create the castle
        this.blueCastle = new Castle(Team.BLUE);
        this.redCastle = new Castle(Team.RED);
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
    private Cell getCell(int i) {
        return this.getCells().get(i);
    }

    public Cell getBlueStartingCell() {
        //Blue are starting left side
        return this.getCell(0);
    }

    // Return the red starting cell
    public Cell getRedStartingCell() {
        // Red are starting right side
        return this.getCell(this.cells.size() - 1);
    }

    // Is the game over ?
    public boolean isGameOver() {
        return this.getBlueStartingCell().isRed() || this.getRedStartingCell().isBlue();
    }

    // Return the blue starting cell
    private void generateCells(int length) {
        for (int i = 0; i < length; i++) {
            this.cells.add(new Cell(i));
        }
    }

    // Add a warrior to a castle
    public void addWarriorToCastle(Castle castle, Warrior warrior) {
        castle.addWarriorToWaitingLine(warrior);
    }

    // Make blue move, then red move
    public void moveWarriors() {
        // From left to right
        LinkedList<Warrior> waitingWarriors = null;
        int i = 0;

        // While there is no red warriors, blue moves on...
        while (i < this.getCells().size() && !this.getCell(i).isRed()) {
            Cell currentCell = this.getCell(i);

            LinkedList<Warrior> deletedWarriors = currentCell.deleteBlueWarriors();
            currentCell.addBlueWarrior(waitingWarriors);

            waitingWarriors = deletedWarriors;
            i++;
        }

        if (i < this.getCells().size()) {
            this.getCell(i).addBlueWarrior(waitingWarriors);

            int startMovingRed;

            if (this.getCell(i).isBlue()) {
                startMovingRed = i + 1;
            } else {
                startMovingRed = i;
            }

            for (int j = startMovingRed; j <= this.getRedStartingCell().getId(); j++) {
                Cell currentCell = this.getCell(j);

                Cell destCell = this.getCell(j - 1);

                LinkedList<Warrior> deletedWarriors = currentCell.deleteRedWarriors();
                destCell.addRedWarrior(deletedWarriors);
            }
        }
    }

    public void fight() {
        for (Cell cells : this.getCells()) {

        }
    }

    public void newRound() {
        this.getBlueCastle().newRound();
        this.getRedCastle().newRound();
    }
}
