package raycasting;

import hsa2.GraphicsConsole;

import java.awt.Color;
import java.awt.Point;

public class Ray {
    GraphicsConsole gc;

    Point pos;
    Point dir;

    public Ray(GraphicsConsole gc, int x, int y) {
        this.gc = gc;
        this.pos = new Point(x, y);
        this.dir = new Point(0, 1);
    }

    public void show() {
        gc.setColor(Color.blue);
        gc.drawLine((int)pos.getX(), (int)pos.getY(), (int)dir.getX() * 10, (int)dir.getY() * 10);
    }
}