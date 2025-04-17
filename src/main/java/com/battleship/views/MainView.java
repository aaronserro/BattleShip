package com.battleship.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    public MainView() {
        Button button = new Button("Click me",
                event -> add(new Paragraph("Clicked!")));

        add(button);
        add(new H1("Battleship AI App Ready!"));
    }
}
