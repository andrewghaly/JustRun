
public class TestFight {

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

        System.out.println(andrew.getHealth());

        BadEvent badevent = new BadEvent();

        badevent.stumbledIntoMonster(andrew, monster, world); //first fight

        System.out.println("Me: " + andrew.getHealth());
        System.out.println("Monster: " + monster.getHealth());

        badevent.stumbledIntoMonster(andrew, monster, world);

        System.out.println(andrew.getHealth());

    }
}
