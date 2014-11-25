
import java.util.Scanner;

public class Input {

    String[] input = {"backpack", "stats", "help", "walk", "fight", "run", "drop", "grab", "exit"};
    Player me = null;
    Npc enemy = null;
    World world = null;
    String tempCommand;

    public Input(Player a, Npc b, World c) {
        me = a;
        enemy = b;
        world = c;
    }

    public void readInput(Player a, Npc b, World c) {

        System.out.println("Please enter a command");

        Scanner keyboard = new Scanner(System.in);
        String walk = keyboard.nextLine();
        walk = checkSpace(walk);

        if (checkInput(walk) == false) {
            System.out.println("Please Enter a valid Command, Type help for help.");
            readInput(a, b, c);
        } else {
            writeOutput(walk, a, b, c);
        }

    }

    public String checkSpace(String a) {
        if (a.contains(" ")) {
            tempCommand = a.substring(a.indexOf(" ") + 1, a.length());
            a = a.substring(0, a.indexOf(" "));
        }
        return a;
    }

    public boolean checkInput(String a) {
        for (int i = 0; i <= input.length - 1; i++) {
            if (a.equals(input[i])) {
                return true;
            }
        }
        return false;

    }

    public void writeOutput(String a, Player b, Npc c, World d) {

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
            System.out.println("backpack, stats, help, walk, fight, run, drop, grab");
            readInput(b, c, d);
        } else if (a.equals(input[3])) { //walk
            System.out.println("Walking");
            d.walk(b, c);
            readInput(b, c, d);
        } else if (a.equals(input[4])) { //fight
            d.fight(b, c);
            readInput(b, c, d);
        } else if (a.equals(input[5])) { //run
            d.run(b, c);
            System.out.println("RUN, RUN, RUN");
            readInput(b, c, d);
        } else if (a.equals(input[6])) { //drop
            b.removeInventory(tempCommand);
            readInput(b, c, d);
        } else if (a.equals(input[7])) { //grab
            System.out.println("grabbed");
            d.grab(b, c, tempCommand);
            readInput(b, c, d);
        } else if (a.equals(input[8])) {
            System.out.println("Shutting Down");
            System.exit(0);
        } else if (checkInput(a) == false) {
            System.out.println("This is an invalid command. Type 'help' for help.");
            readInput(b, c, d);
        }

    }

}
