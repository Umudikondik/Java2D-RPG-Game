package Game;
import java.sql.SQLException;
public class Informations {
    protected String name, start1, start2, start3, start4, escape, chest, bef_fight, aft_fight, level1en, level2en, level3en, highscores_text, boss_text , map_name, en1_name, en2_name, en3_name, bossname, map_image, character_image, en1_image, en2_image, en3_image, boss_image, chest_image, final_image;
    protected int gamemode, hero_class, chosen_map, selected;
    protected String[] highscores_list = new String[5], nicknames_list = new String[5];
    protected LevelCreator levels;
    protected static int checker_en = 0;

    public Informations() {
        levels = new LevelCreator("main_menu.png", "main_menu.png","main_menu.png",0,0,""); // Starting menu
    }
    public void Info_Starting() {

        levels.Menu();   // Create a screen and shows the main_menu.
        while(true)
        {
            if(levels.game.getBasilan() == 9)     // Until user press enter, this loop will continue.
            {
                levels.game.setBasilan(100);        // We set the basilan as an input that does not exist in the keyboard.
                break;                         // Because If we don't change the value, getBasilan will be equal to the basilan that is here.
            }
        }
        levels.LoadingImage();
        start1 = "You open your eyes in  a mysterious village. In front of you stands an old man.";
        String starta = "You decide to talk to him to find out what is happening.";
        String startb = "'Evening traveller! Care to tell me your name?'";
        String startc = "You have to think for a second..";
        String startd =  "(Enter your name)";
        levels.changeImage("main_town.png");     // Starting background.
        levels.changeText(start1);
        time.sleep(3);
        levels.changeText(starta);
        time.sleep(3);
        levels.changeText(startb);
        time.sleep(3);
        levels.changeText(startc);
        time.sleep(3);
        levels.changeText(startd);
        time.sleep(3);
        levels.screen.WhatIsNickname();     // Nickname input
        name = levels.screen.getUsername();   // Equal the nickname input to the name.
        start2 = "'" + name + "...'" + " says the old man.";
        String a  = "'Hope you're ready for an adventure!'";
        String b =  "'Before you go, I need to ask you about a few things, if you don't mind..'";
        String c = "'Tell me son, what are you good at?'";
        String d = "1) Sword fighting 2) Casting spells 3) I'm just really lucky";
        levels.changeText(start2);
        time.sleep(3);
        levels.changeText(a);
        time.sleep(3);
        levels.changeText(b);
        time.sleep(3);
        levels.changeText(c);
        time.sleep(3);
        levels.changeText(d);

        while(true)       // Until user the numbers which have been mentioned below in if, this loop will continue.
        {
            hero_class = levels.game.getBasilan();
            if(hero_class == 1 || hero_class == 2 || hero_class == 3)
            {
                levels.game.setBasilan(100);
                break;
            }
            else
                time.sleep(1);
        }
        start3 = "'I feel like this just might work..'\n" + "\n" + "' Now tell me, are you ready for a challenge?'\n" +
                " 1) I hope I won't get hurt down there..\n" +
                " 2) I think I can handle a few monsters.\n" +
                " 3) I'm aiming for an absolute carnage!";
        levels.changeText(start3);
        while(true)          // Until user the numbers which have been mentioned below in if, this loop will continue.
        {
            gamemode = levels.game.getBasilan();
            if(gamemode == 1 || gamemode == 2 || gamemode == 3){
                levels.game.setBasilan(100);
                break;
            }
            else
                time.sleep(1);
        }
        start4 = "'I see.. Now; there's a few ways you can go, as you can see.'\n" +
                " 'Where would you like to go to start your adventure?'\n" +
                " 1) The Gloomy Forest\n" +
                " 2) The Grand Castle\n" +
                " 3) The Unforgiving Cave";
        System.out.println(start4);
        levels.changeText(start4);
        while(true)            // Until user the numbers which have been mentioned below in if, this loop will continue.
        {
            chosen_map = levels.game.getBasilan();
            if(chosen_map == 1 || chosen_map == 2 || chosen_map == 3){
                levels.game.setBasilan(100);
                break;
            }
            else
                time.sleep(1);
        }
    }

    public void Info_Escape(double final_point) {
        final_image = "final.png";
        levels.LoadingImage();
        levels.changeImage("escape.jpg");
        escape = "You gave up! " + "\n" + " Total points:" + final_point + "\n" + " Thanks for playing!";
        levels.changeText(escape);
        // We get the data which are inside the database.
        try {
            Highscores highscores = new Highscores(final_point, name);        // Enters point and nickname in the database if it is a high score.
            for (int i = 0; i < 5; i++) {
                highscores_list[i] = Double.toString(highscores.getHighscores(i));
                nicknames_list[i] = highscores.getNicknames(i);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        time.sleep(3);
        levels.LoadingImage();
        levels.changeImage("scoreboard.png");       // High scores screen
        for(int i = 0; i < 5; i++)
        {
            highscores_text += i+1 + ")" + nicknames_list[i] + "        " + highscores_list[i] + "\n";
        }
        levels.screen.showHighscores(highscores_text);       // High scores message box.
        time.sleep(5);
        levels.LoadingImage();
        levels.changeImage(final_image);
        time.sleep(5);
        System.exit(0);
    }

    public void Info_Chest()
    {
        levels.game.setEn_y(225);      // Change chest's location.
        levels.game.setEn_x(600);
        chest_image = "Wooden_Chest.png";
        levels.LoadingImage();
        levels.changeImage(map_image);
        levels.addCharacter(character_image);
        levels.addEnemy(chest_image);
        chest = "There is a mysterious chest in front of you!" + "\n"
                + " You have two options:" + "\n"
                + " 1) Open the chest!" + "\n"
                + " 2) Don't take the risk and move on!";
        levels.changeText(chest);
        while(true)    // Until user the numbers which have been mentioned below in if, this loop will continue.
        {
            selected = levels.game.getBasilan();
            if(selected == 1 || selected == 2){
                levels.game.setBasilan(100);
                break;
            }
            else
                time.sleep(1);
        }
    }
    public void Info_Before_Fight(Enemy en) {
        checker_en++;      // It is a static value so we increases it when we call this method.
        levels.LoadingImage();
        levels.changeImage(map_image);
        levels.addCharacter(character_image);
        if (checker_en == 1)         // Change the enemies location via setter methods.
        {
            if(chosen_map == 1)
            {
                levels.game.setEn_x(800);
                levels.game.setEn_y(250);
            }
            if(chosen_map == 3)
                levels.game.setEn_y(400);
            levels.addEnemy(en1_image);
        }
        if (checker_en == 2)
        {
            if(chosen_map == 1)
            {
                levels.game.setEn_y(140);
                levels.game.setEn_x(600);
            }
            if(chosen_map == 2)
            {
                levels.game.setEn_y(100);
            }
            if(chosen_map == 3)
                levels.game.setEn_y(35);
            levels.addEnemy(en2_image);
        }
        if (checker_en == 3)
        {   if(chosen_map == 1)
            {
                levels.game.setEn_x(400);
                levels.game.setEn_y(-600);
            }
            if(chosen_map == 2)
            {
                levels.game.setEn_x(400);
                levels.game.setEn_y(-100); }

            if(chosen_map == 3)
                levels.game.setEn_y(0);
            levels.addEnemy(en3_image);
        }
        bef_fight = "A " + en.enemy_name + " is blocking the way! " + "\n"
                + " Are you brave enough to battle? " + "\n"
                + " 1) Yes." + "\n"
                + " 2) Flee. (This option ends the game)";
        levels.changeText(bef_fight);
        while(true)
        {
            selected = levels.game.getBasilan();
            if(selected == 1 || selected == 2)
            {
                levels.game.setBasilan(100);
                break;
            }
            else
                time.sleep(1);
        }
    }
    public void Info_After_Fight(Enemy en) {
        levels.addCharacter(character_image);
        aft_fight = "You have killed " + en.enemy_name + "!";
        levels.changeText(aft_fight);
        time.sleep(5);
        //levels.changeText(" ");
    }
    public void Info_Shop(double total_coin) {
        levels.game.setCharacters_checker(false);
        levels.game.setEnemy_checker(false);
        levels.game.setShop_text("Balance: " + total_coin);
        levels.game.setShop_checker(true);
        if (hero_class == 1) {
            levels.changeImage("shop_knight.jpg"); // shop for knight
            levels.screen.ShopMessage(); }
        if (hero_class == 2) {
            levels.changeImage("shop_wizard.jpg");    // whop for wizard
            levels.screen.ShopMessage(); }
        if (hero_class == 3) {
            levels.changeImage("shop_thief.jpg");     // shop for thief
            levels.screen.ShopMessage();
        }
        while(true)          // Until user the numbers which have been mentioned below in if, this loop will continue.
        {
            selected = levels.game.getBasilan();
            if(selected== 1 || selected == 2 || selected == 3 || selected == 4 || selected == 5 || selected == 6 || selected == 7){
                levels.game.setBasilan(100);
                break;
            }
            else
                time.sleep(1);
        }
    }
    public void InfoLevel1Enemy() {
        level1en = "Think you can face me? Think again..";
        System.out.println(level1en);
        levels.changeText(level1en);
        time.sleep(3);
    }
    public void InfoLevel2Enemy() {
        level2en = "Prepare to DIE!!!";
        System.out.println(level2en);
        levels.changeText(level2en);
        time.sleep(3);
    }

    public void InfoLevel3Enemy() {
        level3en = "I've seen many heroes come and go. None of them could defeat me. Let's keep it that way.";
        System.out.println(level3en);
        levels.changeText(level3en);
        time.sleep(3);
    }
    public void Info_Dead(boolean death_checker, String death_text, double final_point)
    {      // Boolean death checker is the main_character isDead in the Map class. So if our hero died, this method will executed.
        if(death_checker)
        {
            final_image = "final.png";
            levels.game.setEnemy_checker(false);
            levels.game.setCharacters_checker(false);
            time.sleep(1);
            levels.changeImage("youdied.jpg");
            levels.changeText(death_text);
            time.sleep(5);
            levels.LoadingImage();
            try {
                Highscores highscores = new Highscores(final_point, name);        // Enters point and nickname in the database if it is a high score.
                for (int i = 0; i < 5; i++) {
                    highscores_list[i] = Double.toString(highscores.getHighscores(i));
                    nicknames_list[i] = highscores.getNicknames(i);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            time.sleep(3);
            levels.LoadingImage();
            levels.changeImage("scoreboard.png");       // High scores screen.
            for(int i = 0; i < 5; i++)
            {
                highscores_text += i+1 + ")" + nicknames_list[i] + "        " + highscores_list[i] + "\n";
            }
            levels.screen.showHighscores(highscores_text);
            time.sleep(5);
            levels.LoadingImage();
            levels.changeImage(final_image);
            time.sleep(5);
            System.exit(0);
        }
    }
    public void Info_Boss()
    {
        if(chosen_map == 1)   // Forest boss speaking.
            boss_text = "Get ready to face me, Thrall! The leader of Shamans and the controller of lightnings!";
        if(chosen_map == 2)   // Dangalf boss speaking.
            boss_text = "You shall not escape, fool!";
        if(chosen_map == 3)   // Cave Dragon speaking.
            boss_text = "If you dare awaken The Sleeping Dragon, you face the consequences!";
        levels.changeImage(boss_image);
        levels.addCharacter(character_image);
        levels.changeText(boss_text);
        time.sleep(5);
    }
    public void Info_Final(double total_point) throws SQLException
    {
        System.out.println(name);
        System.out.println(total_point);
        Highscores highscores = new Highscores(total_point,name);
        final_image = "final.png";
        levels.LoadingImage();
        for (int i = 0; i < 5; i++) {
            highscores_list[i] = Double.toString(highscores.getHighscores(i));
            System.out.println(highscores_list[i]);
            nicknames_list[i] = highscores.getNicknames(i);
            System.out.println(nicknames_list[i]);
        }
        levels.changeImage("youwin.jpg");
        time.sleep(5);
        levels.LoadingImage();
        levels.changeImage("scoreboard.png");
        for(int i = 0; i < highscores_list.length; i++)
        {
            highscores_text += i+1 + ")" + nicknames_list[i] + "        " + highscores_list[i] + "\n";
        }
        System.out.println(highscores_text);
        levels.screen.showHighscores(highscores_text);
        time.sleep(5);
        levels.LoadingImage();
        levels.changeImage(final_image);
        time.sleep(5);
    }
    public void Info_GoldenApple()
    {
        levels.changeImage(map_image);
        levels.addCharacter(character_image);
        levels.game.setEnemy_checker(false);
        levels.changeText("You started to hear strange noises, apparently the fight is approaching. Do you want to eat your golden apple? 1) Yes. 2) No.");
        while(true)
        {
            selected = levels.game.getBasilan();
            if(selected== 1 || selected == 2)
            {
                levels.game.setBasilan(100);
                break;
            }
            else
                time.sleep(1);
        }
    }
    public String getName() {
        return name;
    }
    public int getGamemode() {
        return gamemode;
    }
    public int getHero_class() {
        return hero_class;
    }
    public int getChosen_map() {
        return chosen_map;
    }
    public String getStart3() {
        return start3;
    }
    public String getMap_name() {
        return map_name;
    }
    public void setMap_name(String map_name) {
        this.map_name = map_name;
    }
    public String getEn1_name() {
        return en1_name;
    }
    public void setEn1_name(String en1_name) {
        this.en1_name = en1_name;
    }
    public String getEn2_name() {
        return en2_name;
    }
    public void setEn2_name(String en2_name) {
        this.en2_name = en2_name;
    }
    public String getEn3_name() {
        return en3_name;
    }
    public void setEn3_name(String en3_name) {
        this.en3_name = en3_name;
    }
    public String getBossname() {
        return bossname;
    }
    public void setBossname(String bossname) {
        this.bossname = bossname;
    }
    public void setCharacter_image(String character_image) {
        this.character_image = character_image;
    }
    public void setMap_image(String map_image) {
        this.map_image = map_image;
    }
    public void setEn1_image(String en1_image) {
        this.en1_image = en1_image;
    }
    public void setEn2_image(String en2_image) {
        this.en2_image = en2_image;
    }
    public void setEn3_image(String en3_image) {
        this.en3_image = en3_image;
    }
    public void setBoss_image(String boss_image) {
        this.boss_image = boss_image;
    }
    public int getSelected() {
        return selected;
    }
}


