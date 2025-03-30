import java.awt.Color;
import ecs100.*;

public class DrawShape {
    public DrawShape() {
        UI.initialise();
        UI.addButton("Quit", UI::quit);
    }

    private void doMouse(String action, double x, double y) {
        if (action.equals("clicked")) {
            UI.fillOval(x - 25, y - 25, 50, 50);
        }
    }

    public void changeColor() {
        Color col = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
        UI.setColor(col);
    }

    public static void main(String[] args) {
        DrawShape obj = new DrawShape();
        UI.addButton("Change Color", obj::changeColor);
        UI.setMouseListener(obj::doMouse);
    }
}
