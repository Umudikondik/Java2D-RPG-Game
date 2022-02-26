package Game;

public class Boss_Cave extends Enemy         // Boss Cave Dragon gives fire damage.
{
    protected double taken_damage;
    protected static double fire_damage = 5;
    protected String bossCave_name;

    public Boss_Cave(double default_bossCave_health, double default_bossCave_damage, String bossCave_name)
    {
        super(default_bossCave_health,default_bossCave_damage, bossCave_name);
        this.bossCave_name = bossCave_name;
    }
    public void attack(Main_Character our_hero)   // This method decreases the enemy's health according to our_hero's damage.
    {
        taken_damage = our_hero.getDefault_damage() * ((Math.random()*10)+1);    // By the help of the Math.random, our game depends on luck.
        default_health -= taken_damage;
        our_hero.default_health -= fire_damage;
        fire_damage += 5;           // Fire damage's effect increasing every fight round.

        if(default_health <= 0)
        {
            isDead();
        }
        fight_text = "You dealt " + taken_damage + " damage" + "\n" + "Cave Dragon" + " health remaining: " + default_health;
        System.out.println("You dealt " + taken_damage + " damage");
        System.out.println("Cave Dragon health remaining: " + default_health);
    }
    public void isDead()
    {
        setDefault_damage(0);    // When enemy died, enemy's damage will set 0.
    }
}
