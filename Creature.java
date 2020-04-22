public abstract class Creature {

    private final String name;
    private int health;

    /**
     * Constructor for Creature
     *
     * @param name name of the creature
     * @param health health point of the creature
     */
    public Creature(final String name, final int health) {
        this.name = name;
        this.health = health;
    }

    /**
     * Get the name of the creature
     *
     * @return String name if the creature
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the health points of the creature
     *
     * @return Int health point
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Set creature's health point
     * @param health Int desired health point
     */
    public void setHealth(final int health) {
        this.health = health;
    }

    public abstract String getInfo();

    public abstract void doFight(Creature that);

    public abstract String getType();
}
