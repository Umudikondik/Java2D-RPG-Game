package Trash;
import Game.Informations;
import Game.Knight;
import Game.Thief;
import Game.Wizard;
import Trash.Enemy1;
import Trash.Enemy2;
import Trash.Enemy3;

import java.util.*;
public class MapForest    //Thrall the Shaman King -steal our health each round-
{
    /*Knight forest_knight = new Knight(100,9,1);
    double first_knight_health;
    double first_knight_damage;
    Wizard forest_wizard = new Wizard(70,9,2);
    double first_wizard_health;
    double first_wizard_damage;
    Thief forest_thief= new Thief(70,6,3);
    double first_thief_health;
    double first_thief_damage;
    Informations info = new Informations();
    protected int zorluk;
    protected int secilen_karakter;
    protected int girilen;
    protected String isim;
    public double final_point;
    Scanner input = new Scanner(System.in);

    public MapForest(int zorluk,int secilen_karakter, String isim)
    {
        this.zorluk = zorluk;
        this.secilen_karakter = secilen_karakter;
        this.isim = isim;
        forest_knight.setIsim(isim);
        forest_wizard.setIsim(isim);
        forest_thief.setIsim(isim);
    }

    public void Level1()
    {
        System.out.println("You decided to enter the forest!");
        System.out.println("Level 1: ");

        Enemy1 en1 = new Enemy1(100,3, "Bandit");


        if(secilen_karakter == 1)
        {

            forest_knight.game_mode(zorluk);        // Kullanıcıdan alınan inputla oyun zorluğu calıştırma.
            first_knight_health = forest_knight.getKnight_health();    // Burada canı her defasında eski haline döndürmek icin gereken şey var.
            first_knight_damage = forest_knight.getKnight_damage();    // bu kısımlar belki başa eklenebilir biraz cirkin duruyor.
            forest_knight.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                forest_knight.Chest();
            if(secenek2 == 2)
            {

            }
            info.Info_Before_Fight(en1);
            info.InfoLevel1Enemy();
            int secenek = input.nextInt();
            if(secenek == 1)
                System.out.println("Let's fight!");
            if(secenek == 2)
            {   final_point = forest_knight.point + forest_knight.coin;
               // info.Info_Escape(final_point);  // cezası olacak
            }
            forest_knight.attack(en1);   // karakterimiz ölünce isDead calışıyor.
            info.Info_After_Fight(en1);
            forest_knight.coin += 100;   // para ödülü
            forest_knight.point += 250;  // puan ödülü
            forest_knight.shop(forest_knight.coin);
            forest_knight.Buy_Item(girilen);
            forest_knight.setKnight_health(first_knight_health);     // Canı ilk haline döndürmek icin
            forest_knight.setKnight_damage(first_knight_damage);




        }
        if(secilen_karakter == 2)
        {
            forest_wizard.game_mode(zorluk);
            first_wizard_health= forest_wizard.getWizard_health();    // Burada canı her defasında eski haline döndürmek icin gereken şey var.
            first_wizard_damage = forest_wizard.getWizard_damage();
            forest_wizard.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                forest_wizard.Chest();
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
                final_point = forest_wizard.point+forest_wizard.coin;
               // info.Info_Escape(final_point);
            }
            forest_wizard.attack(en1);
            info.Info_After_Fight(en1);
            forest_wizard.coin += 100;
            forest_wizard.point += 250;  // puan ödülü
            forest_wizard.shop();
            forest_wizard.Buy_Item(girilen);
            forest_wizard.setWizard_health(first_wizard_health);
            forest_wizard.setWizard_damage(first_wizard_damage);
        }
        if(secilen_karakter == 3)
        {
            forest_thief.game_mode(zorluk);
            first_thief_health = forest_thief.getThief_health();
            first_thief_damage = forest_thief.getThief_damage();
            forest_thief.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                forest_thief.Chest();
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
                final_point = forest_thief.point + forest_thief.coin;
               // info.Info_Escape(final_point);
            }
            forest_thief.attack(en1);
            info.Info_After_Fight(en1);
            forest_thief.coin += 100;
            forest_thief.point += 250;  // puan ödülü
            forest_thief.shop();
            forest_thief.Buy_Item(girilen);
            forest_thief.setThief_health(first_thief_health);
            forest_thief.setThief_damage(first_thief_damage);
        }
        System.out.println("Level 1 cleared.");

    }
    public void Level2()
    {
        System.out.println("Level 2: ");
        Enemy2 en2 = new Enemy2(150,5, "Ogre");
        if(secilen_karakter == 1)
        {

            System.out.println(forest_knight.getKnight_health());
            forest_knight.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                forest_knight.Chest();
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
                final_point = forest_knight.point + forest_knight.coin;
                //info.Info_Escape(final_point);
            }
            forest_knight.attack(en2);   // Ölünce isDead calışıyor. Eğer karakter ölmezse alttaki satırlara gececek. Enemy de ölmüş olacak.
            forest_knight.coin += 200;
            forest_knight.point += 550;  // puan ödülü
            forest_knight.shop(forest_knight.coin);   //Menü printliyor.
            forest_knight.Buy_Item(girilen);
            forest_knight.setKnight_health(first_knight_health);   // canı eski haline getirecek.
            forest_knight.setKnight_damage(first_knight_damage);
        }
        if(secilen_karakter == 2)
        {
            forest_wizard.game_mode(zorluk);
            forest_wizard.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                forest_wizard.Chest();
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
                final_point = forest_wizard.point+forest_wizard.coin;
             //   info.Info_Escape(final_point);
            }
            forest_wizard.attack(en2);
            forest_wizard.coin += 200;
            forest_wizard.point += 550;  // puan ödülü
            forest_wizard.shop();
            forest_wizard.Buy_Item(girilen);
            forest_wizard.setWizard_health(first_wizard_health);
            forest_wizard.setWizard_damage(first_wizard_damage);

        }
        if(secilen_karakter == 3)
        {
            forest_thief.game_mode(zorluk);
            forest_thief.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                forest_thief.Chest();
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
                final_point = forest_thief.point + forest_thief.coin;
                //info.Info_Escape(final_point);
            }
            forest_thief.attack(en2);
            forest_thief.coin += 200;
            forest_thief.point += 550;  // puan ödülü
            forest_thief.shop();
            forest_thief.Buy_Item(girilen);
            forest_thief.setThief_health(first_thief_health);
            forest_thief.setThief_damage(first_thief_damage);
        }
        System.out.println("Level 2 cleared.");

    }
    public void Level3()
    {
        System.out.println("Level 3: ");
        Enemy3 en3 = new Enemy3(200,7, "Treant");
        if(secilen_karakter == 1)
        {
            forest_knight.game_mode(zorluk);
            forest_knight.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                forest_knight.Chest();
            if(secenek2 == 2)
            {}
            info.Info_Before_Fight(en3);
            info.InfoLevel3Enemy();
            int secenek = input.nextInt();
            if(secenek == 1)
                System.out.println("Let's fight!");
            if(secenek == 2)
            {
                final_point = forest_knight.point + forest_knight.coin;
                //info.Info_Escape(final_point);
            }
            forest_knight.attack(en3);   // ölünce isDead calışıyor.
            forest_knight.coin += 300;   // son düşman ölünce gelen ödül.
            forest_knight.point += 750;  // puan ödülü
            forest_knight.shop(forest_knight.coin);
            forest_knight.Buy_Item(girilen);
            forest_knight.setKnight_health(first_knight_health);
            forest_knight.setKnight_damage(first_knight_damage);
        }
        if(secilen_karakter == 2)
        {
            forest_wizard.game_mode(zorluk);
            forest_wizard.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                forest_wizard.Chest();
            if(secenek2 == 2)
            {}
            info.Info_Before_Fight(en3);
            info.InfoLevel3Enemy();
            int secenek = input.nextInt();
            if(secenek == 1)
                System.out.println("Let's fight!");
            if(secenek == 2)
            {
                final_point = forest_wizard.point+forest_wizard.coin;
               // info.Info_Escape(final_point);
            }
            forest_wizard.attack(en3);
            forest_wizard.coin += 300;
            forest_wizard.point += 750;  // puan ödülü
            forest_wizard.shop();
            forest_wizard.Buy_Item(girilen);
            forest_wizard.setWizard_health(first_wizard_health);
            forest_wizard.setWizard_damage(first_wizard_damage);
        }
        if(secilen_karakter == 3)
        {
            forest_thief.game_mode(zorluk);
            forest_thief.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                forest_thief.Chest();
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
                final_point = forest_thief.point + forest_thief.coin;
               // info.Info_Escape(final_point);
            }
            forest_thief.attack(en3);
            forest_thief.coin += 300;
            forest_thief.point += 750;  // puan ödülü
            forest_thief.shop();
            forest_thief.Buy_Item(girilen);
            forest_thief.setThief_health(first_thief_health);
            forest_thief.setThief_damage(first_thief_damage);
        }
        System.out.println("You saved the world from an evil force!" + "\n" + "THE END...");    //Infodan cekersek daha iyi olacak!
        if(secilen_karakter == 1)
            System.out.println("Your final point : " + forest_knight.point + 500 + forest_knight.coin);   // Puan + coin + bitirme bonusu
        if(secilen_karakter == 2)
            System.out.println("Your final point: " + forest_wizard.point + 500 + forest_wizard.coin);
        if(secilen_karakter == 3)
            System.out.println("Your final point " + forest_thief.point + 500 + forest_thief.coin);

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