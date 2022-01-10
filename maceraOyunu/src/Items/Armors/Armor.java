package Items.Armors;

import Items.Weapons.Weapon;

public abstract class Armor {
    private String name;
    private  int id;
    private  int defending;
    private int price;


    public Armor(String name, int id, int defending, int price) {
        this.name = name;
        this.id = id;
        this.defending = defending;
        this.price = price;
    }

    public static Armor [] armors(){
        Armor [] armorList = {new Light(),new Medium(),new Heavy()};
        return armorList;
    }
    public static Armor getArmorById(int id){
        for( Armor armor: Armor.armors()
             ) {
            if(armor.getId()==id){
                return armor;
            }

        }
        return null;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDefending() {
        return defending;
    }

    public void setDefending(int defending) {
        this.defending = defending;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
