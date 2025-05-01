package com.battleship.views.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.*;
import com.vaadin.flow.router.Route;
import com.battleship.views.components.*;
import com.battleship.logic.*;
import java.util.*;
public class GameBoard extends VerticalLayout {
    private final Cell[][] buttons = new Cell[10][10]; // Assuming a 10x10 grid

    public GameBoard() {
        addClassName("game-board");
        setSpacing(true); // 🔥 ensure horizontal spacing
        setPadding(false);
        setMargin(false);
        //setJustifyContentMode(JustifyContentMode.CENTER); // 🔥 center horizontally
        //setAlignItems(Alignment.CENTER);
        buildBoard();
    }
    public void markShipAt(int row, int col){
        buttons[row][col].setShip();
    }

    private void buildBoard() {
        for (int i = 0; i < buttons.length; i++) {
            HorizontalLayout column = new HorizontalLayout();
            column.setSpacing(true);
            column.setPadding(false);
            column.setMargin(false);
            column.setSizeUndefined();
            for (int j = 0; j < buttons[i].length; j++) {
                int row=i;
                int col =j;
                buttons[row][col] = new Cell(row,col,this);
                buttons[row][col].addClassName("cell");
                buttons[row][col].addClickListener(e -> handleCellClick(row, col));
                column.add(buttons[row][col]);
            }
            add(column);
        }

    }
    public void printBoard() {
        System.out.println("=== Current Board State ===");
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                System.out.print(buttons[i][j].getShipStatus() + " ");
            }
            System.out.println();
        }
    }
    public List<Ship> getplayable(){
        boolean visited [][] = new boolean[10][10];
        List<Ship> allShips = new ArrayList<>();
        for(int row = 0;row<10;row++){
            for(int col = 0;col<10;col++){
                if (!visited[row][col] && buttons[row][col].getShipStatus() == 1) {
                    List<Coordinate> cluster = new ArrayList<>();
                    DFS(row, col, cluster, visited);
                    Ship ship = new Ship(cluster.size(),cluster); // You may need to adapt to your Ship constructor
                    allShips.add(ship);
                }


            }
        }
        return allShips;
    }
    private void DFS(int row, int col, List<Coordinate> coordinates, boolean[][] visited) {
        if (row < 0 || row >= 10 || col < 0 || col >= 10) return; // bounds check first
        if (visited[row][col]) return;
        if (buttons[row][col].getShipStatus() == 0) return;

        visited[row][col] = true;
        coordinates.add(new Coordinate(row, col));

        DFS(row + 1, col, coordinates, visited);
        DFS(row - 1, col, coordinates, visited);
        DFS(row, col + 1, coordinates, visited);
        DFS(row, col - 1, coordinates, visited);
    }





    private void handleCellClick(int x, int y) {
        // Handle cell click logic here
        System.out.println("Cell clicked");
    }
    public void PlacementMode(int shiplength){
        //buildBoard();

    }
}
