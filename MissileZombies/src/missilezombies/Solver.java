package missilezombies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Luis Roberto <luis.robertop87@gmail.com>
 */
public class Solver {
    
    public static int MISSILES = 3;
    
    public static String solution(Grid grid) {
        
        String output = "";
        //Check all point to attack and get its AttackResult
        for (int missile = 0; missile < MISSILES; missile++) {
            List<AttackResult> results = new ArrayList<>();
            for (int x = 1; x <= grid.dimension.width; x++) {
                for (int y = 0; y <= grid.dimension.height; y++) {
                    AttackResult result = grid.receiveImpactWith(new Missile(x, y, grid), false);
                    if (result.zombies > 0) {
                        results.add(result);
                    }
                }
            }

            Collections.sort(results);

            try {
                output += String.format("%s\n", results.get(missile));
                grid.receiveImpactWith(results.get(missile).missile, true);
            } catch (IndexOutOfBoundsException ioe) {
                break;
            }
        }
        
        return output;
    }
    
}
