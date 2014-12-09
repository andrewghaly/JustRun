
import java.util.*;

public class BadEvent {

    public double distance;
    Random rand = new Random();

    public BadEvent() {
        this.distance = rand.nextInt((500 - 1) + 1) + 1;
    }

    public void badIncrease(double walked) {

        distance -= (Math.random() * walked);
        if (this.distance <= 0) {
            this.distance = rand.nextInt((500 - 1) + 1) + 1;
        }

    }

    public double getDistance() {
        return this.distance;
    }

    public void answer(Player a, String b) { //answer y/n question
        Scanner keyboard = new Scanner(System.in);
        char answer = keyboard.next().charAt(0);
        if (answer == 'y' || answer == 'Y') {
            a.setInventory(b);
            System.out.println("You have added " + b + " to your backpack!");
        } else {
            System.out.println("Do not grab " + b);
        }
    }

    public void attack(Object attacker, Object defender) { //attacking of one character to another
        int health = ((Character) defender).getHealth();
        ((Character) defender).setHealth(health - 1);
    }

    public void fight(Player me, Npc enemy, World world) { //fighting of two characters
        boolean fight = true;
        Input.setFight(true);

        for (;;) {
            if (fight == true) {
                if (enemy.dead()) {
                    System.out.println("Monster is dead! You have Won!");
                    Input.setFight(false);
                    if (enemy.hasItem()) {
                        System.out.println("Monster has dropped " + enemy.getItem());
                        System.out.println("type 'grab " + enemy.getItem() + "'");
                    }
                    fight = false;
                    break;
                }
                attack(me, enemy);
                fight = false;
            } else if (fight == false) {
                if (me.dead()) {
                    System.out.println("You have died");
                    break;
                }
                System.out.println("You have been attacked");
                attack(enemy, me);
                fight = true;
            }
        }
    }

    public void stumbledIntoMonster(Player me, Npc enemy, World world) { //#1 Stumble into fight

        System.out.println("Would you like to Run or fight?");
        Scanner keyboard = new Scanner(System.in);
        String tempString = keyboard.nextLine();
        if (tempString.equals("fight")) {
            fight(me, enemy, world);
        } else if (tempString.equals("run")) {
            world.run(me, enemy, world);
        } else {
            System.out.println("Please enter either run or fight. You do not have a choice.");
        }

    }

}
