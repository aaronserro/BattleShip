package com.battleship.views;

import com.battleship.views.components.GameControls;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.router.Route;

@Route("/GameView")
@CssImport("./styles/shared-styles.css")
public class GameView extends VerticalLayout {

    private String selectedDifficulty = "Medium"; // default

    public GameView() {


    }

    private void buildUI() {
    }

    // Optional getter if GameEngine needs to access selected difficulty

}
