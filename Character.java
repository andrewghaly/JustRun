
public class Character {

    int[] intStats = {0, 0, 0, 0, 0, 0};
    String name = "";
    String[] stringStats = {"agility", "strength", "health", "magic", "intelligence", "total"};

    public Character(String a, int[] b) { //set character
        this.name = a;
        this.intStats = b;
        this.intStats[5] = intStats[0] + intStats[1] + intStats[2] + intStats[3] + intStats[4];
    }

    public int getHealth() {
        int a = intStats[2];
        return a;
    }

    public void setHealth(int a) {
        intStats[2] = a;
    }

    public boolean dead() {
        if (intStats[2] > 0) {
            return false;
        }
        return true;

    }

    public int getTotal() {
        int a = intStats[5];
        return a;
    }

    public String getStats() {
        String a = "#########################\n\tStats\n#########################\nAgility: " + intStats[0] + "\nStrength: " + intStats[1] + "\nHealth: " + intStats[2] + "\nMagic: " + intStats[3] + "\nIntelligence: " + intStats[4] + "\nTotal: " + intStats[5];
        return a;
    }

    public int getAgility() {
        int a = intStats[0];
        return a;
    }

    public void setStats(String a, int b) {
        for (int i = 0; i < stringStats.length; i++) {
            if (a.equals((stringStats[i]))) {
                intStats[i] += b;
            }
        }

    }

}
