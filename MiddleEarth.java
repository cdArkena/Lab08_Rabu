import java.util.ArrayList;
import java.util.List;

public class MiddleEarth {

    private final List<Creature> listCreature;

    /**
     * Constructor for MiddleEarth.
     * Creates a new List of Creatures.
     */
    public MiddleEarth() {
        listCreature = new ArrayList<>();
    }

    /**
     * Adds creature to the MiddleEarth's List of Creature
     * @param type Type of the creature
     * @param name Name of the creature
     * @param health health point of the creature
     * @throws CantCreateException if the type is not supported
     */
    public void addCreature(String type, String name, int health) throws CantCreateException {
        switch (type) {
            case "Dwarf": {
                if (health > 2200) {
                    throw new CantCreateException(
                        String.format("Maximum Health for %s is %s", name, 2200));
                }
                Dwarf creature = new Dwarf(name, health);
                listCreature.add(creature);
                break;
            }
            case "Elf": {
                if (health > 3000) {
                    throw new CantCreateException(
                        String.format("Maximum Health for %s is %s", name, 3000));
                }
                Elf creature = new Elf(name, health);
                listCreature.add(creature);
                break;
            }
            case "Hobbit": {
                if (health > 1500) {
                    throw new CantCreateException(
                        String.format("Maximum Health for %s is %s", name, 1500));
                }
                Hobbit creature = new Hobbit(name, health);
                listCreature.add(creature);
                break;
            }
            default: {
                throw new CantCreateException("Creature not found.");
            }
        }
    }

    /**
     * Fights between creatures.
     * @param thisCreature first creature
     * @param thatCreature second creature
     * @throws CivilWarOccurredException if two creature with same type fights
     */
    public void doFight(String thisCreature, String thatCreature) throws CivilWarOccurredException {
        Creature first = creatureFindByName(thisCreature);
        Creature second = creatureFindByName(thatCreature);
        if (first.getType().equals(second.getType())) {
            throw new CivilWarOccurredException("HEYOO CIVIL WAR OCCURRED");
        }
        if (first.getHealth() > 0 && second.getHealth() > 0) {
            while (true) {
                first.doFight(second);
                if (second.getHealth() < 1) {
                    System.out.println(String.format("%s Death", second.getName()));
                    second.setHealth(0);
                    break;
                }
                second.doFight(first);
                if (first.getHealth() < 1) {
                    System.out.println(String.format("%s Death", first.getName()));
                    first.setHealth(0);
                    break;
                }
            }
        }
    }

    /** Finds creature by name in creature list
     *
     * @param name name of the creature
     * @return the object of creature with the name
     */
    public Creature creatureFindByName(String name) {
        for (Creature creature : listCreature) {
            if (creature.getName().equals(name)) {
                return creature;
            }
        }
        return null;
    }

    /**
     * Get the info of every creature in middle earth
     * @return
     */
    public String getCreaturesInfo() {
        StringBuilder ret = new StringBuilder();
        for (Creature creature : listCreature) {
            ret.append(creature.getInfo() + "\n");
        }
        return ret.toString();
    }

    /**
     * Get list of creature in Middle Earth
     * @return
     */
    public List<Creature> getCreatureList() {
        return this.listCreature;
    }
}
