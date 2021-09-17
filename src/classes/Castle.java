package classes;

import classes.warriors.Warrior;

import java.util.LinkedList;

public class Castle {
    // Constructor ---
    public Castle(Team team) {
        this.setTeam(team);
    }

    // Constants ---
    private static final int BASE_RESOURCE = 3;
    private static final int RESOURCE_WIN_PER_ROUND = 1;

    // Variables ---
    private int resource = Castle.BASE_RESOURCE;
    private final LinkedList<Warrior> warriors = new LinkedList<>();
    private Team team;

    // Getters & setters ---
    public int getResource() {
        return this.resource;
    }

    public int setResource(int resource) {
        return this.resource = resource;
    }

    public LinkedList<Warrior> getWarriors() {
        return this.warriors;
    }

    public Team getTeam() {
        return this.team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    // Methods ---
    // Add a warrior in the waiting line
    public void addWarrior(Warrior w) {
        this.warriors.add(w);
    }

    // Return the last warrior waiting in the waiting line
    public Warrior getFirstWarriorInWaitingLine() {
        return this.warriors.getFirst();
    }

    // Return the first warrior waiting in the waiting line
    public Warrior getLastWarriorInWaitingLine() {
        return this.warriors.getLast();
    }

    // Delete the last warrior waiting in the waiting line
    public void deleteFirstWarriorInWaitingLine() {
        this.warriors.removeFirst();
    }

    // Add new resources to the castle
    public int addNewRoundResource() {
        return this.setResource(this.getResource() + RESOURCE_WIN_PER_ROUND);
    }

    // Withdraw resources from the castle
    public int withdrawResource(int cost) {
        return this.setResource(this.getResource() - cost);
    }

    // Train warriors if the castle has enough resources
    public LinkedList<Warrior> trainWarriors() {
        LinkedList<Warrior> trainedWarriors = new LinkedList<>();
        while (this.warriors.size() > 0 && this.getFirstWarriorInWaitingLine().getCost() <= this.getResource()) {
            Warrior w = this.getFirstWarriorInWaitingLine();
            trainedWarriors.add(w);
            int wCost = w.getCost();
            this.withdrawResource(wCost);
            this.deleteFirstWarriorInWaitingLine();
        }
        return trainedWarriors;
    }
}
