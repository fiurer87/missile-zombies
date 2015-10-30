package missilezombies;

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
            int maxZombiesAttacked = Integer.MIN_VALUE;
            AttackResult result = null;
            AttackResult bestShoot = null;

            for (int x = 1; x <= grid.dimension.width; x++) {
                for (int y = 0; y <= grid.dimension.height; y++) {
                    result = grid.receiveImpactWith(new Missile(x, y, grid), false);
                    if (result.zombies > 0) {
                        if (result.zombies >= maxZombiesAttacked) {
                            maxZombiesAttacked = result.zombies;
                            bestShoot = result;
                        }
                    }
                }
            }

            output += String.format("%s\n", bestShoot);
            grid.receiveImpactWith(bestShoot.missile, true);
        }

        return output;
    }

}
