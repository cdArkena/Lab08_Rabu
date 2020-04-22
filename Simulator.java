import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Simulator {

    /**
     * Main program, to simulate the class
     * @param args unused
     * @throws FileNotFoundException if file not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        MiddleEarth middleEarth = new MiddleEarth();
        try {
            List<String> war = readFile(
                "C:\\Users\\Artemis\\Downloads\\Lab08_Rabu\\src\\Input3\\War3.txt");
            List<String> creatures = readFile(
                "C:\\Users\\Artemis\\Downloads\\Lab08_Rabu\\src\\Input3\\Creature3.txt");
            for (String line : creatures) {
                String[] creature = line.strip().split(" ");
                middleEarth.addCreature(creature[0], creature[1], Integer.parseInt(creature[2]));
            }
            System.out.println("THE WAR BEGINS");
            for (String line : war) {
                String[] fight = line.strip().split(";");
                middleEarth.doFight(fight[0], fight[1]);
            }
            System.out.println("Everything Destroyed By Sauron");
        } catch (CivilWarOccurredException | CantCreateException e) {
            System.out.println(e);
        } finally {
            File reportfile = new File("report.txt");
            PrintWriter report = new PrintWriter(reportfile);
            report.println(middleEarth.getCreaturesInfo());
            report.close();
            System.out.println("MIDDLE EARTH DESTROYED");
        }
    }

    /**
     * To read the file, it doesn't include line with only 1 char
     * @param filename name of the file
     * @return list of strings
     */
    public static List<String> readFile(String filename) {
        List<String> ret = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            line = br.readLine();
            while (line != null) {
                if (line.length() > 1) {
                    ret.add(line);
                }
                line = br.readLine();
            }
            br.close();
            return ret;
        } catch (IOException e) {
            System.out.println("File not found.");
        }
        return ret;
    }
}
