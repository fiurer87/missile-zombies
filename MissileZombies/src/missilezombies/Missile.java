package missilezombies;

import java.awt.Point;

/**
 *
 * @author Luis Roberto <luis.robertop87@gmail.com>
 */
class Missile {

    private final Grid objective;
    private final Point goal = new Point();

    private final int limitX;
    private final int limitY;

    public Missile(Grid objective) {
        this.objective = objective;
        limitX = objective.dimension.width;
        limitY = objective.dimension.height;
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
                    maxVictims = victims;
                    this.goal.move(gridX, gridY);
                } else if (victims == maxVictims) {
                    if (objective.existZombiensIn(gridX, gridY)) {
                        this.goal.move(gridX, gridY);
                    }
                }
            }
        }
    }

    public void setGoalPosition(int x, int y) {
        goal.move(x, y);
    }
}
