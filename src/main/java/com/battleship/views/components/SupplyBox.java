package com.battleship.views.components;

import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.dependency.CssImport;

@CssImport("./styles/shared-styles.css")
public class SupplyBox extends FlexLayout {

    private ShipComponent ship2,ship3;
    private ShipComponent ship,ship1,ship11,ship12,ship13,ship14,ship15;
    private ShipComponent ship4,ship5,ship6,ship7,ship8,ship9;

    public SupplyBox() {
        addClassName("supply-box");
        setFlexWrap(FlexWrap.WRAP);
        getStyle().set("gap", "10px");
        //setSpacing(true);
        //setPadding(true);
        setAlignItems(Alignment.CENTER);
        setWidthFull();

        // Create ships
        ship2 = new ShipComponent(1);
        ship3 = new ShipComponent(1);
        ship4 = new ShipComponent(1);
        ship5 = new ShipComponent(1);
        ship6 = new ShipComponent(1);
        ship7 = new ShipComponent(1);
        ship8 = new ShipComponent(1);
        ship9 = new ShipComponent(1);
        ship1 = new ShipComponent(1);
        ship11 = new ShipComponent(1);
        ship12 = new ShipComponent(1);
        ship13 = new ShipComponent(1);
        ship14 = new ShipComponent(1);
        ship15 = new ShipComponent(1);

        // Add them to layout
        add(ship2, ship3, ship5,ship6,ship7,ship8,
        ship9,ship1,ship11,ship12,ship13,ship14,ship15);
    }

    // Optional: you can create getters if you need access to each ship
    public ShipComponent getShip2() {
        return ship2;
    }

    public ShipComponent getShip3() {
        return ship3;
    }

    public ShipComponent getShip4() {
        return ship4;
    }
}
