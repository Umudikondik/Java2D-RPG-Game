package Trash;

import Game.Enemy;
import Game.Main_Character;

public class Enemy3 extends Enemy
{
    private double default_enemy3_damage;
    private double default_enemy3_health;
    private String default_enemy3_name;


    public Enemy3(double default_enemy3_health, double default_enemy3_damage, String default_enemy3_name)
    {
        super(default_enemy3_health, default_enemy3_damage, default_enemy3_name);
        this.default_enemy3_health = default_enemy3_health;
        this.default_enemy3_damage = default_enemy3_damage;
        this.default_enemy3_name = default_enemy3_name;
    }

    @Override
    public void attack(Main_Character our_hero)
    {
        double taken_damage3 = our_hero.getDefault_damage()  * ((Math.random()*10)+1);
        default_enemy3_health -= taken_damage3;
        System.out.println("You dealt " + taken_damage3 + " damage");
        System.out.println("Enemy health remaining: " + default_enemy3_health);


        if(default_enemy3_health <= 0)
        {
            this.isDead();
        }

    }


    public void isDead()
    {

    }


    public double getDefault_enemy_damage()
    {
        return default_enemy3_damage;
    }


    public void setDefault_enemy_damage(double default_enemy3_damage)
    {
        this.default_enemy3_damage = default_enemy3_damage;
    }


    public double getDefault_enemy_health()
    {
        return default_enemy3_health;
    }


    public void setDefault_enemy_health(double default_enemy3_health)
    {
        this.default_enemy3_health = default_enemy3_health;
    }

    public String getDefault_enemy1_name() {
        return default_enemy3_name;
    }

    public void setDefault_enemy1_name(String default_enemy3_name) {
        this.default_enemy3_name = default_enemy3_name;
    }
}
