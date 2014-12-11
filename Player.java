
public final class Player extends Character {

    private final String[] inventory = new String[10];
    private final String[] nameFoods = {"Berries", "RawMeat", "BeefJerky", "CookedMeet", "GoldenApple"};
    private final String[] usableItems = {"SleepingBag", "Boots", "Helmet"};

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
            if (a.equalsIgnoreCase(nameFoods[i])) {
                track++;
                break;
            }
        }
        return track != 0;

    }

    public boolean inInventory(String a) {//check if item is in inventory
        int track = 0;
        for (int i = 0; i < inventory.length; i++) {
            if (a.equalsIgnoreCase(inventory[i])) {
                track++;
                break;
            }
        }

        if (track == 1) {
            return true;
        } else {
            return false;
        }

    }

    public int foodValue(String a) {//Return value of food good
        int carry = 0;
        for (int i = 0; i < nameFoods.length; i++) {
            if (a.equalsIgnoreCase(nameFoods[i])) {
                carry = i;
                break;
            }
        }

        return statsFoods[carry];

    }

    public void removeInventory(String a, Boolean b) { //remove item from inventory
        int track = 0;
        if (inInventory(a)) {
            if (b) {
                System.out.println("You ate " + a);
            } else {
                System.out.println("You dropped " + a);

            }
            for (int i = 0; i < inventory.length; i++) {
                if (a.equalsIgnoreCase(inventory[i])) {
                    inventory[i] = "";
                    break;
                }
            }
        } else {
            System.out.println("You do not have that item in your backpack, type backpack");
        }
    }

    public void setHunger(int a) {
        if ((hunger + a) > 100) {
            hunger = 100;
        } else {
            hunger += a;
        }
    }

    public void eatFood(String a) { //eat the food
        if (inInventory(a)) { //checking inv
            if (isFood(a)) { //checking if food
                setHunger(foodValue(a));
                setHealth(getHealth() + foodValue(a) / 10);
                removeInventory(a, true);
            }
        }
    }

    public Boolean usableItem(String a) { //check if item is a usable item (compares String to usableItems array)

        int track = 0;
        for (int i = 0; i < usableItems.length; i++) {
            if (a.equalsIgnoreCase(inventory[i])) {
                track++;
                break;
            }
        }

        if (track == 1) {
            return true;
        } else {
            return false;
        }

    }

    public void useSleepingbag() {
        Day.setDay(false);
        System.out.println("You have slept through the night!");
    }

    public void useHelmet(Player me) {
        me.incMaxHealth(3);
        me.removeInvNoOutput("helmet");
        System.out.println("You have equipped your helmet!");
    }

    public void useBoots(Player me) {
        me.incMaxHealth(2);
        me.removeInvNoOutput("boots");
        System.out.println("You have equipped your boots!");
    }

    public void useInventory(String a, Player me) { //use an item in inventory
        if (inInventory(a)) {
            if (usableItem(a)) {
                if (a.equalsIgnoreCase("SleepingBag")) {
                    useSleepingbag();
                } else if (a.equalsIgnoreCase("helmet")) {
                    useHelmet(me);
                } else if (a.equalsIgnoreCase("boots")) {
                    useBoots(me);
                }
            } else {
                System.out.println("Item is a non-usable item");
            }
        } else {
            System.out.println("Item is not in your inventory");
        }
    }

    public void makeFire(World world) {
        if (inInventory("DryGrass")) {
            if (inInventory("DryWood")) {
                System.out.println("There is a blazing fire infront of you! You can cook food in a fire.");
                removeInvNoOutput("DryGrass");
                removeInvNoOutput("DryWood");
                world.setFire(true);
            } else {
                System.out.println("You have no DryWood to start a fire.");
            }
        } else {
            System.out.println("You have no DryGrass to start a fire.");
        }
    }

    public void setInventory(String a) { // add item to backpack
        int track = 0;
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].equalsIgnoreCase("")) {
                inventory[i] = a;
                track++;
                break;
            }
        }
        if (track == 0) {
            System.out.println("Your Backpack is full");
        }
    }

    public void removeInvNoOutput(String a) {
        if (inInventory(a)) {
            for (int i = 0; i < inventory.length; i++) {
                if (a.equalsIgnoreCase(inventory[i])) {
                    inventory[i] = "";
                    break;
                }
            }
        } else {
            System.out.println("You do not have that item in your backpack, type backpack");
        }

    }

}
