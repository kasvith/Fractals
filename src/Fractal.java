import com.kasun.app.FractalWindow;

import javax.swing.*;

public class Fractal {
    public static void main(String[] args) {
	// write your code here
        FractalWindow fractalWindow = new FractalWindow("Test", 800, 800);
        fractalWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fractalWindow.setLocationRelativeTo(null);
        fractalWindow.setVisible(true);
    }
}
