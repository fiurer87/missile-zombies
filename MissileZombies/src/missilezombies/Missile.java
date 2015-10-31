package missilezombies;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Roberto <luis.robertop87@gmail.com>
 */
class Missile {

    private Grid objective;
    private final Point goal = new Point();

    private final List<Point> potentialAffectedPositions = new ArrayList<>();
    private final int limitX;
    private final int limitY;

    public Missile(int x, int y, Grid objective) {
        limitX = objective.dimension.width;
        limitY = objective.dimension.height;
        getAffectedPositions();
    }

    public Missile(Grid objective) {
        this.objective = objective;
        limitX = objective.dimension.width;
        limitY = objective.dimension.height;
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

    public void updateToBestPosition() {
        int maxVictims = Integer.MIN_VALUE;
        for (int gridX = 1; gridX <= limitX; gridX++) {
            for (int gridY = 1; gridY <= limitY; gridY++) {
                int victims = objective.potentialVictims(gridX, gridY);
                if (victims > maxVictims) {
                    this.goal.move(gridX, gridY);
                }
            }
        }
    }
}
