
public class Player extends Character {

    String[] inventory = new String[10];
    int hunger = 30;

    public Player(String a, int[] b, String c) {
        super(a, b);
        for (int i = 0; i < inventory.length; i++) {
            inventory[i] = "";
        }

        setInventory(c);
    }

    public void setHunger(int a) {
        hunger += a;
        if (hunger <= 0) {
            System.out.println("You have died from hunger");
        } else if (hunger <= 10) {
            System.out.println("I can hear my stomach growling");
        } else if (hunger <= 20) {
            System.out.println("I am hungry");
        } else if (hunger <= 30) {
            System.out.println("I am getting hungry");
        }
    }

    public String[] getInventory() {
        return inventory;

    }

    public void removeInventory(String a) {
        int track = 0;
        for (int i = inventory.length - 1; i > 0; i--) {
            if (a.equals(inventory[i])) {
                inventory[i] = "";
                System.out.println("You have dropped a " + a);
                track++;
                break;
            }
        }
        if (track == 0) {
            System.out.println("You do not have that item in your backpack, type backpack");
        }
    }

    public void setInventory(String a) {
        int track = 0;
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].equals("")) {
                inventory[i] = a;
                track++;
                break;
            }
        }
        if (track == 0) {
            System.out.println("Your backpack is full");
        }
    }

}
