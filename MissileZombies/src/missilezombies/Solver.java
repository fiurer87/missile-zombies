package missilezombies;

/**
 *
 * @author Luis Roberto <luis.robertop87@gmail.com>
 */
public class Solver {

    public static int MISSILES = 3;

    public String solution(Grid grid) {

        String output = "";
        //Check all point to attack and get its AttackResult
        for (int missile = 0; missile < MISSILES; missile++) {
            AttackResult bestShoot = new AttackResult(new Missile(0, 0, grid), Integer.MIN_VALUE);
            AttackResult result = null;

            for (int x = 1; x <= grid.dimension.width; x++) {
                for (int y = 0; y <= grid.dimension.height; y++) {
                    result = grid.potentialResult(new Missile(x, y, grid));
                    if (result.hasZombiesAttacked()) {
                        if (result.compareTo(bestShoot) > 0) {
                            bestShoot = result;
                        }
                    }
                }
            }

            output += String.format("%s\n", bestShoot);
            grid.receiveImpactWith(bestShoot);
        }

        return output;
    }

}
