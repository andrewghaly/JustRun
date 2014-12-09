
import java.util.Timer;
import java.util.TimerTask;

public class Day {

    boolean isDay = true;

    BadEvent badness = new BadEvent();

    // World currentWorld = new World();
    public void dayTimer() {
        Timer dayNight = new Timer();

        dayNight.scheduleAtFixedRate(
                new TimerTask() {

                    @Override
                    public void run() {
                        if (isDay == true) {
                            System.out.println("Day time");
                            //badness.badIncrease(10);
                            isDay = false;
                        } else {
                            System.out.println("Night time");
                            //  badness.badIncrease(50);

                            isDay = true;
                        }
                    }
                },
                0,
                90000);
    }

    public boolean dayCheck() {
        return this.isDay;
    }
}
