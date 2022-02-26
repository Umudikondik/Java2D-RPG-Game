package Game;
import java.util.Arrays;

public class Boss_Forest extends Enemy   // Boss Thrall the Shaman King stole an item.
{
    protected double taken_damage;
    protected String bossForest_name;
    protected static double secilen;

    public Boss_Forest(double default_bossForest_health, double default_bossForest_damage, String bossForest_name)
    {
        super(default_bossForest_health,default_bossForest_damage, bossForest_name);
        this.bossForest_name = bossForest_name;
    }

    public void attack(Main_Character our_hero)   // This method decreases the enemy's health according to our_hero's damage.
    {
        taken_damage = our_hero.getDefault_damage() * ((Math.random()*10)+1);   // By the help of the Math.random, our game depends on luck.
        default_health -= taken_damage;
        if(default_health <= 0)
        {
            this.isDead();
        }
        fight_text = "You dealt " + taken_damage + " damage" + "\n" + "Thrall the Shaman King" + " health remaining: " + default_health;
        System.out.println("You dealt " + taken_damage + " damage");
        System.out.println("Thrall the Shaman King health remaining: " + default_health);
        time.sleep(1);
    }
    public static void boss_feature(Main_Character our_hero)     // Steal an item from equipment.
    {
        Weapon[] new_array;    // Create a new array that is the same with our_hero's weapons array. After that change one of the items randomly in the equipment. Finally, set it to the new weapons array.
        new_array = Arrays.copyOf(our_hero.getWeapones(), our_hero.getWeapones().length);
        secilen = (Math.random()*1) + 0;
        if(secilen < 0.5)
        {
            new_array[0] = null;
            our_hero.setWeapones(new_array);
        }
        if(secilen >=  0.5)
        {
            new_array[1] = null;
            our_hero.setWeapones(new_array);
        }
    }
    public void isDead()
    {
        setDefault_damage(0);    // When enemy died, enemy's damage will set 0
    }

}
