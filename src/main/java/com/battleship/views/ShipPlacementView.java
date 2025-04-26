package com.battleship.views;

import com.battleship.views.components.GameBoard;
import com.battleship.views.components.GameControls;
import com.battleship.views.components.SupplyBox;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.router.Route;

@Route("/ShipPlacement")
@CssImport("./styles/shared-styles.css")
public class ShipPlacementView extends VerticalLayout {

    private String selectedDifficulty = "Medium"; // default

    public ShipPlacementView() {
        setMinHeight("100vh");
        setWidth("100%");
        setPadding(false);
        setSpacing(false);
        addClassName("main-view");
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.START); // Keeps top spacing

        addClassName("main-view");
        buildUI();



    }

    private void buildUI() {
        H1 title = new H1("⚓ Battleship Game ⚓");
        title.addClassName("game-title");

        //RadioButtonGroup<String> difficultySelector = new RadioButtonGroup<>();
        //difficultySelector.setLabel("Select Difficulty");
        //difficultySelector.setItems("Easy", "Medium", "Hard");
        //difficultySelector.setValue("Medium"); // default
        //difficultySelector.addValueChangeListener(event -> {
        //    selectedDifficulty = event.getValue();
        //    System.out.println("Selected difficulty: " + selectedDifficulty);
            // You can also pass this to your GameEngine or AI here
        //});
        GameBoard board = new GameBoard();
        HorizontalLayout boardWrapper = new HorizontalLayout();
        boardWrapper.setSizeUndefined();
        boardWrapper.setJustifyContentMode(JustifyContentMode.CENTER); // center the board inside
        boardWrapper.add(board);
        board.setHeight("auto");
        board.setWidthFull();
        SupplyBox supplyBox = new SupplyBox(); // <--- CREATE it
        // <--- ADD it to the page


        GameControls controls = new GameControls();
        controls.setWidthFull();;



        add(title,  supplyBox,boardWrapper, controls);//difficulty selector removed

        setAlignItems(Alignment.CENTER);

    }


}
