package raycasting;

import hsa2.GraphicsConsole;

import java.awt.Color;
import java.awt.Point;

public class Boundary {
    GraphicsConsole gc;

    Point a;
    Point b;

    public Boundary(GraphicsConsole gc, int x1, int y1, int x2, int y2) {
        this.gc = gc;

        this.a = new Point(x1, y1);
        this.b = new Point(x2, y2);
    }

    public void show() {
        gc.setColor(Color.white);
        gc.drawLine((int)this.a.getX(), (int)this.a.getY(), (int)this.b.getX(), (int)this.b.getY());
    }
}