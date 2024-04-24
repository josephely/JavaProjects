import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

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

    public static void initWindow() {

        JFrame window = new JFrame("Game");

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton redButton = new ColorButton(Color.RED);
        JButton orangeButton = new ColorButton(Color.ORANGE);
        JButton blueButton = new ColorButton(Color.BLUE);
        JButton cyanButton = new ColorButton(Color.CYAN);
        JButton greenButton = new ColorButton(Color.GREEN);
        JButton yellowButton = new ColorButton(Color.YELLOW);

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
    public static void main(String[] args) throws Exception {

        initWindow();
        board.grid[0][0].select();
        

        boolean gameOver = false;
       
    }
}
