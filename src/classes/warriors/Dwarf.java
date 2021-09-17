package classes.warriors;

import classes.Castle;

public class Dwarf extends Warrior {
    // Constructor ---
    public Dwarf(Castle castle) {
        super(castle);
    }

    @Override
    public void setDamage(int damage) {
        super.setDamage(damage / 2);
    }
}
