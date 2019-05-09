package raycasting;

import hsa2.GraphicsConsole;

import java.awt.Color;
import java.awt.Point;

public class Ray {
    GraphicsConsole gc;

    Point pos;
    Point dir;
    Point rawdir;

    public Ray(GraphicsConsole gc, int x, int y) {
        this.gc = gc;
        this.pos = new Point(x, y);
        this.rawdir = new Point(0, 1);
        this.dir = new Point(0, 1);
    }

    public void lookAt(int x, int y) {
        this.dir = new Point(x - this.pos.x, y - this.pos.y);
    }

    public void show() {
        gc.setColor(Color.blue);
        gc.drawLine((int)pos.getX(), (int)pos.getY(), (int)pos.getX() + (int)dir.getX() * 10, (int)pos.getY() + (int)dir.getY() * 10);
    }

    public Point cast(Boundary wall) {
        int x1 = (int) wall.a.getX();
        int y1 = (int) wall.a.getY();
        int x2 = (int) wall.b.getX();
        int y2 = (int) wall.b.getY();
        

        int x3 = (int) this.pos.getX();
        int y3 = (int) this.pos.getY();
        int x4 = (int) (this.pos.getX() + this.dir.getX());
        int y4 = (int) (this.pos.getY() + this.dir.getY());
        
        double den = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        if (den == 0.0) {
            return new Point(-1, -1);
        }

        double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / den;
        double u = -((x1 - x2) * (y1 - y3) - (y1 - y2) * (x1 - x3)) / den;

        if (t > 0 && t < 1 && u > 0) {
            return new Point((int)(x1 + t * (x2 - x1)), (int)(y1 + t * (y2 - y1)));
        } else {
            return new Point(-1, -1);
        }

    }
}