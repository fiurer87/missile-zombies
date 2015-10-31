package missilezombies;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Roberto <luis.robertop87@gmail.com>
 */
public class Main {

    public static int MISSILES = 3;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Missile Zombies started...");
        Grid grid = null;
        if (args.length == 0) {
            System.out.println("There is no a file to read inputs");
            System.out.println("Next time try: java -jar missilezombies.jar /path/to/file.txt");
            System.out.println("Please insert the values in the specified format in the Exercise: "
                    + "Press [q] when finish to insert");
            Scanner reader = new Scanner(System.in);
            int width = reader.nextInt();
            int height = reader.nextInt();
            grid = new Grid(width, height);
            for (int i = 0; i < width * height; i++) { // Limit insert to Grid size
                try {
                    grid.addZombiesCell(reader.nextInt(), reader.nextInt(), reader.nextInt());
                } catch (Exception e) {
                    break;
                }
            }
        } else {
            File inputFile = new File(args[0]);
            if (inputFile.exists()) {
                try {
                    Scanner fileReader = new Scanner(inputFile);
                    grid = new Grid(fileReader.nextInt(), fileReader.nextInt());
                    while (fileReader.hasNext()) {
                        grid.addZombiesCell(fileReader.nextInt(), fileReader.nextInt(),
                                fileReader.nextInt());
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE,
                            "The file does not exists", ex);
                    System.exit(1);
                }
            }
        }

        System.out.print(solution(grid));
    }

    public static String solution(Grid grid) {

        Missile missile = new Missile(grid);
        AttackResult result = null;
        String output = "";

        for (int i = 0; i < MISSILES; i++) {
            missile.updateToBestPosition();
            result = grid.receiveImpactWith(missile);
            output += String.format("%s\n", result);
        }

        return output;
    }

}
