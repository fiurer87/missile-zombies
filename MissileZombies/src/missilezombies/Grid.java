package missilezombies;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Roberto <luis.robertop87@gmail.com>
 */
class Grid {
    
    protected int width;
    protected int height;
    private List<Cell> matrix;
    
    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new ArrayList<>();
    }

    public int receiveImpactWith(Missile missile) {
        int zombiesEliminated = 0;
        List<Cell> effectiveMatrix = searchAffectedCells(missile.coordinatesUnderAttack());
        if ( effectiveMatrix != null ) {
            for (Cell cell : effectiveMatrix) {
                zombiesEliminated += cell.eliminateZombies();
            }
        }
        return zombiesEliminated;
    }

    public void addZombiesCell(int x, int y, int zombies) {
        if (zombies <= 0) return; // Just accept cells with 1 zombie at least
        if( (x > 0 && x <= width) && (y > 0 && y <= height) ) {
            matrix.add(new Cell(x, y, zombies) );
        }
    }
    
    private List<Cell> searchAffectedCells (List<Point> attackedPositions) {
        List<Cell> effectiveMatrix = new ArrayList<>();
        for (Cell cell : matrix) {
            if ( attackedPositions.contains(cell.position) ) {
                effectiveMatrix.add(cell);
            }
        }
        return effectiveMatrix;
    }

}
