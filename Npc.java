
public class Npc extends Character {

    boolean hostility = true;
    String itemDrop = "";

    public Npc(String a, int[] b, boolean c, String d) {
        super(a, b);
        hostility = c;
        itemDrop = d;
    }

    public Boolean hasItem() {
        if (itemDrop.equals("")) {
            return false;
        }
        return true;

    }

    public String getItem() {

        return itemDrop;

    }

}
