
public class TestCook {

    public static void main(String[] args) {
        System.out.println("Testing Fire starting fire");

        Day timerA = new Day();
        timerA.dayTimer();

        int[][] fightStyles = {
            {6, 2, 5, 10, 3, 25}, //mage
            {5, 9, 7, 2, 2, 25}, //warrior
            {7, 3, 4, 4, 7, 25} //archer
        };

        int[] monsterStats = {2, 2, 2, 2, 2, 10};
        World world = new World();

        Player andrew = new Player("andrew", fightStyles[1], "SleepingBag");
        Npc monster = new Npc("monster", monsterStats, true, "gold");

        andrew.setInventory("DryWood");
        andrew.setInventory("DryGrass");

        String[] backpack = andrew.getInventory();

        for (int i = 0; i < backpack.length; i++) { //check backpack
            System.out.println(backpack[i]);
        }

        andrew.makeFire(world); //make fire

        andrew.setInventory("RawMeat");

        world.cook(andrew, "RawMeat");

        for (int i = 0; i < backpack.length; i++) { //check backpack
            System.out.println(backpack[i]);
        }

    }
}
