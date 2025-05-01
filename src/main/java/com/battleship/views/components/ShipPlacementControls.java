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
import com.battleship.logic.*;
import java.util.*;
@CssImport("./styles/shared-styles.css")
public class ShipPlacementControls extends HorizontalLayout{
    private final GameBoard board;
    private List<Ship> ships;
    private Button startGameButton = new Button("Start Game");
    public ShipPlacementControls(GameBoard board){
        this.board=board;
        VerticalLayout buttonWrapper = new VerticalLayout();
        buttonWrapper.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        buttonWrapper.setSpacing(true);
        buttonWrapper.setPadding(true);

        startGameButton.addClickListener(e -> startGameplay());
        //surrenderButton.addClickListener(e -> surrenderGame());

        add(startGameButton);//removed surrender Button
        startGameButton.addClassName("game-button");
        //surrenderButton.addClassNames("game-button", "danger-button");
        buttonWrapper.add(startGameButton);//surrender game button removed
        add(buttonWrapper);
        setSpacing(true);
        setPadding(true);
        setMargin(true);

    }
    private void startGameplay(){
        System.out.println("gameview");
        board.printBoard();
        ships = board.getplayable();
        UI.getCurrent().navigate("GameView");

    }
    public List<Ship> getShips(){
        return ships;
    }
}