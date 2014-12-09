
import java.util.*;

public class World {

    Day currDay = new Day();
    BadEvent badE = new BadEvent();
    double distance = badE.getDistance();
    String[] items = {"staff", "sword", "gold", "hello"};

    public World() {

    }

    public double totalDistance() { //get distance
        return this.distance;
    }

    public void grab(Player me, Npc enemy, String item) { //grab item
        if (enemy.dead()) {
            if (enemy.hasItem()) {
                if (item.equals(enemy.getItem())) {
                    me.setInventory(item);
                } else {
                    System.out.println("The item you have entered does not exist");
                }
            } else {
                System.out.println("There is not an item in sight!");
            }
        } else {
            System.out.println("There is no item");
        }
    }

    public void run(Player me, Npc enemy, World world) {//run from fight
        int myAgility = me.getAgility();
        int enemyAgility = enemy.getAgility();

        if (myAgility > enemyAgility) {
            System.out.println("You have escaped");
        } else {
            System.out.println("You must fight");
        }

    }

    int intAt(int num, int index) {
        String s = Integer.toString(num);
        int r = Integer.parseInt(s.substring(index, index + 1));
        return r;
    }

    public void walk(Player me, Npc monster, World world) { //walking
        me.walkHunger(-1);

        if (currDay.isDay == true) { //goodevent
            GoodEvent goodevent = new GoodEvent();
            Random randVal = new Random();
            int good = randVal.nextInt(20);
            if (good == 0) {
                goodevent.berryBush(me);
                good++;
            } else if (good == 1) {
                goodevent.foundDryWood(me);
                good++;
            } else if (good == 2) {
                goodevent.foundRabbit(me);
                good++;
            } else if (good == 3) {
                goodevent.foundWetWood(me);
                good++;
            } else if (good == 4) {
                goodevent.foundDryGrass(me);

            }
            badE.badIncrease(50);

        } else {
            badE.badIncrease(90);
        }

        if (badE.getDistance() <= 30) {//badevent

            System.out.println("You have stumbled into a monster");

            badE.stumbledIntoMonster(me, monster, world);
        }
        /*
        
         // This code tells us how close we are to a bad event or fight 
         System.out.print("bad distance: " + badE.getDistance());
         */

    }

}
