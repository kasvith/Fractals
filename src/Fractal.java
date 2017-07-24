import com.kasun.app.FractalWindow;
import javax.swing.*;

public class Fractal {
    public static void main(String[] args) {
        FractalWindow fractalWindow = new FractalWindow("Test", 1200, 800);
        fractalWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fractalWindow.setLocationRelativeTo(null);
        fractalWindow.setVisible(true);
    }
}
