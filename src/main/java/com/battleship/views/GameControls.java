package com.battleship.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.*;
import com.vaadin.flow.router.Route;
@CssImport("./styles/shared-styles.css")
public class GameControls extends HorizontalLayout {
    private Button newGameButton = new Button("New Game");
    private Button surrenderButton = new Button("Surrender");

    public GameControls() {
        VerticalLayout buttonWrapper = new VerticalLayout();
        buttonWrapper.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        buttonWrapper.setSpacing(true);
        buttonWrapper.setPadding(true);

        newGameButton.addClickListener(e -> startNewGame());
        surrenderButton.addClickListener(e -> surrenderGame());

        add(newGameButton, surrenderButton);
        newGameButton.addClassName("game-button");
        surrenderButton.addClassNames("game-button", "danger-button");
        buttonWrapper.add(newGameButton, surrenderButton);
        add(buttonWrapper);
        setSpacing(true);
        setPadding(true);
        setMargin(true);
    }

    private void startNewGame() {
        // Logic to start a new game
        System.out.println("Test Button");
        /**
         * 1. Set AI difficulty
         * 2.
         *
         *
         *
         */

    }

    private void surrenderGame() {
        // Logic to surrender a game
        System.out.println("Surrender Game");
    }
}
