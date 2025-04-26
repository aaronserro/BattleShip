package com.battleship.views.components;
import com.vaadin.flow.component.dnd.DropTarget;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.HasComponents;

public class Cell extends Div {

    public Cell() {
        addClassName("cell");
        setWidth("60px");
        setHeight("60px");
        getStyle().set("margin", "6px");


        // 🎯 Make this cell a drop target
        DropTarget.create(this).addDropListener(event -> {
            if (event.getDragSourceComponent().isPresent()) {
                ShipComponent ship = (ShipComponent) event.getDragSourceComponent().get();
                if (!ship.isPlaced()) { // Only allow placing if not already placed
                    placeShip(ship);
                }
            }
        });
    }

    private void placeShip(ShipComponent ship) {
        if (ship.getParent().isPresent()) {
            ((HasComponents) ship.getParent().get()).remove(ship); // Correct way!
        }

        this.add(ship); // add the ship into the Cell
        ship.setPlaced(true); // mark as placed
        ship.getElement().setAttribute("draggable", "false"); // prevent re-dragging

        System.out.println("Placed ship of size: " + ship.getSize());
    }
}

