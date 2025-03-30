import ecs100.*;
import java.awt.Color;
import java.awt.Shape;

import javax.swing.JColorChooser;

public class MSPaint
{
    // instance variables
    private double startX, startY; // fields to remember "pressed positions
    private Color currentColor = Color.black;
    private double width = 10;
    private boolean rectangle = true;

    /**
     * Constructor for objects of class MsPaint
     */
    public MSPaint()
    {
        // initialise instance variables
        UI.initialise();
        UI.addButton("Quit", UI::quit);
        UI.setMouseListener(this::doMouse);
        UI.setLineWidth(this.width);
        UI.addSlider("Pen Size", 1, 20, this.width, this::setSize);
        UI.addButton("Color", this::doChooseColor);
        UI.addButton("Change Shape", this::changeShape);
    }

    public void doMouse(String action, double x, double y) {
        if (action.equals("pressed") ) {
            this.startX = x;
            this.startY = y;
        } else if (action.equals("released") ) {
            UI.drawLine(this.startX, this.startY, x, y);
        }
    }

    public void doChooseColor() {
            this.currentColor = JColorChooser.showDialog(null, "Choose Color", this.currentColor);
            UI.setColor(currentColor);
        
    }

    public void setSize(double size) {
        this.width = size;
        UI.setLineWidth(width);
    }

    public void changeShape(String action, double x, double y) {
        if (rectangle = true) {
            if (action.equals("clicked")) {
                UI.fillOval(x - width/2.0, y - width/2.0, width, width);
            }
        }

    }

    
    public static void main(String[] args) {
        MSPaint drawer = new MSPaint();
    }
}
