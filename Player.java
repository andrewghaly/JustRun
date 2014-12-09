
public class Player extends Character {

    String[] inventory = new String[10];
    String[] nameFoods = {"Berries", "RawMeat", "BeefJerky", "CookedMeet", "GoldenApple"};
    int[] statsFoods = {10, 20, 30, 40, 100};
    int hunger = 100;

    public Player(String a, int[] b, String c) {
        super(a, b);
        for (int i = 0; i < inventory.length; i++) {
            inventory[i] = "";
        }

        setInventory(c);
    }

    public void walkHunger(int a) { //check hunger level and if you are going low display so
        hunger += a;
        if (hunger == 0) {
            System.out.println("You have died from hunger");
        } else if (hunger == 10) {
            System.out.println("I can hear my stomach growling");
        } else if (hunger == 20) {
            System.out.println("I am hungry");
        } else if (hunger == 30) {
            System.out.println("I am getting hungry");
        }
    }

    public int getHunger() { //get player hunger
        return hunger;
    }

    public String[] getInventory() { //get inventory of player
        return inventory;
    }

    public boolean isFood(String a) { //check if item is food
        int track = 0;
        for (int i = 0; i < nameFoods.length; i++) {
            if (a.equals(nameFoods[i])) {
                track++;
                break;
            }
        }
        return track != 0;

    }

    public boolean inInventory(String a) {//check if item is in inventory
        int track = 0;
        for (int i = 0; i < inventory.length; i++) {
            if (a.equals(inventory[i])) {
                track++;

            }
        }
        return track != 0;

    }

    public int foodValue(String a) {//Return value of food good
        int carry = 0;
        for (int i = 0; i < nameFoods.length; i++) {
            if (a.equals(nameFoods[i])) {
                carry = i;
                break;
            }
        }

        return statsFoods[carry];

    }

    public void removeInventory(String a, Boolean b) { //remove item from inventory
        int track = 0;
        if (inInventory(a)) {
            if (isFood(a)) {
                System.out.println("You ate " + a);
            } else {
                System.out.println("You dropped " + a);

            }
            for (int i = 0; i < inventory.length; i++) {
                if (a.equals(inventory[i])) {
                    inventory[i] = "";
                    break;
                }
            }
        } else {
            System.out.println("You do not have that item in your backpack, type backpack");
        }

        /*
         * for(int i = inventory.length-1; i > 0; i--){
         if(a.equals(inventory[i])){
         inventory[i] = "";
         if(b == true){
         System.out.println("You have eaten: " + a);
         track++;
         break;
         }
         System.out.println("You have dropped a " + a);
         track++;
         break;
         }
         }
         if(track == 0){
         System.out.println("You do not have that item in your backpack, type backpack");
         }
         */
    }

    public void eatFood(String a) { //eat the food
        if (inInventory(a)) { //checking inv
            if (isFood(a)) { //checking if food
                hunger += foodValue(a); //eat food
                removeInventory(a, true);
            }
        }
    }

    public void setInventory(String a) { // add item to backpack
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
