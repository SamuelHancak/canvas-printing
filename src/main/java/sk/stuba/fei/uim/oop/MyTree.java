package sk.stuba.fei.uim.oop;

import java.awt.*;

public class MyTree extends Rectangle {
    private final Color color;

    public MyTree(int x, int y, int width, int height, Color c) {
        super(x, y, width, height);
        color = c;
    }

    public void drawTree(Graphics g) {
        g.setColor(this.color);
        g.fillOval(x, y, width, 2 * (height / 3));
        g.fillRect(x + (width / 3), (y - 10) + 2 * (height / 3), width / 3, (height / 3) + 10);

    }
}
