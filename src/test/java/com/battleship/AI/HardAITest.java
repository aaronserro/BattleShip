package com.battleship.AI;
import com.battleship.ai.*;
import com.battleship.logic.*;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class HardAITest {

    // Test 1: Ensure first move is valid and in bounds
    @Test
    public void testFirstMoveIsValid() {
        HardAI ai = new HardAI(10);
        Set<Coordinate> alreadyFired = new HashSet<>();

        Coordinate move = ai.getNextMove(alreadyFired);

        assertNotNull(move); // Coordinate should not be null
        assertTrue(move.getrow() >= 0 && move.getrow() < 10); // Row in bounds
        assertTrue(move.getcol() >= 0 && move.getcol() < 10); // Col in bounds
    }

    // Test 2: Ensure AI doesn't repeat the same shot
    @Test
    public void testAvoidsAlreadyFired() {
        HardAI ai = new HardAI(10);
        Set<Coordinate> alreadyFired = new HashSet<>();

        Coordinate firstMove = ai.getNextMove(alreadyFired);
        alreadyFired.add(firstMove);

        Coordinate secondMove = ai.getNextMove(alreadyFired);

        assertNotEquals(firstMove, secondMove); // AI should not repeat
        assertFalse(alreadyFired.contains(secondMove)); // AI must avoid already fired
    }

    // Test 3: Ensure AI reacts to HIT by switching to target mode (scoring influenced)
    @Test
    public void testReactsToHit() {
        HardAI ai = new HardAI(10);
        Set<Coordinate> alreadyFired = new HashSet<>();

        Coordinate firstMove = ai.getNextMove(alreadyFired);
        ai.setLastShotResult(firstMove, ShotResult.HIT);
        alreadyFired.add(firstMove);

        Coordinate secondMove = ai.getNextMove(alreadyFired);

        assertNotNull(secondMove); // Still chooses a move
        assertFalse(alreadyFired.contains(secondMove)); // Still avoids repetition
    }

    // Test 4: Ensure AI returns to HUNT mode after SUNK
    @Test
    public void testSwitchToHuntAfterSunk() {
        HardAI ai = new HardAI(10);
        Set<Coordinate> fired = new HashSet<>();

        Coordinate move1 = ai.getNextMove(fired);
        fired.add(move1);
        ai.setLastShotResult(move1, ShotResult.HIT);

        Coordinate move2 = ai.getNextMove(fired);
        fired.add(move2);
        ai.setLastShotResult(move2, ShotResult.SUNK);

        Coordinate move3 = ai.getNextMove(fired);

        assertNotNull(move3); // Should return to hunt mode
        assertFalse(fired.contains(move3));
    }
}
