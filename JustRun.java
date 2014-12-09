
public class JustRun {

    public static void main(String[] args) {

        Day timerA = new Day();
        timerA.dayTimer();

        int[] stats = {4, 2, 4, 2, 2, 12};
        int[] monsterStats = {2, 2, 2, 2, 2, 10};
        World world = new World();
        Player andrew = new Player("andrew", stats, "GoldenApple");
        Npc monster = new Npc("monster", monsterStats, true, "gold");

        Input talk = new Input(andrew, monster, world);
        talk.readInput(andrew, monster, world);

    }

}
