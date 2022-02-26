package Game;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game extends JPanel implements KeyListener    //KeyListener --> Keyboard interface
{
    protected BufferedImage background_image, character_image, enemy_image;
    protected String background_pic_name, character_pic_name, enemy_pic_name, text, shop_text;
    protected int pic_x_coordinate, pic_y_coordinate, basilan, char_x = 50, char_y = 100, en_x = 700, en_y = 100;
    protected boolean shop_checker, characters_checker, enemy_checker, highscore_checker;

    // When Game object created, our main_menu screen will created in the Informations class.
    public Game(String background_pic_name, String character_pic_name, String enemy_pic_name, int pic_x_coordinate, int pic_y_coordinate, String text)
    {
        this.background_pic_name = background_pic_name;
        this.character_pic_name = character_pic_name;
        this.enemy_pic_name = enemy_pic_name;
        this.pic_x_coordinate = pic_x_coordinate;
        this.pic_y_coordinate = pic_y_coordinate;
        this.text = text;
        shop_checker = false;
        characters_checker = false;
        enemy_checker = false;
        highscore_checker = false;
        try
        {
            background_image = ImageIO.read(new FileImageInputStream(new File(background_pic_name)));
            character_image = ImageIO.read(new FileImageInputStream(new File(character_pic_name)));
            enemy_image = ImageIO.read(new FileImageInputStream(new File(enemy_pic_name)));
        }
        catch (IOException ex)
        {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        setBackground(Color.black);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background_image,0,0,background_image.getWidth(),background_image.getHeight(),this);   //ilk koordinatlar nerede oluşacağı, ikinci koordinatlar boyutu.
        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 15));   // Change font, type and size of the texts.
        g.drawString(text,0,700);    // In here, we will see the game scenario.

        // It executed when we want to add a character image in the game. (Via using getter/setter methods.)

        if(characters_checker)
        {
            g.drawImage(character_image,char_x,char_y,character_image.getWidth(),character_image.getHeight(),this);
        }
        // It executed when we want to add a enemy/chest image in the game. (Via using getter/setter methods.)
        if(enemy_checker)
        {
            g.drawImage(enemy_image,en_x,en_y,enemy_image.getWidth(),enemy_image.getHeight(),this);
        }
        // // It executed when we want to add a balance: ... string to the game. (Via using getter/setter methods.)
        if(shop_checker)
        {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.PLAIN, 50));
            g.drawString(shop_text,710,700);   //Shop için sağ altta eklenecek balance yazısı.
        }

    }

    @Override
    public void repaint()  // It updates the game screen when called.
    {
        super.repaint();
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e)   // When user press a number on the keyboard, we change the basilan owing to that we are possible to use it in the Map class.
    {
            basilan = e.getKeyCode();
            if (basilan == KeyEvent.VK_1)
            {
                basilan = 1;
            }
            if (basilan == KeyEvent.VK_2)
            {
                basilan = 2;
            }
            if (basilan == KeyEvent.VK_3)
            {
                basilan = 3;
            }
            if (basilan == KeyEvent.VK_4)
            {
                basilan = 4;
            }
            if (basilan == KeyEvent.VK_5)
            {
                basilan = 5;
            }
            if (basilan == KeyEvent.VK_6)
            {
                basilan = 6;
            }
            if (basilan == KeyEvent.VK_7)
            {
                basilan = 7;
            }
            if (basilan == KeyEvent.VK_ENTER) {
                basilan = 9;
            }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
    // We need to repaint each time when we changed anything in the game. That's why we have repaint() in each setter method.
    public void setBackground_image(BufferedImage image) {
        background_image = image;
        repaint();
    }
    public void setCharacter_image(BufferedImage character_image) {
        this.character_image = character_image;
        repaint();
    }
    public void setEnemy_image(BufferedImage enemy_image) {
        this.enemy_image = enemy_image;
        repaint();
    }
    public void setText(String text) {
        this.text = text;
        repaint();
    }
    public void setCharacters_checker(boolean characters_checker) {
        this.characters_checker = characters_checker;
        repaint();
    }
    public void setShop_checker(boolean shop_checker) {
        this.shop_checker = shop_checker;
        repaint();
    }
    public void setShop_text(String shop_text) {
        this.shop_text = shop_text;
        repaint();
    }
    public int getBasilan() {
        repaint();
        return basilan;
    }
    public void setBasilan(int basilan) {
        this.basilan = basilan;
    }
    public void setEnemy_checker(boolean enemy_checker) {
        this.enemy_checker = enemy_checker;
        repaint();
    }
    public void setChar_x(int char_x) {
        this.char_x = char_x;
    }
    public void setChar_y(int char_y) {
        this.char_y = char_y;
    }
    public void setEn_x(int en_x) {
        this.en_x = en_x;
    }
    public void setEn_y(int en_y) {
        this.en_y = en_y;
    }
}
