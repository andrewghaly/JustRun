
import java.util.Scanner;

public class Start {

    public void titleScreen() {
        //Title Page
        System.out.println("#############################################################");
        System.out.println("\t\t\tJust Run\n");
        System.out.println("\t\t\tBy:");
        System.out.println("\t\t\tAndrew Copeland");
        System.out.println("\t\t\tAndrew Ghaly");
        System.out.println("#############################################################");

        //Title page end
        Day.resetDays();
        Day timerA = new Day();

        timerA.dayTimer();

        int[][] fightStyles = {
            {6, 2, 5, 10, 3, 25}, //mage
            {5, 9, 7, 2, 2, 25}, //warrior
            {10, 3, 4, 4, 7, 25} //archer
        };

        int[] monsterStats = {2, 2, 2, 2, 2, 10};
        World world = new World();
        Scanner vReader = new Scanner(System.in);

        int chooseClass;

        do {
            System.out.print("Choose a class [1: mage], [2: warrior], [3: archer]\n>> ");
            while (!vReader.hasNextInt()) {
                System.out.print("Invalid input, choose a class [1, 2, 3]\n>> ");
                vReader.next();
            }

            chooseClass = vReader.nextInt();
        } while (chooseClass != 1 && chooseClass != 2 && chooseClass != 3);

        if (chooseClass == 1) {
            System.out.println("You choose mage");
        } else if (chooseClass == 2) {
            System.out.println("You choose warrior");
        } else if (chooseClass == 3) {
            System.out.println("You choose archer");
        }

        Player andrew = new Player("andrew", fightStyles[chooseClass - 1], "GoldenApple");
        Npc monster = new Npc("monster", monsterStats, true, "gold");

        Input talk = new Input(andrew, monster, world);
        talk.readInput(andrew, monster, world);
    }
}
