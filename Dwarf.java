public class Dwarf extends Creature {
    private String type;

    /**
     * Dwarf construction
     * @param name name of the dwarf
     * @param health health point of the dwarf
     */
    public Dwarf(String name, int health) {
        super(name, health);
        this.type = "Dwarf";
        System.out.println("Dwarf " + this.getName() + " is ready for the war!");
    }

    /**
     * Get info of the dwarf
     * @return String dwarf info
     */
    public String getInfo() {
        return String.format(
            "Name: %s\nType: Dwarf\nHealth: %d\n",
            this.getName(), this.getHealth()
        );
    }

    /**
     * Getter to get the type
     * @return String Dwarf
     */
    public String getType() {
        return this.type;
    }

    /**
     * Reduce opponent's health points
     * @param that opponent
     */
    public void doFight(Creature that) {
        that.setHealth(that.getHealth()-80);
    }
}
