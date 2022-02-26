package Game;

public class Wizard extends Main_Character implements Characters
{
    protected int secilen_karakter;
    protected String isim;
    protected static String buy_item;
    protected boolean checker = true;  // Shop checker.
    // Wizard weapons.
    Weapon weapon_1 = new Weapon(2,100,"Ice Spell");
    Weapon weapon_2 = new Weapon(4,600,"Fire Spell");
    Weapon armor_1 = new Weapon(30,100,"Health Potion");
    Weapon armor_2 = new Weapon(60,600,"Magic Shield");
    Weapon golden_apple = new Weapon(0.5,50,"Golden Apple");

    public Wizard(double wizard_health, double wizard_damage,int secilen_karakter)
    {
        super(wizard_health,wizard_damage,secilen_karakter);
    }

    public void game_mode(int difficulty)     // Change the game difficulty.
    {
        if(difficulty == 1)       //Easy
        {
            default_health += 20;
            default_damage += 2.5;
            this.point -= 200;
        }
        if(difficulty == 2)      //Normal
        {
            // Default settings
        }
        if(difficulty == 3)          //Hard
        {
            default_health += 20;
            default_damage += 2.5;
            this.point += 200;
        }
    }

    public void Backpack()    // For Golden Apple
    {
        Weapon[] inventory_2 = new Weapon[weapones.length+1];          //Increase Size Equipment
        for(int i = 0; i < weapones.length; i++)
        {
            inventory_2[i] = weapones[i];
        }
        weapones = new Weapon[inventory_2.length];
        for(int i = 0; i < inventory_2.length; i++)
        {
            weapones[i] = inventory_2[i];
        }
        backpack_checker = true;
    }
    public void shop(double final_coin)  // Print shop text to the command line.
    {
        System.out.println("***********SHOP************" + "\n" + "Total coin : " + this.coin + "\n" + "1) " + weapon_1.getWeapon_name() + "\n" +  "Price : " + weapon_1.getWeapon_price() + "\n" + "Damage: " + weapon_1.getWeapon_damage() + "\n" + "2) " + weapon_2.getWeapon_name() +  "\n" + "Price: " + weapon_2.getWeapon_price() + "\n" + "Damage:" + weapon_2.getWeapon_damage() + "\n" + "3) " + armor_1.getWeapon_name() + "\n" + "Price : " + armor_1.getWeapon_price() + "\n" + "Protection: " + armor_1.getWeapon_damage() + "\n" + "4) " + armor_2.getWeapon_name() +  "\n" + "Price: " + armor_2.getWeapon_price() + "\n" + "Protection:" + armor_2.getWeapon_damage() + "\n" + "5) Exit the shop");  //satın alma menüsü printlicez.
    }
    public void Buy_Item(int girilen)   // Shop
    {
        checker = true;
        this.shop(coin);
        if (coin >= weapon_1.getWeapon_price() && girilen == 1)
        {
            buy_item = " You purchased : " + weapon_1.getWeapon_name();
            System.out.println(buy_item);
            weapones[0] = weapon_1;
            coin -= weapon_1.getWeapon_price();
        } else if (coin < weapon_1.getWeapon_price() && girilen == 1) {
            buy_item = "You do not have enough coins to buy " + weapon_1.getWeapon_name();
            System.out.println(buy_item);
        }
        if (coin >= weapon_2.getWeapon_price() && girilen == 2) {
            buy_item = " You purchased : " + weapon_2.getWeapon_name();
            System.out.println(buy_item);
            weapones[0] = weapon_2;
            coin -= weapon_2.getWeapon_price();

        } else if (coin < weapon_2.getWeapon_price() && girilen == 2) {
            buy_item = "You do not have enough coins to buy " + weapon_2.getWeapon_name();
            System.out.println(buy_item);
        }
        if (coin >= armor_1.getWeapon_price() && girilen == 3) {
            buy_item = " You purchased : " + armor_1.getWeapon_name();
            System.out.println(buy_item);
            weapones[1] = armor_1;
            coin -= armor_1.getWeapon_price();

        } else if (coin < armor_1.getWeapon_price() && girilen == 3) {
            buy_item = "You do not have enough coins to buy " + armor_1.getWeapon_name();
            System.out.println(buy_item);
        }
        if (coin >= armor_2.getWeapon_price() && girilen == 4) {
            buy_item = " You purchased : " + armor_2.getWeapon_name();
            System.out.println(buy_item);
            weapones[1] = armor_2;
            coin -= armor_2.getWeapon_price();

        } else if (coin < armor_2.getWeapon_price() && girilen == 4) {
            buy_item = "You do not have enough coins to buy " + armor_2.getWeapon_name();
            System.out.println(buy_item);
        }
        if (coin >= 50 && girilen == 5) {
            buy_item = " You purchased : Backpack";
            System.out.println(buy_item);
            Backpack();
            coin -= 50;
        } else if (coin < 50 && girilen == 5) {
            buy_item = "You do not have enough coins to buy Backpack";
            System.out.println(buy_item);
        }
        if (coin >= 50 && girilen == 6) {
            if(backpack_checker)
            {
                buy_item = " You purchased : Golden Apple";
                System.out.println(buy_item);
                weapones[2] = golden_apple;
                coin -= 50;
            }
            else
                buy_item = "There is not enough room for a golden apple in your inventory.";
        }
        else if (coin < 50 && girilen == 6)
        {
            buy_item = "You do not have enough coins to buy Golden apple";
            System.out.println(buy_item);
        }
        if (girilen == 7) {
            buy_item = "Exiting the item shop...";
            System.out.println("Exiting the item shop...");
            time.sleep(1);
            checker = false;
        }
    }

    public void setIsim(String isim) {
        this.isim = isim;
        super.isim = this.isim;
    }
    public String getBuy_item() {
        return buy_item;
    }
    public boolean isChecker() {
        return checker;
    }
    public void setChecker(boolean checker) {
        this.checker = checker;
    }
}
