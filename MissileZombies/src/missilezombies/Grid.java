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

    public AttackResult receiveImpactWith(Missile missile) {
        int zombies = potentialVictims(missile.arrivedPosition().x, missile.arrivedPosition().y);
        AttackResult result = new AttackResult(missile.arrivedPosition(), zombies);
        return result;
    }

    public void addZombiesCell(int x, int y, int zombies) {
        if (zombies <= 0) {
            return; // Just accept cells with 1 zombie at least
        }
        if ((x > 0 && x <= dimension.width) && (y > 0 && y <= dimension.height)) {
            matrix.add(new Cell(x, y, zombies));
        }
    }

    public int potentialVictims(int x, int y) {
        int zombiesEliminated = 0;
        List<Point> attackedPositions = affectedPositions(new Point(x, y));
        for (Cell cell : matrix) {
            if (attackedPositions.contains(cell.position)) {
                zombiesEliminated += cell.getZombies();
            }
        }
        return zombiesEliminated;
    }

    private List<Point> affectedPositions(Point point) {
        List<Point> positions = new ArrayList<>();
        //Center
        positions.add(new Point(point));
        //Vertical
        positions.add(new Point(point.x, point.y + 1));
        positions.add(new Point(point.x, point.y + 2));
        positions.add(new Point(point.x, point.y - 1));
        positions.add(new Point(point.x, point.y - 2));
        //Horizontal
        positions.add(new Point(point.x + 1, point.y));
        positions.add(new Point(point.x + 2, point.y));
        positions.add(new Point(point.x - 1, point.y));
        positions.add(new Point(point.x - 2, point.y));
        //North squares
        positions.add(new Point(point.x - 1, point.y + 1));
        positions.add(new Point(point.x + 1, point.y + 1));
        //South squares
        positions.add(new Point(point.x - 1, point.y - 1));
        positions.add(new Point(point.x - 1, point.y + 1));

        //Wrapper points
        for (Point position : positions) {
            //Fixed x axis
            if (position.x > dimension.width) {
                position.move(position.x - dimension.width, position.y);
            } else if (position.x < 1) {
                position.move(dimension.width - position.x, position.y);
            }
            //Fixed y axis
            if (position.y > dimension.height) {
                position.move(position.x, position.y - dimension.height);
            } else if (position.y < 1) {
                position.move(position.x, dimension.height - position.y);
            }
        }

        return positions;
    }

    public boolean existZombiensIn(int gridX, int gridY) {
        for (Cell cell : matrix) {
            if (cell.position.x == gridX && cell.position.y == gridY) {
                return (cell.getZombies() != 0);
            }
        }
        return false;
    }
}
