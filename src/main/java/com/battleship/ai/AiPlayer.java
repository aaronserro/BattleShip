package com.battleship.ai;

import java.util.Set;

import com.battleship.logic.*;
public interface AiPlayer {
    Coordinate getNextMove(Set<Coordinate> alreadyFired);

}


