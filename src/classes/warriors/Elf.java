package classes.warriors;

import classes.Castle;

public class Elf extends Warrior {
    /**
     * Elf constructor
     *
     * @param castle
     */
    public Elf(Castle castle) {
        super(castle);
    }

    // Constants ---
    private static final int RESOURCE_COST = 2;

    @Override
    public int getCost() {
        return Elf.RESOURCE_COST;
    }

    @Override
    public int getStrength() {
        return super.getStrength() * 2;
    }
}