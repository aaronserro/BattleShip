package com.battleship.ai;

import java.util.List;
import java.util.Set;

import com.battleship.logic.*;
public interface AiPlayer {
    Coordinate getNextMove(Set<Coordinate> alreadyFired);
     void setupShips(); // ← New method for ship placement
    List<Ship> getShips(); // ← Optional: to retrieve ships after placement


}


