package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MyCanvas extends JPanel implements MouseListener, MouseMotionListener {
    public ArrayList<MyTree> trees = new ArrayList<>();
    private MyTree actualTree;
    private int xPos = 0;
    private int yPos = 0;
    private Color color;
    private boolean isDrawMode = true;
    private Color[] colors;
    private static int colorsIndex;

    public MyCanvas() {
        super();
        color = Color.blue;
        setBackground(Color.white);
        initializeColors();
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    private void initializeColors() {
        colors = new Color[3];
        colors[0] = Color.yellow;
        colors[1] = Color.red;
        colors[2] = Color.blue;
    }

    public Color getColor() {
        return colors[colorsIndex++ % 3];
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setDrawMode(boolean value) {
        this.isDrawMode = value;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int actualX = e.getX();
        int actualY = e.getY();

        if (isDrawMode) {
            if (actualTree != null) {
                if (actualX > xPos && actualY > yPos) {
                    actualTree.width = actualX - xPos;
                    actualTree.height = actualY - yPos;
                }

                if (actualX < xPos && actualY > yPos) {
                    actualTree.x = actualX;

                    actualTree.width = xPos - actualX;
                    actualTree.height = actualY - yPos;
                }

                if (actualX > xPos && actualY < yPos) {
                    actualTree.y = actualY;

                    actualTree.width = actualX - xPos;
                    actualTree.height = yPos - actualY;
                }

                if (actualX < xPos && actualY < yPos) {
                    actualTree.x = actualX;
                    actualTree.y = actualY;

                    actualTree.width = xPos - actualX;
                    actualTree.height = yPos - actualY;
                }
            }
        } else {
            if (!trees.isEmpty()) {
                for (MyTree tree : trees) {
                    if (tree.contains(actualX, actualY)) {
                        // presuvanie mozne len vpravo dole
                        tree.setBounds(actualX, actualY, tree.width, tree.height);
                    }
                }
            }
        }

        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.xPos = e.getX();
        this.yPos = e.getY();

        if (isDrawMode) {
            actualTree = new MyTree(xPos, yPos, 1, 1, color);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (isDrawMode) {
            trees.add(actualTree);
        }

        repaint();
        actualTree = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void paint(Graphics g) {
        super.paintComponent(g);

        for (MyTree tree : trees) {
            tree.drawTree(g);
        }

        if (actualTree != null) {
            actualTree.drawTree(g);
        }

    }
}
