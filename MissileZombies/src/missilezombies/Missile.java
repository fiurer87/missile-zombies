package missilezombies;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Roberto <luis.robertop87@gmail.com>
 */
class Missile {
    
    private final int MAX_CELLS_AFFECTED = 13;

    private Point goal;
    private List<Point> potentialAffectedCells;

    Missile(int x, int y) {
        goal = new Point(x, y);
        potentialAffectedCells = new ArrayList<>();
        getAffectedCells();
    }
    
    private void getAffectedCells() {
        //Center
        potentialAffectedCells.add( new Point(goal) );
        //Vertical
        potentialAffectedCells.add( new Point(goal.x, goal.y + 1) );
        potentialAffectedCells.add( new Point(goal.x, goal.y + 2) );
        potentialAffectedCells.add( new Point(goal.x, goal.y - 1) );
        potentialAffectedCells.add( new Point(goal.x, goal.y - 2) );
        //Horizontal
        potentialAffectedCells.add( new Point(goal.x + 1, goal.y) );
        potentialAffectedCells.add( new Point(goal.x + 2, goal.y) );
        potentialAffectedCells.add( new Point(goal.x - 1, goal.y) );
        potentialAffectedCells.add( new Point(goal.x - 2, goal.y) );
        //North squares
        potentialAffectedCells.add( new Point(goal.x - 1, goal.y + 1) );
        potentialAffectedCells.add( new Point(goal.x + 1, goal.y + 1) );
        //South squeres
        potentialAffectedCells.add( new Point(goal.x - 1, goal.y - 1) );
        potentialAffectedCells.add( new Point(goal.x - 1, goal.y + 1) );
    }
    
    public List<Point> coordinatesUnderAttack() {
        return potentialAffectedCells;
    }
}
