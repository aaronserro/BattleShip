package com.battleship.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.*;
import com.vaadin.flow.router.Route;

public class GameControls extends HorizontalLayout {
    private Button newGameButton = new Button("New Game");
    private Button surrenderButton = new Button("Surrender");

    public GameControls() {
        newGameButton.addClickListener(e -> startNewGame());
        surrenderButton.addClickListener(e -> surrenderGame());
        add(newGameButton, surrenderButton);
    }

    private void startNewGame() {
        // Logic to start a new game
    }

    private void surrenderGame() {
        // Logic to surrender a game
    }
}
