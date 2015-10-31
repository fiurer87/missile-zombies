package missilezombies;

import java.awt.Point;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author roberto
 */
public class MissileTest {

    private Grid proposalGrid;

    @Before
    public void setUp() {
        proposalGrid = new Grid(10, 8);
        proposalGrid.addZombiesCell(3, 3, 4);
        proposalGrid.addZombiesCell(2, 3, 3);
        proposalGrid.addZombiesCell(4, 2, 2);
        proposalGrid.addZombiesCell(5, 1, 3);
        proposalGrid.addZombiesCell(5, 5, 6);
        proposalGrid.addZombiesCell(8, 6, 4);
    }

    @Test
    public void testBestAttackOnEmptyGrid1x1() {
        Grid grid1x1 = new Grid(1, 1);
        Missile missile = new Missile(grid1x1);
        missile.updateToBestPosition();

        AttackResult expected = new AttackResult(new Point(1,1), 0);
        AttackResult result = grid1x1.receiveImpactWith(missile);
        assertEquals(expected, result);
    }
    
    @Test
    public void testBestAttackNonEmptyGrid1x1() {
        Grid grid1x1 = new Grid(1, 1);
        grid1x1.addZombiesCell(1, 1, 5);
        Missile missile = new Missile(grid1x1);
        missile.updateToBestPosition();

        AttackResult expected = new AttackResult(new Point(1,1), 5);
        AttackResult result = grid1x1.receiveImpactWith(missile);
        assertEquals(expected, result);
    }
    
    @Test
    public void testBestAttackOnEmptyGrid2x2() {
        Grid grid2x2 = new Grid(2, 2);
        Missile missile = new Missile(grid2x2);
        missile.updateToBestPosition();

        AttackResult expected = new AttackResult(new Point(2,2), 0);
        AttackResult result = grid2x2.receiveImpactWith(missile);
        assertEquals(expected, result);
    }
    
    @Test
    public void testBestAttackNonEmptyGrid2x2oneCell() {
        Grid grid2x2 = new Grid(2, 2);
        grid2x2.addZombiesCell(1, 1, 5);

        Missile missile = new Missile(grid2x2);
        missile.updateToBestPosition();

        AttackResult expected = new AttackResult(new Point(2,2), 5);
        AttackResult result = grid2x2.receiveImpactWith(missile);
        assertEquals(expected, result);
    }
    
    @Test
    public void testBestAttackNonEmptyGrid2x2twoCells() {
        Grid grid2x2 = new Grid(2, 2);
        grid2x2.addZombiesCell(1, 1, 5);
        grid2x2.addZombiesCell(2, 2, 5);

        Missile missile = new Missile(grid2x2);
        missile.updateToBestPosition();

        AttackResult expected = new AttackResult(new Point(2,2), 10);
        AttackResult result = grid2x2.receiveImpactWith(missile);
        assertEquals(expected, result);
    }
    
    @Test
    public void testBestAttackNonEmptyGrid2x2fullCells() {
        Grid grid2x2 = new Grid(2, 2);
        grid2x2.addZombiesCell(1, 1, 5);
        grid2x2.addZombiesCell(1, 2, 5);
        grid2x2.addZombiesCell(2, 1, 5);
        grid2x2.addZombiesCell(2, 2, 5);

        Missile missile = new Missile(grid2x2);
        missile.updateToBestPosition();

        AttackResult expected = new AttackResult(new Point(2,2), 20);
        AttackResult result = grid2x2.receiveImpactWith(missile);
        assertEquals(expected, result);
    }
    
    @Test
    public void testBestAttackWithExampleExerciseGrid() {
        Missile missile = new Missile(proposalGrid);
        missile.updateToBestPosition();

        AttackResult expected = new AttackResult(new Point(2,2), 20);
        AttackResult result = proposalGrid.receiveImpactWith(missile);
        assertEquals(expected, result);
    }
    
}
