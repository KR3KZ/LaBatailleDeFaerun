package classes.warriors;

import classes.Castle;

public class Dwarf extends Warrior {
    /**
     * Dwarf constructor
     *
     * @param castle
     */
    public Dwarf(Castle castle) {
        super(castle);
    }

    /**
     * Apply damage to a Dwarf (damage divided by 2)
     *
     * @param damage
     */
    @Override
    public void setDamage(int damage) {
        super.setDamage(damage / 2);
    }
}
