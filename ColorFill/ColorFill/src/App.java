import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;


/* 
App logic: 

- Start with top left square selected
- When a button is pushed:
    - Turn all selected squares into that color
    - Any touching squares of that same color become selected


*/ 


public class App {

    private static int NUM_ROWS = 12;
    private static int NUM_COLS = 12;

    static Board board = new Board();
    static JFrame window = new JFrame("Game");
    static JPanel colorPanel = new JPanel();
    static JPanel infoPanel = new JPanel();
    static JLabel turns = new JLabel();
    static Color currentColor;
    static int numSelected = 0;
    static int numTurns = 0;

    public static void initWindow() {

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton redButton = new ColorButton(Color.RED, "Red");
        JButton orangeButton = new ColorButton(Color.ORANGE, "Orange");
        JButton blueButton = new ColorButton(Color.BLUE, "Blue");
        JButton cyanButton = new ColorButton(Color.CYAN, "Cyan");
        JButton greenButton = new ColorButton(Color.GREEN, "Green");
        JButton yellowButton = new ColorButton(Color.YELLOW, "Yellow");

        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button 1 clicked!");
                currentColor = Color.RED;
                changeColor(Color.RED);
                processBoard();
                numTurns++;
                turns.setText("Number of turns: " + String.valueOf(numTurns));
                infoPanel.repaint();
            }
        });
        orangeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button 2 clicked!");
                currentColor = Color.ORANGE;
                changeColor(Color.ORANGE);
                processBoard();
                numTurns++;
                turns.setText("Number of turns: " + String.valueOf(numTurns));
                infoPanel.repaint();
            }
        });
        blueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button 3 clicked!");
                currentColor = Color.BLUE;
                changeColor(Color.BLUE);
                processBoard();
                numTurns++;
                turns.setText("Number of turns: " + String.valueOf(numTurns));
                infoPanel.repaint();
            }
        });
        cyanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button 4 clicked!");
                currentColor = Color.CYAN;
                changeColor(Color.CYAN);
                processBoard();
                numTurns++;
                turns.setText("Number of turns: " + String.valueOf(numTurns));
                infoPanel.repaint();
            }
        });
        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button 5 clicked!");
                currentColor = Color.GREEN;
                changeColor(Color.GREEN);
                processBoard();
                numTurns++;
                turns.setText("Number of turns: " + String.valueOf(numTurns));
                infoPanel.repaint();
            }
        });
        yellowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button 6 clicked!");
                currentColor = Color.YELLOW;
                changeColor(Color.YELLOW);
                processBoard();
                numTurns++;
                turns.setText("Number of turns: " + String.valueOf(numTurns));
                infoPanel.repaint();
            }
        });

        colorPanel.add(redButton);
        colorPanel.add(orangeButton);
        colorPanel.add(blueButton);
        colorPanel.add(cyanButton);
        colorPanel.add(greenButton);
        colorPanel.add(yellowButton);

        turns.setText("Number of turns: " + String.valueOf(numTurns));
        infoPanel.add(turns);

        window.add(board, BorderLayout.CENTER);
        window.add(colorPanel, BorderLayout.SOUTH);
        window.add(infoPanel, BorderLayout.NORTH);

        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }


    public static void checkNeighbors(int x, int y) {
        if ((x-1 >= 0) && (x-1 < board.grid.length)) {
            if (board.grid[x-1][y].getColor() == currentColor) {
                board.grid[x-1][y].select();
                numSelected++;
            }
        }
        if ((x+1 >= 0) && (x+1 < board.grid.length)) {
            if (board.grid[x+1][y].getColor() == currentColor) {
                board.grid[x+1][y].select();
                numSelected++;
            }
        }
        if ((y-1 >= 0) && (y-1 < board.grid.length)) {
            if (board.grid[x][y-1].getColor() == currentColor) {
                board.grid[x][y-1].select();
                numSelected++;
            }
        }
        if ((y+1 >= 0) && (y+1 < board.grid.length)) {
            if (board.grid[x][y+1].getColor() == currentColor) {
                board.grid[x][y+1].select();
                numSelected++;
            }
        };
    }

    public static void processBoard() {
        for (int i = 0; i < NUM_COLS; i++) {
            for (int j = 0; j < NUM_ROWS; j++) {
                //System.out.println(board.grid[i][j].getSelected());
                if (board.grid[i][j].getSelected() == true) checkNeighbors(i, j);
                board.revalidate();
            }
        }
        board.repaint();
        checkGameOver();
    }

    public static void changeColor(Color color) {
        for (int i = 0; i < NUM_COLS; i++) {
            for (int j = 0; j < NUM_ROWS; j++) {
                if (board.grid[i][j].getSelected() == true) board.grid[i][j].setColor(color);
                //board.revalidate(); 
            }
        }
        board.repaint();
    }

    public static void checkGameOver() {
        boolean gameOver = true;
        for (int i = 0; i < NUM_COLS; i++) {   
            for (int j = 0; j < NUM_ROWS; j++) {
                if (board.grid[i][j].getSelected() == false) gameOver = false;
            }
        }
        if (gameOver) {
            JOptionPane.showMessageDialog(window, "You won in " + numTurns + " turns!");
            System.exit(0);
        }
    }

    public static void startGame() {
        // Initialize and select the first square
        initWindow();
        board.grid[0][0].select();
        numSelected = 1;
        numTurns = 0;
        currentColor = board.grid[0][0].getColor();
        processBoard();
    }


    public static void main(String[] args) throws Exception {
        startGame();

    }
}
