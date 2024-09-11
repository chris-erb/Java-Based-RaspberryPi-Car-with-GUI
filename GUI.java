package ProjFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI extends JPanel {
    private char keyPressed;

    public GUI() {
        setLayout(new GridLayout(2, 3));
        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                keyPressed = e.getKeyChar();
                repaint();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE); // Blue square for w
        g.fillRect(70, 10, 50, 50);
        g.setColor(Color.WHITE);
        g.drawString("w", 90, 35);

        g.setColor(Color.RED); // Red square for s
        g.fillRect(70, 80, 50, 50);
        g.setColor(Color.WHITE);
        g.drawString("s", 90, 105);

        g.setColor(Color.GREEN); // Green square for a
        g.fillRect(10, 80, 50, 50);
        g.setColor(Color.WHITE);
        g.drawString("a", 30, 105);

        g.setColor(Color.YELLOW); // Yellow square for d
        g.fillRect(130, 80, 50, 50);
        g.setColor(Color.WHITE);
        g.drawString("d", 150, 105);

        switch (keyPressed) {
            case 'w':
                g.setColor(Color.BLACK);
                g.fillRect(70, 10, 50, 50);
                break;
            case 's':
                g.setColor(Color.BLACK);
                g.fillRect(70, 80, 50, 50);
                break;
            case 'a':
                g.setColor(Color.BLACK);
                g.fillRect(10, 80, 50, 50);
                break;
            case 'd':
                g.setColor(Color.BLACK);
                g.fillRect(130, 80, 50, 50);
                break;
            default:
                break;
        }
    }
    
    public void reset() {
        keyPressed = '\0'; // Reset the keyPressed variable
        repaint(); // Call repaint to redraw the GUI
        
    }
    public static void main(String[] args) {
    	JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Robot Controller");
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(new GUI());
        frame.setVisible(true);
    }
}


