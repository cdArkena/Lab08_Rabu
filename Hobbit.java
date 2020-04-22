public class Hobbit extends Creature {
    private String type;

    /**
     * Constructor for Hobbit
     * @param name name of the hobbit
     * @param health helath points
     */
    public Hobbit(String name, int health) {
        super(name, health);
        this.type = "Hobbit";
        System.out.println("Hobbit " + this.getName() + " is ready for the war!");
    }

    /**
     * Getter for hobbit's info
     * @return String hobbit's info
     */
    public String getInfo() {
        return String.format(
            "Name: %s\nType: Hobbit\nHealth: %d\n",
            this.getName(), this.getHealth()
        );
    }

    /**
     * Getter for creature type
     * @return String hobbit
     */
    public String getType() {
        return this.type;
    }

    /**
     * Reduce opponent's health points
     * @param that opponent
     */
    public void doFight(Creature that) {
        that.setHealth(that.getHealth()-25);
    }
}
