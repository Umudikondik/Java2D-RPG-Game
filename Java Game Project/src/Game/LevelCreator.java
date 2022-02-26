package Game;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
public class LevelCreator           // Main purpose of that class is to make easier to processes in Informations class.
{
    protected String text, pic_name, character_pic_name, enemy_pic_name;
    protected Game game;
    protected int x_coordinate, y_coordinate;
    protected BufferedImage image, loading_image, object_image;
    Screen screen = new Screen("JavAdventure");    // Screen and game name.
    public LevelCreator(String pic_name, String character_pic_name, String enemy_pic_name, int x_coordinate, int y_coordinate, String text)
    {
        this.pic_name = pic_name;
        this.character_pic_name = character_pic_name;
        this.enemy_pic_name = enemy_pic_name;
        this.text = text;
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
        game = new Game(pic_name,character_pic_name,enemy_pic_name,x_coordinate,y_coordinate,text);
    }
    public void Menu()
    {
        // Screen's features
        screen.setResizable(false);        // It prevents the increasing the size of the panel.
        screen.setFocusable(false);
        screen.setSize(1200,800);   // Screen dimensions.
        screen.setDefaultCloseOperation(EXIT_ON_CLOSE);   // When we click to the close in the screen, game will close.
        // Game's feature
        game.requestFocus();
        game.addKeyListener(game);
        game.setFocusable(true);
        game.setFocusTraversalKeysEnabled(false);
        screen.setVisible(true);
        screen.add(game);
    }


    // Change background image.
    public void changeImage(String new_image)
    {
        try {
            image = ImageIO.read(new FileImageInputStream(new File(new_image)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        game.setBackground_image(image);

    }
    // Change text.
    public void changeText(String text)
    {
        game.setText(text);
    }

    // Calls Loading image easily
    public void LoadingImage()
    {
        game.setEnemy_checker(false);
        game.setCharacters_checker(false);
        try {
            loading_image = ImageIO.read(new FileImageInputStream(new File("loading.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        game.setBackground_image(loading_image);
        //game.setText("");
        time.sleep(2);   // By the help of that, user sees the loading screen 2 seconds.
    }
    // Add character image.
    public void addCharacter(String character_pic_name)
    {
        game.setCharacters_checker(true);
        try {
            object_image = ImageIO.read(new FileImageInputStream(new File(character_pic_name)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        game.setCharacter_image(object_image);

    }
    // Add enemy/chest image.
    public void addEnemy(String enemy_pic_name)
    {
        game.setEnemy_checker(true);
        try {
            object_image = ImageIO.read(new FileImageInputStream(new File(enemy_pic_name)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        game.setEnemy_image(object_image);
    }
}
