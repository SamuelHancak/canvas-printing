package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {
    JButton treeButton;
    JButton moveButton;
    JButton nextColorButton;
    JLabel label;
    MyCanvas canvas;

    public MyPanel() {
        super();
        this.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 4));

        treeButton = new JButton();
        treeButton.setText("Strom");
        treeButton.addActionListener(this);

        moveButton = new JButton();
        moveButton.setText("Presun");
        moveButton.addActionListener(this);

        nextColorButton = new JButton();
        nextColorButton.setText("Dalsia farba");
        nextColorButton.addActionListener(this);

        label = new JLabel();
        label.setText("KRESLENIE");
        label.setBackground(Color.blue);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(true);

        panel.add(treeButton);
        panel.add(moveButton);
        panel.add(nextColorButton);
        panel.add(label);

        canvas = new MyCanvas();
        this.add(panel, BorderLayout.PAGE_END);
        this.add(canvas, BorderLayout.CENTER);

        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == treeButton) {
            label.setText("KRESLENIE");
            canvas.setDrawMode(true);
        } else if (e.getSource() == moveButton) {
            label.setText("PRESUVANIE");
            canvas.setDrawMode(false);
        } else if (e.getSource() == nextColorButton) {
            Color nextColor = canvas.getColor();
            label.setBackground(nextColor);
            canvas.setColor(nextColor);
        }
    }

}
