package sk.stuba.fei.uim.oop;

import javax.swing.*;

public class MyFrame extends JFrame {

    public MyFrame(){
    this.setSize(600, 600);
    this.setVisible(true);
    this.add(new MyPanel());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    repaint();
    }
}
