
import java.util.Scanner;

public class Input {

    String[] input = {"backpack", "stats", "help", "walk", "fight", "run", "drop", "grab", "exit", "eat", "hunger"};
    Player me = null;
    Npc enemy = null;
    World world = null;
    String tempCommand;
    static boolean fight = false;

    Day currentDay = new Day();
    BadEvent badDay = new BadEvent();

    Scanner keyboard = new Scanner(System.in);

    public static void setFight(boolean a) { //set if you are in a fight
        fight = a;
    }

    public Input(Player a, Npc b, World c) { //constructor
        me = a;
        enemy = b;
        world = c;
    }

    public void readInput(Player a, Npc b, World c) { //read user input

        System.out.println("Please enter a command");

        String walk = keyboard.nextLine();
        walk = checkSpace(walk);

        if (checkInput(walk) == false) {
            System.out.println("Please enter a valid Command, Type help for help.");
            readInput(a, b, c);
        } else {
            writeOutput(walk, a, b, c);
        }

    }

    public String checkSpace(String a) { //check if there is space after first command and returns second command
        if (a.contains(" ")) {
            tempCommand = a.substring(a.indexOf(" ") + 1, a.length());
            a = a.substring(0, a.indexOf(" "));
        }
        return a;
    }

    public boolean checkInput(String a) { //check if user input is valid
        for (int i = 0; i <= input.length - 1; i++) {
            if (a.equals(input[i])) {
                return true;
            }
        }
        return false;

    }

    public void writeOutput(String a, Player b, Npc c, World d) { //writing out to player

        if (a.equals(input[0])) { //backpack
            System.out.println("You have accessed your backpack");
            String[] tempInv = ((Player) b).getInventory();
            for (int i = 0; i < tempInv.length; i++) {
                System.out.println("#" + i + ": " + tempInv[i]);
            }
            //Character.setStats("agility", 2);
            readInput(b, c, d);
        } else if (a.equals(input[1])) { //stats
            System.out.println(((Character) b).getStats());
            readInput(b, c, d);
        } else if (a.equals(input[2])) { //help
            System.out.println("backpack, stats, help, walk, fight, run, drop, grab, exit");
            readInput(b, c, d);
        } else if (a.equals(input[3])) { //walk
            if (fight == true) {
                System.out.println("You cannot walk, you are in a fight, run or fight!");
            } else {
                System.out.println("Walking");
                d.walk(b, c, d);
                System.out.println(world.totalDistance());
            }

            readInput(b, c, d);
        } else if (a.equals(input[4])) { //fight
            BadEvent badevent = new BadEvent();
            badevent.fight(b, c, d);
            readInput(b, c, d);
        } else if (a.equals(input[5])) { //run
            System.out.println("RUN, RUN, RUN");
            readInput(b, c, d);
        } else if (a.equals(input[6])) { //drop
            // b.removeInventory(tempCommand, false);
            readInput(b, c, d);
        } else if (a.equals(input[7])) { //grab
            System.out.println("grabbed");
            d.grab(b, c, tempCommand);
            readInput(b, c, d);
        } else if (a.equals(input[8])) { //shutdown
            System.out.println("Shutting Down");
            System.exit(0);
        } else if (a.equals(input[9])) { //eat
            b.eatFood(tempCommand);
            readInput(b, c, d);
        } else if (a.equals(input[10])) { //get hunger
            System.out.println(b.getHunger());
            readInput(b, c, d);
        } else if (checkInput(a) == false) {
            System.out.println("This is an invlaid command. Type 'help' for help.");
            readInput(b, c, d);
        }

    }

}
