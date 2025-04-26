package com.battleship.views.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.*;
import com.vaadin.flow.router.Route;
import com.battleship.views.components.*;
public class GameBoard extends HorizontalLayout {
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

    private void buildBoard() {
        for (int i = 0; i < buttons.length; i++) {
            VerticalLayout column = new VerticalLayout();
            column.setSpacing(true);
            column.setPadding(false);
            column.setMargin(false);
            column.setSizeUndefined();
            for (int j = 0; j < buttons[i].length; j++) {
                int row=i;
                int col =j;
                buttons[row][col] = new Cell();
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
    public void PlacementMode(int shiplength){
        //buildBoard();

    }
}
