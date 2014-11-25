
import java.util.Random;
import java.util.stream.IntStream;

public class World {

    int distance = 10;
    int keepTrack = 1;
    int pi = 39393939;
    boolean fight = true;

    String[] items = {"staff", "sword", "gold", "hello"};

    public World() {

    }

    public void attack(Object attacker, Object defender) {
        int health = ((Character) defender).getHealth();
        ((Character) defender).setHealth(health - 1);
    }

    public void grab(Player me, Npc enemy, String item) {
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
            System.out.println("There is not an item");
        }
    }

    public void fight(Player me, Npc enemy) {

        System.out.println("You have entered a fight.");
        for (;;) {
            if (fight == true) {
                if (enemy.dead()) {
                    System.out.println("Monster is dead! You have won!");
                    if (enemy.hasItem()) {
                        System.out.println("Monster has dropped a " + enemy.getItem());
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

    public void run(Player me, Npc enemy) {
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

    public void walk(Player me, Npc monster) {
        me.setHunger(-1);
        if (keepTrack == 7) {
            keepTrack = 0;
        }

        int rand = intAt(pi, keepTrack);
        keepTrack++;

        distance--;
        if (rand >= 5 && distance == 0) { //goodevent
            System.out.println("You have found an item" + rand);
            distance = 10;
        } else if (rand < 5 && distance == 0) {//badevent
            System.out.println("You have stumbled into a monster");
            distance = 10;
            fight(me, monster);
        }

    }

}
