package com.battleship.ai;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.battleship.logic.*;

public class mediumAI implements AiPlayer{
    private ShotResult Shot;
    private List<Coordinate> allcoordinates;
    public mediumAI(int boardsize){
         allcoordinates = new ArrayList<>();
        for (int i = 0;i<boardsize;i++){
            for (int j = 0;j<boardsize;j++){
                Coordinate coor = new Coordinate(i, j);
                allcoordinates.add(coor);
            }
        }
    }

    @Override
    public Coordinate getNextMove(Set<Coordinate> alreadyFired){
        Coordinate coor = new Coordinate(1,2);
        return coor;
    }


}
