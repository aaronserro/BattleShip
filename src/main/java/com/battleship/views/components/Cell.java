package com.battleship.views.components;
import com.vaadin.flow.component.dnd.DropTarget;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.HasComponents;

public class Cell extends Div {
    private final int row;
    private final int col;
    private final GameBoard board;
    private  int hasShip = 0;

    public Cell(int row, int col, GameBoard board) {
        addClassName("cell");
        setWidth("60px");
        setHeight("60px");
        getStyle().set("margin", "6px");
        this.row=row;
        this.col=col;
        this.board=board;


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
    public int getrow(){
        return row;
    }
    public int getcol(){
        return col;
    }

    private void placeShip(ShipComponent ship) {
        if (ship.getParent().isPresent()) {
            ((HasComponents) ship.getParent().get()).remove(ship); // Correct way!
        }

        this.add(ship); // add the ship into the Cell
        ship.setPlaced(true); // mark as placed
        ship.getElement().setAttribute("draggable", "false"); // prevent re-dragging
        board.markShipAt(row, col);
        board.printBoard(); // ⬅️ Print current state of the grid

        //System.out.println("Placed ship of size: " + ship.getSize());
    }
    public void setShip(){
        hasShip = 1;


    }
    public int getShipStatus() {
        return hasShip;
    }


}

