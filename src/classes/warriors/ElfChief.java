package classes.warriors;

import classes.Castle;

public class ElfChief extends Elf {
    /**
     * ElfChief constructor
     *
     * @param castle
     */
    public ElfChief(Castle castle) {
        super(castle);
    }

    // Constants ---
    private static final int RESOURCE_COST = 4;

    @Override
    public int getCost() {
        return ElfChief.RESOURCE_COST;
    }

    @Override
    public int getStrength() {
        return super.getStrength() * 2;
    }
}
