package Game;

public class Main_Character
{
    protected double default_health, default_damage;
    protected int secilen_karakter;
    protected double coin;
    protected double point;
    protected Weapon[] weapones = new Weapon[2];   // First index is weapon, second index is armor.
    protected String isim, default_chest_info = "You didn't take any risks and moved on.", chest_info, death_text, fight_text, golden_apple_info;
    protected double taken_damage;
    protected boolean isDead = false, backpack_checker = false;


    public Main_Character(double default_health, double default_damage, int secilen_karakter) {
        this.default_health = default_health;
        this.default_damage = default_damage;
        this.secilen_karakter = secilen_karakter;
    }
    public Main_Character(double default_health, double default_damage)      // Constructor for enemy.
    {
        this.default_health = default_health;
        this.default_damage = default_damage;
    }
    public void attack(Enemy en1)            // This method decreases the character'S health according to enemy's damage.
    {
        taken_damage = en1.default_damage * ((Math.random()*10)+1);
        default_health -= taken_damage;
        if(this.default_health <= 0 && en1.getDefault_health() <= 0)          // If both sides are dead, return isDead.
        {
            time.sleep(1);
            this.isDead();
        }
        else if(this.default_health <= 0 && en1.getDefault_health() > 0)     // If enemy still alive and character is dead, return isDead.
        {
            time.sleep(1);
            this.isDead();
        }
        else if(en1.getDefault_health() <= 0)      // If enemy died, return enemy.isDead which sets the enemy's damage 0.
        {
            default_health += taken_damage;
            time.sleep(1);
            en1.isDead();
        }
        else  // If both sides are alive, continue to the fight.
        {
            en1.attack(this);
            this.attack(en1);            // Recursion
            time.sleep(1);
        }
    }
    public void isDead()        // It executed when character is dead.
    {
        death_text = isim + " is dead! R.I.P... " + this.isim + " You tried your best... " + "\n" + " Better luck next time!" + "\n" + " Total points: " + (this.point + this.coin - 200);
        isDead = true;
    }

    public void Chest()
    {
        double secilen = (Math.random()*1) + 0;   // 50% chance of death or bonus coin upon opening the chest.
        double bonus = (Math.random()*10) + 1;
        if(secilen < 0.5)
        {
            chest_info = "The chest had explosives in it, they went off, killing you brutally. ";   // Chest exploded.
            isDead();
        }
        if(secilen >= 0.5)
        {
            chest_info = "You just found" + " " + (int)(20*bonus) + " " + "coins in the mysterious chest.";
            coin += (int)(20*bonus);   // Character won coins.
        }

    }
    public void Weapons()   // When it executed, our character's damage and health changed according to the weapons array.
    {
        if(weapones[0] != null)
            this.default_damage += weapones[0].weapon_damage;
        if(weapones[1] != null)
            this.default_health += weapones[1].weapon_damage;
    }
    public void GoldenApple()    // If we bought backpack, we are possible to eat a golden apple which increases our damage and health.
    {
        if(weapones.length > 2) {
            if (weapones[2] != null) {
                golden_apple_info = "You ate a golden apple!";
                this.default_damage += 0.5;
                this.default_health += 25;
                weapones[2] = null;    // We ate the golden apple so we have not any golden apple after that.
            } else
                golden_apple_info = "You don't have any golden apple!";
        }
        else
            golden_apple_info = "You need a backpack for that!";
    }
    public double getDefault_damage() {
        return default_damage;
    }
    public void setDefault_damage(double default_damage) {
        this.default_damage = default_damage;
    }
    public double getDefault_health()
    {
        return default_health;
    }
    public void setDefault_health(double default_health)
    {
        this.default_health = default_health;
    }
    public boolean getDead() {
        return isDead;
    }
    public void setIsim(String isim) {
        this.isim = isim;
    }
    public String getChest_info() {
        return chest_info;
    }
    public String getDeath_text() {
        return death_text;
    }
    public Weapon[] getWeapones() {
        return weapones;
    }
    public void setWeapones(Weapon[] weapones) {
        this.weapones = weapones;
    }
    public String getDefault_chest_info() {
        return default_chest_info;
    }
    public int getSecilen_karakter() {
        return secilen_karakter;
    }
}
