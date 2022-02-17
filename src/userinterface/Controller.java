package userinterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Controller extends JPanel implements KeyListener {
    private char[][] map;

    public Controller(char[][] map) {
        this.map = map;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Controller c = new Controller();
        frame.addKeyListener(c);
        frame.add(c);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.pack();
    }

    public void moveLeft(int x, int y) {
        if (y != 0) {
            map[x][y] = '-';
            y--;
        }
        map[x][y] = 'J';
    }

    public void moveRight() {

    }

    public void moveUp() {

    }

    public void moveDown() {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (Character.toLowerCase(e.getKeyChar())) {
            case 'a' -> moveLeft();
            case 'd' -> moveRight();
            case 's' -> moveDown();
            case 'w' -> moveUp();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        JOptionPane.showMessageDialog(null, e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}