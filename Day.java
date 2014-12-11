
import java.util.Timer;
import java.util.TimerTask;

public class Day {

    static boolean isDay = false;
    static int manyDays;

    BadEvent badness = new BadEvent();

    // World currentWorld = new World();
    public void dayTimer() {
        Timer dayNight = new Timer();

        dayNight.scheduleAtFixedRate(
                new TimerTask() {

                    @Override
                    public void run() {
                        if (isDay == false) {
                            System.out.print("Day time\n>> ");

                            isDay = true;
                        } else {
                            System.out.print("Night time\n>> ");
                            manyDays++;
                            isDay = false;
                        }
                    }
                },
                0,
                90000);
    }

    public boolean dayCheck() {
        System.out.println("Day Time");
        return Day.isDay;
    }

    public static void setDay(Boolean a) {
        isDay = a;
    }

    public static void resetDays() {
        manyDays = 0;
    }

    public static int getDays() {
        return manyDays;
    }
}
