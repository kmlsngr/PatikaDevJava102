package Items.Weapons;

public abstract class Weapon {

    private  int ID;
    private  int damage;
    private int cost;
    private String name;

    public Weapon(int ID, int damage, int cost,String name) {
        this.ID = ID;
        this.damage = damage;
        this.cost = cost;
        this.name=name;
    }
    public static Weapon [] weapons(){
        Weapon[] weaponList =  {new Revolver(),new Sword(),new Rifle()};
        return weaponList;
    }
    public static Weapon getWeaponByID (int id){
        for (Weapon weapon: Weapon.weapons()
             ) {
            if(weapon.getID()==id){
                return weapon;
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
