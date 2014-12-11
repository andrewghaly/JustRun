
import java.util.Random;

public class Npc extends Character {

    private boolean hostility = true;
    private String itemDrop = "";
    private final int defaultHealth = 2;
    private final String[] items = {"BeefJerky", "boots", "helmet", "", "", ""};

    public Npc(String a, int[] b, boolean c, String d) { //constuructor
        super(a, b);
        hostility = c;
        itemDrop = d;
    }

    public Boolean hasItem() { //is Npc holding an item
        return !itemDrop.equalsIgnoreCase("");

    }

    public String randItem() {
        Random rand = new Random();
        int value = rand.nextInt(6);
        return items[value];
    }

    public void setItem(String i) {
        itemDrop = i;
    }

    public String getItem() {//take item from Npc

        return itemDrop;

    }

}
