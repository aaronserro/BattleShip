package com.battleship.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
@CssImport("./styles/shared-styles.css")
public class MainView extends VerticalLayout {

    public MainView() {
        setSizeFull();
        addClassName("main-view");
        buildUI();
    }
    private void buildUI() {
        // Add components here
        add(new  Label("Battleship Game"));
        add(new GameBoard());
        add(new GameControls());
    }
}
