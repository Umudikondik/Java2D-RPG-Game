package Game;

public class Enemy extends Main_Character
{

    protected double taken_damage;
    protected String enemy_name, fight_text;
    public Enemy(double default_enemy_health, double default_enemy_damage, String enemy_name)
    {
        super(default_enemy_health,default_enemy_damage);
        this.enemy_name = enemy_name;
    }
    public void attack(Main_Character our_hero)        // This method decreases the enemy's health according to our_hero's damage.
    {
        int a = 0;
        if(our_hero.getSecilen_karakter() == 3)    // Thief gives %10 more damage thanks to the his luck.
        {
            a = 1;
        }
        taken_damage = our_hero.getDefault_damage() * ((Math.random()*10)+1)+a;   // By the help of the Math.random, our game depends on luck.
        default_health -= taken_damage;
        if(default_health <= 0)
        {
            this.isDead();
        }
        fight_text = "You dealt " + taken_damage + " damage" + "\n" + enemy_name + " health remaining: " + default_health;

        time.sleep(1);
    }
    @Override
    public void isDead()
    {
        setDefault_damage(0);    // When enemy died, enemy's damage will set 0
    }


}
