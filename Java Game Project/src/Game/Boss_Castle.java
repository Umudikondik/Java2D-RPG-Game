package Game;

public class Boss_Castle extends Enemy     // Boss Dangalf does not allow player to escape.
{
    protected double taken_damage;
    protected String bossCastle_name;

    public Boss_Castle(double default_bossCastle_health, double default_bossCastle_damage, String bossCastle_name)
    {
        super(default_bossCastle_health,default_bossCastle_damage, bossCastle_name);
        this.bossCastle_name = bossCastle_name;
    }
    @Override
    public void attack(Main_Character our_hero)      // This method decreases the enemy's health according to our_hero's damage.
    {
        taken_damage = our_hero.getDefault_damage() * ((Math.random()*10)+1);      // By the help of the Math.random, our game depends on luck.
        default_health -= taken_damage;
        if(default_health <= 0)
        {
            this.isDead();
        }
        fight_text = "You dealt " + taken_damage + " damage" + "\n" + "Dangalf" + " health remaining: " + default_damage;
        System.out.println("You dealt " + taken_damage + " damage");
        System.out.println("Dangalf health remaining: " + default_health);
        time.sleep(1);
    }
    public void isDead()
    {
        setDefault_damage(0);  // When enemy died, enemy's damage will set 0.
    }

}


