package com.battleship.ai;

import java.util.Set;

import com.battleship.logic.Coordinate;

public interface AiPlayer {
    Coordinate getNextMove(Set<Coordinate> alreadyFired);
}


