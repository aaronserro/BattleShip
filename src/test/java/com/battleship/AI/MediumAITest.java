package com.battleship.AI;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.*;

import org.junit.jupiter.api.Test;

import com.battleship.ai.MediumAI;
import com.battleship.logic.Coordinate;
import com.battleship.logic.ShotResult;

public class MediumAITest {
    @Test
public void testHuntToTargetToHuntTransition() {
    MediumAI ai = new MediumAI(10);

    // Step 1: Initial move in HUNT mode
    Coordinate huntShot = ai.getNextMove(new HashSet<>());
    assertNotNull(huntShot);

    // Step 2: Simulate HIT
    ai.setLastShotResult(ShotResult.HIT);
    Coordinate targetShot = ai.getNextMove(Set.of(huntShot));
    assertNotEquals(huntShot, targetShot); // shouldn't be the same

    // Step 3: Simulate MISS in TARGET mode
    ai.setLastShotResult(ShotResult.MISS);
    Coordinate newTarget = ai.getNextMove(Set.of(huntShot, targetShot));
    assertNotEquals(targetShot, newTarget); // direction should have changed

    // Step 4: Simulate SUNK
    ai.setLastShotResult(ShotResult.SUNK);
    Coordinate newHunt = ai.getNextMove(Set.of(huntShot, targetShot, newTarget));
    assertNotNull(newHunt); // should go back to HUNT
}



}
