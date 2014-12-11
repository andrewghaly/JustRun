
import java.util.*;

public class BadEvent {

    private double distance;
    private final Random rand;

    public BadEvent(int seed) {
        this.rand = new Random(seed);
        this.distance = rand.nextInt((500 - 1) + 1) + 1;
    }

    public BadEvent() {
        this.rand = new Random();
        this.distance = rand.nextInt((500 - 1) + 1) + 1;
    }

    public void badIncrease(double walked) {

        distance -= (Math.random() * walked);
        if (this.distance <= 0) {
            this.distance = rand.nextInt((500 - 200) + 1) + 200;
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

    public void attack(Character attacker, Character defender) { //attacking of one character to another

        defender.setHealth(-1);
    }

    public void fight(Player me, Npc enemy, World world) {
        boolean fight = true;
        Input.setFight(true);
        enemy.setHealth(2);
        enemy.setItem(enemy.randItem());
        while (true) {
            if (me.dead()) {
                if (Day.getDays() == 1) {
                    System.out.println("You are dead! You lasted " + Day.getDays() + " day.");
                } else {
                    System.out.println("You are dead! You lasted " + Day.getDays() + " days.");
                }
                Start game = new Start();
                Input.setFight(false);
                game.titleScreen();
                break;

            }
            if (enemy.dead()) {

                System.out.println("Monster is dead! You have Won!");
                Input.setFight(false);

                //creates monster that is one health stronger
                me.setAgility(me.getAgility() + 1); //set your stats larger since you won
                me.setMagic(me.getMagic() + 1);
                me.setStrength(me.getStrength() + 1);

                if (enemy.hasItem()) {
                    System.out.println("Monster has dropped " + enemy.getItem());
                    System.out.println("type 'grab " + enemy.getItem() + "'");
                }

                break;
            }

            if (fight) {
                attack(me, enemy);
                fight = false;
            } else if (fight == false) {
                attack(enemy, me);
                fight = true;

            }

        }

    }

    /*public void fight(Player me, Npc enemy, World world) { //fighting of two characters
    	
     boolean fight = true;
     Input.setFight(true);

     for (;;) {
     if (fight == true) { //you are in a fight
     if (enemy.dead()) { 
     System.out.println("Monster is dead! You have Won!");
     Input.setFight(false);
     //enemy.setHealth(2); //creates monster that is one health stronger
                    
     me.setAgility(me.getAgility()+1); //set your stats larger since you won
     me.setMagic(me.getMagic()+1);
     me.setStrength(me.getStrength()+1);
                    
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
     }*/
    public void stumbledIntoMonster(Player me, Npc enemy, World world) { //#1 Stumble into fight

        System.out.print("Would you like to run or fight?\n>> ");
        Scanner keyboard = new Scanner(System.in);
        String tempString = keyboard.nextLine();
        Input.setFight(true);
        switch (tempString) {
            case "fight":
                fight(me, enemy, world);
                break;
            case "run":
                world.run(me, enemy, world);

                break;
            default:
                System.out.println("Please enter either run or fight. You do not have a choice.");

        }

    }

}
