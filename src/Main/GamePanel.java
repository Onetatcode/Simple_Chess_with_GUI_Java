package Main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    public static final int Width = 8 * Board.SQUARE_SIZE; // Match chessboard size
    public static final int Height = 8 * Board.SQUARE_SIZE;
    final int fps = 60;
    Thread gameThread;
    Board board = new Board();

    public GamePanel() {
        setPreferredSize(new Dimension(Width, Height));
        setBackground(new Color(210, 165, 125)); // Match light square color
    }

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000.0 / fps; // Correct calculation
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update() {
        // Update game state (empty for now)
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        board.draw(g2);
    }
}
