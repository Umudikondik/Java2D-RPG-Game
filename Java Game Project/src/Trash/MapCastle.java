package Trash;
import Game.*;
import Trash.Enemy1;
import Trash.Enemy2;
import Trash.Enemy3;

import java.sql.SQLException;
import java.util.*;
public class MapCastle   // DANGALF CASTLE BOSS -You shall not escape!-
{
    /*Knight castle_knight = new Knight(100,6,1);
    double first_knight_health;
    double first_knight_damage;
    Wizard castle_wizard = new Wizard(75,9,2);
    double first_wizard_health;
    double first_wizard_damage;
    Thief castle_thief= new Thief(75,6,3);
    double first_thief_health;
    double first_thief_damage;
    Informations info = new Informations();
    protected int zorluk;
    protected int secilen_karakter;
    protected int girilen;
    protected String isim;
    public double final_point;
    Scanner input = new Scanner(System.in);

    public MapCastle(int zorluk,int secilen_karakter, String isim)
    {
        this.zorluk = zorluk;
        this.secilen_karakter = secilen_karakter;
        this.isim = isim;
        castle_knight.setIsim(isim);
        castle_wizard.setIsim(isim);
        castle_thief.setIsim(isim);
    }
    public void Level1()
    {
        System.out.println("You decided to enter the castle!");
        System.out.println("Level 1: ");
        Enemy1 en1 = new Enemy1(100,3, "Corrupted Knight");
        if(secilen_karakter == 1)
        {
            castle_knight.game_mode(zorluk);        // Kullanıcıdan alınan inputla oyun zorluğu calıştırma.
            first_knight_health = castle_knight.getKnight_health();    // Burada canı her defasında eski haline döndürmek icin gereken şey var.
            first_knight_damage = castle_knight.getKnight_damage();    // bu kısımlar belki başa eklenebilir biraz cirkin duruyor.
            castle_knight.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                castle_knight.Chest();
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
                final_point = castle_knight.point + castle_knight.coin;
                //info.Info_Escape(final_point-50);  // cezası olacak 50 PUAN.
            }
            castle_knight.attack(en1);   // karakterimiz ölünce isDead calışıyor.
            info.Info_After_Fight(en1);
            castle_knight.coin += 100;   // para ödülü
            castle_knight.point += 250;  // puan ödülü
            castle_knight.shop(castle_knight.coin);
            castle_knight.Buy_Item(girilen);
            castle_knight.setKnight_health(first_knight_health);     // Canı ilk haline döndürmek icin
            castle_knight.setKnight_damage(first_knight_damage);
        }
        if(secilen_karakter == 2)
        {
            castle_wizard.game_mode(zorluk);
            first_wizard_health= castle_wizard.getWizard_health();    // Burada canı her defasında eski haline döndürmek icin gereken şey var.
            first_wizard_damage = castle_wizard.getWizard_damage();
            castle_wizard.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                castle_wizard.Chest();
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
                final_point = castle_wizard.point+castle_wizard.coin;
                //info.Info_Escape(final_point);
            }
            castle_wizard.attack(en1);
            info.Info_After_Fight(en1);
            castle_wizard.coin += 100;
            castle_wizard.point += 250;  // puan ödülü
            castle_wizard.shop();
            castle_wizard.Buy_Item(girilen);
            castle_wizard.setWizard_health(first_wizard_health);
            castle_wizard.setWizard_damage(first_wizard_damage);
        }
        if(secilen_karakter == 3)
        {
            castle_thief.game_mode(zorluk);
            first_thief_health = castle_thief.getThief_health();
            first_thief_damage = castle_thief.getThief_damage();
            castle_thief.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                castle_thief.Chest();
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
                final_point = castle_thief.point + castle_thief.coin;
               // info.Info_Escape(final_point);
            }
            castle_thief.attack(en1);
            info.Info_After_Fight(en1);
            castle_thief.coin += 100;
            castle_thief.point += 250;  // puan ödülü
            castle_thief.shop();
            castle_thief.Buy_Item(girilen);
            castle_thief.setThief_health(first_thief_health);
            castle_thief.setThief_damage(first_thief_damage);
        }
        System.out.println("Level 1 cleared.");
    }
    public void Level2()
    {
        System.out.println("Level 2: ");
        Enemy2 en2 = new Enemy2(150,5, "Armored Guard");
        if(secilen_karakter == 1)
        {
            System.out.println(castle_knight.getKnight_health());
            castle_knight.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                castle_knight.Chest();
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
                final_point = castle_knight.point + castle_knight.coin;
               // info.Info_Escape(final_point);
            }
            castle_knight.attack(en2);   // Ölünce isDead calışıyor. Eğer karakter ölmezse alttaki satırlara gececek. Enemy de ölmüş olacak.
            castle_knight.coin += 200;
            castle_knight.point += 550;  // puan ödülü
            castle_knight.shop(castle_knight.coin);   //Menü printliyor.
            castle_knight.Buy_Item(girilen);
            castle_knight.setKnight_health(first_knight_health);   // canı eski haline getirecek.
            castle_knight.setKnight_damage(first_knight_damage);
        }
        if(secilen_karakter == 2)
        {
            castle_wizard.game_mode(zorluk);
            castle_wizard.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                castle_wizard.Chest();
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
                final_point = castle_wizard.point+castle_wizard.coin;
             //   info.Info_Escape(final_point);
            }
            castle_wizard.attack(en2);
            castle_wizard.coin += 200;
            castle_wizard.point += 550;  // puan ödülü
            castle_wizard.shop();
            castle_wizard.Buy_Item(girilen);
            castle_wizard.setWizard_health(first_wizard_health);
            castle_wizard.setWizard_damage(first_wizard_damage);
        }
        if(secilen_karakter == 3)
        {
            castle_thief.game_mode(zorluk);
            castle_thief.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                castle_thief.Chest();
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
                final_point = castle_thief.point + castle_thief.coin;
               // info.Info_Escape(final_point);
            }
            castle_thief.attack(en2);
            castle_thief.coin += 200;
            castle_thief.point += 550;  // puan ödülü
            castle_thief.shop();
            castle_thief.Buy_Item(girilen);
            castle_thief.setThief_health(first_thief_health);
            castle_thief.setThief_damage(first_thief_damage);
        }
        System.out.println("Level 2 cleared.");
    }
    public void Level3()
    {
        System.out.println("Level 3: ");
        Enemy3 en3 = new Enemy3(200,7, "King Rhoam");
        if(secilen_karakter == 1)
        {
            castle_knight.game_mode(zorluk);
            castle_knight.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                castle_knight.Chest();
            if(secenek2 == 2)
            {}
            info.Info_Before_Fight(en3);
            info.InfoLevel3Enemy();
            int secenek = input.nextInt();
            if(secenek == 1)
                System.out.println("Let's fight!");
            if(secenek == 2)
            {
                final_point = castle_knight.point + castle_knight.coin;
              //  info.Info_Escape(final_point);
            }
            castle_knight.attack(en3);   // ölünce isDead calışıyor.
            castle_knight.coin += 300;   // son düşman ölünce gelen ödül.
            castle_knight.point += 750;  // puan ödülü
            castle_knight.shop(castle_knight.coin);
            castle_knight.Buy_Item(girilen);
            castle_knight.setKnight_health(first_knight_health);
            castle_knight.setKnight_damage(first_knight_damage);
        }
        if(secilen_karakter == 2)
        {
            castle_wizard.game_mode(zorluk);
            castle_wizard.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                castle_wizard.Chest();
            if(secenek2 == 2)
            {}
            info.Info_Before_Fight(en3);
            info.InfoLevel3Enemy();
            int secenek = input.nextInt();
            if(secenek == 1)
                System.out.println("Let's fight!");
            if(secenek == 2)
            {
                final_point = castle_wizard.point+castle_wizard.coin;
             //   info.Info_Escape(final_point);
            }
            castle_wizard.attack(en3);
            castle_wizard.coin += 300;
            castle_wizard.point += 750;  // puan ödülü
            castle_wizard.shop();
            castle_wizard.Buy_Item(girilen);
            castle_wizard.setWizard_health(first_wizard_health);
            castle_wizard.setWizard_damage(first_wizard_damage);
        }
        if(secilen_karakter == 3)
        {
            castle_thief.game_mode(zorluk);
            castle_thief.Weapons();
            info.Info_Chest();
            int secenek2 = input.nextInt();
            if(secenek2 == 1)
                castle_thief.Chest();
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
                final_point = castle_thief.point + castle_thief.coin;
             //   info.Info_Escape(final_point);
            }
            castle_thief.attack(en3);
            castle_thief.coin += 300;
            castle_thief.point += 750;  // puan ödülü
            castle_thief.shop();
            castle_thief.Buy_Item(girilen);
            castle_thief.setThief_health(first_thief_health);
            castle_thief.setThief_damage(first_thief_damage);
        }
        System.out.println("You saved the world from an evil force!" + "\n" + "THE END...");    //Infodan cekersek daha iyi olacak!
        if(secilen_karakter == 1)
        {
            System.out.println("Your final point : " + castle_knight.point + 500 + castle_knight.coin);      //Kazanma ödülü 500 point.
            try
            {
                Highscores highscores = new Highscores(castle_knight.point + 500 + castle_knight.coin,isim);        //Girilen puanı ve nickname'i database'e kaydediyor.
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(secilen_karakter == 2)
        {
            System.out.println("Your final point: " + castle_wizard.point + 500 + castle_wizard.coin);
            try
            {
                Highscores highscores = new Highscores(castle_wizard.point + 500 + castle_wizard.coin,isim);        //Girilen puanı ve nickname'i database'e kaydediyor.
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(secilen_karakter == 3)
        {
            System.out.println("Your final point " + castle_thief.point + 500 + castle_thief.coin);
            try
            {
                Highscores highscores = new Highscores(castle_thief.point + 500 + castle_thief.coin,isim);        //Girilen puanı ve nickname'i database'e kaydediyor.
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
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
