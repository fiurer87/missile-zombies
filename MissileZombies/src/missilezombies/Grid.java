package missilezombies;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Roberto <luis.robertop87@gmail.com>
 */
class Grid {

    protected final Dimension dimension;
    private final List<Cell> matrix;

    public Grid(int width, int height) {
        dimension = new Dimension(width, height);
        matrix = new ArrayList<>();
    }

    private AttackResult impactWith(Missile missile, boolean clean) {
        int zombiesEliminated = 0;
        List<Point> attackedPositions = missile.coordinatesUnderAttack();
        for (Cell cell : matrix) {
            if (attackedPositions.contains(cell.position)) {
                int zombiesToEliminate = cell.eliminateZombies(clean);
                zombiesEliminated += zombiesToEliminate;
            }
        }
        return new AttackResult(missile, zombiesEliminated);
    }

    public void receiveImpactWith(AttackResult attack) {
        impactWith(attack.getMissile(), true);
    }

    public AttackResult potentialResult(Missile missile) {
        return impactWith(missile, false);
    }

    public void addZombiesCell(int x, int y, int zombies) {
        if (zombies <= 0) {
            return; // Just accept cells with 1 zombie at least
        }
        if ((x > 0 && x <= dimension.width) && (y > 0 && y <= dimension.height)) {
            matrix.add(new Cell(x, y, zombies));
        }
    }

}
