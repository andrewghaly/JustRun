
import java.util.*;

public class World {

    private final Day currDay = new Day();
    private final BadEvent badE = new BadEvent();
    private final double distance = badE.getDistance();

    private Boolean isFire = false;

    public double totalDistance() { //get distance
        return this.distance;
    }

    public void setFire(Boolean a) {
        isFire = a;
    }

    public void grab(Player me, Npc enemy, String item) { //grab item
        if (enemy.dead()) {
            if (enemy.hasItem()) {
                if (item.equalsIgnoreCase(enemy.getItem())) {
                    me.setInventory(item);
                } else {
                    System.out.println("The item you have entered does not exist");
                }
            } else {
                System.out.println("There is not an item in sight!");
            }
        } else {
            System.out.println("There is no item to grab");
        }
    }

    public void cook(Player me, String a) {
        if (isFire == true) {
            if (me.inInventory(a)) {
                if (me.isFood(a)) {
                    if (a.equalsIgnoreCase("RawMeat")) {
                        me.removeInvNoOutput("RawMeat");
                        me.setInventory("CookedMeat");
                        System.out.println("You have cooked your RawMeat");
                    }
                } else {
                    System.out.println("That item is not a food.");
                }
            } else {
                System.out.println("You do not have that item in your backpack!");
            }
        } else {
            System.out.println("There is no fire near you!");
        }
    }

    public void run(Player me, Npc enemy, World world) {//run from fight
        int myAgility = me.getAgility();
        int enemyAgility = enemy.getAgility();

        if (myAgility > enemyAgility) {
            System.out.println("You have escaped");
            Input.setFight(false);
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

        if (isFire == true) {
            System.out.println("You walked away from your fire");
            setFire(false);
        }

        if (Day.isDay == true) { //goodevent
            GoodEvent goodevent = new GoodEvent();
            Random randVal = new Random();
            int good = randVal.nextInt(20);
            if (good == 0) {//#0 berry bush
                goodevent.berryBush(me);
                good++;
            } else if (good == 1) {//#1 Dry Wood
                goodevent.foundDryWood(me);
                good++;
            } else if (good == 2) {//#2 Rabbit
                goodevent.foundRabbit(me);
                good++;
            } else if (good == 3) { //#3 WetWood
                goodevent.foundWetWood(me);
                good++;
            } else if (good == 4) { //#4 Dry Grass
                goodevent.foundDryGrass(me);

            } else if (good == 5) {// #5 sleeping bag
                goodevent.foundSleepingBag(me);

            }
            badE.badIncrease(40);

        } else {
            badE.badIncrease(150);
        }

        if (badE.getDistance() <= 100) {//badevent

            System.out.println("You have stumbled into a monster");

            badE.stumbledIntoMonster(me, monster, world);
        }
        /*
         Debugger: tells us how close we are to a bad event or fight 
         
         System.out.print("distance to bad event: " + badE.getDistance());
         badE.getDistance();
         */
    }

}
