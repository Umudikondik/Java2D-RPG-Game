package Trash;
import Game.Informations;
import Game.Knight;
import Game.Thief;
import Game.Wizard;
import Trash.Enemy1;
import Trash.Enemy2;
import Trash.Enemy3;

import java.util.*;
public class MapCave   // Cave Dragon BOSS  -Burn damage each round-
{
    /*Knight cave_knight = new Knight(100,9,1);
    double first_knight_health;
    double first_knight_damage;
    Wizard cave_wizard = new Wizard(70,9,2);
    double first_wizard_health;
    double first_wizard_damage;
    Thief cave_thief= new Thief(70,6,3);
    double first_thief_health;
    double first_thief_damage;
    Informations info = new Informations();
    protected int zorluk;
    protected int secilen_karakter;
    protected int girilen;
    protected String isim;
    public double final_point;
    Scanner input = new Scanner(System.in);

    public MapCave(int zorluk,int secilen_karakter, String isim)
    {
        this.zorluk = zorluk;
        this.secilen_karakter = secilen_karakter;
        this.isim = isim;
        cave_knight.setIsim(isim);
        cave_wizard.setIsim(isim);
        cave_thief.setIsim(isim);
    }

    public void Level1()
    {
        System.out.println("You decided to enter the cave!");
        System.out.println("Level 1: ");

        Enemy1 en1 = new Enemy1(100,3, "Spelunker");


        if(secilen_karakter == 1)
        {

            cave_knight.game_mode(zorluk);        // Kullanıcıdan alınan inputla oyun zorluğu calıştırma.
            first_knight_health = cave_knight.getKnight_health();    // Burada canı her defasında eski haline döndürmek icin gereken şey var.
            first_knight_damage = cave_knight.getKnight_damage();    // bu kısımlar belki başa eklenebilir biraz cirkin duruyor.
            cave_knight.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                cave_knight.Chest();
            if(secenek2 == 2)
            {

            }
            info.Info_Before_Fight(en1);
            info.InfoLevel1Enemy();
            int secenek = input.nextInt();
            if(secenek == 1)
                System.out.println("Let's fight!");
            if(secenek == 2)
            {   final_point = cave_knight.point + cave_knight.coin;
                //info.Info_Escape(final_point);  // cezası olacak
            }
            cave_knight.attack(en1);   // karakterimiz ölünce isDead calışıyor.
            info.Info_After_Fight(en1);
            cave_knight.coin += 100;   // para ödülü
            cave_knight.point += 250;  // puan ödülü
            cave_knight.shop(cave_knight.coin);
            cave_knight.Buy_Item(girilen);
            cave_knight.setKnight_health(first_knight_health);     // Canı ilk haline döndürmek icin
            cave_knight.setKnight_damage(first_knight_damage);




        }
        if(secilen_karakter == 2)
        {
            cave_wizard.game_mode(zorluk);
            first_wizard_health= cave_wizard.getWizard_health();    // Burada canı her defasında eski haline döndürmek icin gereken şey var.
            first_wizard_damage = cave_wizard.getWizard_damage();
            cave_wizard.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                cave_wizard.Chest();
            if(secenek2 == 2)
            {

            }
            info.Info_Before_Fight(en1);
            info.InfoLevel1Enemy();
            int secenek = input.nextInt();
            if(secenek == 1)
                System.out.println("Let's fight!");
            if(secenek == 2)
            {
                final_point = cave_wizard.point+cave_wizard.coin;
                //info.Info_Escape(final_point);
            }
            cave_wizard.attack(en1);
            info.Info_After_Fight(en1);
            cave_wizard.coin += 100;
            cave_wizard.point += 250;  // puan ödülü
            cave_wizard.shop();
            cave_wizard.Buy_Item(girilen);
            cave_wizard.setWizard_health(first_wizard_health);
            cave_wizard.setWizard_damage(first_wizard_damage);
        }
        if(secilen_karakter == 3)
        {
            cave_thief.game_mode(zorluk);
            first_thief_health = cave_thief.getThief_health();
            first_thief_damage = cave_thief.getThief_damage();
            cave_thief.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                cave_thief.Chest();
            if(secenek2 == 2)
            {

            }
            info.Info_Before_Fight(en1);
            info.InfoLevel1Enemy();
            int secenek = input.nextInt();
            if(secenek == 1)
                System.out.println("Let's fight!");
            if(secenek == 2)
            {
                final_point = cave_thief.point + cave_thief.coin;
                //info.Info_Escape(final_point);
            }
            cave_thief.attack(en1);
            info.Info_After_Fight(en1);
            cave_thief.coin += 100;
            cave_thief.point += 250;  // puan ödülü
            cave_thief.shop();
            cave_thief.Buy_Item(girilen);
            cave_thief.setThief_health(first_thief_health);
            cave_thief.setThief_damage(first_thief_damage);
        }
        System.out.println("Level 1 cleared.");

    }
    public void Level2()
    {
        System.out.println("Level 2: ");
        Enemy2 en2 = new Enemy2(150,5, "Golbat");
        if(secilen_karakter == 1)
        {

            System.out.println(cave_knight.getKnight_health());
            cave_knight.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                cave_knight.Chest();
            if(secenek2 == 2)
            {

            }
            info.Info_Before_Fight(en2);
            info.InfoLevel2Enemy();
            int secenek = input.nextInt();
            if(secenek == 1)
                System.out.println("Let's fight!");
            if(secenek == 2)
            {
                final_point = cave_knight.point + cave_knight.coin;
                //info.Info_Escape(final_point);
            }
            cave_knight.attack(en2);   // Ölünce isDead calışıyor. Eğer karakter ölmezse alttaki satırlara gececek. Enemy de ölmüş olacak.
            cave_knight.coin += 200;
            cave_knight.point += 550;  // puan ödülü
            cave_knight.shop(cave_knight.coin);   //Menü printliyor.
            cave_knight.Buy_Item(girilen);
            cave_knight.setKnight_health(first_knight_health);   // canı eski haline getirecek.
            cave_knight.setKnight_damage(first_knight_damage);
        }
        if(secilen_karakter == 2)
        {
            cave_wizard.game_mode(zorluk);
            cave_wizard.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                cave_wizard.Chest();
            if(secenek2 == 2)
            {

            }
            info.Info_Before_Fight(en2);
            info.InfoLevel2Enemy();
            int secenek = input.nextInt();
            if(secenek == 1)
                System.out.println("Let's fight!");
            if(secenek == 2)
            {
                final_point = cave_wizard.point+cave_wizard.coin;
                //info.Info_Escape(final_point);
            }
            cave_wizard.attack(en2);
            cave_wizard.coin += 200;
            cave_wizard.point += 550;  // puan ödülü
            cave_wizard.shop();
            cave_wizard.Buy_Item(girilen);
            cave_wizard.setWizard_health(first_wizard_health);
            cave_wizard.setWizard_damage(first_wizard_damage);

        }
        if(secilen_karakter == 3)
        {
            cave_thief.game_mode(zorluk);
            cave_thief.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                cave_thief.Chest();
            if(secenek2 == 2)
            {

            }
            info.Info_Before_Fight(en2);
            info.InfoLevel2Enemy();
            int secenek = input.nextInt();
            if(secenek == 1)
                System.out.println("Let's fight!");
            if(secenek == 2)
            {
                final_point = cave_thief.point + cave_thief.coin;
               // info.Info_Escape(final_point);
            }
            cave_thief.attack(en2);
            cave_thief.coin += 200;
            cave_thief.point += 550;  // puan ödülü
            cave_thief.shop();
            cave_thief.Buy_Item(girilen);
            cave_thief.setThief_health(first_thief_health);
            cave_thief.setThief_damage(first_thief_damage);
        }
        System.out.println("Level 2 cleared.");

    }
    public void Level3()
    {
        System.out.println("Level 3: ");
        Enemy3 en3 = new Enemy3(200,7, "Warden");
        if(secilen_karakter == 1)
        {
            cave_knight.game_mode(zorluk);
            cave_knight.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                cave_knight.Chest();
            if(secenek2 == 2)
            {}
            info.Info_Before_Fight(en3);
            info.InfoLevel3Enemy();
            int secenek = input.nextInt();
            if(secenek == 1)
                System.out.println("Let's fight!");
            if(secenek == 2)
            {
                final_point = cave_knight.point + cave_knight.coin;
              //  info.Info_Escape(final_point);
            }
            cave_knight.attack(en3);   // ölünce isDead calışıyor.
            cave_knight.coin += 300;   // son düşman ölünce gelen ödül.
            cave_knight.point += 750;  // puan ödülü
            cave_knight.shop(cave_knight.coin);
            cave_knight.Buy_Item(girilen);
            cave_knight.setKnight_health(first_knight_health);
            cave_knight.setKnight_damage(first_knight_damage);
        }
        if(secilen_karakter == 2)
        {
            cave_wizard.game_mode(zorluk);
            cave_wizard.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                cave_wizard.Chest();
            if(secenek2 == 2)
            {}
            info.Info_Before_Fight(en3);
            info.InfoLevel3Enemy();
            int secenek = input.nextInt();
            if(secenek == 1)
                System.out.println("Let's fight!");
            if(secenek == 2)
            {
                final_point = cave_wizard.point+cave_wizard.coin;
                //info.Info_Escape(final_point);
            }
            cave_wizard.attack(en3);
            cave_wizard.coin += 300;
            cave_wizard.point += 750;  // puan ödülü
            cave_wizard.shop();
            cave_wizard.Buy_Item(girilen);
            cave_wizard.setWizard_health(first_wizard_health);
            cave_wizard.setWizard_damage(first_wizard_damage);
        }
        if(secilen_karakter == 3)
        {
            cave_thief.game_mode(zorluk);
            cave_thief.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                cave_thief.Chest();
            if(secenek2 == 2)
            {

            }
            info.Info_Before_Fight(en3);
            info.InfoLevel3Enemy();
            int secenek = input.nextInt();
            if(secenek == 1)
                System.out.println("Let's fight!");
            if(secenek == 2)
            {
                final_point = cave_thief.point + cave_thief.coin;
               // info.Info_Escape(final_point);
            }
            cave_thief.attack(en3);
            cave_thief.coin += 300;
            cave_thief.point += 750;  // puan ödülü
            cave_thief.shop();
            cave_thief.Buy_Item(girilen);
            cave_thief.setThief_health(first_thief_health);
            cave_thief.setThief_damage(first_thief_damage);
        }
        System.out.println("You saved the world from an evil force!" + "\n" + "THE END...");    //Infodan cekersek daha iyi olacak!
        if(secilen_karakter == 1)
            System.out.println("Your final point : " + cave_knight.point + 500 + cave_knight.coin);   // Puan + coin + bitirme bonusu
        if(secilen_karakter == 2)
            System.out.println("Your final point: " + cave_wizard.point + 500 + cave_wizard.coin);
        if(secilen_karakter == 3)
            System.out.println("Your final point " + cave_thief.point + 500 + cave_thief.coin);

        System.exit(0);

    }
    public int getGirilen()
    {
        return girilen;
    }
    public void setGirilen(int girilen)
    {
        this.girilen = girilen;
    }
    public double getFinal_point() {
        return final_point;
    }
    public void setFinal_point(double final_point) {
        this.final_point = final_point;
    }*/
}