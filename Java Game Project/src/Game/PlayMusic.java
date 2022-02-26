package Game;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class PlayMusic
{
	private static File file;
	public PlayMusic()
	{

	}
	public static void clipstart(String clip_name) throws UnsupportedAudioFileException, IOException, LineUnavailableException
		{
			file = new File(clip_name);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);

			FloatControl controller =
					(FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			controller.setValue(-25.0f);        // Decreases the music volume.
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);   // When music finished, it started again and again.
		}
	}


