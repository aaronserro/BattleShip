package com.battleship.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.*;
import com.vaadin.flow.router.Route;
public class GameBoard extends HorizontalLayout {
    private final Button[][] buttons = new Button[10][10]; // Assuming a 10x10 grid

    public GameBoard() {
        addClassName("game-board");
        buildBoard();
    }

    private void buildBoard() {
        for (int i = 0; i < buttons.length; i++) {
            VerticalLayout column = new VerticalLayout();
            for (int j = 0; j < buttons[i].length; j++) {
                int row=i;
                int col =j;
                buttons[row][col] = new Button();
                buttons[row][col].addClassName("cell");
                buttons[row][col].addClickListener(e -> handleCellClick(row, col));
                column.add(buttons[row][col]);
            }
            add(column);
        }
    }

    private void handleCellClick(int x, int y) {
        // Handle cell click logic here
        System.out.println("Cell clicked");
    }
}
