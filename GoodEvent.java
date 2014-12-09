
import java.util.Scanner;

public class GoodEvent {

    public void answer(Player a, String b) { // y/n response
        Scanner keyboard = new Scanner(System.in);
        char answer = keyboard.next().charAt(0);
        if (answer == 'y' || answer == 'Y') {
            a.setInventory(b);
            System.out.println("You have added " + b + " to your backpack!");
        } else {
            System.out.println("Do not grab " + b);
        }
    }

    public void berryBush(Player a) { //#1 finding a berry bush 
        System.out.println("You have found a berry bush");
        System.out.println("Would you like to grab some berries?(y/n)");
        answer(a, "Berries");
    }

    public void foundDryWood(Player a) { //#2 finding drywood
        System.out.println("I just spotted some dry wood");
        System.out.println("Grab the dry wood?(y/n)");
        answer(a, "DryWood");

    }

    public void foundDryGrass(Player a) {//#3 finding dry grass 
        System.out.println("I have found some dry grass, this will be helpful for starting a fire.");
        System.out.println("Grab the dry grasswood?(y/n)");
        answer(a, "DryGrass");
    }

    public void foundWetWood(Player a) {//#3 finding a wet wodd 
        System.out.println("I found some wet wood");
        System.out.println("Grab the wet wood?(y/n)");
        answer(a, "WetWood");
    }

    public void foundRabbit(Player a) { //#5 finding a Rabbit 
        System.out.println("You see a Rabbit");
        System.out.println("Would you like to hunt the Rabbit?(y/n)");
        answer(a, "RawMeat");
    }
}
