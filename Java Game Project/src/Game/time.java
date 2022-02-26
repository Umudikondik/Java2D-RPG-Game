package Game;
import java.util.concurrent.TimeUnit;

public class time {
    public time()
    {

    }
    // Static method because we don't need create an object each time.
    public static void sleep(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);        // Waits until the input seconds.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
