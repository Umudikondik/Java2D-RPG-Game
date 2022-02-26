package Game;
import javax.swing.*;
import java.sql.SQLException;
public class Map
{
    protected Knight knight = new Knight(120,7.5,1);
    protected Wizard wizard = new Wizard(75,10,2);
    protected Thief thief= new Thief(70,7.5,3);
    protected boolean game_checker;
    protected double first_knight_health, first_knight_damage, first_wizard_health, first_wizard_damage, first_thief_health, first_thief_damage, final_point;
    protected Enemy boss;    // For Polymorphism.
    protected Informations info = new Informations();
    protected int zorluk, secilen_karakter, girilen, map;
    protected String isim;
    public Map()
    {

        info.Info_Starting();
        zorluk = info.getGamemode();
        secilen_karakter = info.getHero_class();
        isim = info.getName();
        map = info.getChosen_map();
        knight.setIsim(isim);
        wizard.setIsim(isim);
        thief.setIsim(isim);

        // Change the locations and images according to the hero class and chosen map.
        if(secilen_karakter == 1)
        {
            info.setCharacter_image("knight.png");
            info.levels.game.setChar_x(-50);
            info.levels.game.setChar_y(-100);
        }
        if(secilen_karakter == 2) {
            info.setCharacter_image("wizard.png");
            info.levels.game.setChar_x(-200);
            info.levels.game.setChar_y(120); }
        if(secilen_karakter == 3) {
            info.setCharacter_image("thief.png");
            info.levels.game.setChar_x(-50); }

        if(map == 1) {
            info.setMap_name("Gloomy Forest");
            info.setMap_image("forest.jpg");
            info.setEn1_name("Bandit Leader");
            info.setEn1_image("bandit.png");
            info.setEn2_name("Ogre");
            info.setEn2_image("oger.png");
            info.setEn3_name("Treant");
            info.setEn3_image("treant.png");
            info.setBossname("Thrall the Shaman King");
            info.setBoss_image("thrall_boss.png");
            boss = new Boss_Forest(250,10,info.getBossname()); }
        if(map == 2) {
            info.setMap_name("Grand Castle");
            info.setMap_image("castle.png");
            info.setEn1_name("Imp");
            info.setEn1_image("imp.png");
            info.setEn2_name("Armored Guard");
            info.setEn2_image("kınaytkötü.png");
            info.setEn3_name("King Rhoam");
            info.setEn3_image("king.png");
            info.setBossname("Dangalf");
            info.setBoss_image("danglaf.jpg");
            boss = new Boss_Castle(250,10,info.getBossname()); }
        if(map == 3) {
            info.setMap_name("Unforgiving Cave");
            info.setMap_image("cave.png");
            info.setEn1_name("Spelunker");
            info.setEn1_image("spelunker.png");
            info.setEn2_name("Golbat");
            info.setEn2_image("golbat.png");
            info.setEn3_name("Warden");
            info.setEn3_image("warden.png");
            info.setBossname("Cave Dragon");
            info.setBoss_image("dragon_boss.jpg");
            boss = new Boss_Cave(250,10,info.getBossname()); }
    }
    public void Level1()
    {
        info.levels.changeText("You decided to enter the " + info.getMap_name());
        time.sleep(1);
        info.levels.changeText("Level 1: ");
        time.sleep(3);
        Enemy en1 = new Enemy(100,4, info.getEn1_name());
        if(secilen_karakter == 1)
        {
            knight.game_mode(zorluk);        // zorluk = Informations gamemode
            first_knight_health = knight.getDefault_health();    // It holds the first healths and damages because when the fight finished, our hero's health must be the first health for next round.
            first_knight_damage = knight.getDefault_damage();
            knight.Weapons();
            info.Info_Chest();
            int secenek2 = info.getSelected();
            if(secenek2 == 1)
            {
                knight.Chest();
                info.levels.changeText(knight.getChest_info());
                info.Info_Dead(knight.getDead(),knight.getDeath_text(),knight.point + knight.coin-200);   // Death punishment.
                time.sleep(2);
            }
            if(secenek2 == 2)
            {
                info.levels.changeText(knight.getDefault_chest_info());
                time.sleep(2);
            }
            info.Info_GoldenApple();
            if(info.getSelected() == 1)
            {
                knight.GoldenApple();
                info.levels.changeText(knight.golden_apple_info);
            }
            else {
                info.levels.changeText("Keep going!");
            }
            time.sleep(3);
            info.Info_Before_Fight(en1);
            int secenek = info.getSelected();
            if(secenek == 1)     // Fight option
            {
                info.levels.screen.FightMessage("Your current health is: " + knight.getDefault_health() + "\n" + "Your current damage is: " + knight.getDefault_damage(), "Enemy current health is: " + en1.getDefault_health() + "\n" + "Enemy current damage is: " + en1.getDefault_damage());
                info.InfoLevel1Enemy();
                info.levels.changeText("Let's fight!");
                time.sleep(1);
            }
            if(secenek == 2)
            {
                final_point = knight.point + knight.coin;
                info.Info_Escape(final_point+100);  // 100 points gained.
            }
            knight.attack(en1);
            info.Info_Dead(knight.getDead(),knight.getDeath_text(),knight.point + knight.coin-200);
            info.Info_After_Fight(en1);
            knight.coin += 100;   // money reward
            knight.point += 250;  // point reward
            while(knight.isChecker())   // checker is the shop checker which exits the shop our hero.
            {
                info.Info_Shop(knight.coin);
                girilen = info.getSelected();
                knight.Buy_Item(girilen);
                info.levels.changeText(knight.getBuy_item());
            }
            knight.setChecker(true);
            info.levels.game.setShop_checker(false);
            knight.setDefault_health(first_knight_health);     // Sets the health and damage first health and damage like mentioned at the top of the method.
            knight.setDefault_damage(first_knight_damage);
        }
        if(secilen_karakter == 2)
        {
            wizard.game_mode(zorluk);        // zorluk = Informations gamemode
            first_wizard_health = wizard.getDefault_health();    // It holds the first healths and damages because when the fight finished, our hero's health must be the first health for next round.
            first_wizard_damage = wizard.getDefault_damage();
            wizard.Weapons();
            info.Info_Chest();
            int secenek2 = info.getSelected();
            if(secenek2 == 1)
            {
                wizard.Chest();
                info.levels.changeText(wizard.getChest_info());
                info.Info_Dead(wizard.getDead(),wizard.getDeath_text(),wizard.point + wizard.coin-200);
                time.sleep(2);
            }
            if(secenek2 == 2)
            {
                info.levels.changeText(wizard.getDefault_chest_info());
                time.sleep(2);
            }
            info.Info_GoldenApple();
            if(info.getSelected() == 1)
            {
                wizard.GoldenApple();
                info.levels.changeText(wizard.golden_apple_info);
            }
            else {
                info.levels.changeText("Keep going!");
            }
            time.sleep(3);
            info.Info_Before_Fight(en1);
            int secenek = info.getSelected();
            if(secenek == 1)
            {
                info.levels.screen.FightMessage("Your current health is: " + wizard.getDefault_health() + "\n" + "Your current damage is: " + wizard.getDefault_damage(), "Enemy current health is: " + en1.getDefault_health() + "\n" + "Enemy current damage is: " + en1.getDefault_damage());
                info.InfoLevel1Enemy();
                info.levels.changeText("Let's fight!");
                time.sleep(1);
            }
            if(secenek == 2)
            {
                final_point = wizard.point + wizard.coin;
                info.Info_Escape(final_point+100);
            }
            wizard.attack(en1);
            info.Info_Dead(wizard.getDead(),wizard.getDeath_text(),wizard.point + wizard.coin-200);
            info.Info_After_Fight(en1);
            wizard.coin += 100;
            wizard.point += 250;
            while(wizard.isChecker())
            {
                info.Info_Shop(wizard.coin);
                girilen = info.getSelected();
                wizard.Buy_Item(girilen);
                info.levels.changeText(wizard.getBuy_item());
            }
            wizard.setChecker(true);
            info.levels.game.setShop_checker(false);
            wizard.setDefault_health(first_wizard_health);     // Sets the health and damage first health and damage like mentioned at the top of the method.
            wizard.setDefault_damage(first_wizard_damage);
        }
        if(secilen_karakter == 3) {
            thief.game_mode(zorluk);        // zorluk = Informations gamemode
            first_thief_health = thief.getDefault_health();    // It holds the first healths and damages because when the fight finished, our hero's health must be the first health for next round.
            first_thief_damage = thief.getDefault_damage();
            thief.Weapons();
            info.Info_Chest();
            int secenek2 = info.getSelected();
            if (secenek2 == 1) {
                thief.Chest();
                info.levels.changeText(thief.getChest_info());
                info.Info_Dead(thief.getDead(), thief.getDeath_text(), thief.point + thief.coin-200);
                time.sleep(2);
            }
            if (secenek2 == 2) {
                info.levels.changeText(thief.getDefault_chest_info());
                time.sleep(2);
            }
            info.Info_GoldenApple();
            if (info.getSelected() == 1) {
                thief.GoldenApple();
                info.levels.changeText(thief.golden_apple_info);
            } else {
                info.levels.changeText("Keep going!");
            }
            time.sleep(3);
            info.Info_Before_Fight(en1);
            int secenek = info.getSelected();
            if (secenek == 1) {
                info.levels.screen.FightMessage("Your current health is: " + thief.getDefault_health() + "\n" + "Your current damage is: " + thief.getDefault_damage(), "Enemy current health is: " + en1.getDefault_health() + "\n" + "Enemy current damage is: " + en1.getDefault_damage());
                info.InfoLevel1Enemy();
                info.levels.changeText("Let's fight!");
                time.sleep(1);
            }
            if (secenek == 2) {
                final_point = thief.point + thief.coin;
                info.Info_Escape(final_point+100);  // 100 points gained.
            }
            thief.attack(en1);
            info.Info_Dead(thief.getDead(), thief.getDeath_text(), thief.point + thief.coin-200);
            info.Info_After_Fight(en1);
            thief.coin += 100;
            thief.point += 250;
            while (thief.isChecker())
            {
                info.Info_Shop(thief.coin);
                girilen = info.getSelected();
                thief.Buy_Item(girilen);
                info.levels.changeText(thief.getBuy_item());
            }
            thief.setChecker(true);
            info.levels.game.setShop_checker(false);
            thief.setDefault_health(first_thief_health);     // Sets the health and damage first health and damage like mentioned at the top of the method.
            thief.setDefault_damage(first_thief_damage);
        }
        info.levels.changeText("Level 1 cleared.");
        time.sleep(2);
    }
    public void Level2()
    {
        info.levels.changeText("Level 2: ");
        time.sleep(3);
        Enemy en2 = new Enemy(150,6, info.getEn2_name());
        if(secilen_karakter == 1)
        {
            first_knight_health = knight.getDefault_health();    // It holds the first healths and damages because when the fight finished, our hero's health must be the first health for next round.
            first_knight_damage = knight.getDefault_damage();
            knight.Weapons();
            info.Info_Chest();
            int secenek2 = info.getSelected();
            if (secenek2 == 1) {
                knight.Chest();
                info.levels.changeText(knight.getChest_info());
                info.Info_Dead(knight.getDead(), knight.getDeath_text(), knight.point + knight.coin-200);
                time.sleep(2);
            }
            if (secenek2 == 2) {
                info.levels.changeText(knight.getDefault_chest_info());
                time.sleep(2);
            }
            info.Info_GoldenApple();
            if (info.getSelected() == 1) {
                knight.GoldenApple();
                info.levels.changeText(knight.golden_apple_info);
            } else {
                info.levels.changeText("Keep going!");
            }
            time.sleep(3);
            info.Info_Before_Fight(en2);
            int secenek = info.getSelected();
            if (secenek == 1) {
                info.levels.screen.FightMessage("Your current health is: " + knight.getDefault_health() + "\n" + "Your current damage is: " + knight.getDefault_damage(), "Enemy current health is: " + en2.getDefault_health() + "\n" + "Enemy current damage is: " + en2.getDefault_damage());
                info.InfoLevel2Enemy();
                info.levels.changeText("Let's fight!");
                time.sleep(1);
            }
            if (secenek == 2) {
                final_point = knight.point + knight.coin;
                info.Info_Escape(final_point + 100);
            }
            knight.attack(en2);
            info.Info_Dead(knight.getDead(), knight.getDeath_text(), knight.point + knight.coin-200);
            info.Info_After_Fight(en2);
            knight.coin += 200;
            knight.point += 550;
            while (knight.isChecker())
            {
                info.Info_Shop(knight.coin);
                girilen = info.getSelected();
                knight.Buy_Item(girilen);
                info.levels.changeText(knight.getBuy_item());
            }
            knight.setChecker(true);
            info.levels.game.setShop_checker(false);
            knight.setDefault_health(first_knight_health);     // Sets the health and damage first health and damage like mentioned at the top of the method.
            knight.setDefault_damage(first_knight_damage);
        }
        if(secilen_karakter == 2)
        {
            first_wizard_health = wizard.getDefault_health();    // It holds the first healths and damages because when the fight finished, our hero's health must be the first health for next round.
            first_wizard_damage = wizard.getDefault_damage();
            wizard.Weapons();
            info.Info_Chest();
            int secenek2 = info.getSelected();
            if(secenek2 == 1)
            {
                wizard.Chest();
                info.levels.changeText(wizard.getChest_info());
                info.Info_Dead(wizard.getDead(),wizard.getDeath_text(),wizard.point + wizard.coin-200);
                time.sleep(2);
            }
            if(secenek2 == 2)
            {
                info.levels.changeText(wizard.getDefault_chest_info());
                time.sleep(2);
            }
            info.Info_GoldenApple();
            if(info.getSelected() == 1)
            {
                wizard.GoldenApple();
                info.levels.changeText(wizard.golden_apple_info);
            }
            else {
                info.levels.changeText("Keep going!");
            }
            time.sleep(3);
            info.Info_Before_Fight(en2);
            int secenek = info.getSelected();
            if(secenek == 1)
            {
                info.levels.screen.FightMessage("Your current health is: " + wizard.getDefault_health() + "\n" + "Your current damage is: " + wizard.getDefault_damage(), "Enemy current health is: " + en2.getDefault_health() + "\n" + "Enemy current damage is: " + en2.getDefault_damage());
                info.InfoLevel2Enemy();
                info.levels.changeText("Let's fight!");
                time.sleep(1);
            }
            if(secenek == 2)
            {
                final_point = wizard.point + wizard.coin;
                info.Info_Escape(final_point+100);
            }
            wizard.attack(en2);
            info.Info_Dead(wizard.getDead(),wizard.getDeath_text(),wizard.point + wizard.coin-200);
            info.Info_After_Fight(en2);
            wizard.coin += 100;
            wizard.point += 250;
            while(wizard.isChecker())
            {
                info.Info_Shop(wizard.coin);
                girilen = info.getSelected();
                wizard.Buy_Item(girilen);
                info.levels.changeText(wizard.getBuy_item());
            }
            wizard.setChecker(true);
            info.levels.game.setShop_checker(false);
            wizard.setDefault_health(first_wizard_health);     // Sets the health and damage first health and damage like mentioned at the top of the method.
            wizard.setDefault_damage(first_wizard_damage);
        }
        if(secilen_karakter == 3)
        {
            first_thief_health = thief.getDefault_health();    // It holds the first healths and damages because when the fight finished, our hero's health must be the first health for next round.
            first_thief_damage = thief.getDefault_damage();
            thief.Weapons();
            info.Info_Chest();
            int secenek2 = info.getSelected();
            if (secenek2 == 1) {
                thief.Chest();
                info.levels.changeText(thief.getChest_info());
                info.Info_Dead(thief.getDead(), thief.getDeath_text(), thief.point + thief.coin-200);
                time.sleep(2);
            }
            if (secenek2 == 2) {
                info.levels.changeText(thief.getDefault_chest_info());
                time.sleep(2);
            }
            info.Info_GoldenApple();
            if (info.getSelected() == 1) {
                thief.GoldenApple();
                info.levels.changeText(thief.golden_apple_info);
            } else {
                info.levels.changeText("Keep going!");
            }
            time.sleep(3);
            info.Info_Before_Fight(en2);
            int secenek = info.getSelected();
            if (secenek == 1) {
                info.levels.screen.FightMessage("Your current health is: " + thief.getDefault_health() + "\n" + "Your current damage is: " + thief.getDefault_damage(), "Enemy current health is: " + en2.getDefault_health() + "\n" + "Enemy current damage is: " + en2.getDefault_damage());
                info.InfoLevel2Enemy();
                info.levels.changeText("Let's fight!");
                time.sleep(1);
            }
            if (secenek == 2) {
                final_point = thief.point + thief.coin;
                info.Info_Escape(final_point+100);  // 100 points gained.
            }
            thief.attack(en2);
            info.Info_Dead(thief.getDead(), thief.getDeath_text(), thief.point + thief.coin-200);
            info.Info_After_Fight(en2);
            thief.coin += 100;
            thief.point += 250;
            while (thief.isChecker())
            {
                info.Info_Shop(thief.coin);
                girilen = info.getSelected();
                thief.Buy_Item(girilen);
                info.levels.changeText(thief.getBuy_item());
            }
            thief.setChecker(true);
            info.levels.game.setShop_checker(false);
            thief.setDefault_health(first_thief_health);     // Sets the health and damage first health and damage like mentioned at the top of the method.
            thief.setDefault_damage(first_thief_damage);
        }
        info.levels.changeText("Level 2 cleared.");
    }
    public void Level3()
    {
        info.levels.changeText("Level 3: ");
        time.sleep(3);
        Enemy en3 = new Enemy(200,7.5, info.getEn3_name());
        if(secilen_karakter == 1) {
            first_knight_health = knight.getDefault_health();    // It holds the first healths and damages because when the fight finished, our hero's health must be the first health for next round.
            first_knight_damage = knight.getDefault_damage();
            knight.Weapons();
            info.Info_Chest();
            int secenek2 = info.getSelected();
            if(secenek2 == 1)
            {
                knight.Chest();
                info.levels.changeText(knight.getChest_info());
                info.Info_Dead(knight.getDead(),knight.getDeath_text(),knight.point + knight.coin-200);
                time.sleep(2);
            }
            if(secenek2 == 2)
            {
                info.levels.changeText(knight.getDefault_chest_info());
                time.sleep(2);
            }
            info.Info_GoldenApple();
            if(info.getSelected() == 1)
            {
                knight.GoldenApple();
                info.levels.changeText(knight.golden_apple_info);
            }
            else {
                info.levels.changeText("Keep going!");
            }
            time.sleep(3);
            info.Info_Before_Fight(en3);
            int secenek = info.getSelected();
            if(secenek == 1)
            {
                info.levels.screen.FightMessage("Your current health is: " + knight.getDefault_health() + "\n" + "Your current damage is: " + knight.getDefault_damage(), "Enemy current health is: " + en3.getDefault_health() + "\n" + "Enemy current damage is: " + en3.getDefault_damage());
                info.InfoLevel3Enemy();
                info.levels.changeText("Let's fight!");
                time.sleep(1);
            }
            if(secenek == 2)
            {
                final_point = knight.point + knight.coin;
                info.Info_Escape(final_point+100);
            }
            knight.attack(en3);
            info.Info_Dead(knight.getDead(),knight.getDeath_text(),knight.point + knight.coin-200);
            info.Info_After_Fight(en3);
            knight.coin += 200;
            knight.point += 550;
            while(knight.isChecker())
            {
                info.Info_Shop(knight.coin);
                girilen = info.getSelected();
                knight.Buy_Item(girilen);
                info.levels.changeText(knight.getBuy_item());
            }
            knight.setChecker(true);
            info.levels.game.setShop_checker(false);
            knight.setDefault_health(first_knight_health);     // Sets the health and damage first health and damage like mentioned at the top of the method.
            knight.setDefault_damage(first_knight_damage);
        }
        if(secilen_karakter == 2)
        {
            first_wizard_health = wizard.getDefault_health();    // It holds the first healths and damages because when the fight finished, our hero's health must be the first health for next round.
            first_wizard_damage = wizard.getDefault_damage();
            wizard.Weapons();
            info.Info_Chest();
            int secenek2 = info.getSelected();
            if(secenek2 == 1)
            {
                wizard.Chest();
                info.levels.changeText(wizard.getChest_info());
                info.Info_Dead(wizard.getDead(),wizard.getDeath_text(),wizard.point + wizard.coin-200);
                time.sleep(2);
            }
            if(secenek2 == 2)
            {
                info.levels.changeText(wizard.getDefault_chest_info());
                time.sleep(2);
            }
            info.Info_GoldenApple();
            if(info.getSelected() == 1)
            {
                wizard.GoldenApple();
                info.levels.changeText(wizard.golden_apple_info);
            }
            else {
                info.levels.changeText("Keep going!");
            }
            time.sleep(3);
            info.Info_Before_Fight(en3);
            int secenek = info.getSelected();
            if(secenek == 1)
            {
                info.levels.screen.FightMessage("Your current health is: " + wizard.getDefault_health() + "\n" + "Your current damage is: " + wizard.getDefault_damage(), "Enemy current health is: " + en3.getDefault_health() + "\n" + "Enemy current damage is: " + en3.getDefault_damage());
                info.InfoLevel3Enemy();
                info.levels.changeText("Let's fight!");
                time.sleep(1);
            }
            if(secenek == 2)
            {
                final_point = wizard.point + wizard.coin;
                info.Info_Escape(final_point+100);
            }
            wizard.attack(en3);
            info.Info_Dead(wizard.getDead(),wizard.getDeath_text(),wizard.point + wizard.coin-200);
            info.Info_After_Fight(en3);
            wizard.coin += 200;
            wizard.point += 550;
            while(wizard.isChecker())
            {
                info.Info_Shop(wizard.coin);
                girilen = info.getSelected();
                wizard.Buy_Item(girilen);
                info.levels.changeText(wizard.getBuy_item());
            }
            wizard.setChecker(true);
            info.levels.game.setShop_checker(false);
            wizard.setDefault_health(first_wizard_health);     // Sets the health and damage first health and damage like mentioned at the top of the method.
            wizard.setDefault_damage(first_wizard_damage);
        }
        if(secilen_karakter == 3)
        {
            first_thief_health = thief.getDefault_health();    // It holds the first healths and damages because when the fight finished, our hero's health must be the first health for next round.
            first_thief_damage = thief.getDefault_damage();
            thief.Weapons();
            info.Info_Chest();
            int secenek2 = info.getSelected();
            if (secenek2 == 1) {
                thief.Chest();
                info.levels.changeText(thief.getChest_info());
                info.Info_Dead(thief.getDead(), thief.getDeath_text(), thief.point + thief.coin-200);
                time.sleep(2);
            }
            if (secenek2 == 2) {
                info.levels.changeText(thief.getDefault_chest_info());
                time.sleep(2);
            }
            info.Info_GoldenApple();
            if (info.getSelected() == 1) {
                thief.GoldenApple();
                info.levels.changeText(thief.golden_apple_info);
            } else {
                info.levels.changeText("Keep going!");
            }
            time.sleep(3);
            info.Info_Before_Fight(en3);
            int secenek = info.getSelected();
            if (secenek == 1) {
                info.levels.screen.FightMessage("Your current health is: " + thief.getDefault_health() + "\n" + "Your current damage is: " + thief.getDefault_damage(), "Enemy current health is: " + en3.getDefault_health() + "\n" + "Enemy current damage is: " + en3.getDefault_damage());
                info.InfoLevel3Enemy();
                info.levels.changeText("Let's fight!");
                time.sleep(1);
            }
            if (secenek == 2) {
                final_point = thief.point + thief.coin;
                info.Info_Escape(final_point+100); // 100 points gained.
            }
            thief.attack(en3);
            info.Info_Dead(thief.getDead(), thief.getDeath_text(), thief.point + thief.coin-200);
            info.Info_After_Fight(en3);
            thief.coin += 200;
            thief.point += 550;
            while (thief.isChecker())
            {
                info.Info_Shop(thief.coin);
                girilen = info.getSelected();
                thief.Buy_Item(girilen);
                info.levels.changeText(thief.getBuy_item());
            }
            thief.setChecker(true);
            info.levels.game.setShop_checker(false);
            thief.setDefault_health(first_thief_health);     // Sets the health and damage first health and damage like mentioned at the top of the method.
            thief.setDefault_damage(first_thief_damage);
        }
        info.levels.changeText("Level 3 cleared.");
        time.sleep(3);
    }
    public void LevelFinal() throws SQLException
    {
        info.levels.changeText("Final Level: ");
        if(secilen_karakter == 1)
        {
            first_knight_health = knight.getDefault_health();
            first_knight_damage = knight.getDefault_damage();
            if(boss.enemy_name.equals("Thrall the Shaman King"))   // If Shaman King is the boss, it will steal one of the items in our equipment.
            {
                Boss_Forest.boss_feature(knight);
            }
            knight.Weapons();
            info.Info_Chest();
            int secenek2 = info.getSelected();
            if(secenek2 == 1) {
                knight.Chest();
                info.levels.changeText(knight.getChest_info());
                info.Info_Dead(knight.getDead(),knight.getDeath_text(),knight.point + knight.coin-200);
                time.sleep(2); }
            if(secenek2 == 2) {
                info.levels.changeText(knight.getDefault_chest_info());
                time.sleep(2); }
            info.Info_GoldenApple();
            if(info.getSelected() == 1) {
                knight.GoldenApple();
                info.levels.changeText(knight.golden_apple_info); }
            else {
                info.levels.changeText("Keep going!");
            }
            time.sleep(3);
            info.Info_Before_Fight(boss);
            int secenek = info.getSelected();
            if(secenek == 1) {
                info.levels.screen.FightMessage("Your current health is: " + knight.getDefault_health() + "\n" + "Your current damage is: " + knight.getDefault_damage(), "Enemy current health is: " + boss.getDefault_health() + "\n" + "Enemy current damage is: " + boss.getDefault_damage());
                info.Info_Boss();
                info.levels.changeText("Let's fight!");
                time.sleep(1); }
            else if(secenek == 2 && !info.getBossname().equals("Dangalf"))
            {
                final_point = knight.point + knight.coin;
                info.Info_Escape(final_point + 100);  // 100 point gained.
            }
            else {
                info.levels.screen.FightMessage("Your current health is: " + knight.getDefault_health() + "\n" + "Your current damage is: " + knight.getDefault_damage(), "Enemy current health is: " + boss.getDefault_health() + "\n" + "Enemy current damage is: " + boss.getDefault_damage());
                info.Info_Boss();
                info.levels.changeText("Let's fight!");
                time.sleep(1); }
            knight.attack(boss);
            info.Info_Dead(knight.getDead(),knight.getDeath_text(),knight.point + knight.coin-200);
            info.Info_After_Fight(boss);
            knight.coin += 700;
            knight.point += 1000;
            knight.setDefault_health(first_knight_health);
            knight.setDefault_damage(first_knight_damage);
        }
        if(secilen_karakter == 2)
        {
            first_wizard_health = wizard.getDefault_health();
            first_wizard_damage = wizard.getDefault_damage();
            if(boss.enemy_name.equals("Thrall the Shaman King"))  // If Shaman King is the boss, it will steal one of the items in our equipment.
            {
                Boss_Forest.boss_feature(wizard);
            }
            wizard.Weapons();
            info.Info_Chest();
            int secenek2 = info.getSelected();
            if(secenek2 == 1) {
                wizard.Chest();
                info.levels.changeText(wizard.getChest_info());
                info.Info_Dead(wizard.getDead(),wizard.getDeath_text(),wizard.point + wizard.coin-200);
                time.sleep(2); }
            if(secenek2 == 2) {
                info.levels.changeText(wizard.getDefault_chest_info());
                time.sleep(2); }
            info.Info_GoldenApple();
            if(info.getSelected() == 1) {
                wizard.GoldenApple();
                info.levels.changeText(wizard.golden_apple_info); }
            else {
                info.levels.changeText("Keep going!");
            }
            time.sleep(3);
            info.Info_Before_Fight(boss);
            int secenek = info.getSelected();
            if(secenek == 1) {
                info.levels.screen.FightMessage("Your current health is: " + wizard.getDefault_health() + "\n" + "Your current damage is: " + wizard.getDefault_damage(), "Enemy current health is: " + boss.getDefault_health() + "\n" + "Enemy current damage is: " + boss.getDefault_damage());
                info.Info_Boss();
                info.levels.changeText("Let's fight!");
                time.sleep(1); }
            else if(secenek == 2 && !info.getBossname().equals("Dangalf")) {
                final_point = wizard.point + wizard.coin;
                info.Info_Escape(wizard.point + wizard.coin+100);  // 100 points gained.
            }
            else {
                info.levels.screen.FightMessage("Your current health is: " + wizard.getDefault_health() + "\n" + "Your current damage is: " + wizard.getDefault_damage(), "Enemy current health is: " + boss.getDefault_health() + "\n" + "Enemy current damage is: " + boss.getDefault_damage());
                info.Info_Boss();
                info.levels.changeText("Let's fight!");
                time.sleep(1); }
            wizard.attack(boss);   // karakterimiz ölünce isDead calışıyor.
            info.Info_Dead(wizard.getDead(),wizard.getDeath_text(),final_point);
            info.Info_After_Fight(boss);
            wizard.coin += 700;   
            wizard.point += 1000;
            wizard.setDefault_health(first_wizard_health);     // Sets the health and damage first health and damage like mentioned at the top of the method.
            wizard.setDefault_damage(first_wizard_damage);
        }
        if(secilen_karakter == 3)
        {
            first_thief_health = thief.getDefault_health();
            first_thief_damage = thief.getDefault_damage();
            if(boss.enemy_name.equals("Thrall the Shaman King"))   // If Shaman King is the boss, it will steal one of the items in our equipment.
            {
                Boss_Forest.boss_feature(thief);
            }
            thief.Weapons();
            info.Info_Chest();
            int secenek2 = info.getSelected();
            if (secenek2 == 1) {
                thief.Chest();
                info.levels.changeText(thief.getChest_info());
                info.Info_Dead(thief.getDead(), thief.getDeath_text(), thief.point + thief.coin-200);
                time.sleep(2); }
            if (secenek2 == 2) {
                info.levels.changeText(thief.getDefault_chest_info());
                time.sleep(2); }
            info.Info_GoldenApple();
            if (info.getSelected() == 1) {
                thief.GoldenApple();
                info.levels.changeText(thief.golden_apple_info);
            } else {
                info.levels.changeText("Keep going!");
            }
            time.sleep(3);
            info.Info_Before_Fight(boss);
            int secenek = info.getSelected();
            if (secenek == 1) {
                info.levels.screen.FightMessage("Your current health is: " + thief.getDefault_health() + "\n" + "Your current damage is: " + thief.getDefault_damage(), "Enemy current health is: " + boss.getDefault_health() + "\n" + "Enemy current damage is: " + boss.getDefault_damage());
                info.Info_Boss();
                info.levels.changeText("Let's fight!");
                time.sleep(1); }
            else if(secenek == 2 && !info.getBossname().equals("Dangalf")) {
                final_point = thief.point + thief.coin;
                info.Info_Escape(thief.point + thief.coin + 100);  // 100 point gained.
            }
            else {
                info.levels.screen.FightMessage("Your current health is: " + thief.getDefault_health() + "\n" + "Your current damage is: " + thief.getDefault_damage(), "Enemy current health is: " + boss.getDefault_health() + "\n" + "Enemy current damage is: " + boss.getDefault_damage());
                info.Info_Boss();
                info.levels.changeText("Let's fight!");
                time.sleep(1); }
            thief.attack(boss);
            info.Info_Dead(thief.getDead(), thief.getDeath_text(), thief.point + thief.coin-200);
            info.Info_After_Fight(boss);
            thief.coin += 700;
            thief.point += 1000;
            thief.setDefault_health(first_thief_health);
            thief.setDefault_damage(first_thief_damage);
        }
        info.levels.changeText("You saved the world from an evil force!" + "\n" + " THE END...");
        time.sleep(2);
        if(secilen_karakter == 1) {
            final_point = (knight.point + 500 + knight.coin);
            info.levels.changeText(" Your final point : " + final_point);      // Winning point += 500.
            time.sleep(2);
            info.Info_Final(final_point); }
        if(secilen_karakter == 2) {
            final_point = (wizard.point + 500 + wizard.coin);
            info.levels.changeText(" Your final point: " + final_point);        // Winning point += 500.
            time.sleep(2);
            info.Info_Final(final_point); }
        if(secilen_karakter == 3) {
            final_point = (thief.point + 500 + thief.coin);             // Winning point += 500;
            info.levels.changeText("Your final point " + final_point);
            time.sleep(2);
            info.Info_Final(final_point); }
    }
    public void Restart()
    {
        info.levels.screen.Restart();
        if(info.levels.screen.getDialogResult() == JOptionPane.NO_OPTION)    // If input == No finish the game.
        {
            System.exit(0); }
        if(info.levels.screen.getDialogResult() == JOptionPane.YES_OPTION)    // If input == Yes restart the game.
        {
            game_checker = true; }
    }
    public boolean isGame_checker() {
        return game_checker;
    }
}
