package classes.warriors;

import classes.Castle;

public class DwarfChief extends Dwarf {
    /**
     * DwarfChief constructor
     *
     * @param castle
     */
    public DwarfChief(Castle castle) {
        super(castle);
    }

    // Constants ---
    private static final int RESOURCE_COST = 3;

    @Override
    public int getCost() {
        return DwarfChief.RESOURCE_COST;
    }

    @Override
    public void setDamage(int damage) {
        super.setDamage(damage / 2);
    }
}
