package raycasting;

import hsa2.GraphicsConsole;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class Particle {
    GraphicsConsole gc;

    List<Ray> rays = new ArrayList<>();
    Point pos;

    public Particle(GraphicsConsole gc) {
        this.gc = gc;

        this.pos = new Point(0, 0);

        for (int a = 0; a < 360; a++) {
            this.rays.add(new Ray(gc, (int) this.pos.getX(), (int) this.pos.getY(), a));
        }
    }
}