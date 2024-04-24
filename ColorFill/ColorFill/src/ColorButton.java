import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

public class ColorButton extends JButton {

    public ColorButton(Color color) {
        this.setPreferredSize(new Dimension(50, 50));
        this.setBackground(color);
    }

}
