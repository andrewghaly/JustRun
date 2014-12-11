
import java.util.Scanner;

public class Input {

    private final String[] input = {"backpack", "stats", "help", "walk", "fight", "run", "drop", "grab", "exit", "eat", "hunger", "use", "fire", "cook"};
    private Player me = null;
    private Npc enemy = null;
    private World world = null;
    private String tempCommand;
    private static boolean fight = false;

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

        System.out.print("Please enter a command\n>> ");

        String walk = keyboard.nextLine();
        walk = checkSpace(walk);

        if (checkInput(walk) == false) {
            System.out.println("Please Enter a valid Command, Type help for help.");
            readInput(a, b, c);
        } else {
            writeOutput(walk, a, b, c);
        }

    }

    public String checkSpace(String a) { //check if there is space after first command and returns second command
        tempCommand = "";
        if (a.contains(" ")) {
            tempCommand = a.substring(a.indexOf(" ") + 1, a.length());
            a = a.substring(0, a.indexOf(" "));
        }
        return a;
    }

    public boolean checkInput(String a) { //check if user input is valid
        for (int i = 0; i <= input.length - 1; i++) {
            if (a.equalsIgnoreCase(input[i])) {
                return true;
            }
        }
        return false;

    }

    public void writeOutput(String command, Player me, Npc enemy, World world) { //writing out to player

        if (fight == true) {
            if (command.equalsIgnoreCase(input[4])) { //fight
                BadEvent badevent = new BadEvent();
                badevent.fight(me, enemy, world);
                readInput(me, enemy, world);
            } else if (command.equalsIgnoreCase(input[5])) { //run
                world.run(me, enemy, world);
                readInput(me, enemy, world);
            } else {
                System.out.println("You can only fight or run");
                readInput(me, enemy, world);
            }
        } else {

            if (command.equalsIgnoreCase(input[0])) { //backpack
                System.out.println("You have accessed your backpack");
                String[] tempInv = ((Player) me).getInventory();
                for (int i = 0; i < tempInv.length; i++) {
                    System.out.println("#" + i + ": " + tempInv[i]);
                }
                //Character.setStats("agility", 2);
                readInput(me, enemy, world);
            } else if (command.equalsIgnoreCase(input[1])) { //stats
                System.out.println(((Character) me).getStats());
                readInput(me, enemy, world);
            } else if (command.equalsIgnoreCase(input[2])) { //help
                System.out.println("backpack, stats, help, walk, fight, run, drop, grab, exit, eat, hunger, use, fire, cook");
                readInput(me, enemy, world);
            } else if (command.equalsIgnoreCase(input[3])) { //walk
                if (fight == true) {
                    System.out.println("You cannot walk, you are in a fight, run or fight!");
                } else {
                    System.out.println("Walking");
                    world.walk(me, enemy, world);
                    // System.out.println(world.totalDistance());
                }

                readInput(me, enemy, world);
            } else if (command.equalsIgnoreCase(input[4])) { //fight
                System.out.println("You cannot fight, you are not in a fight.");
                readInput(me, enemy, world);
            } else if (command.equalsIgnoreCase(input[5])) { //run
                System.out.println("You cannot run, you are not in a fight.");
                readInput(me, enemy, world);
            } else if (command.equalsIgnoreCase(input[6])) { //drop
                me.removeInventory(tempCommand, false);
                readInput(me, enemy, world);
            } else if (command.equalsIgnoreCase(input[7])) { //grab
                System.out.println("grabbed");
                world.grab(me, enemy, tempCommand);
                readInput(me, enemy, world);
            } else if (command.equalsIgnoreCase(input[8])) { //shutdown
                System.out.println("Shutting Down...");
                System.exit(0);
            } else if (command.equalsIgnoreCase(input[9])) { //eat
                me.eatFood(tempCommand);
                readInput(me, enemy, world);
            } else if (command.equalsIgnoreCase(input[10])) { //get hunger
                System.out.println(me.getHunger());
                readInput(me, enemy, world);
            } else if (command.equalsIgnoreCase(input[11])) { //use command
                if (tempCommand.equalsIgnoreCase("")) {
                    System.out.println("Correct usage: use <item> (e.g. item must be a usable item)");
                    readInput(me, enemy, world);
                }
                me.useInventory(tempCommand, me);
                readInput(me, enemy, world);
            } else if (command.equalsIgnoreCase(input[12])) {//fire commnad
                me.makeFire(world);
            } else if (command.equalsIgnoreCase(input[13])) {//cook command
                world.cook(me, tempCommand);
            } else if (checkInput(command) == false) {
                System.out.println("This is an invalid command. Type 'help' for help.");
                readInput(me, enemy, world);
            }

        }
    }

}
