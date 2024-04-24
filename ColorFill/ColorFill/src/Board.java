import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Board extends JPanel{

    public Tile[][] grid;

    private static final int GRID_SIZE = 12;
    private static final int SQUARE_SIZE = 50;


    public Board() {
        setPreferredSize(new Dimension(600, 600));
        initializeGrid();

    }

    private void initializeGrid() {
        grid = new Tile[GRID_SIZE][GRID_SIZE];
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Random r = new Random();
                int value = r.nextInt(5);
                grid[row][col] = new Tile(returnColorValue(value)); // Initialize with default color
            }
        }
    }

    private Color returnColorValue(int value) {
        if (value == 0) return Color.RED;
        if (value == 1) return Color.ORANGE;
        if (value == 2) return Color.BLUE;
        if (value == 3) return Color.CYAN;
        if (value == 4) return Color.GREEN;
        if (value == 5) return Color.YELLOW;
        else return Color.WHITE;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int squareWidth = getWidth() / GRID_SIZE;
        int squareHeight = getHeight() / GRID_SIZE;

        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Tile tile = grid[row][col];
                g.setColor(tile.getColor());
                g.fillRect(col * squareWidth, row * squareHeight, squareWidth, squareHeight);
            }
        }
    }
}
