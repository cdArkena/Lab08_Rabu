public class Elf extends Creature {
    private String type;

    /**
     * Constructor of Elf
     * @param name name of the elf
     * @param health health point of the elf
     */
    public Elf(String name, int health) {
        super(name, health);
        this.type = "Elf";
        System.out.println("Elf " + this.getName() + " is ready for the war!");
    }

    /**
     * Get info of the elf
     * @return Elf's info
     */
    public String getInfo() {
        return String.format(
            "Name: %s\nType: Elf\nHealth: %d\n",
            this.getName(), this.getHealth()
        );
    }

    /**
     * Getter for the type
     * @return String elf
     */
    public String getType() {
        return this.type;
    }

    /**
     * Reduce opponent's health points
     * @param that opponent
     */
    public void doFight(Creature that) {
        that.setHealth(that.getHealth()-150);
    }
}
