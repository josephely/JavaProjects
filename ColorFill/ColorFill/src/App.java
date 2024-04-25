import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

    static Board board = new Board();
    static JPanel colorPanel = new JPanel();
    static Color currentColor;

    public static void initWindow() {

        JFrame window = new JFrame("Game");

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton redButton = new ColorButton(Color.RED);
        JButton orangeButton = new ColorButton(Color.ORANGE);
        JButton blueButton = new ColorButton(Color.BLUE);
        JButton cyanButton = new ColorButton(Color.CYAN);
        JButton greenButton = new ColorButton(Color.GREEN);
        JButton yellowButton = new ColorButton(Color.YELLOW);

        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic for button 1 click
                System.out.println("Button 1 clicked!");
                // Add your custom logic here
            }
        });
        orangeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic for button 1 click
                System.out.println("Button 2 clicked!");
                // Add your custom logic here
            }
        });
        blueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic for button 1 click
                System.out.println("Button 3 clicked!");
                // Add your custom logic here
            }
        });
        cyanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic for button 1 click
                System.out.println("Button 4 clicked!");
                // Add your custom logic here
            }
        });
        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic for button 1 click
                System.out.println("Button 5 clicked!");
                // Add your custom logic here
            }
        });
        yellowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic for button 1 click
                System.out.println("Button 6 clicked!");
                // Add your custom logic here
            }
        });


        colorPanel.add(redButton);
        colorPanel.add(orangeButton);
        colorPanel.add(blueButton);
        colorPanel.add(cyanButton);
        colorPanel.add(greenButton);
        colorPanel.add(yellowButton);

        window.add(board, BorderLayout.CENTER);
        window.add(colorPanel, BorderLayout.SOUTH);

        window.setResizable(false);

        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }


    public static void checkNeighbors(int x, int y) {
        if ((x-1 >= 0) && (x-1 < board.grid.length)) {
            if (board.grid[x-1][y].getColor() == currentColor) {
                board.grid[x-1][y].select();
            }
        }
        if ((x+1 >= 0) && (x+1 < board.grid.length)) {
            if (board.grid[x+1][y].getColor() == currentColor) {
                board.grid[x+1][y].select();
            }
        }
        if ((y-1 >= 0) && (y-1 < board.grid.length)) {
            if (board.grid[x][y-1].getColor() == currentColor) {
                board.grid[x][y-1].select();
            }
        }
        if ((y+1 >= 0) && (y+1 < board.grid.length)) {
            if (board.grid[x][y+1].getColor() == currentColor) {
                board.grid[x][y+1].select();
            }
        };
    }


    public static void main(String[] args) throws Exception {

        initWindow();
        board.grid[0][0].select();
        currentColor = board.grid[0][0].getColor();
        checkNeighbors(0, 0);

        boolean gameOver = false;
       
    }
}
