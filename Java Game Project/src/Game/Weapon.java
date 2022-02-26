package Game;
public class Weapon
{
    protected double weapon_damage, weapon_price;
    protected String weapon_name;
    public Weapon(double weapon_damage, double weapon_price, String weapon_name)   // Weapons for our characters.
    {
        this.weapon_damage = weapon_damage;
        this.weapon_price = weapon_price;
        this.weapon_name = weapon_name;
    }
    public double getWeapon_damage()
    {
        return weapon_damage;
    }
    public double getWeapon_price()
    {
        return weapon_price;
    }
    public String getWeapon_name()
    {
        return weapon_name;
    }
}
