
public class Npc extends Character {

    boolean hostility = true;
    String itemDrop = "";

    public Npc(String a, int[] b, boolean c, String d) { //constuructor
        super(a, b);
        hostility = c;
        itemDrop = d;
    }

    public Boolean hasItem() { //is Npc holding an item
        return !itemDrop.equals("");

    }

    public String getItem() {//take item from Npc

        return itemDrop;

    }

}
