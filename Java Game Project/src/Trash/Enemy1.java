package Trash;

import Game.Enemy;
import Game.Main_Character;

public class Enemy1 extends Enemy
{
    private double default_enemy1_damage;
    private double default_enemy1_health;
    private String default_enemy1_name;


    public Enemy1(double default_enemy1_health, double default_enemy1_damage, String default_enemy1_name)
    {
        super(default_enemy1_health, default_enemy1_damage, default_enemy1_name);
        this.default_enemy1_health = default_enemy1_health;
        this.default_enemy1_damage = default_enemy1_damage;
        this.default_enemy1_name = default_enemy1_name;
    }


    @Override
    public void attack(Main_Character our_hero)
    {
        double taken_damage1 = our_hero.getDefault_damage()  * ((Math.random()*10)+1);
        default_enemy1_health -= taken_damage1;
        System.out.println("You dealt " + taken_damage1 + " damage");
        System.out.println("Enemy health remaining: " + default_enemy1_health);


        if(default_enemy1_health <= 0)
        {
            this.isDead();
        }

    }


    public void isDead()
    {

    }


    public double getDefault_enemy_damage()
    {
        return default_enemy1_damage;
    }
    public void setDefault_enemy_damage(double default_enemy1_damage)
    {
        this.default_enemy1_damage = default_enemy1_damage;
    }
    public double getDefault_enemy_health()
    {
        return default_enemy1_health;
    }
    public void setDefault_enemy_health(double default_enemy1_health)
    {
        this.default_enemy1_health = default_enemy1_health;
    }
    public String getDefault_enemy1_name() {
        return default_enemy1_name;
    }
    public void setDefault_enemy1_name(String default_enemy1_name) {
        this.default_enemy1_name = default_enemy1_name;
    }
}
