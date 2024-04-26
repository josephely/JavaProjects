import javax.swing.*;
import java.awt.*;

public class Tile  {

    private boolean isSelected;
    private Color color;

        public Tile(Color color) {
            this.color = color;
            this.isSelected = false;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public void select() {
            this.isSelected = true;
        }

        public boolean getSelected() {
            return isSelected;
        }

        public String getText() {
            if (this.isSelected) return "Yes";
            else return "No";

        }

}
