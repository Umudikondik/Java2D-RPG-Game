package Game;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.SQLException;

public class GameDriver
{
    public static void main(String args[]) throws SQLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        while(true)     // If user wants to play game again, loop will continue.
        {
            PlayMusic.clipstart("pop beat.wav");
            Map game = new Map();
            game.Level1();
            game.Level2();
            game.Level3();
            game.LevelFinal();
            game.Restart();
            if(!game.isGame_checker())    // For restarting
                break;
        }
    }
}
