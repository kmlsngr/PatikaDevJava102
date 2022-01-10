package Items;

import Items.Armors.Armor;
import Items.Weapons.Weapon;

public class Inventory {

    private Weapon weapon;
    private Armor armor;
    private String [] collectedTropies = new String[3];

    public String[] getCollectedTropies() {
        return collectedTropies;
    }

    public void setCollectedTropies(String collectedTropies , int index) {
        this.collectedTropies[index] = collectedTropies;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Inventory() {
        this.weapon = new Weapon(0,0,0,"Punch"){};
        this.armor = new Armor("Armorless",0,0,0) {};
    }
}
