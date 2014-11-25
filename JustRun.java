
public class JustRun {

    public static void main(String[] args) {
        World world = new World();

        int[] stats = {2, 2, 4, 2, 2, 10};
        int[] monsterStats = {2, 2, 2, 2, 2, 10};

        Player andrew = new Player("andrew", stats, "staff");
        Npc monster = new Npc("monster", monsterStats, true, "somethingElse");

        Input talk = new Input(andrew, monster, world);
        talk.readInput(andrew, monster, world);
    }

}
