package missilezombies;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Roberto <luis.robertop87@gmail.com>
 */
class Missile {

    private Point goal;

    private final List<Point> potentialAffectedPositions;
    private final int limitX;
    private final int limitY;

    Missile(int x, int y, Grid objective) {
        goal = new Point(x, y);
        potentialAffectedPositions = new ArrayList<>();
        limitX = objective.dimension.width;
        limitY = objective.dimension.height;
        getAffectedPositions();
    }

    private void getAffectedPositions() {
        //Center
        potentialAffectedPositions.add(new Point(goal));
        //Vertical
        potentialAffectedPositions.add(new Point(goal.x, goal.y + 1));
        potentialAffectedPositions.add(new Point(goal.x, goal.y + 2));
        potentialAffectedPositions.add(new Point(goal.x, goal.y - 1));
        potentialAffectedPositions.add(new Point(goal.x, goal.y - 2));
        //Horizontal
        potentialAffectedPositions.add(new Point(goal.x + 1, goal.y));
        potentialAffectedPositions.add(new Point(goal.x + 2, goal.y));
        potentialAffectedPositions.add(new Point(goal.x - 1, goal.y));
        potentialAffectedPositions.add(new Point(goal.x - 2, goal.y));
        //North squares
        potentialAffectedPositions.add(new Point(goal.x - 1, goal.y + 1));
        potentialAffectedPositions.add(new Point(goal.x + 1, goal.y + 1));
        //South squeres
        potentialAffectedPositions.add(new Point(goal.x - 1, goal.y - 1));
        potentialAffectedPositions.add(new Point(goal.x - 1, goal.y + 1));

        //Wrapper points
        for (Point position : potentialAffectedPositions) {
            //Fixed x axis
            if (position.x > limitX) {
                position.move(position.x - limitX, position.y);
            } else if (position.x < 1) {
                position.move(limitX - position.x, position.y);
            }
            //Fixed y axis
            if (position.y > limitY) {
                position.move(position.x, position.y - limitY);
            } else if (position.y < 1) {
                position.move(position.x, limitY - position.y);
            }
        }
    }

    public List<Point> coordinatesUnderAttack() {
        return potentialAffectedPositions;
    }

    public Point arrivedPosition() {
        return goal;
    }
}
