package classes;

import classes.warriors.*;

public class Test {
//    public static void main(String[] args) {
////        ElfVSDwarf();
////        ElfChiefVSDwarfChief();
//        Castle();
//    }

    public static void Castle() {
        Board board = new Board(5);
        board.addWarriorToCastle(board.getBlueCastle(), new Elf(board.getBlueCastle()));
        board.moveWarriors();
    }

    public static void ElfVSDwarf() {
        Castle c = new Castle(Team.BLUE);
        Elf a = new Elf(c);
        Dwarf b = new Dwarf(c);
        Duel(a, b);
    }

    public static void ElfChiefVSDwarfChief() {
        Castle c = new Castle(Team.BLUE);
        ElfChief a = new ElfChief(c);
        DwarfChief b = new DwarfChief(c);
        Duel(a, b);
    }

    public static void Duel(Warrior a, Warrior b) {
        System.out.println("Fight !");
        do {
            if (a.isAlive()) {
                a.attackWarrior(b);
                System.out.println("A attaque B, il lui reste " + b.getLife() + " pdv.");
            }

            if (b.isAlive()) {
                b.attackWarrior(a);
                System.out.println("B attaque A, il lui reste " + a.getLife() + " pdv.");
            }
        } while (a.isAlive() && b.isAlive());
        if (a.isAlive()) {
            System.out.println("A gagne, B est mort.");
        } else {
            System.out.println("B gagne, A est mort.");
        }
    }
}
