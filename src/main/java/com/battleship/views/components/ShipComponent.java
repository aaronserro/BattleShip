package com.battleship.views.components;
import com.vaadin.flow.component.dnd.DragSource;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.dependency.CssImport;

@CssImport("./styles/shared-styles.css")
public class ShipComponent extends HorizontalLayout {

    private int size;
    private boolean placed = false; // Initially not placed

    public ShipComponent(int size) {
        this.size = size;
        addClassName("ship-component");
        setSpacing(false);
        setPadding(false);

        buildShip();
        DragSource.create(this)
            .setDragData(String.valueOf(size)); // we'll send size info
    }

    private void buildShip() {
        for (int i = 0; i < size; i++) {
            Image part = new Image("images/ship1.png", "Ship Part");
            part.setWidth("40px");
            part.setHeight("40px");
            add(part);
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isPlaced() {
        return placed;
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
        // Optional: Add visual effect if you want (e.g., gray it out)
    }
}
