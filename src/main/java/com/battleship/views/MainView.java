package com.battleship.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.router.Route;

@Route("")
@CssImport("./styles/shared-styles.css")
public class MainView extends VerticalLayout {

    private String selectedDifficulty = "Medium"; // default

    public MainView() {
        //setSizeFull();
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

        RadioButtonGroup<String> difficultySelector = new RadioButtonGroup<>();
        difficultySelector.setLabel("Select Difficulty");
        difficultySelector.setItems("Easy", "Medium", "Hard");
        difficultySelector.setValue("Medium"); // default
        difficultySelector.addValueChangeListener(event -> {
            selectedDifficulty = event.getValue();
            System.out.println("Selected difficulty: " + selectedDifficulty);
            // You can also pass this to your GameEngine or AI here
        });
        GameBoard board = new GameBoard();
        board.setHeight("600px");
        board.setWidthFull();


        GameControls controls = new GameControls();
        controls.setWidthFull();;



        add(title, difficultySelector, board, controls);

        setAlignItems(Alignment.CENTER);
    }

    // Optional getter if GameEngine needs to access selected difficulty
    public String getSelectedDifficulty() {
        return selectedDifficulty;
    }
}
