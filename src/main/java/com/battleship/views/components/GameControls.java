package com.battleship.views.components;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.*;
import com.vaadin.flow.router.Route;
@CssImport("./styles/shared-styles.css")
public class GameControls extends HorizontalLayout {
    private Button newGameButton = new Button("New Game");
    //private Button surrenderButton = new Button("Surrender");

    public GameControls() {
        VerticalLayout buttonWrapper = new VerticalLayout();
        buttonWrapper.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        buttonWrapper.setSpacing(true);
        buttonWrapper.setPadding(true);

        newGameButton.addClickListener(e -> startNewGame());
        //surrenderButton.addClickListener(e -> surrenderGame());

        add(newGameButton);//removed surrender Button
        newGameButton.addClassName("game-button");
        //surrenderButton.addClassNames("game-button", "danger-button");
        buttonWrapper.add(newGameButton);//surrender game button removed
        add(buttonWrapper);
        setSpacing(true);
        setPadding(true);
        setMargin(true);
    }

    private void startNewGame() {
        // Logic to start a new game
        System.out.println("Test Button");
        UI.getCurrent().navigate("ShipPlacement");


        //openShipPlacementDialog();
        /**
         * 1. Set AI difficulty
         * 2.
         *
         *
         *
         */

    }
    private void openShipPlacementDialog() {
        Dialog dialog = new Dialog();
        dialog.setCloseOnOutsideClick(false);

        VerticalLayout content = new VerticalLayout();
        content.setSpacing(true);

        content.add(new Label("Place Your Ships"));

        // Ship 2-segment
        HorizontalLayout ship2 = new HorizontalLayout();
        Button placebutton = new Button("Place");
        Image shipImage = new Image("images/ship1.png", "Ship");
        placebutton.addClickListener(e->UIPlacementMode());
        ship2.add(shipImage,placebutton);

        // Ship 3-segment
        HorizontalLayout ship3 = new HorizontalLayout();
        ship3.add(new Image("images/ship1.png", "Ship 3"), new Button("Place"));

        // Ship 4-segment
        HorizontalLayout ship4 = new HorizontalLayout();
        ship4.add(new Image("images/ship1.png", "Ship 4"), new Button("Place"));

        content.add(ship2, ship3, ship4);

        Button close = new Button("Done", e -> dialog.close());
        content.add(close);

        dialog.add(content);
        dialog.open();
    }
    private void UIPlacementMode(){
        System.out.println("Ship to be places here");
        GameBoard boardPlace = new GameBoard();
        boardPlace.PlacementMode(3);
    };
    private void surrenderGame() {
        // Logic to surrender a game
        System.out.println("Surrender Game");
    }
}
