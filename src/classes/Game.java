package classes;

import classes.warriors.Elf;

public class Game {

    private final Board board;

    public Game(int nbrCells) {
        System.out.println("Game started");
        this.board = new Board(nbrCells);
        this.board.getBlueCastle().addWarriorToWaitingLine(new Elf(this.board.getBlueCastle()));
        while (!this.board.isGameOver()) {
            this.board.moveWarriors();

            this.board.newRound();
        }
        System.out.println("Game ended");
    }

    public static void main(String[] args) {
        Game game = new Game(5);
    }
}
