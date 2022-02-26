package Trash;

import Game.Enemy;
import Game.Main_Character;

public class Enemy2 extends Enemy
{
    private double default_enemy2_damage;
    private double default_enemy2_health;
    private String default_enemy2_name;


    public Enemy2(double default_enemy2_health, double default_enemy2_damage, String default_enemy2_name)
    {
        super(default_enemy2_health, default_enemy2_damage, default_enemy2_name);
        this.default_enemy2_health = default_enemy2_health;
        this.default_enemy2_damage = default_enemy2_damage;
        this.default_enemy2_name = default_enemy2_name;
    }

    @Override
    public void attack(Main_Character our_hero)
    {
        double taken_damage2 = our_hero.getDefault_damage()  * ((Math.random()*10)+1);
        default_enemy2_health -= taken_damage2;
        System.out.println("You dealt " + taken_damage2 + " damage");
        System.out.println("Enemy health remaining: " + default_enemy2_health);


        if(default_enemy2_health <= 0)
        {
            this.isDead();
        }

    }


    public void isDead()
    {

    }


    public double getDefault_enemy_damage()
    {
        return default_enemy2_damage;
    }


    public void setDefault_enemy_damage(double default_enemy2_damage)
    {
        this.default_enemy2_damage = default_enemy2_damage;
    }


    public double getDefault_enemy_health()
    {
        return default_enemy2_health;
    }


    public void setDefault_enemy_health(double default_enemy2_health)
    {
        this.default_enemy2_health = default_enemy2_health;
    }

    public String getDefault_enemy1_name() {
        return default_enemy2_name;
    }

    public void setDefault_enemy1_name(String default_enemy2_name) {
        this.default_enemy2_name = default_enemy2_name;
    }
}
